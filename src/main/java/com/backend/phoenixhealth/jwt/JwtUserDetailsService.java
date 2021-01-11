package com.backend.phoenixhealth.jwt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOUser user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		//return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				//new ArrayList<>());
		return new MyUserDetails (user);
	}

	public DAOUser save(DAOUser user) {
		//DAOUser newUser = new DAOUser();
		//newUser.setUsername(user.getUsername());
		//newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		user.setFullname(user.getFullname());
		user.setUsername(user.getUsername());
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		user.setEnabled(user.isEnabled());
		
		return  userDao.save(user);
	}

}