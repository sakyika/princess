package com.sakk.princess.patient.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sakk.princess.patient.jpa.repository.ComplaintRepository;
import com.sakk.princess.patient.model.Complaint;
import com.sakk.princess.patient.service.ComplaintService;

@Service
@Transactional
public class ComplaintServiceImpl implements ComplaintService {
	
	static Logger logger = LoggerFactory.getLogger(ComplaintServiceImpl.class);

	@Autowired
	ComplaintRepository complaintRepository;

	@Override
	public List<Complaint> findAllComplaints() {
		return getComplaints();
	}

	@Override
	public Complaint addComplaint(Complaint complaint) {
		return complaintRepository.save(complaint);
	}

	@Override
	public Complaint getComplaint(Long complaintId) {
		return complaintRepository.getOne(complaintId);
	}
	
	@Override
	public Complaint updateComplaint(Complaint complaint){
		if(complaint != null){
			complaintRepository.saveAndFlush(complaint);
		}
		return complaint;
	}

	@Override
	public Complaint updateComplaintByPatientNumber(Long patientNumber, Complaint complaint) {
		
		Complaint complaintToUpdate = getComplaint(complaint.getId());
		
		if(complaintToUpdate != null){
/*			complaintToUpdate.setAching(complaint.isAching());
			complaintToUpdate.setBurning(complaint.isBurning());
			complaintToUpdate.setDull(complaint.isDull());
			complaintToUpdate.setHowItHappened(complaint.getHowItHappened());
			complaintToUpdate.setId(complaint.getId());
			complaintToUpdate.setLocation(complaint.getLocation());
			complaintToUpdate.setNumbness(complaint.isNumbness());
			complaintToUpdate.setOther(complaint.isOther());
			complaintToUpdate.setOtherDescription(complaint.getOtherDescription());
			complaintToUpdate.setPainPattern(complaint.getPainPattern());
			complaintToUpdate.setPainRadiates(complaint.isPainRadiates());
			complaintToUpdate.setPainRadiatesWhere(complaint.getPainRadiatesWhere());
			complaintToUpdate.setPainScale(complaint.getPainScale());
			complaintToUpdate.setPainWorst(complaint.getPainWorst());
			complaintToUpdate.setPatientInfo(complaint.getPatientInfo());
			complaintToUpdate.setPreviousOccurance(complaint.isPreviousOccurance());
			complaintToUpdate.setPreviousOccuranceDate(complaint.getPreviousOccuranceDate());
			complaintToUpdate.setSharp(complaint.isSharp());
			complaintToUpdate.setStabbing(complaint.isStabbing());
			complaintToUpdate.setStartDate(complaint.getStartDate());
			complaintToUpdate.setThrobbing(complaint.isThrobbing());
			complaintToUpdate.setTingling(complaint.isTingling());
			complaintToUpdate.setWeakness(complaint.isWeakness());
			complaintToUpdate.setWhatMakesBetter(complaint.getWhatMakesBetter());
			complaintToUpdate.setWhatMakesWorst(complaint.getWhatMakesWorst());	
*/			
			complaintRepository.saveAndFlush(complaint);
			
		}
		
		return complaintToUpdate;
	}

	@Override
	public Complaint deleteComplaint(Long complaintId) {
		
		Complaint complaintToDelete = getComplaint(complaintId);
		
		if(complaintToDelete != null){
			complaintRepository.delete(complaintToDelete);
		}
		
		return complaintToDelete;
	}

	@Override
	public List<Complaint> getComplaints() {
		return complaintRepository.findAll();
	}

	@Override
	public List<Complaint> getComplaintSublist(List<Long> complaintIdList) {
		
		List<Complaint> complaintList = new ArrayList<Complaint>();
		
		for(Long childhoodTruamaId : complaintIdList){
			complaintList.add(getComplaint(childhoodTruamaId));
		}
		
		return complaintList;
	}
	
	@Override
	public List<Complaint> findByPatientNumber(Long patientNumber){
		return complaintRepository.findByPatientPatientNumber(patientNumber);
	}

}
