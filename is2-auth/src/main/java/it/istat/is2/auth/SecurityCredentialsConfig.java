package it.istat.is2.auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import it.istat.is2.auth.security.JwtAuthenticationEntryPoint;
import it.istat.is2.auth.security.JwtUsernameAndPasswordAuthenticationFilter;
import it.istat.is2.common.security.JwtConfig;


@EnableWebSecurity 
public class SecurityCredentialsConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
 	private  UserDetailsService userDetailsService;

	@Autowired
	private JwtConfig jwtConfig;
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		    .csrf().disable()
		     // make sure we use stateless session; session won't be used to store user's state.
	            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	      .and()
	            // handle an authorized attempts 
	         //   .exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
	      .exceptionHandling()
	     
	      .authenticationEntryPoint(jwtAuthenticationEntryPoint)
	      .and()
	    
		    // Add a filter to validate user credentials and add token in the response header
			
		    // What's the authenticationManager()? 
		    // An object provided by WebSecurityConfigurerAdapter, used to authenticate the user passing user's credentials
		    // The filter needs this auth manager to authenticate the user.
		    .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig))	
		.authorizeRequests()
		 .antMatchers("/api/v1/open/users").permitAll() 
		 	    // allow all POST requests 
		    .antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll()
		    
		     // any other requests must be authenticated
		    .anyRequest().authenticated();
	}
	
	// Spring has UserDetailsService interface, which can be overriden to provide our implementation for fetching user from database (or any other source).
	// The UserDetailsService object is used by the auth manager to load the user from database.
	// In addition, we need to define the password encoder also. So, auth manager can compare and verify passwords.
	 @Override
	    public void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	  }
	
	@Bean
	public JwtConfig jwtConfig() {
        	return new JwtConfig();
	}
	
  @Bean(name = "passwordEncoder")
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
  
 
  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
      return super.authenticationManagerBean();
  }
 
}
