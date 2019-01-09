package com.cattool.application.CATToolApp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.cattool.application.controller.ApplicationController;
import com.cattool.application.entity.Application;
import com.cattool.application.repository.ApplicationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//@Transactional
public class ApplicationTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	ApplicationController applicationController;
	
	@Before
	public void setUp() throws Exception
	{
//		mockMvc = 
	}
	@Test
	public void testgetAll() throws Exception
	{
		
	}
	
//	@Autowired
//	ApplicationRepository applicationRepository;
//	
//	
//	
//	@Test
//	public void getAllApplication()
//	{
//		assertNotNull(applicationRepository.findAll());
//	}
//	
//	@Test
//	public void saveApplication()
//	{
//		Application application=new Application();
//		applicationRepository.save(application);
//	}
//	
//	@Test
//	public void deleteApplicationById() {
//		System.out.println("***********************************");
//		applicationRepository.findByApplicationId(2);
//		System.out.println(applicationRepository.findByApplicationId(2));
//		System.out.println("***********************************");
//		applicationRepository.deleteByApplicationId(2);
//		assertNull(applicationRepository.findByApplicationId(2));
//	}
//	
//	@Test
//	public void updateApplication()
//	{
//		Application application=new Application();
//		applicationRepository.saveAndFlush(application);
//	}
//	

}
