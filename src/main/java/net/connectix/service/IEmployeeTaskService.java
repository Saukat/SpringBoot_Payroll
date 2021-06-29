package net.connectix.service;


import java.util.List;
import java.util.Optional;

import net.connectix.document.EmployeeTask;

public interface IEmployeeTaskService {
    
	public String saveEmployeeTask(EmployeeTask employeeTask);
	public List<EmployeeTask> getAllEmployeeTask();
	public Optional<EmployeeTask> getOneEmployeeTAsk(String id);
	public boolean isPresent(String id);
	public void updateEmployee(EmployeeTask employeeTask);
	
	
	

}
