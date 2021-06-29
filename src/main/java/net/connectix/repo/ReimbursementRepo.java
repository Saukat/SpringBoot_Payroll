package net.connectix.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.connectix.document.EmployeeTask;
import net.connectix.document.Payroll;
import net.connectix.document.Reimbursement;

public interface ReimbursementRepo extends MongoRepository<Reimbursement, String>{
  
//	Reimbursement findReimbursementBy(String status); 
	List<Reimbursement> findReimbursementByEmpId(String id);

	List<Reimbursement> findReimbursementByHigherAuth(String higherAuth);
	
	List<Reimbursement> findReimbursementByReportStatusAndPaymentStatus(String reportStatus,String paymentStatus);
}
