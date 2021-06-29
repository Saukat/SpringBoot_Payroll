package net.connectix.repo;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import net.connectix.document.Employee;
//import net.connectix.document.Payroll;
import net.connectix.document.Leave;


@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{
    
//	@Query("{ 'reportHighAuth' : ?0 }")
//	String findEmployeeById(String id);
//	
//	@Query("{ 'name' : ?0 }")
//	String findEmployeeByReportHighAuth(String reportHighAuth);
	
	 Boolean existsByEmail(String email);
	 Boolean existsByEmployeeId(String employeeId);
	
    Employee findEmployeeById(String id);
    
//    List<Employee> findEmployeeById(String id);
    
    Employee findEmployeeReportHighAuthById(String id);
    

    
    Employee findEmployeeByEmail(String email);
    
    List<Employee> findEmployeeNameById(String id);
    
//    Employee findEmployeeByReportHighAuth(String id);
    
    @Query("{'id' : ?0 , 'password' : ?1}")
    Employee findEmployeeByIdAndPassword(String id, String password);

}
