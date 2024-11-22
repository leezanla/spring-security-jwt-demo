/**
 * @author leezan
 * @Data 2024/11/20 22:28
 */
package cc.lz.springsecurityjwtdemo.config;

import cc.lz.springsecurityjwtdemo.filter.JWTFilter;
import cc.lz.springsecurityjwtdemo.handler.JwtAccessDeniedHandler;
import cc.lz.springsecurityjwtdemo.handler.JwtAuthenticationEntryPoint;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Resource
    private JWTFilter jwtFilter;

    @Resource
    private JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Resource
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorization ->
                        authorization.requestMatchers("/api/user/save", "/api/authenticate")
                                .permitAll()
                                .requestMatchers("/**")
                                .hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                                .anyRequest().permitAll())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(exception ->
                        exception.accessDeniedHandler(jwtAccessDeniedHandler)
                                .authenticationEntryPoint(jwtAuthenticationEntryPoint));
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
