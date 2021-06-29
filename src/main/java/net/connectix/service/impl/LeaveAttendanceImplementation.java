package net.connectix.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.connectix.document.leaveAttendance;
import net.connectix.repo.LeaveAttendanceRepository;
import net.connectix.service.ILeaveAttendanceService;

@Service
public class LeaveAttendanceImplementation implements ILeaveAttendanceService{
	@Autowired
	private LeaveAttendanceRepository repo;
  
	@Override
	public String saveLeaveAttendance(leaveAttendance attendance) {
		
		return repo.save(attendance).getAttendEmpId();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<leaveAttendance> getAllLeaveAttendance() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	@Override
	@Transactional(readOnly = true)
	public Optional<leaveAttendance> getOneLeaveAttendance(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}
	@Override
	@Transactional(readOnly = true)
	public boolean isPresent(String id) {
		// TODO Auto-generated method stub
		return repo.existsById(id);
	}
	@Override
	public void updateleaveAttendance(leaveAttendance attendance) {
		repo.save(attendance);
		
	}
}
