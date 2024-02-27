package com.inventory.service;

import com.inventory.entity.User;

public interface UserService {
	
	public User addNewUser(User user);
	
	public boolean validateUser(String userName,String password);

}
