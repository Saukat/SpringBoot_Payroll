package net.connectix.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.connectix.document.Employee;
import net.connectix.repo.EmployeeRepository;
import net.connectix.service.IEmployeeService;

@Service
public class EmployeeRegistrationImplementation implements IEmployeeService{
	 @Autowired
	 private EmployeeRepository repo;
	
	@Override
	public String saveEmployeeRegistration(Employee employee) {
		
		return repo.save(employee).getName();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Employee> getAllEmployee() {
		
		return repo.findAll();
	}
	
	//Retrieve one records based on id
	@Override
	@Transactional(readOnly = true)
	public Optional<Employee> getOneEmployee(String id) {
		
		return repo.findById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public boolean isPresent(String id) {
       
		return repo.existsById(id);
	}
	
	
	@Transactional
	public void updateEmployee(Employee employee) {
		repo.save(employee);
		
	}
}
