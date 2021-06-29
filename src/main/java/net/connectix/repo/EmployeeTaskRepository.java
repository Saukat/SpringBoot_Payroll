package net.connectix.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.connectix.document.EmployeeTask;

@Repository
public interface EmployeeTaskRepository extends MongoRepository<EmployeeTask, String>{

	EmployeeTask findEmployeeTaskById(String id);
     
    List<EmployeeTask> findEmployeeTaskByHigherAuthId(String higherAuthId);
    
    List<EmployeeTask> findEmployeeTaskByEmployeeId(String employeeId);
    
    List<EmployeeTask> findEmployeeTaskBySupHigherAuth(String higherAuthId);
}
