@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable()) // Disable CSRF for API (stateless)
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/auth/**").permitAll() // Allow unauthenticated access to auth endpoints
            .anyRequest().authenticated() // All other requests require authentication
        )
        .httpBasic(Customizer.withDefaults()); // Enable HTTP Basic Authentication

    return http.build();
}
