package com.paymybuddy.paymybuddy.config;

import com.paymybuddy.paymybuddy.security.CustomUserDetailsService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private DataSource dataSource;

    /**
     * Method to encode the password user.
     *
     */
    @Contract(" -> new")
    @Bean
    public static @NotNull PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(@NotNull HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/resources/**", "/static/**").permitAll()
                        .requestMatchers("/register/**").permitAll()
                        .requestMatchers("/login/**").permitAll()
//                        .requestMatchers("/register.css", "/login.css").permitAll()
                        .anyRequest().authenticated()
                )
                .csrf().disable()
                // Auth
                .authenticationProvider(authenticationProvider())
                // Login
                .formLogin((form) -> form
                        .loginPage("/login")
//                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/home",true)
                        .permitAll()
                )
                // Logout
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");

        return http.build();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(@NotNull HttpSecurity http) throws Exception {
//        http.httpBasic().disable();
//        http.csrf().disable()
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/register/**").permitAll()
//                        .requestMatchers("/login/**").permitAll()
//                        .requestMatchers("/login.css", "/register.css").permitAll()
//                        .anyRequest().authenticated()
//                )
//                // Login
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/home",true)
//                .permitAll()
//                .and()
//                 // Remember me option
//                .rememberMe()
////                .alwaysRemember(true)
////                .tokenRepository(persistentTokenRepository())
//                .rememberMeParameter("remember-me") // Name of checkbox at login page.
////                .rememberMeCookieName("rememberlogin") // Name of the cookie.
////                .tokenValiditySeconds(86400)
////                .useSecureCookie(true)
//                .and()
//                // Logout
//                .logout()
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login");
//
//        http.authenticationProvider(authenticationProvider());
//
//        return http.build();
//    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(@NotNull AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

//    @Bean
//    public PersistentTokenRepository persistentTokenRepository() {
//        TokenRepositoryImpl tokenRepository = new TokenRepositoryImpl();
//        tokenRepository.setDataSource(dataSource);
//
//        return tokenRepository;
//    }
}