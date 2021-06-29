package net.connectix.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import net.connectix.document.EmployeeSalaryStructure;

import net.connectix.repo.EmployeeSalRepository;
import net.connectix.service.IEmployeeSalService;


@Service
public class EmployeeSalaryServiceImplemention implements IEmployeeSalService{
	 @Autowired
	 private EmployeeSalRepository repo;
	 
	@Override
	public String saveEmployeeSalary(EmployeeSalaryStructure employeeSal) {
		
		return repo.save(employeeSal).getId();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<EmployeeSalaryStructure> getOneEmployeeSalStructure(String id) {
		
		return repo.findById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public boolean isPresent(String id) {
		
		return repo.existsById(id);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public List<EmployeeSalaryStructure> getAllEmployeeSalStructure() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	@Override
	@Transactional
	public void updateEmployeeSalStructure(EmployeeSalaryStructure employeeSal) {
		 repo.save(employeeSal);
		
	}
}
