package com.ar.ecommerce.security;

import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetails extends User {
	
	private static final long serialVersionUID = 1L;
	
	public CustomUserDetails(String username, String password, List<GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
}
