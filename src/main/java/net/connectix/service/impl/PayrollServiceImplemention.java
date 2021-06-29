package net.connectix.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.connectix.document.Payroll;

import net.connectix.repo.PayrollRepository;

import net.connectix.service.IPayrollService;

@Service
public class PayrollServiceImplemention implements IPayrollService{
	 @Autowired
	 private PayrollRepository repo;
	 
	 @Override
	 public String savePayroll(Payroll payroll) {
		
		return repo.save(payroll).getId();
	}
	 @Override
	 @Transactional(readOnly = true)
	public List<Payroll> getAllEmpPayroll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	 
	 @Override
	 @Transactional(readOnly = true)
	public Optional<Payroll> getOneEmpPayroll(String id) {
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
	 public void updateEmplPayroll(Payroll payroll) {
		 System.out.println(repo.save(payroll));
		repo.save(payroll);
		
	}
	 
	 @Override
	public String insertCurrentPayroll(Payroll payroll) {
		
		return repo.insert(payroll).getName();
	}
	
	
}
