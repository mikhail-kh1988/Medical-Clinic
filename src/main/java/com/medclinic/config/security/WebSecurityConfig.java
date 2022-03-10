package com.medclinic.config.security;

import com.medclinic.config.security.jwt.JwtFilter;
import com.medclinic.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private IUserService userService;

    @Autowired
    private CustomAuthenticateProvider customAuthenticateProvider;

    @Autowired
    private JwtFilter jwtFilter;


    @Bean
    public PasswordEncoder getPasswordEncoder(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        return encoder;
    }


    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider (){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticateProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                    .antMatchers("/app/doctors/**").hasAnyAuthority("DOCTOR")
                    .antMatchers("/app/medcards/**").hasAnyAuthority("DOCTOR")
                    .antMatchers("/app/users/**").hasAnyAuthority("DOCTOR")
                    .antMatchers("/app/results/**").hasAnyAuthority("DOCTOR")
                    .antMatchers("/app/analysis/**").hasAnyAuthority("DOCTOR")
                    .antMatchers("/app/clients/**").hasAnyAuthority("CLIENT")
                    .antMatchers( "/app/clients/register/**", "/app/auth/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin().permitAll()
                .and()
                    .logout()
                    .permitAll()
                .and()
                    .csrf().disable()
                    .cors().disable()
                .httpBasic().disable();
    }
}
