package com.sakk.princess.core.rest.controller;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.eq;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
import com.sakk.princess.core.model.Role;
import com.sakk.princess.core.rest.controller.PermissionController;
import com.sakk.princess.core.service.PermissionService;

public class PermissionControllerTest {

	@InjectMocks
	private PermissionController controller;

	@Mock
	private PermissionService permissionService;

	private MockMvc mockMvc;

	// private ArgumentCaptor<User> accountCaptor;

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

	}

	@Test
	public void getPermission() throws Exception {
		Permission permission = new Permission();
		permission.setId(56L);
		permission.setPermissionName("Permission56");

		when(permissionService.getPermission(56L)).thenReturn(permission);

		mockMvc.perform(get("/rest/permissions/56"))
				.andDo(print())
				.andExpect(
						jsonPath("$.permissionName",
								is(permission.getPermissionName())))
				.andExpect(
						jsonPath("$.links[*].href",
								hasItem(endsWith("/rest/permissions/56"))))
				.andExpect(status().isOk());

	}

	@SuppressWarnings("unchecked")
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

		when(permissionService.getPermissions()).thenReturn(permissions);

		mockMvc.perform(get("/rest/permissions")).andDo(print())
		
		 .andExpect( jsonPath("$.permissionListResource[*].permissionName", hasItems(endsWith("permissionA"), endsWith("permissionB"), endsWith("permissionC"), endsWith("permissionD"))))
		 
		.andExpect(status().isOk());
	}
	
	@Test 
	public void createPermission() throws Exception {
		
		Permission permission = new Permission();
		permission.setId(232L);
		permission.setPermissionName("TEST_CTR_PERMISSION_CREATE_POST");
		
		when(permissionService.addPermission(any(Permission.class))).thenReturn(permission);
		
		mockMvc.perform(post("/rest/permissions")
			.content("{\"permissionName\":\"TEST_CTR_PERMISSION_CREATE_POST\"}")
			.contentType("application/hal+json"))
			.andDo(print())
			//.andExpect(header().string("Location", endsWith("/rest/permissions/232")))
			.andExpect(jsonPath("$.permissionName", is("TEST_CTR_PERMISSION_CREATE_POST")))
			.andExpect(status().isCreated());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getPermissionRoles() throws Exception {
		
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
		
		Permission permission = new Permission();
		permission.setId(89L);
		permission.setPermissionName("TEST_CTRL_ROLE_USERPERMISSIONS_A");
		permission.setRoleList(roles);

		when(permissionService.getPermission(permission.getId())).thenReturn(permission);
		
		mockMvc.perform(get("/rest/permissions/89/roles"))
			.andDo(print())
			//.andExpect(jsonPath("$.permissionListResource[*].roleList[*].rolename", hasItems(endsWith("roleA"), endsWith("roleB"), endsWith("roleC"), endsWith("roleD"))))
			.andExpect(jsonPath("$.roleListResource[*].rolename", hasItems(endsWith("roleA"), endsWith("roleB"), endsWith("roleC"), endsWith("roleD"))))
			.andExpect(status().isOk());
		
	}
	
	@Test
	public void updatePermission() throws Exception {
		Permission permission = new Permission();
		permission.setId(65L);
		permission.setPermissionName("TEST_CTRL_PERMISSION_UPDATE");
		
		when(permissionService.getPermission(65L)).thenReturn(permission);
		when(permissionService.updatePermission(any(Permission.class))).thenReturn(permission);
		
		mockMvc.perform(put("/rest/permissions/65")
			.content("{\"permissionName\":\"TEST_CTRL_PERMISSION_UPDATE\"}")
			.contentType("application/hal+json"))
			.andDo(print())
			.andExpect(status().isOk());
			
	}
	
	@Test 
	public void deletePermission() throws Exception {
		
		Permission permission = new Permission();
		permission.setId(39L);
		permission.setPermissionName("TEST_CTRL_PERMISSION_DELETE");
	
		when(permissionService.deletePermission(39L)).thenReturn(permission);
		
		mockMvc.perform(delete("/rest/permissions/39"))
			.andDo(print())
			.andExpect(jsonPath("$.permissionName", is(permission.getPermissionName())))
			.andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/permissions/39"))))
			.andExpect(status().isOk());
		
	}

}
