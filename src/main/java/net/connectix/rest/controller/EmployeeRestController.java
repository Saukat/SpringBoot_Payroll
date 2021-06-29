package net.connectix.rest.controller;

import java.util.Base64;
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

import net.connectix.document.Admin;
import net.connectix.document.Employee;
import net.connectix.document.EmployeeSalaryStructure;
import net.connectix.document.Leave;
import net.connectix.dto.EmployeeChangePassword;
import net.connectix.repo.AdminRepository;
import net.connectix.repo.EmployeeRepository;
import net.connectix.service.IAdminService;
import net.connectix.service.IEmployeeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	@Autowired
	private IEmployeeService service;

	@Autowired
	private IAdminService adminService;

	@Autowired
	private EmployeeRepository repo;

	@Autowired
	MongoOperations mongoOperations;

	@Autowired
	private EmployeeRepository empRepo;
	
	
	@Autowired
	AdminRepository adminRepo;
	

	@PostMapping("/empReg")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {

		ResponseEntity<String> resp = null;
		employee.setPassword("cntx@123");
		employee.setStatus("Working");  

		try {
			if (empRepo.existsByEmployeeId(employee.getEmployeeId())) {
				return ResponseEntity.badRequest().body("Already Employee Id already exists");
			} else if (empRepo.existsByEmail(employee.getEmail())) {
				return ResponseEntity.badRequest().body("Already Email Id already exists");
			} else {

				service.saveEmployeeRegistration(employee);
				resp = new ResponseEntity<String>("Employee " + employee.getName() + " Register Succesfully",
						HttpStatus.OK);
			}

		} catch (Exception e) {
			resp = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@PostMapping("/saveSalData")
	public ResponseEntity<String> saveEmplSalStructure(@RequestBody EmployeeSalaryStructure empSalStructure) {
		ResponseEntity<String> resp = null;

		Employee employee = new Employee();
		String name = service.saveEmployeeRegistration(employee);

		try {
			resp = new ResponseEntity<String>("Employee " + employee.getName() + " Register Succesfully",
					HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

//		 EmployeeSalaryStructure empSalStructure=new EmployeeSalaryStructure();
//		 empSalStructure.
//		 System.out.println();

		return resp;
	}

	// get all records
	@GetMapping("/allEmp")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> resp = null;
		List<Employee> list = service.getAllEmployee();
		System.out.println("list" + list);
		if (list == null || list.isEmpty()) {
			String message = "No data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
		}
		return resp;
	}

	// get single records
	@GetMapping("/one/{id}")
	public ResponseEntity<?> oneRecordsByid(@PathVariable String id) {
		System.out.println("ID" + id);
		ResponseEntity<Optional<Employee>> resp = null;
		// Check for Exist
		boolean present = service.isPresent(id);
		if (present) {
			// if Exist
			Optional<Employee> one = service.getOneEmployee(id);
			resp = new ResponseEntity<Optional<Employee>>(one, HttpStatus.OK);

		} else {
			// not exist
			resp = new ResponseEntity<Optional<Employee>>(HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	
	// get single 
//		@GetMapping("/higherAuthName/{id}")
//		public ResponseEntity<?> getHigherAutNameByid(@PathVariable String id) {
//			System.out.println("ID" + id);
//			ResponseEntity<Employee> resp = null;
//			// Check for Exist
//			boolean present = service.isPresent(id);
//			System.out.println("is present"+present);
//			if (present) {
//				// if Exist
////				Optional<Employee> one = service.getOneEmployee(id);
//				Employee emp=repo.findEmployeeById(id);
//				System.out.println("employee"+emp);
//				 Employee emp1=repo.findEmployeeById(emp.getReportHighAuth());
//				
//				System.out.println("S"+emp1);
//				resp = new ResponseEntity<Employee>(emp1, HttpStatus.OK);
//
//			} else {
//				// not exist
//				resp = new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
//			}
//			return resp;
//		}
		
		@GetMapping("/higherAuthName/{id}")
		public ResponseEntity<?> getHigherAutNameByid(@PathVariable String id) {
	        System.out.println("id"+id);
			ResponseEntity<?> resp = null;
//
			Employee emp = repo.findEmployeeById(id);
			System.out.println("leave data" + emp);

//			leave.forEach(lea -> {

				// Check for Exist
				boolean present =  service.isPresent(id);
				System.out.println("Present"+present);
				if (present) {
					// if Exist
                     System.out.println("1");
					Admin one = adminRepo.findAdminById(emp.getReportHighAuth());
					System.out.println("One Data Of Higher Auth"+one);
//					emp.setReportHighAuth(one.getEmail());
					if(one==null) {
						System.out.println("Null Data");
//						System.out.println("saukat");
						Employee empl = empRepo.findEmployeeById(emp.getReportHighAuth());
						System.out.println("Employee emp" + empl);

//						Employee sub = empRepo.findEmployeeById(lea.getBackupEmpId());
						emp.setReportHighAuth(empl.getName());
						emp.setRepostHighAuthId(empl.getId());
						
//						lea.setBackupEmpId(sub.getName());
					}else {
						emp.setReportHighAuth(one.getEmail());
						emp.setRepostHighAuthId(one.getId());
//						System.out.println("All Data ");

					}
//					Employee sub = empRepo.findEmployeeById(emp.getBackupEmpId());
//					lea.setBackupEmpId(sub.getName());
//					 resp = new ResponseEntity<Optional<Admin>>(one, HttpStatus.OK);

				} else {
					System.out.println("saukat");
					Employee empl = empRepo.findEmployeeById(emp.getReportHighAuth());
					System.out.println("Employee emp" + empl);

//					Employee sub = empRepo.findEmployeeById(lea.getBackupEmpId());
					emp.setReportHighAuth(empl.getName());
//					lea.setBackupEmpId(sub.getName());

				}

//			});

//			System.out.println("Leave" + leave);

			if (emp == null) {
				String message = "No data Found";
				resp = new ResponseEntity<String>(message, HttpStatus.OK);
			} else {
				resp = new ResponseEntity<Employee>(emp, HttpStatus.OK);
			}

			return resp;
		}
		
		
		
		
		
		
		
		
	
	
	
	
	

	// HireAuth email for mail sending purpose
	@GetMapping("/hireAuthEmail/{id}")
	public ResponseEntity<?> getHireAuthEmailUsingId(@PathVariable String id) {
		System.out.println("ID" + id);
		ResponseEntity<Employee> resp = null;
		Employee one = null;

		boolean present = service.isPresent(id);
		if (present) {
			// if Exist
			one = repo.findEmployeeById(id);
			Employee onehigherAuth = repo.findEmployeeById(one.getReportHighAuth());

			resp = new ResponseEntity<Employee>(onehigherAuth, HttpStatus.OK);
		} else {
			// not exist
			return resp = new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// HireAuth email for mail sending purpose
		@GetMapping("/substituteEmail/{id}")
		public ResponseEntity<?> getSubstituteEmailUsingId(@PathVariable String id) {
			System.out.println("ID" + id);
			ResponseEntity<Employee> resp = null;
			Employee one = null;

			boolean present = service.isPresent(id);
			if (present) {
				// if Exist
				one = repo.findEmployeeById(id);
				resp = new ResponseEntity<Employee>(one, HttpStatus.OK);
			} else {
				return resp = new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
			}
			return resp;
		}
	

	// Update Data
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Employee employee) {
		ResponseEntity<String> resp = null;
		// check for id
		boolean present = service.isPresent(employee.getId());
		if (present) {
			service.updateEmployee(employee);
			resp = new ResponseEntity<String>("Updated Successfuly", HttpStatus.OK);

		} else {
			resp = new ResponseEntity<String>("Records" + employee.getId() + "Not Found", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	// retrive id and name for reportHighAuth
	// get all records
	@SuppressWarnings("unchecked")
	@GetMapping("/adminHighAuth")
	public ResponseEntity<?> getIdAndNameReportHighAuth() {
		ResponseEntity<?> resp = null;
		List<Employee> list = service.getAllEmployee();

		if (list == null || list.isEmpty()) {
			String message = "No data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {

			resp = new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
		}
		return resp;
	}

	// update ReportHigherAuthremark and status
	@PutMapping("/changePassword")
	public ResponseEntity<?> changePasswordByOldPassword(@RequestBody EmployeeChangePassword employee) {
		ResponseEntity<?> resp = null;
//		System.out.println("Employee"+employee.getId());
	  Employee emp=new Employee();
//		System.out.println("Employee"+employee.getOldPassword());
		emp.setPassword(employee.getOldPassword());
//		admin.setPassword(pwdEncoder.encode(admin.getPassword()));
//		System.out.println("Employee"+employee.getNewPassword());
		boolean present = service.isPresent(employee.getId());
		System.out.println("Present"+present);
		if (present) {

			try {
				Employee query = repo.findEmployeeById(employee.getId());
				System.out.println(query);
				if(employee.getOldPassword().equals(query.getPassword())) {
					query.setPassword(employee.getNewPassword());
					System.out.println("Employee on id" + query);
					service.saveEmployeeRegistration(query);
					resp = new ResponseEntity<String>("Updated Successfuly", HttpStatus.OK);
				}else {
					resp = new ResponseEntity<String>("Records Not Found", HttpStatus.BAD_REQUEST);
				}
				
				

			} catch (Exception e) {
				resp = new ResponseEntity<String>("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}

		} else {
			resp = new ResponseEntity<String>("Records Not Found", HttpStatus.BAD_REQUEST);
		}
		return resp;

	}
	
	// update ReportHigherAuthremark and status
		@PutMapping("/updatePhoto")
		public ResponseEntity<?> updateProfilePhoto(@RequestBody Employee employee) {
			ResponseEntity<?> resp = null;
          System.out.println(employee.getPhoto());
			boolean present = service.isPresent(employee.getId());
			if (present) {
				Query query = new Query();
				query.addCriteria(Criteria.where("id").is(employee.getId()));

				Update update = new Update();
				update.set("photo", employee.getPhoto());
//				update.set("repAuthRemark", leave.getRepAuthRemark());
				System.out.println("updated" + update);
				Employee updatedData = mongoOperations.findAndModify(query, update, employee.getClass());

				resp = new ResponseEntity<String>("Updated Successfuly", HttpStatus.OK);

			} else {
				resp = new ResponseEntity<String>("Records Not Found", HttpStatus.BAD_REQUEST);
			}
			return resp;

		}

}
