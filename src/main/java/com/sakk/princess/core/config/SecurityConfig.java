package com.sakk.princess.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import com.sakk.princess.core.exceptions.AccessDeniedExceptionHandler;
import com.sakk.princess.core.exceptions.AuthenticationFailureHandler;
import com.sakk.princess.core.exceptions.AuthenticationSuccessHandler;
import com.sakk.princess.core.exceptions.EntryPointUnauthorizedHandler;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"com.sakk.princess.core.exceptions", "com.sakk.princess.core.service"})
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationFailureHandler AuthenticationFailureHandler;
	
	@Autowired
	private AuthenticationSuccessHandler AuthenticationSuccessHandler;
   
	
	@Autowired
	private EntryPointUnauthorizedHandler entryPointUnauthorizedHandler;
	
	@Autowired
	private UserDetailsService userDetailsService;


    @Autowired
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
        	.authenticationProvider(daoAuthenticationProvider())
            .userDetailsService(userDetailsService);
        	
    }
 
    @Autowired
    AccessDeniedExceptionHandler accessDeniedExceptionHandler;
    
    @Override public void configure(WebSecurity web) throws Exception{
    	web.ignoring()
    		.antMatchers("/v2/api-docs")
    		.antMatchers("/swagger-resources")
    		.antMatchers("/configuration/security")
    		.antMatchers("/configuration/ui")
    		.antMatchers("/swagger-resources")
    		.antMatchers("/swagger-ui.html")
    		.antMatchers("/resources/**")
    		.antMatchers("/webjars/**")
    		.antMatchers("/app/**");
    }
   
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
        http
        	.httpBasic()
        	.and()
        	.authorizeRequests()
        		.anyRequest().authenticated()
        		.and()
        	.exceptionHandling()
        		.authenticationEntryPoint(entryPointUnauthorizedHandler)
        	.and()
        	.formLogin()
        		.successHandler(AuthenticationSuccessHandler)
        		.failureHandler(AuthenticationFailureHandler)
        	.and()
        	.logout()
        		.logoutSuccessUrl("/app/index.html#/login")
        	.and().csrf().disable()
        	.headers().contentTypeOptions();
        	//.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
        	//.csrf().csrfTokenRepository(csrfTokenRepository());
    	         
    }
    
    private CsrfTokenRepository csrfTokenRepository(){
    	HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
    	repository.setHeaderName("X-XSRF-TOKEN");
    	
    	return repository;
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
    	
    	DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    	
    	daoAuthenticationProvider.setUserDetailsService(userDetailsService);
    	daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    	
    	return daoAuthenticationProvider;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
 
}