package com.android.ecommerce.configuration;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.android.ecommerce.jwt.JwtAuthentificationFilter;
import com.android.ecommerce.repository.UserRepository;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	private final JwtAuthentificationFilter jwtAuthFilter;
	private final AuthenticationProvider authentificationProvider;

	public SecurityConfiguration(JwtAuthentificationFilter jwtAuthFilter,
			AuthenticationProvider authentificationProvider, UserRepository userRepository) {
		this.jwtAuthFilter = jwtAuthFilter;
		this.authentificationProvider = authentificationProvider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		try {
			http.csrf(csrf -> csrf.disable())
			.cors(Customizer.withDefaults())
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/api/auth/**",
					          "/api/auth/**",
					            "/v3/api-docs",
					            "/v3/api-docs/**",
					            "/swagger-ui.html",
					            "/swagger-ui/**", // Swagger UI v3 paths
					            "/swagger-resources/**",
					            "/configuration/ui",
					            "/configuration/security",
					            "/webjars/**").permitAll()
					//.requestMatchers("/api/monument/admin/**").hasAnyAuthority(Role.ADMINISTRATEUR.toString())
					//.requestMatchers("/api/celebrite/admin/**").hasAnyAuthority(Role.ADMINISTRATEUR.toString())
					//.anyRequest().authenticated()
					.anyRequest().permitAll()
					//.anyRequest().hasAnyAuthority(Role.ADMINISTRATEUR.toString(), Role.TOURISTE.toString())
					)
			.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authenticationProvider(authentificationProvider)
			.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 


		return http.build();
	}
}
