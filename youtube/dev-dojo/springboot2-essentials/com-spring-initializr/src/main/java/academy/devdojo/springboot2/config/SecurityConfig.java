package academy.devdojo.springboot2.config;

import academy.devdojo.springboot2.service.DevDojoUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Log4j2
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final DevDojoUserDetailsService devDojoUserDetailsService;

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests((authz) -> authz.requestMatchers("/animes/admin/**").hasRole("ADMIN").requestMatchers("/animes/**").hasRole("USER").anyRequest().authenticated()).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    protected AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        log.info("password enconder: '{}'", passwordEncoder.encode("academy"));
        authenticationManagerBuilder.userDetailsService(devDojoUserDetailsService).passwordEncoder(passwordEncoder);
        return authenticationManagerBuilder.build();
    }
}