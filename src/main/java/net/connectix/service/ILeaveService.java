package net.connectix.service;

import java.util.List;
import java.util.Optional;


import net.connectix.document.Leave;

public interface ILeaveService {
	public String saveLeaveData(Leave leave);
	public List<Leave> getAllLeave();
	public Optional<Leave> getOneEmpLeave(String id);
	public boolean isPresent(String id);
	public void updateLeave(Leave leave);
	
}
