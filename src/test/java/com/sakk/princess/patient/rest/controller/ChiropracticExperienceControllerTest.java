package com.sakk.princess.patient.rest.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sakk.princess.patient.model.ChiropracticExperience;
import com.sakk.princess.patient.model.Patient;
import com.sakk.princess.patient.model.Title;
import com.sakk.princess.patient.service.ChiropracticExperienceService;

public class ChiropracticExperienceControllerTest {

	@Mock
	private ChiropracticExperienceService chiropracticExperienceService;

	@InjectMocks
	private ChiropracticExperienceController chiropracticExperienceController;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(chiropracticExperienceController).build();
	}

	@Test
	public void getChiropracticExperiences() throws Exception {

		Patient patient = new Patient();
		ChiropracticExperience chiropracticExperience = new ChiropracticExperience();

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

		chiropracticExperience.setId(1L);
		chiropracticExperience.setLastChiropractorVisit(new Date());
		chiropracticExperience.setPatient(patient);
		chiropracticExperience.setPreviousChiropractorLocation("Rexdale");
		chiropracticExperience.setPreviousChiropractorName("Dr. Lynn");
		chiropracticExperience.setPreviousChiropractorPhone("416-555-5555");
		chiropracticExperience.setxRayTaken(false);

		List<ChiropracticExperience> chiropracticExperienceList = new ArrayList<ChiropracticExperience>();

		chiropracticExperienceList.add(chiropracticExperience);

		when(chiropracticExperienceService.getChiropracticExperiences()).thenReturn(chiropracticExperienceList);

		mockMvc.perform(get("/rest/chiropracticexperiences").accept("application/hal+json").content(""))

				.andExpect(jsonPath("$.chiropracticExperinceListResource[0].previousChiropractorName", is("Dr. Lynn")))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.chiropracticExperinceListResource[0].xRayTaken", is(false))).andDo(print());
	}

}
