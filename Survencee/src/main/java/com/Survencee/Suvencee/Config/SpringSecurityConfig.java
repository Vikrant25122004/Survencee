package com.Survencee.Suvencee.Config;

import com.Survencee.Suvencee.Filter.JwtFilter;
import com.Survencee.Suvencee.Services.ReporterServiceimpl;
import com.Survencee.Suvencee.Services.SurveyorServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
public class SpringSecurityConfig {
    @Autowired
    private SurveyorServiceimpl surveyorDetailsServiceimpl;
    @Autowired
    private ReporterServiceimpl reporterDetailServiceimpl;
    @Autowired
    private JwtFilter jwtFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return  http.csrf(AbstractHttpConfigurer::disable) // Disable CSRF as we're using JWT
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/Surveyor/**").authenticated()
                        .requestMatchers("/Reporter/**").authenticated()
                        .anyRequest().permitAll()) // Permit other requests
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)// Add JWT filter before UsernamePasswordAuthenticationFilter// Add vendor authentication provider
                .build();


    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();

    }
    @Bean
    public DaoAuthenticationProvider SurveyorAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(surveyorDetailsServiceimpl);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    @Bean
    public DaoAuthenticationProvider ReporterAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(reporterDetailServiceimpl);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
}
