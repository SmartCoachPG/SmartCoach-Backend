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
                .antMatchers(HttpMethod.POST, "/api/usuarios/iniciarsesion", "/api/usuarios/hashContraseñas", "/api/usuarioadministrador/crear","/api/usuariocliente/crear","/api/rutina/crear","/api/perfilmedico/crear","/api/valor/crear","/api/usuarioclienterestriccionmedica/crear").permitAll()
                .antMatchers(HttpMethod.GET, "/api/objetivorutina/crear","/api/grupomuscular/crear","/api/unidadmetrica/libre","/api/valorevaluacionfisica/libre","/api/restriccionmedica/libre","/api/usuarios/emailcheck/{email}").permitAll()
                .anyRequest().authenticated();

        // desarrollo
        /*
         http.cors().and().csrf().disable()
                .addFilterAfter(new AuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated();*/
    }
}