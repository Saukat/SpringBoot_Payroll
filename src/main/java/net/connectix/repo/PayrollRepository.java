package net.connectix.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import net.connectix.document.Leave;
import net.connectix.document.Payroll;


@Repository
public interface PayrollRepository extends MongoRepository<Payroll, String>{
    
	List<Payroll> findPayrollById(String id);
	
	 boolean existsBySalaryMonth(String salaryMonth);
//		@Query("{'id' : ?0 , 'status' : ?1}")
	 List<Payroll> findPayrollByStatus(String status); 
	
//	Payroll findPayrollById(String id);
 
	@Query("{ 'remark' : ?0 }")
	List<Payroll> findPayrollByRemark(String remark);
	
	@Query("{ 'salaryMonth' : ?0 }")
	List<Payroll> findPayrollBySalaryMonth(String salaryMonth);
	
//	Payroll findPayrollById(String id);
	
	@Query("{'name' : ?0 , 'salaryMonth' : ?1}")
	List<Payroll> findPayrollByNameAndSalaryMonth(String name,String salaryMonth);
}
