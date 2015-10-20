package com.sakk.princess.core.rest.controller;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.*;
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
	private UserController userController;

	@Mock
	private UserService userService;

	private MockMvc mockMvc;

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

	}
	
	@Test 
	public void getExistingUser() throws Exception{
		User user = new User();
		user.setId(56L);
		user.setEnabled(true);
		user.setUsername("kwadwo");
		user.setPassword("password");
		user.setRole(null);
		
		when(userService.getUser(56L)).thenReturn(user);
		
		mockMvc.perform(get("/rest/users/56"))
			.andDo(print())
			.andExpect(jsonPath("$.username", is(user.getUsername())))
			.andExpect(jsonPath("$.role", is(nullValue())))
			.andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/rest/users/56"))))
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

		when(userService.getUsers()).thenReturn(users);

		mockMvc.perform(get("/rest/users"))
				.andDo(print())
				.andExpect(jsonPath("$.users[0].username", hasItem("userA")))
				.andExpect(jsonPath("$.users[1].username", hasItem("userB")))
				.andExpect(jsonPath("$.users[2].username", hasItem("userC")))
				.andExpect(jsonPath("$.users[3].username", hasItem("userD")))
				.andExpect(status().isOk());
	}

}
