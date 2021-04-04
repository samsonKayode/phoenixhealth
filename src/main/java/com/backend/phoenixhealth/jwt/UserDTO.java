package com.backend.phoenixhealth.jwt;

public class UserDTO {
	private String username;
	private String password;
	private String fullname;
	private boolean enabled;
	
	public DAOUser getUserFromDTO() {
		
		DAOUser user = new DAOUser();
		
		user.setUsername(username);
		user.setPassword(password);
		user.setFullname(fullname);
		user.setEnabled(enabled);
		
		return user;
	}

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
