package com.geulgrim.auth.security.config.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geulgrim.auth.user.application.dto.CustomAuthenticationToken;
import com.geulgrim.auth.user.application.dto.UserLoginRequestDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;

import java.io.IOException;

public class CustomAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public CustomAuthenticationFilter(){
        super(new AntPathRequestMatcher("/api/v1/auth/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        if(!HttpMethod.POST.name().equals(request.getMethod()) || isAjax(request)){
            throw new IllegalArgumentException("Authentication method not supported: ");
        }

        UserLoginRequestDto dto = objectMapper.readValue(request.getReader(), UserLoginRequestDto.class);

        if(!StringUtils.hasText(dto.getEmail()) || !StringUtils.hasText(dto.getPassword())){
            throw new AuthenticationServiceException("User Email not provided");
        }

        CustomAuthenticationToken token = new CustomAuthenticationToken(dto.getEmail(),dto.getPassword());

        return this.getAuthenticationManager().authenticate(token);
    }

    public static boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }
}
