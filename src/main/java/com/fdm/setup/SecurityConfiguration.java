//package com.fdm.setup;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//	private final UserDetailsServiceImpl userDetailsService;
//	
//	@Autowired
//	public SecurityConfiguration(UserDetailsServiceImpl userDetailsService) {
//		super();
//		this.userDetailsService = userDetailsService;
//	}
//	
//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity
//			.csrf().disable()
//			.cors().disable()
//			.authorizeRequests()
//				.antMatchers("/login", "/getRegister", "/", "/processRegister")
//					.permitAll()
//				.anyRequest()
//					.authenticated()
//					.and()
//					.formLogin()
//					.defaultSuccessUrl("/home");
//	}
//	
//	
//	@Override
//	protected void configure(final AuthenticationManagerBuilder auth) throws Exception{
//		auth.userDetailsService(userDetailsService)
//			.and().inMemoryAuthentication()
//				.withUser("admin")
//					.password(passwordEncoder().encode("Password1"))
//					.roles("ADMIN");
//	}
//	
//	@Bean(name="passwordEncoder")
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(11);
//    }
//
//
//}
