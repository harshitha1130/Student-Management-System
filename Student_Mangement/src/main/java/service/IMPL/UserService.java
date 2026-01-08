package service.IMPL;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import config.UserPrincipal;
import entity.User;
import repo.UserRepository;

@Service
public class UserService implements UserDetailsService{
	@Autowired
    private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder encoder;
 
 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	User user = userRepo.findByUsername(username);

    	System.out.println("user Name ----> :" + username);
    	if (user == null) {

    	throw new UsernameNotFoundException("User not found");

    	}

    	return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());

    }
    
    public String addUser(User userInfo) {
        // Encode password before saving the user
    	System.out.println("hitting the add user request ");
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        userRepo.save(userInfo);
        return "User Added Successfully";
    }
    
	
}












/*  @Autowired
	private UserRepository userRepository;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	User user = userRepository.findByUsername(username);

	if (user == null) {

	throw new UsernameNotFoundException("User not found");

	}

	return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());

	}
	
	
	public User loadUserByUsername2(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		
		return user;
		
	}
	 */