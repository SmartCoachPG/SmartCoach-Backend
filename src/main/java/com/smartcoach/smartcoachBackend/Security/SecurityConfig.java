package com.smartcoach.smartcoachBackend.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // servicio
        http.cors().and().csrf().disable()
                .addFilterAfter(new AuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/api/usuarios/iniciarsesion","/api/usuarios/hashContraseñas").permitAll()
                .anyRequest().authenticated();

        // desarrollo
        /* http.cors().and().csrf().disable()
                .addFilterAfter(new AuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated();*/
    }
}