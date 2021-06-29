package net.connectix.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.connectix.document.EmailRequest;
import net.connectix.document.Employee;
import net.connectix.repo.EmployeeRepository;
import net.connectix.service.impl.EmailService;



@CrossOrigin(origins = "*")	
@RestController
@RequestMapping("/email")
public class EmailController {
	@Autowired
	private EmailService service;
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "Welcome";
	}
	
	@PostMapping("/sendEmail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
//		System.out.println("EMAIL REQUEST::"+request);
		ResponseEntity<?> resp=null;
		boolean result= service.sendEmail(request.getSubject(),request.getMessage(),request.getTo());
		System.out.println("Result"+result);
		if(result) {
			resp= ResponseEntity.ok("Email Send Successfully...");
		}else {
			resp= ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email Not send");
		}
		return resp;
	}
	
	@PostMapping("/sendEmailForForgotPassword")
	public ResponseEntity<?> sendEmailForForgotPassword(@RequestBody EmailRequest request){
		System.out.println("EMAIL REQUEST::"+request.getTo());
		ResponseEntity<?> resp=null;
		Employee emp=empRepo.findEmployeeByEmail(request.getTo());
		System.out.println("Employee Data"+emp);
		if(emp !=null) {
			request.setTo(emp.getEmail());
			request.setSubject("Forgot Password!!");
			request.setMessage("Your Password is "+emp.getPassword());
			boolean result= service.sendEmail(request.getSubject(),request.getMessage(),request.getTo());
			System.out.println("Result"+result);
			if(result) {
				resp= ResponseEntity.ok("Email Send Successfully...");
			}else {
				resp= ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email Not send");
			}
			System.out.println("Employee Data"+request);
			
		}else {
			resp= ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Email Id");
			
		}
//		boolean result= service.sendEmail(request.getSubject(),request.getMessage(),request.getTo());
//		System.out.println("Result"+result);
//		if(result) {
//			resp= ResponseEntity.ok("Email Send Successfully...");
//		}else {
//			resp= ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email Not send");
//		}
		return resp;
	}

}

