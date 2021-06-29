package net.connectix.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.fasterxml.jackson.core.JsonProcessingException;

import net.connectix.document.Admin;
import net.connectix.document.Employee;
import net.connectix.dto.AdminDTO;
import net.connectix.dto.Data;

import net.connectix.service.IAdminService;

@CrossOrigin(origins = "*")	
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminRestController {
	@Autowired
	private IAdminService service;
	
	

	
//	@PostMapping("/authForAdminLogin")
	

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> resp = null;
		List<Admin> list = service.getAllAdmin();
		if (list == null || list.isEmpty()) {
			String message = "No data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<List<Admin>>(list, HttpStatus.OK);
		}
		return resp;
	}
	
	
	//get single records
		@GetMapping("/one/{id}")
		   public ResponseEntity<?> oneRecordsByid(@PathVariable String id){
			System.out.println("ID"+id);
			   ResponseEntity<Optional<Admin>> resp=null;
			   //Check for Exist
			   boolean present=service.isPresent(id);
			   if(present) {
				   //if Exist
				 Optional<Admin> one=service.getOneAdmin(id);
				 resp = new ResponseEntity<Optional<Admin>>(one, HttpStatus.OK);
				   
			   }else {
				   //not exist
				   resp=new ResponseEntity<Optional<Admin>>(HttpStatus.BAD_REQUEST);
			   }
			   return resp;
		}
	
	
	//Update Data
	   @PutMapping("/restPassword")
	   public ResponseEntity<String> update(@RequestBody Admin admin){
		   System.out.println("edit"+admin);
		   ResponseEntity<String> resp=null;
		   //check for id
		   boolean present=service.isPresent(admin.getId());
		   if(present) {
			   service.ResetPassword(admin);
			   resp=new ResponseEntity<String>("Rest Successfuly",HttpStatus.OK);
			   
		   }else {
			   resp=new ResponseEntity<String>("Records"+admin.getId()+"Not Found",HttpStatus.BAD_REQUEST);
		   }
		   return resp;
	   }
	

	@SuppressWarnings("unlikely-arg-type")
	@PostMapping("/login")
	public HashMap<String, Object> save(@RequestBody Admin admin) throws JsonProcessingException {

		
		 System.out.println("Saukat");
		// Admin adm=service.saveAdmin(admin);
		String id = null;
		String email = null;
		String password = null;
		List<Admin> all = service.getAllAdmin();

		for (Admin a : all) {
			id = a.getId();
			email = a.getEmail();
			password = a.getPassword();

		}



		AdminDTO adminDto = new AdminDTO();
 
		Data data=new Data();
		data.setId(id);
		data.setEmail(email);
		data.setPassword(password);
		
		
		HashMap<String, Object> map = new HashMap<>();

		if (admin.getEmail().trim().equals(email) && admin.getPassword().trim().equals(password)) {
			
			adminDto.setStatus("OK");
			adminDto.setMessage(new ResponseEntity<String>("Admin " + admin.getEmail() + " Login Succesfully", HttpStatus.OK));
			adminDto.setData(data);

			map.put("status", adminDto.getStatus());
			map.put("message", adminDto.getMessage());
			map.put("data", adminDto.getData());
	
			
		} else if (!admin.getEmail().trim().equals(email) && !admin.getPassword().trim().equals(password)) {
			Data data1=new Data();
			data1.setId("");
			data1.setEmail("");
			data1.setPassword("");
			adminDto.setStatus("Failed");
			adminDto.setData(data1);
			adminDto.setMessage(new ResponseEntity<String>("Both Email And password Wrong", HttpStatus.BAD_REQUEST));
			
			map.put("message",adminDto.getMessage());
			map.put("status", adminDto.getStatus());
			map.put("data", adminDto.getData());
		} else if (!admin.getEmail().trim().equals(email) || admin.getPassword().trim().equals(password)) {
			
			Data data1=new Data();
			data1.setId("");
			data1.setEmail("");
			data1.setPassword("");
			adminDto.setStatus("Failed");
			adminDto.setData(data1);
			adminDto.setMessage(new ResponseEntity<String>("Email Wrong Credentials", HttpStatus.BAD_REQUEST));
			
			
			  map.put("message",adminDto.getMessage());
			  map.put("status", adminDto.getStatus());
			  map.put("data", adminDto.getData());
		} else if (admin.getEmail().trim().equals(email) || !admin.getPassword().trim().equals(password)) {
			Data data1=new Data();
			data1.setId("");
			data1.setEmail("");
			data1.setPassword("");
			adminDto.setStatus("Failed");
			adminDto.setData(null);
			adminDto.setMessage(new ResponseEntity<String>("Password Wrong Credentials", HttpStatus.BAD_REQUEST));
			  
			  map.put("message",adminDto.getMessage());
			  map.put("status", adminDto.getStatus());
			  map.put("data", adminDto.getData());

		}
		return map;
	}
	
	
	@PostMapping("/save")
	public String saveLoginId(@RequestBody Admin admin) {
		System.out.println("saukat");
		   service.saveAdmin(admin);
		return "Save";
	}
	
//	if(adminRepo.existsByEmail(admin.getEmail())) {
//		return ResponseEntity.badRequest().body("User Already Exit");
//	}
//	   admin.setRole(Arrays.asList("ROLE_ADMIN"));
//	   service.saveAdmin(admin);
//	return ResponseEntity.ok("Admin Saved Succesfully");
//	
  


}
