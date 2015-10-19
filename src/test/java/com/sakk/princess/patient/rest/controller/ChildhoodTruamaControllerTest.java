package com.sakk.princess.patient.rest.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sakk.princess.patient.model.ChildhoodTruama;
import com.sakk.princess.patient.model.Patient;
import com.sakk.princess.patient.model.Title;
import com.sakk.princess.patient.service.ChildhoodTruamaService;

public class ChildhoodTruamaControllerTest {
	
	@Mock
	private ChildhoodTruamaService childhoodTruamaService;
	
	@InjectMocks
	private ChildhoodTruamaController childhoodTruamaController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		
		MockitoAnnotations.initMocks(this);
		
		mockMvc = MockMvcBuilders.standaloneSetup(childhoodTruamaController).build();
		
	}
	
	@Test
	public void getChildhoodTruamas() throws Exception{
		
		Patient patient = new Patient();
		ChildhoodTruama childhoodTruama = new ChildhoodTruama();
		
		
		patient.setId(1L);
		patient.setAddress("11 Arbordell Road Unit 5, Toronto - Ontario, M9W 4C6");
		patient.setCellPhone("905-616-2943");
		patient.setDob(new Date());
		patient.setEmail("info@sakks.ca");
		patient.setEmergencyContact("Juliet Sakyi");
		patient.setEmergencyContactPhone("1-780-720-2520");
		patient.setEmployer("Sakk Software");
		patient.setFirstName("Kwadwo");
		patient.setHearAboutUs("Through a friend");
		patient.setHomePhone("");
		patient.setLastName("Sakyi");
		patient.setOccupation("Software Developer");
		patient.setPatientNumber(77L);
		patient.setTitle(Title.MR);
		patient.setWorkPhone("");
		
		childhoodTruama.setId(1L);
		childhoodTruama.setBodyPartsInjured("Right foot big toe");
		childhoodTruama.setBriefAccount("Was playing soccer bear foot");
		childhoodTruama.setCareGivenByDoctor("Mother");
		childhoodTruama.setChildhoodTruama(true);
		childhoodTruama.setTruamaDate(new Date());
		childhoodTruama.setInjuriesResolved(true);
		childhoodTruama.setMedicalCareReceived(false);
		childhoodTruama.setPatient(patient);
				
		List<ChildhoodTruama> childhoodTruamaList = new ArrayList<ChildhoodTruama>();
		
		childhoodTruamaList.add(childhoodTruama);
		
		when(childhoodTruamaService.getChildhoodTruamas()).thenReturn(childhoodTruamaList);
		
		mockMvc.perform(get("/rest/childhoodtruamas").accept("application/hal+json")).andDo(print());
		
	}
/*	
	@Test
	public void getChildhoodTruama() throws Exception{
		
		Patient singlePatient = new Patient();
		ChildhoodTruama childhoodTruama = new ChildhoodTruama();
		
		singlePatient.setId(2L);
		singlePatient.setAddress("145 Jamestown Crescent, Toronto - Ontario, M9V 3M6");
		singlePatient.setCellPhone("905-616-2943");
		singlePatient.setDob(new Date());
		singlePatient.setEmail("slugz_17@hotmail.com");
		singlePatient.setEmergencyContact("Juliet Sakyi");
		singlePatient.setEmergencyContactPhone("1-780-720-2520");
		singlePatient.setEmployer("IBM Canada");
		singlePatient.setFirstName("Amoako");
		singlePatient.setHearAboutUs("Through a friend");
		singlePatient.setHomePhone("");
		singlePatient.setLastName("Sakyi");
		singlePatient.setOccupation("Software Engineer");
		singlePatient.setPatientNumber(25L);
		singlePatient.setTitle(Title.MR);
		singlePatient.setWorkPhone("");
		
		childhoodTruama.setId(2L);
		childhoodTruama.setBodyPartsInjured("Left knee");
		childhoodTruama.setBriefAccount("Was exercising");
		childhoodTruama.setCareGivenByDoctor("Dr. Yeboah");
		childhoodTruama.setChildhoodTruama(true);
		childhoodTruama.setTruamaDate(new Date());
		childhoodTruama.setInjuriesResolved(true);
		childhoodTruama.setMedicalCareReceived(true);
		childhoodTruama.setPatient(singlePatient);
		
		when(childhoodTruamaService.getChildhoodTruama(childhoodTruama.getId())).thenReturn(childhoodTruama);
		
		mockMvc.perform(get("/rest/childhoodtruamas/2").accept("application/hal+json")).andExpect(jsonPath("$.", is("")));
		
	}
*/	

/*	
	@Test
	public void getChildhoodTruama() throws Exception{
		
		mockMvc.perform(get("/rest/childhoodtruamas/55")).andDo(print());
		
	}
	
	@Test
	public void addChildhoodTruama() throws Exception{
		
		mockMvc.perform(get("/rest/childhoodtruamas/55/childhoodtruama")).andDo(print());
		
	}
*/	
	@After
	public void tearDown(){
		
	}

}
