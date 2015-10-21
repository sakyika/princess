package com.sakk.princess.core.rest.controller;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.*;
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
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sakk.princess.core.model.Permission;
import com.sakk.princess.core.model.Role;
import com.sakk.princess.core.model.User;
import com.sakk.princess.core.rest.controller.RoleController;
import com.sakk.princess.core.service.RoleService;

public class RoleControllerTest {
	
	@InjectMocks
	private RoleController roleController;

	@Mock
	private RoleService roleService;

	private MockMvc mockMvc;
	
	private ArgumentCaptor<Role> roleCaptor;

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(roleController).build();
		
		roleCaptor = ArgumentCaptor.forClass(Role.class);

	}
	
	
	@Test 
	public void getRole() throws Exception{
		
		Role role = new Role();
		role.setId(56L);
		role.setRolename("Role56");
		
		when(roleService.getRole(56L)).thenReturn(role);
		
		mockMvc.perform(get("/rest/roles/56"))
			.andDo(print())
			.andExpect(jsonPath("$.rolename", is(role.getRolename())))
			.andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/rest/roles/56"))))
			.andExpect(status().isOk());
		
	}

	@SuppressWarnings("unchecked")
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

		when(roleService.getRoles()).thenReturn(roles);

		mockMvc.perform(get("/rest/roles"))
				.andDo(print())
				.andExpect(jsonPath("$.roleListResource[*].rolename", hasItem("roleA")))
				.andExpect(jsonPath("$.roleListResource[*].rolename", hasItem("roleB")))
				.andExpect(jsonPath("$.roleListResource[*].rolename", hasItem("roleC")))
				.andExpect(jsonPath("$.roleListResource[*].rolename", hasItem("roleD")))
				.andExpect(jsonPath("$.roleListResource[*].rolename", hasItems(endsWith("roleA"), endsWith("roleB"), endsWith("roleC"), endsWith("roleD"))))
				.andExpect(status().isOk());
	}
	
	@Test
	public void createRole() throws Exception {
		
		Role role = new Role();
		role.setId(22L);
		role.setRolename("ROLE_PATIENT");
		
		when(roleService.addRole(any(Role.class))).thenReturn(role);
		
		mockMvc.perform(post("/rest/roles")
			.content("{\"rolename\":\"ROLE_PATIENT\"}")
			.contentType("application/hal+json"))
			.andDo(print())
			.andExpect(header().string("Location", endsWith("/rest/roles/22")))
			.andExpect(jsonPath("$.rolename", is(role.getRolename())))
			.andExpect(status().isCreated());
		
			verify(roleService).addRole(roleCaptor.capture());
			
			String roleName = roleCaptor.getValue().getRolename();
			assertEquals(role.getRolename(), roleName);
		
	}
	
	@Test
	public void getRoleUsers() throws Exception {
		
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
		
		Permission permissionA = new Permission();
		permissionA.setId(11L);
		permissionA.setPermissionName("TEST_CTRL_ROLE_ROLEUSERS_GET");
		
		Role roleA = new Role();
		roleA.setId(12L);
		roleA.setRolename("TEST_CTR_USER_USERROLE");
		roleA.setPermissionList(new ArrayList<Permission>());
		roleA.getPermissionList().add(permissionA);
		roleA.setUserList(users);

		when(roleService.getRole(roleA.getId())).thenReturn(roleA);
		
		mockMvc.perform(get("/rest/roles/12/users"))
			.andDo(print())
			.andExpect(jsonPath("$.userListResource[*].username", hasItem("userA")))
			.andExpect(jsonPath("$.userListResource[*].username", hasItem("userB")))
			.andExpect(jsonPath("$.userListResource[*].username", hasItem("userC")))
			.andExpect(jsonPath("$.userListResource[*].username", hasItem("userD")))
			.andExpect(status().isOk());
	}
	
	@Test
	public void getRolePermissions() throws Exception {
		
		List<Permission> permissions = new ArrayList<Permission>();
		
		Permission permissionA = new Permission();
		permissionA.setId(89L);
		permissionA.setPermissionName("TEST_CTRL_ROLE_USERPERMISSIONS_A");
		permissions.add(permissionA);
	
		Permission permissionB = new Permission();
		permissionB.setId(67L);
		permissionB.setPermissionName("TEST_CTRL_ROLE_USERPERMISSIONS_B");
		permissions.add(permissionB);
		
		Permission permissionC = new Permission();
		permissionC.setId(54L);
		permissionC.setPermissionName("TEST_CTRL_ROLE_USERPERMISSIONS_C");
		permissions.add(permissionC);
		
		Permission permissionD = new Permission();
		permissionD.setId(24L);
		permissionD.setPermissionName("TEST_CTRL_ROLE_USERPERMISSIONS_D");
		permissions.add(permissionD);
		
		Role role = new Role();
		role.setId(101L);
		role.setRolename("ROLE_PERSON");
		
		role.setPermissionList(permissions);
		
		when(roleService.getRole(role.getId())).thenReturn(role);
		
		mockMvc.perform(get("/rest/roles/101/permissions"))
			.andDo(print())
			.andExpect(jsonPath("$.permissionListResource[*].permissionName", hasItem("TEST_CTRL_ROLE_USERPERMISSIONS_A")))
			.andExpect(jsonPath("$.permissionListResource[*].permissionName", hasItem("TEST_CTRL_ROLE_USERPERMISSIONS_B")))
			.andExpect(jsonPath("$.permissionListResource[*].permissionName", hasItem("TEST_CTRL_ROLE_USERPERMISSIONS_C")))
			.andExpect(jsonPath("$.permissionListResource[*].permissionName", hasItem("TEST_CTRL_ROLE_USERPERMISSIONS_D")))
			.andExpect(status().isOk());
		
	}
	
	@Test
	public void deleteRole() throws Exception {
		
		Role role = new Role();
		role.setId(43L);
		role.setRolename("ROLE_TEST");
		
		when(roleService.deleteRole(43L)).thenReturn(role);
		
		mockMvc.perform(delete("/rest/roles/43"))
			.andDo(print())
			.andExpect(jsonPath("$.rolename", is(role.getRolename())))
			.andExpect(jsonPath("$.id", is(43)))
			.andExpect(status().isOk());
		
	}
	
	@Test
	public void update() throws Exception {
		
		Role role = new Role();
		role.setId(65L);
		role.setRolename("ROLE_TEST");
		
		when(roleService.getRole(65L)).thenReturn(role);
		when(roleService.updateRole(any(Role.class))).thenReturn(role);
		
		mockMvc.perform(put("/rest/roles/65")
			.content("{\"rolename\":\"ROLE_TEST\"}")
			.contentType("application/hal+json"))
			.andDo(print())
			.andExpect(status().isOk());
		
	}
	

}
