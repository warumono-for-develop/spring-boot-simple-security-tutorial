package com.warumono.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.warumono.domains.AuthenticatedUser;
import com.warumono.models.AuthenticatedUserDetails;
import com.warumono.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthenticatedUserDetailsService implements UserDetailsService
{
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		log.debug("username: {}", username);
		
		final Optional<AuthenticatedUser> user = userRepository.findOneByUsername(username);
		
		if(!user.isPresent())
		{
			throw new UsernameNotFoundException("Not found user with username '".concat(username).concat("'."));
		}
		
		log.debug("{}", user.get());
		
		return new AuthenticatedUserDetails(user.get());
	}

	public AuthenticatedUser persistUser(String name, String username, String password)
	{
		AuthenticatedUser user = AuthenticatedUser.user();
		user.setName(username);
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		
		user = userRepository.save(user);
		
		log.debug("{}", user);
		
		return user;
	}

}
