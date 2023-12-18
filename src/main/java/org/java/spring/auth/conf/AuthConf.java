package org.java.spring.auth.conf;

import org.java.spring.auth.db.serv.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@CrossOrigin
public class AuthConf {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf().disable()
			.cors().disable()
			.authorizeHttpRequests()
			.requestMatchers("/photos/create/**").hasAnyAuthority("ADMIN", "GOD")	// PIZZA crete
			.requestMatchers("/photos/edit/**").hasAnyAuthority("ADMIN", "GOD") // PIZZA edit
			.requestMatchers("/categories/create/**").hasAnyAuthority("ADMIN", "GOD")	// INGREDIENT crete
			.requestMatchers("/api/photos/**").permitAll()
//			.requestMatchers("/css/**", "/js/**", "/webjars/**").permitAll()
			.and().formLogin()
			.and().logout();

		return http.build();
	}

	@Bean
	UserDetailsService userDetailsService() {
		return new UserService();
	}

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	DaoAuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

}
