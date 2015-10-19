package com.sakk.princess.patient.service.util;

import java.util.ArrayList;
import java.util.List;

import com.sakk.princess.patient.model.SportsAccident;

public class SportsAccidentList {
	
	private List<SportsAccident> sportsAccidentList = new ArrayList<SportsAccident>();

	public SportsAccidentList(List<SportsAccident> sportsAccidentList) {
		this.sportsAccidentList = sportsAccidentList;
	}

	public List<SportsAccident> getSportsAccidentList() {
		return sportsAccidentList;
	}

	public void setSportsAccidentList(List<SportsAccident> sportsAccidentList) {
		this.sportsAccidentList = sportsAccidentList;
	}

}
