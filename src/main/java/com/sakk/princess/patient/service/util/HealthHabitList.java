package com.sakk.princess.patient.service.util;

import java.util.ArrayList;
import java.util.List;

import com.sakk.princess.patient.model.HealthHabit;

public class HealthHabitList {
	
	private List<HealthHabit> healthHabitList = new ArrayList<HealthHabit>();

	public HealthHabitList(List<HealthHabit> healthHabitList) {
		this.healthHabitList = healthHabitList;
	}

	public List<HealthHabit> getHealthHabitList() {
		return healthHabitList;
	}

	public void setHealthHabitList(List<HealthHabit> healthHabitList) {
		this.healthHabitList = healthHabitList;
	}

}
