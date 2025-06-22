import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// ...
@Autowired
private AuthTokenFilter authTokenFilter; // Inject your JWT filter
@Autowired
private AuthEntryPointJwt unauthorizedHandler; // Inject your JWT entry point

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler)) // Handle unauthorized errors
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Crucial for JWT!
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/auth/**").permitAll()
            .anyRequest().authenticated()
        );

    http.addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class); // Add your JWT filter before
    return http.build();
}
