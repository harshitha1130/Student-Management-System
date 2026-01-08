package config;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.IMPL.UserService;
import util.JwtUtil;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserService userDetailsService;
	
//	@Autowired
//    ApplicationContext context;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)

			throws ServletException, IOException{

		String authorizationHeader = request.getHeader("Authorization");

		String username = null;

		String token = null;
		// Check if the header starts with "Bearer "
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7); // Extract token
            username = jwtUtil.extractUsername(token); // Extract username from token
        }
 
        // If the token is valid and no authentication is set in the context
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            System.out.println("In filter  ...." +userDetails.getUsername() +" "+userDetails.getPassword());
            // Validate token and set authentication
            if (jwtUtil.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities()
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
 
        // Continue the filter chain
        try {
			chain.doFilter(request, response);
		} catch (java.io.IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		}
	
	}
	
	




















/*  if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {

			token = authorizationHeader.substring(7);

			username = jwtUtil.extractUsername(token);

		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			
			
			System.out.println("In filter  ...." +userDetails.getUsername() +" "+userDetails.getPassword());
			
			

			if (jwtUtil.validateToken(token, userDetails)) 
			{

				/*
				 * var authenticationToken = new org.springframework.security.authentication.
				 * UsernamePasswordAuthenticationToken(
				 * 
				 * userDetails, null, userDetails.getAuthorities());
				 * 
				 * authenticationToken.setDetails(new
				 * WebAuthenticationDetailsSource().buildDetails(request));
				 * 
				 * SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				 */
				
				
//				if (jwtUtil.validateToken(token, userDetails)) {
//	                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
//	                    userDetails,
//	                    null,
//	                    userDetails.getAuthorities()
//	                );
//	                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//	                SecurityContextHolder.getContext().setAuthentication(authToken);
//
//			}
			/*else
			{
            	System.out.println("Token validation failed for user: " + username); 

			}*/

//		}
			
			

		/*try {
			chain.doFilter(request, response);
		} catch (java.io.IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
			
			
//			chain.doFilter(request, response);

//		} */











/*if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
	 
	token = authorizationHeader.substring(7);

	username = jwtUtil.extractUsername(token);

}

if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

	UserDetails userDetails = context.getBean(UserDetailsService.class).loadUserByUsername(username);

	if (jwtUtil.validateToken(token, userDetails)) {

		var authenticationToken = new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(

				userDetails, null, userDetails.getAuthorities());

		authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
*/
