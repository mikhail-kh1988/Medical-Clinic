/*
package com.medclinic.config.security;

import com.medclinic.entity.User;
import com.medclinic.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticateProvider implements AuthenticationProvider {

    @Autowired
    private IUserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String login = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userService.findByLogin(login);

        if (user != null || user.getPassword().equals(password)){
            return new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword(), user.getAuthorities());
        }else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
*/
