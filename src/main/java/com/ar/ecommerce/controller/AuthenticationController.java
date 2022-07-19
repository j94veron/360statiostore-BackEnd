package com.ar.ecommerce.controller;

import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ar.ecommerce.dto.FormLoginDTO;
import com.ar.ecommerce.dto.LoginDTO;
import com.ar.ecommerce.model.Customer;
import com.ar.ecommerce.security.CustomUserDetails;
import com.ar.ecommerce.security.JWTProvider;
import com.ar.ecommerce.service.api.UserService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	private static final String REFRESH_TOKEN_PATH = "/refresh_token";
	
	private static final String LOGIN_TOKEN_PATH = "/login";
			
	@Autowired
	private UserService usuarioService;
	
	@Autowired
	private JWTProvider jwtProvider;


	@PostMapping(value = LOGIN_TOKEN_PATH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginDTO> authenticate(@RequestBody @Validated FormLoginDTO request) {
		Customer user = usuarioService.findByUserName(request.getUsername());
		UsernamePasswordAuthenticationToken auhtenToken = getSecurityUser(user, request.getPassword());
		SecurityContextHolder.getContext().setAuthentication(auhtenToken);
		Map<String, String> tokenMap = jwtProvider.createToken(auhtenToken);
		return ResponseEntity.ok(new LoginDTO(user.getUsername(), tokenMap.get("token"), tokenMap.get("refresh_token"), user.getName(), user.getSurname(), user.getRole(), user.getAddress(), user.getEmail(), user.getPhone() ));
	}
	
	@GetMapping(value = REFRESH_TOKEN_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, String>> refreshToken(Authentication authentication) {
		return ResponseEntity.ok(jwtProvider.createToken(authentication));
	}
	
	private UsernamePasswordAuthenticationToken getSecurityUser(Customer user, String password) {	
		String passwordDecryt = new String(Base64.getDecoder().decode(user.getPassword()));
		if (!passwordDecryt.equals(password)) {
			 throw new BadCredentialsException("User/password incorrectas.");
		}
		List<GrantedAuthority> grantedAuthorities = List.of(new SimpleGrantedAuthority(user.getRole()));
		return new UsernamePasswordAuthenticationToken(new CustomUserDetails(user.getUsername(), passwordDecryt, grantedAuthorities), user.getId(), grantedAuthorities);
	}
}
