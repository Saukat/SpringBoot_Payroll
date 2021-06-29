package net.connectix.service;

import java.util.List;
import java.util.Optional;

import net.connectix.document.EmployeeSalaryStructure;

public interface IEmployeeSalService {
    
	public String saveEmployeeSalary(EmployeeSalaryStructure employeeSal);
	public List<EmployeeSalaryStructure> getAllEmployeeSalStructure();
	public Optional<EmployeeSalaryStructure> getOneEmployeeSalStructure	(String id);
	public boolean isPresent(String id);
	public void updateEmployeeSalStructure(EmployeeSalaryStructure employeeSal);
	

}
