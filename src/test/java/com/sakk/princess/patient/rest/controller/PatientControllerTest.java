package com.sakk.princess.patient.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.Mockito.when;

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

import com.sakk.princess.patient.model.Patient;
import com.sakk.princess.patient.model.Title;
import com.sakk.princess.patient.service.PatientService;

public class PatientControllerTest {
	
	@Mock
	private PatientService patientService;
	
	@InjectMocks
	private PatientController patientController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		
		MockitoAnnotations.initMocks(this);
		
		mockMvc = MockMvcBuilders.standaloneSetup(patientController).build();
		
	}
	
	@Test
	public void getPatients() throws Exception{
		
		Patient patient = new Patient();
		
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
		
		List<Patient> patientList = new ArrayList<Patient>();
		
		patientList.add(patient);
		
		when(patientService.getPatients()).thenReturn(patientList);
		
		mockMvc.perform(get("/rest/patients").accept("application/hal+json")).andDo(print());
		
	}
/*	
	@Test
	public void getPatient() throws Exception{
		
		mockMvc.perform(get("/rest/childhoodtruamas/55")).andDo(print());
		
	}
	
	@Test
	public void addPatient() throws Exception{
		
		mockMvc.perform(get("/rest/childhoodtruamas/55/childhoodtruama")).andDo(print());
		
	}
*/	
	@After
	public void tearDown(){
		
	}

}
