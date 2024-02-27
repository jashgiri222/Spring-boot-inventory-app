package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.inventory.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	 User findByUserNameAndPassword(String userName,String password);

}
