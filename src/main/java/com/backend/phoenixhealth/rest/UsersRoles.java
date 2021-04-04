package com.backend.phoenixhealth.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.phoenixhealth.dao.RoleRepo;
import com.backend.phoenixhealth.entity.Role;
import com.backend.phoenixhealth.jwt.DAOUser;
import com.backend.phoenixhealth.jwt.JwtUserDetailsService;
import com.backend.phoenixhealth.jwt.UserDao;

@RestController
@RequestMapping("/ph/users/v1")
public class UsersRoles {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JwtUserDetailsService userService;
	
	@Autowired
	UserDao userDAO;
	
	@Autowired
	RoleRepo roleRepo;
	
	//save new user..
	
	@PostMapping("/new")
	public DAOUser saveUser(@RequestBody DAOUser user) {
		
		//Set<Role> roles = user.getRoles();
		
		//user.setRoles(roles);
		//Role roles = roleRepo.findAllById(ids)
		
		userDAO.save(user);
		log.info("New user saved");
		
		DAOUser myUser = userDAO.findByUsername(user.getUsername());
		
		return myUser;
	}
	
	//Update User..
	
	@PutMapping("/update")
	public DAOUser updateUser(@RequestBody DAOUser user) {
		
		userDAO.save(user);
		
		DAOUser myUser = userDAO.findByUsername(user.getUsername());
		return myUser;
	}
	
	//save role..
	
	@PostMapping("/role/new")
	public List<Role> saveRole (@RequestBody Role role) {
		
		roleRepo.save(role);
		log.info("New role saved");
		
		List<Role> allRoles = roleRepo.findAll();
		
		return allRoles;
	}
	
	//delete Role..
	
	@DeleteMapping("/role/delete")
	public List<Role> deleteRole(@PathVariable int role_id){
		
		roleRepo.deleteById(role_id);
		
		List<Role> allRoles = roleRepo.findAll();
		
		return allRoles;
	}
	
}
