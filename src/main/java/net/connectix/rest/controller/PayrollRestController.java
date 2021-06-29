package net.connectix.rest.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.connectix.document.Employee;
import net.connectix.document.Leave;
import net.connectix.document.Payment;
import net.connectix.document.Payroll;
import net.connectix.dto.PayrollWithAccountNo;
import net.connectix.repo.PayrollRepository;
import net.connectix.service.IEmployeeService;
import net.connectix.service.IPaymentService;
import net.connectix.service.IPayrollService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/payroll")
public class PayrollRestController {

//	@Autowired
//	private IEmployeeService service;

	@Autowired
	private IPayrollService payrollService;
	@Autowired
	private IEmployeeService empService;
	@Autowired
	private IPaymentService paymentService;
	@Autowired
	private PayrollRepository repo;
//	

//	@PostMapping("/save")
//	public String saveEmployeeSalary(@RequestBody Payroll payroll) {
//	return "save";
//	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllPayroll() {

		ResponseEntity<?> resp = null;
		List<Payroll> list = payrollService.getAllEmpPayroll();
		if (list == null || list.isEmpty()) {
			String message = "No data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<List<Payroll>>(list, HttpStatus.OK);
		}
		return resp;
	}

	@GetMapping("one/{id}")
	public ResponseEntity<?> getOneEmpSalaryStructure(@PathVariable String id) {

		System.out.println("ID" + id);
		ResponseEntity<Optional<Payroll>> resp = null;
		// Check for Exist
		boolean present = payrollService.isPresent(id);
		if (present) {
			// if Exist
			Optional<Payroll> one = payrollService.getOneEmpPayroll(id);
			resp = new ResponseEntity<Optional<Payroll>>(HttpStatus.OK);

		} else {
			// not exist
			resp = new ResponseEntity<Optional<Payroll>>(HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	@GetMapping("salaryMonth/{id}")
	public ResponseEntity<?> getAllRecordsUsingId(@PathVariable String id) {

		ResponseEntity<?> resp = null;
		System.out.println("ID" + id);
		
		
		List<Payroll> payrollByid=repo.findPayrollById(id);
//		System.out.println("Payroll ID"+payrollByid);
//		System.out.println("Payroll data" + list);
		List<Payroll> listOfMonth = new ArrayList<Payroll>();
		List<Payroll> res=repo.findPayrollByStatus("Final");

		System.out.println("Solution"+res.size());
		for (Payroll payroll : res) {
			if(payroll.getId().equals(id)) {
				listOfMonth.add(payroll);
			}
     
		}
		resp = new ResponseEntity<List<Payroll>>(listOfMonth, HttpStatus.OK);
		
		System.out.println("Solution"+listOfMonth.size());
//		
//		List<Payroll> list = payrollService.getAllEmpPayroll();
//		for (Payroll payroll : list) {
//		if(payroll.getStatus().equals("Final")) {
//			resp = new ResponseEntity<List<Payroll>>(listOfMonth, HttpStatus.OK);
//		}else {
//			System.out.println("Records Not Found");
//		}
//	List<Payroll>	res=repo.findPayrollByStatus("Final");
//
//	System.out.println("Payroll "+res);
//		}
//		List<Payroll> list = payrollService.getAllEmpPayroll();
//
//		System.out.println("Payroll data" + list);
//		List<Payroll> listOfMonth = new ArrayList<Payroll>();
//
//		if (list == null || list.isEmpty()) {
//			String message = "No data Found";
//			resp = new ResponseEntity<String>(message, HttpStatus.OK);
//		} else {
//			for (Payroll payroll : list) {
//				if (payroll.getId().equals(id)) {
//					
//					 Calendar cal = Calendar.getInstance();
//				      SimpleDateFormat simpleformat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");
//		     
//				      simpleformat = new SimpleDateFormat("dd-MMMM-yyyy");
//				      String str = simpleformat.format(new Date());
//				      System.out.println("Current Date = "+str);
//
//                     
//					listOfMonth.add(payroll);
//					if(payroll.getStatus().equals("Final")) {
//						resp = new ResponseEntity<List<Payroll>>(listOfMonth, HttpStatus.OK);
//					}else {
//						System.out.println("Records Not Found");
//					}
//
//				}
//			}

//		}

		return resp;
	}

	// Update Data
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Payroll payroll) {
		ResponseEntity<String> resp = null;
		// check for id
		boolean present = payrollService.isPresent(payroll.getPayrollId());
		if (present) {
//			payrollService.updateEmplPayroll(payroll);
//			resp = new ResponseEntity<String>("Updated Successfuly", HttpStatus.OK);
		boolean check=repo.existsBySalaryMonth(payroll.getSalaryMonth());
			if(!check) {
			
				
//				Query query = new Query();
//				query.addCriteria(Criteria.where("payrollId").is(payroll.getPayrollId()));
//	          
//				Update update = new Update();
				Payroll update=new Payroll();
//				update.set("id", payroll.getId());
				update.setId(payroll.getId());
				update.setMonthMaxDays(payroll.getMonthMaxDays());
				update.setName(payroll.getName());
				update.setTotalCostToCompany(payroll.getTotalCostToCompany());
				
				update.setGrossPay(payroll.getGrossPay());
				update.setSalaryMonth(payroll.getSalaryMonth());
				update.setAddition(payroll.getAddition());
				
				update.setDeduction(payroll.getDeduction());
				update.setPaidHoliday(payroll.getPaidHoliday());
				update.setUnPaidHoliday(payroll.getUnPaidHoliday());
				update.setReimbursements(payroll.getReimbursements());
				
				
				update.setAddtionRemark(payroll.getAddtionRemark());
				update.setDeductionRemark(payroll.getDeductionRemark());
				update.setRemark(payroll.getRemark());
				update.setStatus(payroll.getStatus());
				String name=payrollService.insertCurrentPayroll(update);
				System.out.println("Inserted" + update);
				resp = new ResponseEntity<String>("Records" + payroll.getName() + "Inserted", HttpStatus.OK);
//				Leave updatedData = mongoOperations.findAndModify(query, update, leave.getClass());
			}else {
				payrollService.updateEmplPayroll(payroll);
				   resp=new ResponseEntity<String>("Updated Successfuly",HttpStatus.OK);
			  System.out.println("Updated data");	
			}

		} else {
			resp = new ResponseEntity<String>("Records" + payroll.getId() + "Not Found", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	List<Payroll> payList;
	// Fetch Current Month Data
	@GetMapping("/currentMonthRecords")
	public ResponseEntity<?> fetchCurrentMonth() {
		ResponseEntity<?> resp = null;

		LocalDate currentdate = LocalDate.now();
		List<Payment> listPayment = paymentService.getAllPayment();
		// Getting the current month
		Month currentMonth = currentdate.getMonth();
		// getting the current year
		int currentYear = currentdate.getYear();
		String date = currentMonth + "-" + currentYear;
//		System.out.println("date" + date);

		List<Employee> allEmpRecords = empService.getAllEmployee();
//		System.out.println("all Employee Records" + allEmpRecords);
		for (Employee employee : allEmpRecords) {
			for (Payment payment : listPayment) {

				if (payment.getId().equals(employee.getId()) && employee.getStatus().equals("Working")) {
//					System.out.println("working 1" + payment.getId());
					payList = repo.findPayrollBySalaryMonth(date);
//					System.out.println("Current month Records 1" + payList + "\n");

					if (payList == null || payList.isEmpty()) {
						String message = "No data Found";
						resp = new ResponseEntity<String>(message, HttpStatus.OK);
					} else {
						resp = new ResponseEntity<List<Payroll>>(payList, HttpStatus.OK);
					}
				} else {
//					System.out.println("Not Working 2");
				}
			}
		}

		return resp;
	}

	// Fetch Current Month Data
	@GetMapping("/previousMonthRecords")
	public ResponseEntity<?> fetchPreviousMonth() {
		ResponseEntity<?> resp = null;

		LocalDate currentdate = LocalDate.now().minusMonths(1);

		// Getting the current month
		Month currentMonth = currentdate.getMonth();
		// getting the current year
		int currentYear = currentdate.getYear();
		String date = currentMonth + "-" + currentYear;

		List<Payroll> payList = repo.findPayrollBySalaryMonth(date);
//		System.out.println("Current month Records" + payList + "\n");

		if (payList == null || payList.isEmpty()) {
			String message = "No data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<List<Payroll>>(payList, HttpStatus.OK);
		}
		return resp;
	}

	// Fetch Current Month Data
	@GetMapping("calendarWiseRecords/{salaryMonth}/{id}")
	public ResponseEntity<?> fetchCalendarWiseRecords(@PathVariable String salaryMonth, @PathVariable String id) {
		ResponseEntity<?> resp = null;

//		System.out.println("Id p" + id);

		List<Payroll> payList = repo.findPayrollBySalaryMonth(salaryMonth);
//		System.out.println("Current month Records" + payList + "\n");
		List<Payroll> listOfMonth = new ArrayList<Payroll>();

		if (payList == null || payList.isEmpty()) {
			String message = "No data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			for (Payroll payroll : payList) {
				if (payroll.getId().contains(id)) {
					listOfMonth.add(payroll);
//					System.out.println("payroll   lk" + listOfMonth);
					resp = new ResponseEntity<List<Payroll>>(listOfMonth, HttpStatus.OK);
				}
			}

		}
		return resp;
	}

	int k = 0;

	// saveData if salaryMonth not match
	@GetMapping("/saveCurrentPayroll")
	public String savePayrollOfCurrentMonth() {

//		   ResponseEntity<String> resp=null;
		String resp = null;

		LocalDate currentdate = LocalDate.now();
		// Getting the current month
		Month currentMonth = currentdate.getMonth();

		// getting the current year
		int currentYear = currentdate.getYear();

		String date = currentMonth + "-" + currentYear;
//		System.out.println("Current dATE: " + date.replaceAll("\\s", ""));
		List<Payroll> list = payrollService.getAllEmpPayroll();
		List<Payment> listPayment = paymentService.getAllPayment();
		System.out.println("SizeAll: " + list.size());

		List<Payroll> currentlist = repo.findPayrollBySalaryMonth(date.replaceAll("\\s", ""));
//		System.out.println("sizecurrent: " + currentlist.size() + "Current Month data" + currentlist);
		if (list.size() > 0) {
			for (Payroll alllist : list) {

				List<Payroll> currentPayroll = repo.findPayrollByNameAndSalaryMonth(alllist.getName(), date);
//						System.out.println("Payroll data by using id and currentMonth"+currentPayroll);

				Calendar c = Calendar.getInstance();
				int monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
				System.out.println("Month Total Day" + monthMaxDays);
				
				if (currentPayroll.size() == 0) {
					System.out.println("insert" + alllist.getName());
					long millis = System.currentTimeMillis();
					java.sql.Date date1 = new java.sql.Date(millis);

					Payroll payroll = new Payroll();
					payroll.setId(alllist.getId());
					payroll.setName(alllist.getName());
					payroll.setTotalCostToCompany(alllist.getTotalCostToCompany());
					payroll.setSalaryMonth(date);
					payroll.setGrossPay(alllist.getGrossPay());
					payroll.setNetSalary(alllist.getNetSalary());
					payroll.setMonthMaxDays(monthMaxDays);

					payroll.setAddition("0");
					payroll.setDeduction("0");
					payroll.setPaidHoliday("0");
					payroll.setUnPaidHoliday("0");
               
					
					payroll.setSalaryMonth(date);
					payroll.setReimbursements("0");
					payroll.setRemark("Salary for "+date);
					payroll.setStatus("Process");

					payroll.setCreatedBy("null");
					payroll.setCreatedDate(date1.toString());
					payroll.setUpdatedBy("null");
					payroll.setUpdatedDate(date1.toString());
					payroll.setDescription("Payroll data Process");
					payroll.setTrash("Empty Data");

					List<Employee> allEmpRecords = empService.getAllEmployee();
					System.out.println("all Employee Records" + allEmpRecords);
					for (Employee employee : allEmpRecords) {
						for (Payment payment : listPayment) {

							if (payment.getId().equals(employee.getId()) && employee.getStatus().equals("Working")) {
								System.out.println("WORKING All" + alllist);
								payrollService.insertCurrentPayroll(payroll);
								try {
//							System.out.println("Success");
//									resp=new ResponseEntity<String>("Current Month Records Inserted Succesfully", HttpStatus.OK);
									resp = "Current Data Inserted";
								} catch (Exception ex) {
//							System.out.println("Not Inseted");
//						 			resp=new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
									ex.printStackTrace();
								}
							} else {
								System.out.println("NOT WORKING");
							}

						}
					}
				} else {
					System.out.println("not" + alllist.getName());
//					    	resp=new ResponseEntity<String>("Current Month Records Already Updated");
					resp = "Records already Upadated";
				}

			}
		}
		System.out.println(resp);

		return resp;

	}

	@GetMapping("/payWithAccNo")
	public ResponseEntity<?> getAllPayrollWithAccNo() {

		LocalDate currentdate = LocalDate.now();


		Month currentMonth = currentdate.getMonth();
		
		int currentYear = currentdate.getYear();
		String date = currentMonth + "-" + currentYear;

		List<Payroll> listPayroll = repo.findPayrollBySalaryMonth(date);
		System.out.println("Current month Records" + listPayroll + "\n");

		List<Payment> listPayment = paymentService.getAllPayment();


		HashMap<Integer, String> hmap2 = new HashMap<Integer, String>();

		List<PayrollWithAccountNo> list = new ArrayList();

		for (Payroll payroll : listPayroll) {
			for (Payment payment : listPayment) {

				if (payment.getId().equals(payroll.getId())) {

					PayrollWithAccountNo pac = new PayrollWithAccountNo();

					pac.setPayrollId(payroll.getPayrollId());
					pac.setId(payroll.getId());

					pac.setAccNo(payment.getAccNo());
                    pac.setIfscCode(payment.getIfscCode());
					pac.setAddition(payroll.getAddition());
					pac.setDeduction(payroll.getDeduction());
					pac.setGrossPay(payroll.getGrossPay());
					pac.setName(payroll.getName());
					pac.setNetSalary(payroll.getNetSalary());
					pac.setReimbursements(payroll.getReimbursements());
					pac.setRemark(payroll.getRemark());
					pac.setStatus(payroll.getStatus());
					pac.setSalaryMonth(payroll.getSalaryMonth());
					pac.setTotalCostToCompany(payroll.getTotalCostToCompany());

					list.add(pac);

				}
			}
		}

		ResponseEntity<?> resp = null;

		if (list == null || list.isEmpty()) {
			String message = "No data Found";

			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<List<PayrollWithAccountNo>>(list, HttpStatus.OK);


		}

		return resp;

	}
	
	
	//Modify Status of payroll
	@GetMapping("/process")
	public ResponseEntity<?> ProcessToFinal() {
		ResponseEntity<?> resp=null;
		   System.out.println("Current month Records"+payList);
		   if(payList !=null) {
			   for (Payroll payroll : payList) {
				   System.out.println("payroll 342");
					payroll.setStatus("Final");
				 }  
		   }
		 
//		   resp = new ResponseEntity<List<Payroll>>(payList, HttpStatus.OK);
		   if(payList != null) {
			   System.out.println("1"+payList);
			   repo.saveAll(payList);
//			   String message="Status Changed";
			   
			   return ResponseEntity.status(HttpStatus.OK).body("Status Changed!!");
		   }else {
//			   String message="Status Not Changed";
			   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Status Not Changed!!");
			   
		   }
//		return resp;
	}
	
	//get payroll report for every month based on calender
	@GetMapping("monthWisePayrollReport/{salaryMonth}")

	public ResponseEntity<?> getPayrollReportByCalender(@PathVariable String salaryMonth) {


		List<Payroll> listPayroll = repo.findPayrollBySalaryMonth(salaryMonth);
		System.out.println("Current month Records" + listPayroll + "\n");

		List<Payment> listPayment = paymentService.getAllPayment();

		HashMap<Integer, String> hmap2 = new HashMap<Integer, String>();

		List<PayrollWithAccountNo> list = new ArrayList();

		for (Payroll payroll : listPayroll) {
			for (Payment payment : listPayment) {

				if (payment.getId().equals(payroll.getId())) {

					PayrollWithAccountNo pac = new PayrollWithAccountNo();

					pac.setPayrollId(payroll.getPayrollId());
					pac.setId(payroll.getId());

					pac.setAccNo(payment.getAccNo());
                    pac.setIfscCode(payment.getIfscCode());
					pac.setAddition(payroll.getAddition());
					pac.setDeduction(payroll.getDeduction());
					pac.setGrossPay(payroll.getGrossPay());
					pac.setName(payroll.getName());
					pac.setNetSalary(payroll.getNetSalary());
					pac.setReimbursements(payroll.getReimbursements());
					pac.setRemark(payroll.getRemark());
					pac.setStatus(payroll.getStatus());
					pac.setSalaryMonth(payroll.getSalaryMonth());
					pac.setTotalCostToCompany(payroll.getTotalCostToCompany());

					list.add(pac);

				}
			}
		}

		ResponseEntity<?> resp = null;

		if (list == null || list.isEmpty()) {
			String message = "No data Found";
//			System.out.println("np trcords"+message);
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			for (PayrollWithAccountNo payrollWithAccountNo : list) {
				if (payrollWithAccountNo.getRemark().equals("Salary Process")) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Salary Process");
				} else if(payrollWithAccountNo.getStatus().equals("Final")){
					System.out.println("all records of txt" + list);
					 return resp = new ResponseEntity<List<PayrollWithAccountNo>>(list, HttpStatus.OK);
//					System.out.println("current month");
				}else {
					System.out.println("No Records");
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Records Found!!");
				}
			}

		}

		return resp;

	}

}
