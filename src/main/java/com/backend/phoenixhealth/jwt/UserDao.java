package com.backend.phoenixhealth.jwt;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<DAOUser, Integer> {
	
	public DAOUser findByUsername(String username);
	
	//UserDao getUserData(String username, String password);
}
