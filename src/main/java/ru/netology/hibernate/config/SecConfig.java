package ru.netology.hibernate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class SecConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin1").password("{noop}admin").roles("admin")
                .and().withUser("justUserPetrov").password("{noop}123").roles()
                .and().withUser("userRead").password("{noop}1").roles("READ", "admin")
                .and().withUser("userWrite").password("{noop}2").roles("WRITE", "admin")
                .and().withUser("userDelete").password("{noop}3").roles("DELETE", "admin")
                .and().withUser("userMultiRoles").password("{noop}4").roles("READ", "WRITE", "DELETE", "admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeHttpRequests().antMatchers("/persons/by-city").permitAll()
                .and()
                .authorizeHttpRequests().antMatchers("/persons/by-age", "/persons/by-name-surname").hasRole("admin");
    }
}
