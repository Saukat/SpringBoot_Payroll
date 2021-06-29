package net.connectix.rest.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import net.connectix.document.Employee;
import net.connectix.document.EmployeeLogin;
import net.connectix.document.Payroll;
import net.connectix.dto.Data;
import net.connectix.dto.EmployeeLoginDTO;
import net.connectix.repo.PayrollRepository;
import net.connectix.service.IEmployeeService;

@CrossOrigin(origins = "*")	
@RestController
@RequestMapping("/employeeLogin")
public class EmployeeLoginRestController {
   
	@Autowired
	private IEmployeeService service;
	 
	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
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
	
	
	@PostMapping("/login")
	public HashMap<String, Object> save(@RequestBody EmployeeLogin employeeLogin) throws JsonProcessingException {
		
		System.out.println("Data of user"+employeeLogin);
		
		List<Employee> all = service.getAllEmployee();
		
//		System.out.println("Data of all"+all);
		
		
		String id = null;
		String email = null;
		String password = null;
		String name=null;

		String id1 = null;
		String email1 = null;
		String password1 = null;
		String name1 = null;
		
		EmployeeLoginDTO emplDto=new EmployeeLoginDTO();
		Data data=new Data();
		data.setId(id);
		data.setEmail(email);
		data.setPassword(password);

		HashMap<String, Object> map = new HashMap<>();
		String validuser = "NOTOK";
		String invalidvaliduser;
		for (Employee a : all) {
			id = a.getId();
			email = a.getEmail();
			password = a.getPassword();
			name=a.getName();
//			if (employeeLogin.getEmail().equals(email)){
//				System.out.println("done");
//			}
			
			if (employeeLogin.getEmail().equals(email) && employeeLogin.getPassword().equals(password)) {
				 validuser ="OK";
				 id1 = id;
				 email1 = email;
				 password1 = password;
			     name1=name;
				
			}
			
			else {
				
			}
			

			
		}
		
		if(validuser.equals("OK")) {
			Data data1=new Data();
			data1.setId(id1);
			data1.setEmail(email1);
			data1.setPassword(password1);
			data1.setName(name1);
			emplDto.setStatus("OK");
			emplDto.setMessage(new ResponseEntity<String>("User " + password1 + " Login Succesfully", HttpStatus.OK));
			emplDto.setData(data1);
			map.put("status", emplDto.getStatus());
			map.put("message", emplDto.getMessage());
			map.put("data", emplDto.getData());	
			
		}else {
			Data data1=new Data();
			data1.setId("");
			data1.setEmail("");
			data1.setPassword("");
			emplDto.setStatus("Failed");
			emplDto.setData(data1);
			emplDto.setMessage(new ResponseEntity<String>("Invalid credentials", HttpStatus.BAD_REQUEST));
			
			map.put("message",emplDto.getMessage());
			map.put("status", emplDto.getStatus());
			map.put("data", emplDto.getData());
			
		}
		return map;
	}
	
	@Autowired
	private PayrollRepository repo;
	
	@GetMapping("/remark/{remark}")
	public List<Payroll> getPayrollByRemark(@PathVariable String remark) {
 	  System.out.println("remark"+remark);
		  
		  List<Payroll> emp=repo.findPayrollByRemark(remark);
		  System.out.println("employee remark"+emp);
		return emp;
	}

}
