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

import com.sakk.princess.core.model.Permission;
import com.sakk.princess.core.rest.controller.PermissionController;
import com.sakk.princess.core.service.PermissionService;

public class PermissionControllerTest {

	@InjectMocks
	private PermissionController controller;

	@Mock
	private PermissionService service;

	private MockMvc mockMvc;

	// private ArgumentCaptor<User> accountCaptor;

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

	}
/*
	@Test
	public void getExistingPermission() throws Exception {
		Permission permission = new Permission();
		permission.setId(56L);
		permission.setPermissionName("Permission56");

		when(service.getPermission(56L)).thenReturn(permission);

		mockMvc.perform(get("/rest/permission/56"))
				.andDo(print())
				.andExpect(
						jsonPath("$.permissionName",
								is(permission.getPermissionName())))
				.andExpect(
						jsonPath("$.links[*].href",
								hasItem(endsWith("/rest/permission/56"))))
				.andExpect(status().isOk());

	}

	@Test
	public void getPermissions() throws Exception {

		List<Permission> permissions = new ArrayList<Permission>();

		Permission permissionA = new Permission();
		permissionA.setId(10L);
		permissionA.setPermissionName("permissionA");
		permissions.add(permissionA);

		Permission permissionB = new Permission();
		permissionB.setId(11L);
		permissionB.setPermissionName("permissionB");
		permissions.add(permissionB);

		Permission permissionC = new Permission();
		permissionC.setId(13L);
		permissionC.setPermissionName("permissionC");
		permissions.add(permissionC);

		Permission permissionD = new Permission();
		permissionD.setId(14L);
		permissionD.setPermissionName("permissionD");
		permissions.add(permissionD);

		when(service.getPermissions()).thenReturn(permissions);

		mockMvc.perform(get("/rest/permissions")).andDo(print())
		
		 .andExpect( jsonPath("$.users[*].username",
		 hasItems(endsWith("userA"), endsWith("userB"), endsWith("userC"),
		 endsWith("userD"))))
		 
		.andExpect(status().isOk());
	}
*/
}
