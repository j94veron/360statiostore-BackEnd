package com.ar.ecommerce.config;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.ar.ecommerce.constans.Roles;
import com.ar.ecommerce.security.JWTAuthenticationEntryPoint;
import com.ar.ecommerce.security.JWTFilter;
import com.ar.ecommerce.security.JWTProvider;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
		
	@Autowired
	private JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	private JWTProvider jwtProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors()
			.and()
				.csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
            	.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
			.and()
				.authorizeRequests()
				.antMatchers("/auth/login/**").permitAll()
				.antMatchers("/auth/refresh_token/**").authenticated()
				.antMatchers(HttpMethod.GET,"/customer/**").permitAll()
				.antMatchers(HttpMethod.POST,"/customer/**").permitAll()
				.antMatchers(HttpMethod.PUT,"/customer/**").permitAll()
				.antMatchers(HttpMethod.DELETE,"/customer/**").access(String.format("hasRole('%s')", Roles.ROLE_ADMIN))
				.antMatchers(HttpMethod.GET,"/product/**").permitAll()
				.antMatchers(HttpMethod.POST ,"/product/**").access(String.format("hasRole('%s')", Roles.ROLE_ADMIN))
				.antMatchers(HttpMethod.PUT ,"/product/**").access(String.format("hasRole('%s')", Roles.ROLE_ADMIN))
				.antMatchers(HttpMethod.DELETE ,"/product/**").access(String.format("hasRole('%s')", Roles.ROLE_ADMIN))
				.anyRequest().authenticated()
            .and()
				.addFilterBefore(new JWTFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class);
	}
	
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		final CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
		configuration.setAllowCredentials(true);
		configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/security", "/swagger-ui.html", "/webjars/**");
	}
}
