package net.connectix.rest.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.xml.crypto.Data;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import net.connectix.document.Employee;
import net.connectix.document.EmployeeTask;
import net.connectix.document.Leave;
import net.connectix.document.Payment;
import net.connectix.document.Payroll;
import net.connectix.document.Reimbursement;
import net.connectix.dto.PayrollWithAccountNo;
import net.connectix.dto.ReimbursementResponse;
import net.connectix.dto.ResponseMessage;
import net.connectix.dto.RestResponseData;
import net.connectix.repo.EmployeeRepository;
import net.connectix.repo.PayrollRepository;
import net.connectix.repo.PayrollWithAccountNoRepo;
import net.connectix.repo.ReimbursementRepo;
import net.connectix.service.IEmployeeService;
import net.connectix.service.IPaymentService;
import net.connectix.service.IReimbursementService;

@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/reimbursement")
public class ReimbursementRestController {

	@Autowired
	private IReimbursementService service;
	@Autowired
	private IEmployeeService empService;
	
	@Autowired
	private PayrollRepository repo;
	
	@Autowired
	private IPaymentService paymentService;

	@Autowired
	private ReimbursementRepo Reimrepo;
	@Autowired
	MongoOperations mongoOperations;
	
	@Autowired
	PayrollWithAccountNoRepo payrollAccount;

	@PostMapping("/save")
	public ResponseEntity<?> saveReimbursement(@RequestBody Reimbursement reimbursement) {
		System.out.println("all");
		ResponseEntity<?> resp = null;
		reimbursement.setStatus("Apply");
		reimbursement.setReportStatus("Process");
		reimbursement.setPaymentStatus("Process");
		String ids = service.saveReimbursement(reimbursement);

		try {
			System.out.println("Success");

// 			String message="Inserted File";
// 			String id=ids;
			ReimbursementResponse reim = new ReimbursementResponse();
			reim.setId(ids);
			reim.setMessage("Inserted");
			System.out.println("Reim==>" + reim);
// 			Map<String, String> map=new HashMap<>();

// 		     map.put("message", "Inserted");
// 		     map.put("id", reimbursement.getId());
			resp = ResponseEntity.status(HttpStatus.OK).body(reim);
// 			return ResponseEntity.status(HttpStatus.ACCEPTED).body(map);
// 			return resp=new ResponseEntity<?>(map, HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	// get single records
	@GetMapping("/getHigherAuth/{id}")
	public ResponseEntity<?> oneRecordsByHigherAuth(@PathVariable String id) {

		ResponseEntity<?> resp = null;
		System.out.println("saukat alli" + id);
		// Check for Exist
		boolean present = empService.isPresent(id);
		System.out.println("present" + present);
		if (present) {
			// if Exist
			Optional<Employee> one = empService.getOneEmployee(id);
			resp = new ResponseEntity<Optional<Employee>>(one, HttpStatus.OK);

		} else {
			// not exist
			resp = new ResponseEntity<Optional<Employee>>(HttpStatus.BAD_REQUEST);
		}

		return resp;
	}

	// get all records
	ResponseEntity<?> resp = null;

	@GetMapping("/allEmpReim")
	public ResponseEntity<?> getAll() {

		List<Reimbursement> list = service.getAllReimbursement();

		List<Reimbursement> arr = new ArrayList<>();

		if (list == null || list.isEmpty()) {
			String message = "No data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {

			list.forEach(data -> {
				if (data.getPaymentStatus().equals("Process")) {
					System.out.println("saukat");
					arr.add(data);
					resp = new ResponseEntity<List<Reimbursement>>(arr, HttpStatus.OK);
				}
//					else{
//						String message = "Procee Data Not Available";
//						resp = new ResponseEntity<String>(message, HttpStatus.OK);
//					}
			});
		}
		return resp;
	}

	@GetMapping("/updateStatus")
	public ResponseEntity<?> updateReportSatatus() {
		ResponseEntity<?> resp = null;

		List<Reimbursement> list = service.getAllReimbursement();

		if (list != null) {
			for (Reimbursement reim : list) {
				System.out.println("payroll 342");
				reim.setReportStatus("Final");
			}
		}

		if (list != null) {
			System.out.println("1");
			Reimrepo.saveAll(list);

			return ResponseEntity.status(HttpStatus.OK).body("Status Changed!!");
		} else {
//				   String message="Status Not Changed";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Status Not Changed!!");

		}

//			if (list == null || list.isEmpty()) {
//				String message = "No data Found";
//				resp = new ResponseEntity<String>(message, HttpStatus.OK);
//			} else {
//				
//
//				resp = new ResponseEntity<List<Reimbursement>>(list, HttpStatus.OK);
//			}
//			return resp;
	}

	// get all records
	@GetMapping("/getAllReim/{id}")
	public ResponseEntity<?> getAllSendTaskByEmployeeId(@PathVariable String id) {
		ResponseEntity<?> resp = null;
		System.out.println("id" + id);
		List<Reimbursement> list = Reimrepo.findReimbursementByEmpId(id);
		System.out.println("Emp Assign data" + list);
		if (list == null || list.isEmpty()) {
			String message = "No data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<List<Reimbursement>>(list, HttpStatus.OK);
		}
		return resp;
	}

	// Update Data
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Reimbursement reimbursement) {
		ResponseEntity<String> resp = null;
		// check for id
		boolean present = service.isPresent(reimbursement.getId());
		if (present) {
			service.updateReimbursement(reimbursement);
			resp = new ResponseEntity<String>("Updated Successfuly", HttpStatus.OK);

		} else {
			resp = new ResponseEntity<String>("Records" + reimbursement.getId() + "Not Found", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	// get all records
	@GetMapping("/getReimRequest/{higherAuth}")
	public ResponseEntity<?> getAllReimByHigherId(@PathVariable String higherAuth) {
		ResponseEntity<?> resp = null;
		System.out.println("id" + higherAuth);
		List<Reimbursement> list = Reimrepo.findReimbursementByHigherAuth(higherAuth);
		System.out.println("All higher" + list);
		if (list == null || list.isEmpty()) {
			String message = "No data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<List<Reimbursement>>(list, HttpStatus.OK);
		}
		return resp;
	}

	@PutMapping("/updateStatus")
	public ResponseEntity<?> updateStatusByEmployee(@RequestBody Reimbursement reimbursement) {
		ResponseEntity<?> resp = null;
		System.out.println("id" + reimbursement.getHigherAuthremark());
		boolean present = service.isPresent(reimbursement.getId());
		if (present) {
			Query query = new Query();
			query.addCriteria(Criteria.where("id").is(reimbursement.getId()));

			Update update = new Update();
			update.set("status", reimbursement.getStatus());
			update.set("HigherAuthremark", reimbursement.getHigherAuthremark());
			System.out.println("updated" + update);
			Reimbursement updatedData = mongoOperations.findAndModify(query, update, reimbursement.getClass());

			resp = new ResponseEntity<String>("Updated Successfuly", HttpStatus.OK);

		} else {
			resp = new ResponseEntity<String>("Records Not Found", HttpStatus.BAD_REQUEST);
		}
		return resp;

	}

	@SuppressWarnings("unlikely-arg-type")
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
		
		List<Reimbursement> listofREim=	Reimrepo.findReimbursementByReportStatusAndPaymentStatus("Final","Process");
	 
		
//		System.out.println("");
		

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
			
			System.out.println("REim"+listofREim.size());
			System.out.println("list"+list.size());
			
			PayrollWithAccountNo pac = new PayrollWithAccountNo();
//			List<Integer> countAmount=new ArrayList<Integer>();
//			 Integer amount=0;
			 Map<String, Integer> map = new HashMap<String, Integer>();
			for (PayrollWithAccountNo accNo : list) {
		    	for (Reimbursement reimbursement : listofREim) {
					  if (accNo.getId().equals(reimbursement.getEmpId())) {
						  
					   Integer integer = map.get(reimbursement.getEmpId());					 
						
					   map.put(reimbursement.getEmpId(),(integer==null)?reimbursement.getAmount():integer+reimbursement.getAmount());
				
//						 	amount += reimbursement.getAmount();
//						 	  System.out.println("Amount=>"+amount);
//						   countAmount.add(reimbursement.getAmount());
//						   System.out.println("Count 1=>"+countAmount);
					  }
//			System.out.println("Count 2=>"+countAmount);
				}
			}
			System.out.println("Map amount=>"+map);
			List<PayrollWithAccountNo> list12 = new ArrayList<PayrollWithAccountNo>();
			
	   for (PayrollWithAccountNo payrollList : list) {
		   for (Map.Entry<String,Integer> entry : map.entrySet()) {
			   if(entry.getKey().equals(payrollList.getId())) {
				   PayrollWithAccountNo payAccNo=new PayrollWithAccountNo();
				   
				   payAccNo.setAccNo(payrollList.getAccNo());
				   payAccNo.setName(payrollList.getName());
				   payAccNo.setAmount(entry.getValue());
				   payAccNo.setSalaryMonth(payrollList.getSalaryMonth());
				   payAccNo.setIfscCode(payrollList.getIfscCode());
				   list12.add(payAccNo);
				   
			   }
		  }
	   }
					 
				
			  
			resp = new ResponseEntity<List<PayrollWithAccountNo>>(list12, HttpStatus.OK);
		}

		return resp;

	}

}
