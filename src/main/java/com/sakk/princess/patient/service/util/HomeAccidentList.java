package com.sakk.princess.patient.service.util;

import java.util.ArrayList;
import java.util.List;

import com.sakk.princess.patient.model.HomeAccident;

public class HomeAccidentList {
	
	private List<HomeAccident> homeAccidentList = new ArrayList<HomeAccident>();

	public HomeAccidentList(List<HomeAccident> homeAccidentList) {
		this.homeAccidentList = homeAccidentList;
	}

	public List<HomeAccident> getHomeAccidentList() {
		return homeAccidentList;
	}

	public void setHomeAccidentList(List<HomeAccident> homeAccidentList) {
		this.homeAccidentList = homeAccidentList;
	}

}
