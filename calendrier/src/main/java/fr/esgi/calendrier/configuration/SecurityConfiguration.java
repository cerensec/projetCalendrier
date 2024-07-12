package fr.esgi.calendrier.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())

                .formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/calendar")
                        .failureUrl("/login-error")
                        .permitAll()
                )

                .authorizeHttpRequests(requests ->
                        requests.requestMatchers("/signup", "/login").permitAll()
                                .requestMatchers("/swagger-ui/**").permitAll()
                                .requestMatchers("/v3/api-docs/**").permitAll()
                                .requestMatchers("/index").authenticated()
                                .requestMatchers("/h2-console/**").permitAll()
                                .requestMatchers("/beans").permitAll()
                                .requestMatchers(HttpMethod.POST, "/user/**").permitAll()
                )
                .headers(header -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
        return http.build();
    }
}
