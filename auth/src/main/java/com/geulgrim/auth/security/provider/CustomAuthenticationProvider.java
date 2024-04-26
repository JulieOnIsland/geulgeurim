package com.geulgrim.auth.security.provider;

import com.geulgrim.auth.user.application.CustomUserDetailsService;
import com.geulgrim.auth.user.application.CustomUserDetailsService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    private CustomUserDetailsService customUserDetailsService;
    private PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        //이메일 검증
        UserDetails user = customUserDetailsService.loadUserByUsername(email);
        if(user == null) throw  new UsernameNotFoundException("UsernameNotFoundException");

        return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
