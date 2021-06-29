package net.connectix.repo;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import net.connectix.document.Leave;
import net.connectix.document.Payroll;

public interface LeaveRepo extends MongoRepository<Leave, String>{
	
	
    List<Leave> findLeaveByHigAuthId(String higAuthId);
    
    List<Leave> findLeaveByEmpId(String empId);
    
    List<Leave> findLeaveByBackupEmpId(String backupEmpId);

	Leave findEmployeeTaskById(String id);
    
   
    
} 

