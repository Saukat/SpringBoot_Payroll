package net.connectix.service;


import java.util.List;
import java.util.Optional;

import net.connectix.document.Payroll;

public interface IPayrollService {
    
	public String savePayroll(Payroll payroll);
	
	
	public List<Payroll> getAllEmpPayroll();
	public Optional<Payroll> getOneEmpPayroll(String id);
	public boolean isPresent(String id);
	public void updateEmplPayroll(Payroll payroll);
	
    
	
	public String insertCurrentPayroll(Payroll payroll);
	

}
