package com.chatter.service;

import com.chatter.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

public class UserAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        UserDto user = (UserDto) userDetailsService.loadUserByUsername(username);

        if(!matchPassword(username, password, user.getPassword())) {
            throw new BadCredentialsException(username);
        }
        if(!user.isEnabled()) {
            throw new BadCredentialsException(username);
        }

        return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

    private boolean matchPassword(String username, String loginPwd, String password) {
        loginPwd = loginPwd.replaceAll("['\"\\-!@#$%^&*()?]", "");
        String hashedPw = userService.getHashedPassword(username, loginPwd);

        return hashedPw.equals(password);
    }
}
