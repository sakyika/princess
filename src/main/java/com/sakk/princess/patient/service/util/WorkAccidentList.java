package com.sakk.princess.patient.service.util;

import java.util.ArrayList;
import java.util.List;

import com.sakk.princess.patient.model.WorkAccident;

public class WorkAccidentList {
	
	private List<WorkAccident> workAccidentList = new ArrayList<WorkAccident>();

	public WorkAccidentList(List<WorkAccident> workAccidentList) {
		this.workAccidentList = workAccidentList;
	}

	public List<WorkAccident> getWorkAccidentList() {
		return workAccidentList;
	}

	public void setWorkAccidentList(List<WorkAccident> workAccidentList) {
		this.workAccidentList = workAccidentList;
	}

}
