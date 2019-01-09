package com.cattool.application.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class ApplicationControllerTest {

	
	private MockMvc mockMvc;
	
	@InjectMocks
	ApplicationController applicationController;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(applicationController).build();
	}
	
	@Test
	public void testGetAllApplicationCount() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/application/getTotalApplicationsCount"))
		.andExpect(MockMvcResultMatchers.status().isOk());
//		.andExpect(MockMvcResultMatchers.content().)
		
//		fail("Not yet implemented");
		
		
	}
	
	
	  
	
	
	
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}

//	

//	@After
//	public void tearDown() throws Exception {
//	}

	
	

//	@Test
//	public void testGetAllApplication() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetAllFinalizeAplication() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetApplicationById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSaveApplication() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetApplicationByName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetAppByUser() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateApplication() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteApplication() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testResetApplication() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeactivateApplication() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetAllReassessment() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAllRuleCheck() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testMigrationCheck() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCloudProviderCheck() {
//		fail("Not yet implemented");
//	}

}
