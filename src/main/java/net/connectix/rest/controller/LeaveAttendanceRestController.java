package net.connectix.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.connectix.document.Employee;
import net.connectix.document.Leave;
import net.connectix.document.Payment;
import net.connectix.document.leaveAttendance;
import net.connectix.repo.LeaveAttendanceRepository;
import net.connectix.service.ILeaveAttendanceService;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/leaveAttendance")
public class LeaveAttendanceRestController {

	@Autowired
	private ILeaveAttendanceService service;

	@Autowired
	private LeaveAttendanceRepository repo;
	

	@Autowired
	MongoOperations mongoOperations;
	
	
	public String saveLeaveAndAttendance(String id) {
		leaveAttendance attendance = new leaveAttendance();

//		Calendar calendar = Calendar.getInstance();
//		int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		attendance.setTotalDayOfMonth(0);
		attendance.setAttendEmpId(id);
		attendance.setLeaveTaken("0");
		attendance.setTotalLeave("18");
		attendance.setRemain("18");

		System.out.println(attendance);
//		leaveAttendService.saveLeaveAttendance(attendance);

		return "Save";
	}

	// get all records
	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		System.out.println("saukat");
		ResponseEntity<?> resp = null;
		List<leaveAttendance> list = service.getAllLeaveAttendance();
		System.out.println("list" + list);
		if (list == null || list.isEmpty()) {
			String message = "No data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<List<leaveAttendance>>(list, HttpStatus.OK);
		}
		return resp;
	}
	
	
	

	// get single records
	@GetMapping("/one/{id}")
	public ResponseEntity<?> oneRecordsByid(@PathVariable String id) {
		System.out.println("IDs" + id);
		ResponseEntity<leaveAttendance> resp = null;
		// Check for Exist
		boolean present = repo.existsByAttendEmpId(id);
		if (present) {
			System.out.println("Present");
			// if Exist
			leaveAttendance attendance = repo.findLeaveAttendanceByAttendEmpId(id);
			System.out.println("Leave " + attendance);

			resp = new ResponseEntity<leaveAttendance>(attendance, HttpStatus.OK);

		} else {
			System.out.println("Not Present");
			// not exist
			resp = new ResponseEntity<leaveAttendance>(HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	
	// Update Data
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody leaveAttendance attendance) {
		ResponseEntity<String> resp = null;
		// check for id
		boolean present = service.isPresent(attendance.getId());
		if (present) {
			service.updateleaveAttendance(attendance);
			resp = new ResponseEntity<String>("Updated Successfuly", HttpStatus.OK);

		} else {
			resp = new ResponseEntity<String>("Records" + attendance.getId() + "Not Found", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	
	

//	 update Attendance table data by id
	@PutMapping("/updateLeaveTakenById")
	public ResponseEntity<?> updateLeaveTaken(@RequestBody Leave attendance) {
		ResponseEntity<?> resp = null;
     System.out.println("attendance"+attendance.getNumberOfDays());
     System.out.println("attendance"+attendance.getAttendEmpId());
		boolean present = repo.existsByAttendEmpId(attendance.getAttendEmpId());
		leaveAttendance empAttendtance=repo.findLeaveAttendanceByAttendEmpId(attendance.getAttendEmpId());
	     
		String remainday=null;
		String numberOfDays=null;
		String leavesTaken=null;
		int remain=0;
		int totalLeavesTaken=0;
		
		remainday= empAttendtance.getRemain(); 
		numberOfDays=attendance.getNumberOfDays();
		leavesTaken=empAttendtance.getLeaveTaken();
		
		remain=Integer.parseInt(remainday) - Integer.parseInt(numberOfDays);
		
		totalLeavesTaken=Integer.parseInt(numberOfDays)+Integer.parseInt(leavesTaken);
		
		
		
//		System.out.println("remain"+remainday+"leave taken"+leaveTaken);
		
//		 System.out.println("attendance"+empAttendtance);
		if (present) {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("attendEmpId").is(attendance.getAttendEmpId()));

			Update update = new Update();
			update.set("leaveTaken", totalLeavesTaken);
			update.set("remain", remain);
			
//			service.saveLeaveAttendance(update);
//			System.out.println("updated" + update);
			leaveAttendance updatedData = mongoOperations.findAndModify(query, update, empAttendtance.getClass());
//
			resp = new ResponseEntity<String>("Updated Successfuly", HttpStatus.OK);

		} else {
			resp = new ResponseEntity<String>("Records Not Found", HttpStatus.BAD_REQUEST);
		}
		return resp;

	}

	 @PostMapping("/save")
     public String savePayment(@RequestBody leaveAttendance attendance) {
    	 ResponseEntity<String> resp=null;
 	  	String id=service.saveLeaveAttendance(attendance);
 	
 		
 		try {
 			  resp=new ResponseEntity<String>("Payment " + attendance.getId() + " save Succesfully", HttpStatus.OK);
 		} catch (Exception e) {
 			resp=new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
 			e.printStackTrace();
 		}
 		return "Employee"+resp;
     }

}
