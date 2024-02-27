package com.inventory.service.impl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventory.entity.User;
import com.inventory.repository.UserRepository;
import com.inventory.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User addNewUser(User user) {
		User userData = new User();
		userData.setFirstName(user.getFirstName());
		userData.setLastName(user.getLastName());
		userData.setUserName(user.getUserName());
		userData.setPassword(user.getPassword());
		userData.setCreatedBy(user.getLastName() + "," + user.getFirstName());
		userData.setCreatedOn(new Date());
		return userRepository.save(userData);
	}

	@Override
	public boolean validateUser(String userName, String password) {

		User userCredentials = userRepository.findByUserNameAndPassword(userName, password);

		if (userCredentials != null) {
			return true;

		} else {
			return false;

		}

	}

}
