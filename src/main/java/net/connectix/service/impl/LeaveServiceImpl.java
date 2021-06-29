package net.connectix.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.connectix.document.Leave;
import net.connectix.repo.LeaveRepo;
import net.connectix.service.ILeaveService;
@Service
public class LeaveServiceImpl implements ILeaveService{
   
	@Autowired
	private LeaveRepo repo;

	@Override
	public String saveLeaveData(Leave leave) {
		return repo.save(leave).getId();
	}

	@Override
	public List<Leave> getAllLeave() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Leave> getOneEmpLeave(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public boolean isPresent(String id) {
		// TODO Auto-generated method stub
		return repo.existsById(id);
	}

	@Override
	public void updateLeave(Leave leave) {
		// TODO Auto-generated method stub
		repo.save(leave);
		
	}
	
	
	
}
