package net.connectix.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.connectix.document.Employee;
import net.connectix.document.leaveAttendance;


@Repository
public interface LeaveAttendanceRepository extends MongoRepository<leaveAttendance, String>{
	
       leaveAttendance findLeaveAttendanceByAttendEmpId(String attendEmpId);
        Boolean existsByAttendEmpId(String attendEmpId); 
}
