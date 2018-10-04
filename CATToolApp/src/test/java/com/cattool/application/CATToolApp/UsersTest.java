package com.cattool.application.CATToolApp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.cattool.application.entity.Users;
import com.cattool.application.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UsersTest {
	
	@Autowired
	UserRepository userRepository;
	
	Users user=new Users();
	
	
	@Test
	public void findAllUsers() {
		
		assertNotNull(userRepository.findAll());
	}

	@Test
	public void saveUser() {
		userRepository.save(user);
		assertNotNull(user);
	}
	
	@Test
	public void deleteById() {
		userRepository.deleteByUserId(1);
		assertNull(userRepository.findByUserId(1));
	}
	
	@Test
	public void updateUsers() {
		userRepository.saveAndFlush(user);
	}

}
