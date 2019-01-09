package com.cattool.application.CATToolApp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.cattool.application.controller.UserController;
import com.cattool.application.entity.Users;
import com.cattool.application.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UsersTest {
	
	
	
//	@Autowired
//	UserRepository userRepository;
//	
//	
//	
//	Users user=new Users();
//	
	 private MockMvc restMyRestControllerMockMvc;

	    @Autowired
	    private WebApplicationContext context;

	    @Before
	    public void setup() {
	        final UserController userController = new UserController();
//	        this.restMyRestControllerMockMvc = MockMvcBuilders.standaloneSetup(myRestController)
//	                .build();
	        this.restMyRestControllerMockMvc = MockMvcBuilders.webAppContextSetup(context)
	                .build();
	    }
	    int value=26;

	    @Test
	    public void getMyDataTest() throws Exception {
	    	restMyRestControllerMockMvc.perform(MockMvcRequestBuilders.get("/user/getTotalUsersCount"))
	    	.andExpect(MockMvcResultMatchers.status().isOk());
	    	//.andExpect(MockMvcResultMatchers.content().string("26");
	      //  restMyRestControllerMockMvc.perform(get("/api/mydata"));
	    }
	
	
//	@Test
//	public void findAllUsers() {
//		
//		assertNotNull(userRepository.findAll());
//	}
//
//	@Test
//	public void saveUser() {
//		userRepository.save(user);
//		assertNotNull(user);
//	}
//	
//	
//	
//	@Test
//	public void deleteById() {
//		userRepository.deleteByUserId(1);
//		assertNull(userRepository.findByUserId(1));
//	}
//	
//	@Test
//	public void updateUsers() {
//		userRepository.saveAndFlush(user);
//	}

}
