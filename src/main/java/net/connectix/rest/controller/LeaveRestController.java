package net.connectix.rest.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

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

import net.connectix.document.Admin;
import net.connectix.document.Employee;
import net.connectix.document.EmployeeTask;
import net.connectix.document.Leave;
import net.connectix.dto.LeaveDTO;
import net.connectix.dto.RestResponseData;
import net.connectix.repo.AdminRepository;
import net.connectix.repo.EmployeeRepository;
import net.connectix.repo.LeaveRepo;
import net.connectix.service.IAdminService;
import net.connectix.service.IEmployeeService;
import net.connectix.service.ILeaveService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/leave")
public class LeaveRestController {
	@Autowired
	private ILeaveService service;

	@Autowired
	private LeaveRepo repo;

	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private IEmployeeService empService;

	@Autowired
	MongoOperations mongoOperations;

	@Autowired
	IAdminService adminService;

	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	LeaveRepo leaverepo;

	@PostMapping("/save")
	public LeaveDTO saveLeaveData(@RequestBody Leave leave) {
		ResponseEntity<String> resp = null;

		leave.setStatus("applied");
		

		// retrive single data using java 8
		
		empService.getOneEmployee(leave.getEmpId()).ifPresent(e -> {
			leave.setHigAuthId(e.getReportHighAuth());
		});

		String id = service.saveLeaveData(leave);

		Leave leaveData=leaverepo.findEmployeeTaskById(id);
		LeaveDTO response=new LeaveDTO();

		
		try {	

			response.setData(leaveData);
			response.setMessage(new ResponseEntity<String>("Leave Data Save Succesfully", HttpStatus.OK));
	        response.setStatus("OK"); 
//			resp = new ResponseEntity<String>("Leave Data Save Succesfully", HttpStatus.OK);
		} catch (Exception e) {
			response.setData(leaveData);
			response.setMessage(new ResponseEntity<String>("Leave Data Save Succesfully", HttpStatus.OK));
	        response.setStatus("Failed"); 
			resp = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
//			e.printStackTrace();
		}
		return response;
	}

	// get all records
	@GetMapping("/allLeave")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> resp = null;
		List<Leave> list = service.getAllLeave();

		if (list == null || list.isEmpty()) {
			String message = "No data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<List<Leave>>(list, HttpStatus.OK);
		}
		return resp;
	}

	// get all records
	@GetMapping("/allLeaveWithAuthSubstitute")
	public ResponseEntity<?> getAllLeaveWithAuthAndSubstituteNAme() {
		ResponseEntity<?> resp = null;
		List<Leave> list = service.getAllLeave();

		if (list == null || list.isEmpty()) {
			String message = "No data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<List<Leave>>(list, HttpStatus.OK);
		}
		return resp;
	}

	// get single records
	@GetMapping("/one/{id}")
	public ResponseEntity<?> oneRecordsByid(@PathVariable String id) {
         System.out.println("id"+id);
		ResponseEntity<?> resp = null;

		List<Leave> leave = repo.findLeaveByEmpId(id);
		System.out.println("leave data" + leave);

		leave.forEach(lea -> {

			// Check for Exist
			boolean present = adminService.isPresent(lea.getHigAuthId());
			if (present) {
				// if Exist

				Admin one = adminRepo.findAdminById(lea.getHigAuthId());
				System.out.println("One Data"+one);
				lea.setHigAuthId(one.getEmail());
				Employee sub = empRepo.findEmployeeById(lea.getBackupEmpId());
				lea.setBackupEmpId(sub.getName());
// 				 resp = new ResponseEntity<Optional<Admin>>(one, HttpStatus.OK);

			} else {
				System.out.println("saukat");
				Employee emp = empRepo.findEmployeeById(lea.getHigAuthId());
				System.out.println("Employee emp" + emp);

				Employee sub = empRepo.findEmployeeById(lea.getBackupEmpId());
				lea.setHigAuthId(emp.getName());
				lea.setBackupEmpId(sub.getName());

			}

		});

		System.out.println("Leave" + leave);

		if (leave == null || leave.isEmpty()) {
			String message = "No data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<List<Leave>>(leave, HttpStatus.OK);
		}

		return resp;
	}

	// all records show on admin panel
	@GetMapping("/allLeaveRecords")
	public ResponseEntity<?> allRecordsByid() {

		ResponseEntity<?> resp = null;
		List<Leave> list = service.getAllLeave();
		
			list.forEach(lea -> {

				// Check for Exist
				boolean present = adminService.isPresent(lea.getHigAuthId());
				if (present) {
					// if Exist

					List<Admin> one = adminRepo.findAdminEmailById(lea.getHigAuthId());
//					lea.setHigAuthId(one.getEmail());
					
					
					for (Admin email : one) {
						   lea.setHigAuthId(email.getEmail());
						List<Employee> emp = empRepo.findEmployeeNameById(lea.getEmpId());

						for (Employee emps : emp) {
							System.out.println("Employee name" + emps.getName());
							lea.setEmpId(emps.getName());
							
							
								List<Employee> substituteList = empRepo.findEmployeeNameById(lea.getBackupEmpId());
								for (Employee substitute : substituteList) {
									System.out.println(substitute.getName());
									lea.setBackupEmpId(substitute.getName());
								}
							
						}
//						return new ResponseEntity<List<Leave>>(list, HttpStatus.OK);
					}
					
	

				} else {
				
					
						List<Employee> emp = empRepo.findEmployeeNameById(lea.getEmpId());

						for (Employee emps : emp) {
							System.out.println("Employee else name" + emps.getName());
							lea.setEmpId(emps.getName());
							List<Employee> higherAuthList = empRepo.findEmployeeNameById(lea.getHigAuthId());
							for (Employee higherAuth : higherAuthList) {
//								System.out.println(higherAuth.getName());
								lea.setHigAuthId(higherAuth.getName());
								List<Employee> substituteList = empRepo.findEmployeeNameById(lea.getBackupEmpId());
								for (Employee substitute : substituteList) {
//									System.out.println(substitute.getName());
									lea.setBackupEmpId(substitute.getName());
//									System.out.println("leave:"+lea);
								}
							}
						}
					
				}

			});
			System.out.println("Leave" + list);

			if (list == null || list.isEmpty()) {
				String message = "No data Found";
				resp = new ResponseEntity<String>(message, HttpStatus.OK);
			} else {
				resp = new ResponseEntity<List<Leave>>(list, HttpStatus.OK);
			}

			return resp;
		
	}

	// get single records
	@GetMapping("/substitute/{id}")
	public ResponseEntity<?> oneRecordsBySubstituteId(@PathVariable String id) {
		System.out.println("id" + id);
		ResponseEntity<?> resp = null;

		List<Leave> leave = repo.findLeaveByBackupEmpId(id);
		System.out.println("leave auth 1" + leave);

		leave.forEach(lea -> {

			// Check for Exist
			boolean present = adminService.isPresent(lea.getHigAuthId());
			if (present) {
				// if Exist

				Admin one = adminRepo.findAdminById(lea.getHigAuthId());
				lea.setHigAuthId(one.getEmail());
				Employee sub = empRepo.findEmployeeById(lea.getEmpId());
				lea.setEmpId(sub.getName());

			} else {

				Employee emp = empRepo.findEmployeeById(lea.getHigAuthId());
				System.out.println("Employee emp" + emp);
				lea.setHigAuthId(emp.getName());
				Employee sub = empRepo.findEmployeeById(lea.getEmpId());
				lea.setEmpId(sub.getName());

			}

// 				Employee emp=empRepo.findEmployeeById("603774c9685e386fdd93b6cf");
//	 			Employee byWhomApply=empRepo.findEmployeeById(lea.getEmpId());
//	 			lea.setHigAuthId(emp.getName());
//	 			lea.setEmpId(byWhomApply.getName());	
		});

		System.out.println("Leave" + leave);

		if (leave == null || leave.isEmpty()) {
			String message = "No data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<List<Leave>>(leave, HttpStatus.OK);
		}
		System.out.println("Leave Data" + leave);

		return resp;
	}

	// get single records
	@GetMapping("/approve/{id}")
	public ResponseEntity<?> oneRecordsByHigherAuth(@PathVariable String id) {

		ResponseEntity<?> resp = null;

		List<Leave> leave = repo.findLeaveByHigAuthId(id);
		System.out.println("leave auth 1" + leave);

		leave.forEach(lea -> {
			System.out.println("Leave" + lea.getHigAuthId());
			lea.setAttendEmpId(lea.getEmpId());
			Employee emp = empRepo.findEmployeeById(lea.getEmpId());
			Employee sub = empRepo.findEmployeeById(lea.getBackupEmpId());
			lea.setEmpId(emp.getName());
			lea.setBackupEmpId(sub.getName());

//	 			String ids=emp.getId();
		});

		System.out.println("Leave" + leave);

		if (leave == null || leave.isEmpty()) {
			String message = "No data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<List<Leave>>(leave, HttpStatus.OK);
		}
		System.out.println("Leave Data" + leave);

		return resp;
	}

	// update ReportHigherAuthremark and status
	@PutMapping("/updateStatus")
	public ResponseEntity<?> updateStatusAndAuthRemark(@RequestBody Leave leave) {
		ResponseEntity<?> resp = null;

		boolean present = service.isPresent(leave.getId());
		if (present) {
			Query query = new Query();
			query.addCriteria(Criteria.where("id").is(leave.getId()));
          
			Update update = new Update();
			update.set("status", leave.getStatus());
			update.set("repAuthRemark", leave.getRepAuthRemark());
			System.out.println("updated" + update);
			Leave updatedData = mongoOperations.findAndModify(query, update, leave.getClass());

			resp = new ResponseEntity<String>("Updated Successfuly", HttpStatus.OK);

		} else {
			resp = new ResponseEntity<String>("Records Not Found", HttpStatus.BAD_REQUEST);
		}
		return resp;

	}

	// update Substitute Remark
	@PutMapping("/updateSubstituteRemak")
	public ResponseEntity<?> updateSubstituteRemak(@RequestBody Leave leave) {
		ResponseEntity<?> resp = null;

		boolean present = service.isPresent(leave.getId());
		if (present) {
			Query query = new Query();
			query.addCriteria(Criteria.where("id").is(leave.getId()));

			Update update = new Update();
			update.set("backupEmpRemark", leave.getBackupEmpRemark());
			System.out.println("updated" + update);
			Leave updatedData = mongoOperations.findAndModify(query, update, leave.getClass());

			resp = new ResponseEntity<String>("Updated Successfuly", HttpStatus.OK);

		} else {
			resp = new ResponseEntity<String>("Records Not Found", HttpStatus.BAD_REQUEST);
		}
		return resp;

	}

}
