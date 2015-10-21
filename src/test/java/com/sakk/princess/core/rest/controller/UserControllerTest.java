package com.sakk.princess.core.rest.controller;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sakk.princess.core.model.Permission;
import com.sakk.princess.core.model.Role;
import com.sakk.princess.core.model.User;
import com.sakk.princess.core.rest.controller.UserController;
import com.sakk.princess.core.rest.resource.PermissionResource;
import com.sakk.princess.core.rest.resource.UserResource;
import com.sakk.princess.core.rest.resource.assembler.PermissionResourceAssembler;
import com.sakk.princess.core.rest.resource.assembler.UserResourceAssembler;
import com.sakk.princess.core.service.UserService;

public class UserControllerTest {

	@InjectMocks
	private UserController userController;

	@Mock
	private UserService userService;

	private MockMvc mockMvc;
	
	private ArgumentCaptor<User> userCaptor;

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
		
		userCaptor = ArgumentCaptor.forClass(User.class);

	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void getUsers() throws Exception {

		List<User> users = new ArrayList<User>();

		User userA = new User();
		userA.setId(10L);
		userA.setPassword("password");
		userA.setUsername("userA");
		users.add(userA);

		User userB = new User();
		userB.setId(11L);
		userB.setPassword("password");
		userB.setUsername("userB");
		users.add(userB);
		
		User userC = new User();
		userC.setId(12L);
		userC.setPassword("password");
		userC.setUsername("userC");
		users.add(userC);
		
		User userD = new User();
		userD.setId(14L);
		userD.setPassword("password");
		userD.setUsername("userD");
		users.add(userD);

		when(userService.getUsers()).thenReturn(users);

		mockMvc.perform(get("/rest/users"))
				.andDo(print())
				.andExpect(jsonPath("$.userListResource[*].username", hasItem("userA")))
				.andExpect(jsonPath("$.userListResource[*].username", hasItem("userB")))
				.andExpect(jsonPath("$.userListResource[*].username", hasItem("userC")))
				.andExpect(jsonPath("$.userListResource[*].username", hasItem("userD")))
				.andExpect(jsonPath("$.userListResource[*].username", hasItems(endsWith("userD"), endsWith("userC"), endsWith("userB"), endsWith("userA"))))
				.andExpect(status().isOk());
	}
		
	@Test
	public void getUserRole() throws Exception {
		
		Permission permissionA = new Permission();
		permissionA.setId(11L);
		permissionA.setPermissionName("TEST_CTRL_PERMISSION_PERMISSION_GET");
		
		Role roleA = new Role();
		roleA.setId(12L);
		roleA.setRolename("TEST_CTR_USER_USERROLE");
		roleA.setPermissionList(new ArrayList<Permission>());
		roleA.getPermissionList().add(permissionA);

		User userA = new User();
		userA.setId(10L);
		userA.setPassword("userA");
		userA.setUsername("userA");
		userA.setRole(roleA);

		when(userService.getUser(userA.getId())).thenReturn(userA);

		mockMvc.perform(get("/rest/users/10/role"))
			.andDo(print())
			.andExpect(jsonPath("$.id", is(12)))
			.andExpect(jsonPath("$.rolename", is("TEST_CTR_USER_USERROLE")))
			.andExpect(status().isOk());
	}
	
	@Test 
	public void getUser() throws Exception{
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
	public void createUser() throws Exception {
		
		User user = new User();
		user.setId(56L);
		user.setUsername("kwadwo");
		user.setPassword("password");
		
		when(userService.addUser(any(User.class))).thenReturn(user);
		
		mockMvc.perform(post("/rest/users")
			.content("{\"username\":\"kwadwo\",\"password\":\"password\"}")
			.contentType("application/hal+json"))
			.andDo(print())
			.andExpect(header().string("Location", endsWith("/rest/users/56")))
			.andExpect(jsonPath("$.username", is(user.getUsername())))
			.andExpect(status().isCreated());
		
		verify(userService).addUser(userCaptor.capture());
		
		String password = userCaptor.getValue().getPassword();
		assertEquals("password", password);
		
	}
	
	@Test
	public void deleteUser() throws Exception {
		
		User user = new User();
		user.setId(94L);
		user.setUsername("testUser");
		user.setPassword("password");
		
		when(userService.deleteUser(94L)).thenReturn(user);
		
		mockMvc.perform(delete("/rest/users/94"))
			.andDo(print())
			.andExpect(jsonPath("$.username", is(user.getUsername())))
			.andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/users/94"))))
			.andExpect(status().isOk());
		
	}
	
	@Test
	public void updateUser() throws Exception {
		User user = new User();
		user.setId(65L);
		user.setUsername("bestUser");
		
		when(userService.getUser(65L)).thenReturn(user);
		when(userService.updateUser(any(User.class))).thenReturn(user);
		
		mockMvc.perform(put("/rest/users/65")
			.content("{\"username\":\"bestUser\"}")
			.contentType("application/hal+json"))
			.andDo(print())
			.andExpect(status().isOk());
			
	}

}
