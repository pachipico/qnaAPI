package com.bootproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.bootproject.config.security.JwtAuthenticationFilter;
import com.bootproject.config.security.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private final JwtTokenProvider jwtTokenProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.httpBasic().disable()
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
				.authorizeRequests()
					.antMatchers("/*/login", "/*/signup").permitAll()
					.anyRequest().hasRole("USER")
			.and()
				.addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		
		web.ignoring().antMatchers("/v2/api-docs");
	}

	

	
	
	

}
