package me.BaHeTo0.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.httpBasic()
			.and()
			.authorizeRequests()
				.antMatchers("/v2/api-docs",
	                        "/configuration/ui",
	                        "/swagger-resources/**",
	                        "/configuration/security",
	                        "/swagger-ui.html",
	                        "/webjars/**").permitAll()
				.anyRequest().permitAll()
			.and()
			.csrf().disable()
			.formLogin().disable();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("admin").password("{noop}admin").roles("ADMIN", "USER");
	}
}
