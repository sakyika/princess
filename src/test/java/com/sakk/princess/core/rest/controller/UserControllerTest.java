package com.sakk.princess.core.rest.controller;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sakk.princess.core.model.User;
import com.sakk.princess.core.rest.controller.UserController;
import com.sakk.princess.core.service.UserService;

public class UserControllerTest {

	@InjectMocks
	private UserController controller;

	@Mock
	private UserService service;

	private MockMvc mockMvc;

	// private ArgumentCaptor<User> accountCaptor;

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

	}
	/*
	@Test 
	public void getExistingUser() throws Exception{
		User user = new User();
		user.setId(56L);
		user.setUsername("kwadwo");
		user.setPassword("kwadwo");
		
		when(service.getUser(56L)).thenReturn(user);
		
		mockMvc.perform(get("/rest/user/56"))
			.andDo(print())
			.andExpect(jsonPath("$.username", is(user.getUsername())))
			.andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/rest/user/56"))))
			.andExpect(status().isOk());
		
	}
	
	

	@Test
	public void getUsers() throws Exception {

		List<User> users = new ArrayList<User>();

		User userA = new User();
		userA.setId(10L);
		userA.setPassword("userA");
		userA.setUsername("userA");
		users.add(userA);

		User userB = new User();
		userB.setId(11L);
		userB.setPassword("userB");
		userB.setUsername("userB");
		users.add(userB);
		
		User userC = new User();
		userC.setId(12L);
		userC.setPassword("userC");
		userC.setUsername("userB");
		users.add(userC);
		
		User userD = new User();
		userD.setId(14L);
		userD.setPassword("userD");
		userD.setUsername("userD");
		users.add(userD);

		when(service.getUsers()).thenReturn(users);

		mockMvc.perform(get("/rest/users"))
				.andDo(print())
				.andExpect(
						jsonPath("$.users[*].username",
								hasItems(endsWith("userA"), endsWith("userB"), endsWith("userC"), endsWith("userD")))) 
				.andExpect(status().isOk());
	}
*/
}
