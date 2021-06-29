package net.connectix.service;

import java.util.List;
import java.util.Optional;

import net.connectix.document.Admin;
import net.connectix.document.EmployeeSalaryStructure;
import net.connectix.document.leaveAttendance;

public interface ILeaveAttendanceService {
    public String saveLeaveAttendance(leaveAttendance attendance);
    public List<leaveAttendance> getAllLeaveAttendance();
	public Optional<leaveAttendance> getOneLeaveAttendance	(String id);
	public boolean isPresent(String id);
	public void updateleaveAttendance(leaveAttendance attendance);
	
}
