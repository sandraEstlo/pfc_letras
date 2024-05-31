package com.letras.pfc_letras.configurations;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Resource
    private UserDetailsService  userDetailsService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/register").permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/admin/**")).hasRole("ADMIN")
                                .requestMatchers(new AntPathRequestMatcher("/letras/**")).hasRole("USER")
                                .anyRequest().permitAll()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login").permitAll()
                                .loginProcessingUrl("/logincheck")
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .defaultSuccessUrl("/")
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/")
                                .permitAll()
                )
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/css/**", "/js/**", "/images/**");
    }

    @Resource
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

}
