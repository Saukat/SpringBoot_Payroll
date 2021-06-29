package net.connectix.rest.controller;

import java.util.List;
import java.util.Optional;

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
import net.connectix.document.EmployeeTask;
import net.connectix.document.Leave;
import net.connectix.dto.RestResponseData;
import net.connectix.repo.EmployeeRepository;
import net.connectix.repo.EmployeeTaskRepository;
import net.connectix.service.IEmployeeTaskService;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employeeTask")
public class EmployeeTaskRestController {
	@Autowired
	private IEmployeeTaskService service;

	@Autowired
	private EmployeeTaskRepository taskRepo;

	@Autowired
	MongoOperations mongoOperations;

	@Autowired
	private EmployeeRepository empRepo;

	@PostMapping("/save")
	public RestResponseData saveEmpTask(@RequestBody EmployeeTask employeeTask) {
		ResponseEntity<String> resp = null;

		LocalDateTime myDateObj = LocalDateTime.now();
//	    System.out.println("Before formatting: " + myDateObj);
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);

		employeeTask.setCreatedDate(formattedDate);

		Employee oneHigherAuthRecord = empRepo.findEmployeeReportHighAuthById(employeeTask.getHigherAuthId());

//		System.out.println("Employee Higher Auth id " + oneHigherAuthRecord.getReportHighAuth()+"id"+employeeTask.getHigherAuthId());

		employeeTask.setSupHigherAuth(oneHigherAuthRecord.getReportHighAuth());

//		System.out.println("Employee Task" + employeeTask);

	String id = service.saveEmployeeTask(employeeTask);

	EmployeeTask empTask=taskRepo.findEmployeeTaskById(id);
//		
		RestResponseData response=new RestResponseData();

		try {	

			response.setData(empTask);
			response.setMessage(new ResponseEntity<String>(employeeTask.getEmployeeName() + " Task Save Succesfully", HttpStatus.OK));
	        response.setStatus("OK"); 

		} catch (Exception e) {
			response.setData(empTask);
			response.setMessage(new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR));
	        response.setStatus("Failed"); 

			e.printStackTrace();
		}
		return response;
	}

	// get all records
	@GetMapping("/allEmpTask")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> resp = null;

		List<EmployeeTask> list = service.getAllEmployeeTask();
		if (list == null || list.isEmpty()) {
			String message = "No data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<List<EmployeeTask>>(list, HttpStatus.OK);
		}
		return resp;
	}

	
	// get all records
	@GetMapping("/getAllSendTask/{higherAuthId}")
	public ResponseEntity<?> getAllSendTaskByHigherId(@PathVariable String higherAuthId) {
		ResponseEntity<?> resp = null;

		List<EmployeeTask> list = taskRepo.findEmployeeTaskByHigherAuthId(higherAuthId);
		System.out.println("All higher" + list);
		if (list == null || list.isEmpty()) {
			String message = "No data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<List<EmployeeTask>>(list, HttpStatus.OK);
		}
		return resp;
	}
	
	
	//view employeeTask list by higherAuth using supHigherAuth
	@GetMapping("/getAllEmployeeAdd/{higherAuthId}")
	public ResponseEntity<?> getAllEmployeeTaskUsingSupHigherAuth(@PathVariable String higherAuthId) {
		ResponseEntity<?> resp = null;
		
	
     System.out.println("Saukat alli");
		List<EmployeeTask> list = taskRepo.findEmployeeTaskBySupHigherAuth(higherAuthId);
		System.out.println("All higher details" + list);
		if (list == null || list.isEmpty()) {
			String message = "No data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<List<EmployeeTask>>(list, HttpStatus.OK);
		}
		return resp;
	}
	
	

	// get all records
	@GetMapping("/getAllTask/{employeeId}")
	public ResponseEntity<?> getAllSendTaskByEmployeeId(@PathVariable String employeeId) {
		ResponseEntity<?> resp = null;

		List<EmployeeTask> list = taskRepo.findEmployeeTaskByEmployeeId(employeeId);
		System.out.println("Emp Assign data" + list);
		if (list == null || list.isEmpty()) {
			String message = "No data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<List<EmployeeTask>>(list, HttpStatus.OK);
		}
		return resp;
	}

	// get single records
	@GetMapping("/one/{id}")
	public ResponseEntity<Optional<EmployeeTask>> oneRecordsByid(@PathVariable String id) {

		ResponseEntity<Optional<EmployeeTask>> resp = null;
		// Check for Exist
		boolean present = service.isPresent(id);
		if (present) {
			// if Exist
			Optional<EmployeeTask> one = service.getOneEmployeeTAsk(id);
			resp = new ResponseEntity<Optional<EmployeeTask>>(one, HttpStatus.OK);

		} else {
			// not exist

			resp = new ResponseEntity<Optional<EmployeeTask>>(HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	// Update Data
	@PutMapping("/update")
	public RestResponseData update(@RequestBody EmployeeTask employeeTask) {
		ResponseEntity<String> resp = null;
		EmployeeTask empTask = taskRepo.findEmployeeTaskById(employeeTask.getId());
		RestResponseData response = new RestResponseData();
		// check for id
		boolean present = service.isPresent(employeeTask.getId());

		if (present) {
			service.updateEmployee(employeeTask);
			response.setData(empTask);
			response.setMessage(new ResponseEntity<String>("Updated Successfuly", HttpStatus.OK));
			response.setStatus("OK");
//				   resp=new ResponseEntity<String>("Updated Successfuly",HttpStatus.OK);

		} else {
			response.setData(empTask);
			response.setMessage(
					new ResponseEntity<String>("Records" + employeeTask.getId() + "Not Found", HttpStatus.BAD_REQUEST));
			response.setStatus("Failed");
//				   resp=new ResponseEntity<String>("Records"+employeeTask.getId()+"Not Found",HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	// update employee remark
	// update ReportHigherAuthremark and status
	@PutMapping("/updateStatus")
	public ResponseEntity<?> updateStatusByEmployee(@RequestBody EmployeeTask employeeTask) {
		ResponseEntity<?> resp = null;

		LocalDateTime myDateObj = LocalDateTime.now();
//				    System.out.println("Before formatting: " + myDateObj);
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);

		boolean present = service.isPresent(employeeTask.getId());
		if (present) {
			Query query = new Query();
			query.addCriteria(Criteria.where("id").is(employeeTask.getId()));

			Update update = new Update();
			update.set("status", employeeTask.getStatus());
			update.set("empRemark", employeeTask.getEmpRemark());
			update.set("completeDateAndTime", employeeTask.getCompleteDateAndTime());
			update.set("updatedDate", formattedDate);
			System.out.println("updated" + update);
			EmployeeTask updatedData = mongoOperations.findAndModify(query, update, employeeTask.getClass());

			resp = new ResponseEntity<String>("Updated Successfuly", HttpStatus.OK);

		} else {
			resp = new ResponseEntity<String>("Records Not Found", HttpStatus.BAD_REQUEST);
		}
		return resp;

	}

}
