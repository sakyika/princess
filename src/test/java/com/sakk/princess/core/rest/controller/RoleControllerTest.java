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

import com.sakk.princess.core.model.Role;
import com.sakk.princess.core.rest.controller.RoleController;
import com.sakk.princess.core.service.RoleService;

public class RoleControllerTest {
	
	@InjectMocks
	private RoleController controller;

	@Mock
	private RoleService service;

	private MockMvc mockMvc;

	// private ArgumentCaptor<User> accountCaptor;

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

	}
	/*
	
	@Test 
	public void getExistingRole() throws Exception{
		Role role = new Role();
		role.setId(56L);
		role.setRolename("Role56");
		
		when(service.getRole(56L)).thenReturn(role);
		
		mockMvc.perform(get("/rest/role/56"))
			.andDo(print())
			.andExpect(jsonPath("$.roleName", is(role.getRolename())))
			.andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/rest/role/56"))))
			.andExpect(status().isOk());
		
	}
	
	

	@Test
	public void getRoles() throws Exception {

		List<Role> roles = new ArrayList<Role>();

		Role roleA = new Role();
		roleA.setId(10L);
		roleA.setRolename("roleA");
		roles.add(roleA);

		Role roleB = new Role();
		roleB.setId(11L);
		roleB.setRolename("roleB");
		roles.add(roleB);
		
		Role roleC = new Role();
		roleC.setId(13L);
		roleC.setRolename("roleC");
		roles.add(roleC);
		
		Role roleD = new Role();
		roleD.setId(14L);
		roleD.setRolename("roleD");
		roles.add(roleD);

		when(service.getRoles()).thenReturn(roles);

		mockMvc.perform(get("/rest/roles"))
				.andDo(print())
				.andExpect(
						jsonPath("$.users[*].username",
								hasItems(endsWith("userA"), endsWith("userB"), endsWith("userC"), endsWith("userD")))) 
				.andExpect(status().isOk());
	}
*/
}
