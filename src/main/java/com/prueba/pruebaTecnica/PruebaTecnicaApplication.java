package com.prueba.pruebaTecnica;

import com.prueba.pruebaTecnica.security.Auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class PruebaTecnicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaTecnicaApplication.class, args);
	}


	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new Auth(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
				//.antMatchers(HttpMethod.POST, "/api/usuarios/guardar").permitAll()
				//.antMatchers(HttpMethod.POST, "/api/tareas/guardar").permitAll()
				.antMatchers(HttpMethod.GET,
				"/swagger-resources/**",
				"/swagger-ui.html",
				"/v2/api-docs",
				"/webjars/**"
				).permitAll()
				.anyRequest().authenticated();
		}
	}

}
