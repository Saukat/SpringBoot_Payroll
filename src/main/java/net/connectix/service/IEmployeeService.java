package net.connectix.service;

import java.util.List;
import java.util.Optional;

import net.connectix.document.Employee;

public interface IEmployeeService {
    
	public String saveEmployeeRegistration(Employee employee);
	public List<Employee> getAllEmployee();
	public Optional<Employee> getOneEmployee(String id);
	public boolean isPresent(String id);
	public void updateEmployee(Employee employee);
	
	
	

}
