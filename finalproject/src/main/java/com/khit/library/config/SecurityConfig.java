package com.khit.library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private CustomUserDetailsService customService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.userDetailsService(customService);

        http
                .authorizeHttpRequests(authroize -> authroize
                        .requestMatchers("/", "/css/**", "/images/**", "/js/**").permitAll()
                        .requestMatchers("/board/write").authenticated()
                        .requestMatchers("/member/list").hasAnyAuthority("Admin")
                        .requestMatchers("/member/**", "/board/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form.loginPage("/member/login")
                                .defaultSuccessUrl("/")
                );

        //접근권한 페이지
        http.exceptionHandling().accessDeniedPage("/auth/accessDenied");
        http.logout().logoutUrl("/member/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/");
        return http.build();
    }
    
    //암호화 설정
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
