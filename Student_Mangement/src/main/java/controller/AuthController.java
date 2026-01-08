package controller;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import entity.User;
import service.IMPL.UserService;
import util.JwtUtil;

@RestController
public class AuthController {

	
	@Autowired
	private AuthenticationManager authenticationManager;



	@Autowired
	private JwtUtil jwtUtil;
	
	
	@Autowired 
    @Qualifier("userService")
	private UserService service;



	@PostMapping("/authenticate")
	public ResponseEntity<String>authenticate(@RequestBody AuthRequest authRequest) throws Exception {

	try {

		authenticationManager.authenticate(

			new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

	}
	catch (BadCredentialsException e) {

		throw new Exception("Invalid credentials", e);

	}
	catch (DisabledException e) {

		throw new Exception("Account disabled", e); // Account disabled

		} catch (LockedException e) {

		throw new Exception("Account locked", e); // Account locked

		}

		String token = jwtUtil.generateToken(authRequest.getUsername());
		return ResponseEntity.ok(token);

	}
	
	
	@PostMapping("/addNewUser")
    public String addNewUser(@RequestBody User userInfo) {
		System.out.println("request hitted");
        return service.addUser(userInfo);
    }
	
	
	

	}



class AuthRequest {

	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

	
}
