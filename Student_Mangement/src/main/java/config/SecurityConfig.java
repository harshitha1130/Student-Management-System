package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import service.IMPL.UserService;

import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
 

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig   {

	@Autowired
	private JwtFilter jwtFilter;

//	@Autowired
//	private UserDetailsService userDetailsService;

//	@Autowired
//	private PasswordEncoder passwordEncoder;

//	@Bean
//	public UserDetailsService userDetailsService() {
//		return new InMemoryUserDetailsManager(
//				User.withUsername("user1").password(passwordEncoder().encode("password1")).build(),
//				User.withUsername("user2").password(passwordEncoder().encode("password2")).build());
//	}

	
	@Bean
    public UserDetailsService userDetailsService() {
        return new UserService(); // Ensure UserInfoService implements UserDetailsService
    }
	
		
	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();

	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		
		http
        .csrf(csrf -> csrf.disable()) // Disable CSRF for stateless APIs
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/authenticate","/addNewUser").permitAll()
        //    .requestMatchers("/auth/user/**").hasAuthority("ROLE_USER")
        //    .requestMatchers("/auth/admin/**").hasAuthority("ROLE_ADMIN")
        //    .requestMatchers("/actuator/**").hasAuthority("ROLE_ADMIN")
            .anyRequest().authenticated() // Protect all other endpoints
        )
        .sessionManagement(sess -> sess
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // No sessions
        )
        .authenticationProvider(authenticationProvider()) // Custom authentication provider
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class); // Add JWT filter

		return http.build();
		
		
		
		
		

	}

}




























/*
 * @Bean public AuthenticationManager authenticationManager(HttpSecurity http)
 * throws Exception {
 * 
 * AuthenticationManagerBuilder authenticationManagerBuilder =
 * 
 * http.getSharedObject(AuthenticationManagerBuilder.class);
 * 
 * authenticationManagerBuilder.userDetailsService(userDetailsService).
 * passwordEncoder(passwordEncoder());
 * 
 * return authenticationManagerBuilder.build();
 * 
 * }
 */




//@Bean
//public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration) throws Exception
//{
//	return authenticationConfiguration.getAuthenticationManager();
//}




/* http.csrf(csrf -> csrf.disable()) // Disable CSRF protection

				.authorizeRequests().requestMatchers("/authenticate","/addNewUser").permitAll().anyRequest().authenticated().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build(); */




//
//@Bean
//public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//  http
//      .csrf(csrf -> csrf.disable()) // Disable CSRF protection using Lambda DSL
//      .authorizeHttpRequests(authorizeRequests ->
//          authorizeRequests
//              .requestMatchers("/authenticate").permitAll()
//              .anyRequest().authenticated()
//      )
//      .sessionManagement(sessionManagement ->
//          sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//      );
//
//  http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//
//  return http.build();
//}
//






//@Bean
// authentication
//public UserDetailsService userDetailsService() {
// return new CustomUserDetailsService();
//}





//private final AuthenticationConfiguration authenticationConfiguration;     
//
//public SecurityConfig(AuthenticationConfiguration authenticationConfiguration) 
//{         
//	this.authenticationConfiguration = authenticationConfiguration; 
//}














/*    @Bean
  public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration) throws Exception
   {
    	return authenticationConfiguration.getAuthenticationManager();
  }
     
     @Bean 
	  public  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	  
	   http.csrf(csrf -> csrf.disable()) // Disable CSRF protection
	  
	  .authorizeRequests()
	  .requestMatchers("/authenticate").permitAll() 
	  .anyRequest().authenticated() 
	  .and()
	  .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	  
	  http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	  return http.build();
	  
	  }  */










/* 
//		http.csrf(csrf -> csrf.disable()) // Disable CSRF protection
//
//				.authorizeHttpRequests()
//				.requestMatchers("/authenticate","/addNewUser").permitAll().anyRequest().authenticated().and()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//		return http.build(); */