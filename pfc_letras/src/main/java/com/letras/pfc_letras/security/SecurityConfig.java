package com.letras.pfc_letras.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/register").permitAll() // Permitir acceso sin autenticación a estas rutas
                                .anyRequest().authenticated() // Requerir autenticación para cualquier otra ruta
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login").permitAll() // Página de inicio de sesión personalizada y permitir acceso sin autenticación
                )
                .logout(LogoutConfigurer::permitAll // Permitir acceso sin autenticación al proceso de cierre de sesión
                );
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/css/**", "/js/**", "/images/**");
    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(request -> request
//                        .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
//                        .requestMatchers(new AntPathRequestMatcher("/admin/**")).hasRole("ADMIN")
//                        .requestMatchers(new AntPathRequestMatcher("/letras/**")).hasRole("USER")
//                        .requestMatchers(HttpMethod.POST, "register").permitAll()
//                        .anyRequest().permitAll()
//                )
//                .formLogin(formLogin ->
//                        formLogin
//                                .loginPage("/login")
//                                .loginProcessingUrl("/login-process")
//                                .failureUrl("/login?error")
//                                .usernameParameter("username")
//                                .passwordParameter("password")
//                                .successHandler(authenticationSuccessHandler())
//                                .failureHandler(authenticationFailureHandler())
//                                .permitAll()
//                )
//                .build();
//    }
//
//    @Bean
//    public AuthenticationSuccessHandler authenticationSuccessHandler() {
//        return (request, response, authentication) -> {
//            response.sendRedirect("/");
//        };
//    }
//
//    @Bean
//    public AuthenticationFailureHandler authenticationFailureHandler() {
//        return (request, response, exception) -> {
//            response.sendRedirect("/login?error");
//        };
//    }
}
