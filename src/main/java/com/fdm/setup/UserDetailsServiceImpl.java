//package com.fdm.setup;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.fdm.dao.UserRepository;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//	
//	private final UserRepository userRepository;
//
//	@Autowired
//	public UserDetailsServiceImpl(UserRepository userRepository) {
//		super();
//		this.userRepository = userRepository;
//	}
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//		return userRepository.findByUsername(username)
//				.map(u -> new org.springframework.security.core.userdetails.User(
//						u.getUsername(),
//						u.getPassword(),
//						new ArrayList<>()))
//				.orElseThrow(() -> new UsernameNotFoundException("User '" + username + "' not found"));
//	}
//}
