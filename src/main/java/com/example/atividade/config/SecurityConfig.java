package com.example.atividade.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.atividade.service.UsuarioService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	  SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		 return httpSecurity
                 .csrf(AbstractHttpConfigurer::disable)
                 .formLogin(configure -> configure.loginPage("/login").permitAll())
                 .httpBasic(Customizer.withDefaults())
                 .headers(headers -> headers.frameOptions().sameOrigin())//acessar h2 
                 .authorizeHttpRequests(http -> {

                     http.requestMatchers("/banco/**").permitAll();
                     http.requestMatchers("/").permitAll();


                     http.requestMatchers(HttpMethod.GET, "/produto/**").hasAnyRole("ADM","ATEND");

                     http.requestMatchers(HttpMethod.POST, "/deposito/**").hasAnyRole("ADM","ALMOX");
                     http.requestMatchers(HttpMethod.GET, "/deposito/**").hasAnyRole("ADM","ALMOX");
                     http.requestMatchers(HttpMethod.PUT, "/deposito/**").hasAnyRole("ADM","ALMOX");
                     http.requestMatchers(HttpMethod.GET, "/produto/**").hasAnyRole("ADM","ALMOX");
                     http.requestMatchers(HttpMethod.PUT, "/produto/**").hasAnyRole("ADM","ALMOX");
                     http.requestMatchers(HttpMethod.POST, "/produto/**").hasAnyRole("ADM","ALMOX");
                     
                     http.requestMatchers("/roles/**").hasRole("ADM");


                    


                     http.anyRequest().authenticated();
                 })

                 .build();
	 }
	
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
	
	
	@Bean
	UserDetailsService userDatailsService(UsuarioService usuarioService) {
		
		return new CustomUserDetailsService(usuarioService);
	}
}
