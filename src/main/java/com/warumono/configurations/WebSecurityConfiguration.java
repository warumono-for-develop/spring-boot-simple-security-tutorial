package com.warumono.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.warumono.services.AuthenticatedUserDetailsService;

@EnableWebSecurity
@Configuration
@Order(value = SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter
{
	@Autowired
	private AuthenticatedUserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
			.csrf().disable()
			.headers()
				.frameOptions().disable()
			
			.and()
		
			.formLogin()
				.loginPage("/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.loginProcessingUrl("/signin")
				.defaultSuccessUrl("/success", true)
				.failureUrl("/failure")
			
			.and()
			
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
			
			.and()
			
			.exceptionHandling()
				.accessDeniedPage("/denied")
			
			.and()
			
			.sessionManagement()
				.invalidSessionUrl("/invalid")
			
			.and()
			
			.authorizeRequests()
				.antMatchers("/app/**/*.css", "/app/**/*.js").permitAll()
				.antMatchers("/regist", "/login").anonymous()
				.antMatchers("/", "/index", "/crossroads", "/registration").permitAll()
				.antMatchers("/failure", "/denied", "invalid", "/success").permitAll()
				.antMatchers("/h2-console/**").permitAll()
				.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
				.antMatchers("/staff/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_STAFF")
				.antMatchers("/user/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN", "ROLE_STAFF")
//				.antMatchers("/admin/**").hasRole("ADMIN")
//				.antMatchers("/staff/**").hasAnyRole("ADMIN", "STAFF")
//				.antMatchers("/user/**").hasAnyRole("USER", "ADMIN", "STAFF")
				.anyRequest().authenticated();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
	}
}
