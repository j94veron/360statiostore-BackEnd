package com.ar.ecommerce.security;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JWTProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(JWTProvider.class);
	
	@Value("${security.jwt.token.secret-key}")
	private String secretKey;
	
	@Value("${security.jwt.token.expire-length}")
	private long tokenValidityInMilliseconds;
	
	private static final String AUTHORITIES_KEY = "authorities";

	public Map<String, String> createToken(Authentication authentication) {
		CustomUserDetails cUserDetails = (CustomUserDetails) authentication.getPrincipal();
		String authorities = cUserDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
		Long now = (new Date()).getTime();
		String token = this.getToken(cUserDetails.getUsername(), authorities, new Date(now + this.tokenValidityInMilliseconds));
		String refreshToken = this.getToken(cUserDetails.getUsername(), authorities, new Date(now + this.tokenValidityInMilliseconds * 2));
		
		return Map.of("token", token, "refresh_token", refreshToken);
	}
	
	private String getToken (String userName, String authorities, Date validaty) {
		return Jwts.builder().setSubject(userName).claim(AUTHORITIES_KEY, authorities)
				.signWith(SignatureAlgorithm.HS512, secretKey)
				.setExpiration(validaty)
				.compact();
	}
	
	public Authentication getAuthentication(String token) {
		Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
		List<GrantedAuthority> authorities = Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		
		return new UsernamePasswordAuthenticationToken(new CustomUserDetails(claims.getSubject(), token, authorities), token, authorities);
	}

	public boolean validateToken(String token) {
		try {
 			Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
			return true;
		} catch (SignatureException e) {
			logger.info("Invalid JWT signature.");
			logger.trace("Invalid JWT signature trace: {}", e);
		} catch (MalformedJwtException e) {
			logger.info("Invalid JWT token.");
			logger.trace("Invalid JWT token trace: {}", e);
		} catch (ExpiredJwtException e) {
			logger.info("Expired JWT token.");
			logger.trace("Expired JWT token trace: {}", e);
		} catch (UnsupportedJwtException e) {
			logger.info("Unsupported JWT token.");
			logger.trace("Unsupported JWT token trace: {}", e);
		} catch (IllegalArgumentException e) {
			logger.info("JWT token compact of handler are invalid.");
			logger.trace("JWT token compact of handler are invalid trace: {}", e);
		}
		return false;
	}
}
