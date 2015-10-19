package com.sakk.princess.patient.service.util;

import java.util.ArrayList;
import java.util.List;

import com.sakk.princess.patient.model.ChildhoodTruama;

public class ChildhoodTruamaList {
	
	private List<ChildhoodTruama> childhoodTruamaList = new ArrayList<ChildhoodTruama>();

	public ChildhoodTruamaList(List<ChildhoodTruama> childhoodTruamaList) {
		this.childhoodTruamaList = childhoodTruamaList;
	}

	public List<ChildhoodTruama> getChildhoodTruamaList() {
		return childhoodTruamaList;
	}

	public void setChildhoodTruamaList(List<ChildhoodTruama> childhoodTruamaList) {
		this.childhoodTruamaList = childhoodTruamaList;
	}

}
