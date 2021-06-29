package net.connectix.rest.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
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
import net.connectix.document.EmployeeSalaryStructure;
import net.connectix.document.Leave;
import net.connectix.document.Payroll;
import net.connectix.repo.PayrollRepository;
import net.connectix.service.IEmployeeSalService;
import net.connectix.service.IEmployeeService;
import net.connectix.service.IPayrollService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/salary")
public class EmployeeSalaryStructureRestController {

	@Autowired
	private IPayrollService payrollService;
	@Autowired
	private IEmployeeService empService;
	@Autowired
	private IEmployeeSalService salService;
	@Autowired
	PayrollRepository payrollRepo;

	@Autowired
	MongoOperations mongoOperation;

	@PostMapping("/salSave")
	public String saveEmployeeSalary(@RequestBody EmployeeSalaryStructure empSal) {
		System.out.println("sal" + empSal.getGrossPay());

		String id = empSal.getId();

		ResponseEntity<Object> resp = null;
		Payroll payroll = new Payroll();

		Optional<Employee> one = null;
		boolean present = empService.isPresent(id);
		if (present) {
			// if Exist
			one = empService.getOneEmployee(id);
			resp = new ResponseEntity<Object>(one, HttpStatus.OK);

		} else {
			// not exist
			resp = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}

		String empName = one.get().getName();
		String status = one.get().getStatus();

		System.out.println("status" + status);
//		
		long millis = System.currentTimeMillis();
		java.sql.Date date1 = new java.sql.Date(millis);

		LocalDate currentdate = LocalDate.now();
		int currentDay = currentdate.getDayOfMonth();
		System.out.println("Current day: " + currentDay);

		// Getting the current month
		Month currentMonth = currentdate.getMonth();
		System.out.println("Current month: " + currentMonth);
		// getting the current year
		int currentYear = currentdate.getYear();
		System.out.println("Current month: " + currentYear);

		String date = currentMonth + "-" + currentYear;
		System.out.println("Date Of payroll" + date);

		Calendar c = Calendar.getInstance();
		int monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("Month Total Day" + monthMaxDays);

		payroll.setId(empSal.getId());
		payroll.setName(empName);
		payroll.setTotalCostToCompany(empSal.getTotalCostToCompany());
		payroll.setGrossPay(empSal.getGrossPay());
		payroll.setNetSalary(empSal.getNetSalary());

		payroll.setAddition("0");
		payroll.setDeduction("0");
		payroll.setPaidHoliday("0");
		payroll.setUnPaidHoliday("0");

		payroll.setSalaryMonth(date);
		payroll.setMonthMaxDays(monthMaxDays);
		payroll.setReimbursements("0");
		payroll.setRemark("Salary for " + date);
		payroll.setStatus("Process");
       
		payroll.setAddtionRemark("");
		payroll.setDeductionRemark("");
		payroll.setCreatedBy("null");
		payroll.setCreatedDate(date1.toString());
		payroll.setUpdatedBy("null");
		payroll.setUpdatedDate(date1.toString());
		payroll.setDescription("Payroll data Process");
		payroll.setTrash("Empty Data");
       
//		String name1=payrollService.savePayroll(payroll);
		if (status.equals("Working")) {
			String name1 = payrollService.savePayroll(payroll);
			String name = salService.saveEmployeeSalary(empSal);
			System.out.println("Working");
			try {
				System.out.println("done");
				resp = new ResponseEntity<Object>("Employee Salary" + name1 + " Register Succesfully", HttpStatus.OK);
				try {
					resp = new ResponseEntity<Object>(
							"Employee sal and Payroll" + payroll.getName() + " Register Succesfully", HttpStatus.OK);
				} catch (Exception e) {

				}
			} catch (Exception e) {
				resp = new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}
		} else {
			System.out.println("Not Working");
			resp = new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
//			resp=new ResponseEntity<Optional<EmployeeSalaryStructure>>(HttpStatus.BAD_REQUEST);

		}

//		try {
//			System.out.println("done");
//			  resp=new ResponseEntity<Object>("Employee Salary" + name1 + " Register Succesfully", HttpStatus.OK);
//			try {
//				 resp=new ResponseEntity<Object>("Employee sal and Payroll" + payroll.getName() + " Register Succesfully", HttpStatus.OK);
//			} catch (Exception e) {
//				
//			}
//		}catch (Exception e) {
//			resp=new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
//			e.printStackTrace();
//		}
		return "save" + resp;

	}

	@GetMapping("one/{id}")
	public String getOneEmpSalaryStructure(@PathVariable String id) {

		System.out.println("ID" + id);
		ResponseEntity<Optional<EmployeeSalaryStructure>> resp = null;
		// Check for Exist
		boolean present = salService.isPresent(id);
		if (present) {
			// if Exist
			Optional<EmployeeSalaryStructure> one = salService.getOneEmployeeSalStructure(id);
			resp = new ResponseEntity<Optional<EmployeeSalaryStructure>>(one, HttpStatus.OK);

		} else {
			// not exist
			resp = new ResponseEntity<Optional<EmployeeSalaryStructure>>(HttpStatus.BAD_REQUEST);
		}
		return "retrive" + resp;
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllEmpSalStructure() {
		ResponseEntity<?> resp = null;
		List<EmployeeSalaryStructure> list = salService.getAllEmployeeSalStructure();
		if (list == null || list.isEmpty()) {
			String message = "No data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<List<EmployeeSalaryStructure>>(list, HttpStatus.OK);
		}
		return resp;
	}

	// Update Data
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody EmployeeSalaryStructure employeeSal) {
		ResponseEntity<String> resp = null;
		// check for id
		boolean present = salService.isPresent(employeeSal.getSaId());
		if (present) {
			salService.updateEmployeeSalStructure(employeeSal);
//			 payrollService.updateEmplPayroll(payroll); 
		

			Payroll payroll = new Payroll();
			payroll.setId(employeeSal.getId());
//			payroll.setNetSalary(employeeSal.getNetSalary());
//			payroll.setGrossPay(employeeSal.getGrossPay());
//			payroll.setTotalCostToCompany(employeeSal.getTotalCostToCompany());
			
			List<Payroll> listOfpayroll=payrollRepo.findAll();
			System.out.println("Saukat"+listOfpayroll);
			for (Payroll payroll2 : listOfpayroll) {
				if(payroll2.getId().equals(employeeSal.getId())) {
					payroll2.setNetSalary(employeeSal.getNetSalary());
					payroll2.setGrossPay(employeeSal.getGrossPay());
					payroll2.setTotalCostToCompany(employeeSal.getTotalCostToCompany());
					
					System.out.println("Payroll Data"+payroll2);
					payrollService.updateEmplPayroll(payroll2);
					resp = new ResponseEntity<String>("Updated Successfuly", HttpStatus.OK);
				}	
			
			}

		} else {
			resp = new ResponseEntity<String>("Records" + employeeSal.getId() + "Not Found", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

}
