package net.connectix.rest.controller;

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

import net.connectix.document.Payment;
import net.connectix.service.IPaymentService;


@CrossOrigin(origins = "*")	
@RestController
@RequestMapping("/payment")
public class PaymentRestController {
     @Autowired
	 private IPaymentService service;
     
     @PostMapping("/save")
     public String savePayment(@RequestBody Payment payment) {
    	 ResponseEntity<String> resp=null;
 	  	String id=service.savePayment(payment);
 	
 		
 		
 		try {
 			  resp=new ResponseEntity<String>("Payment " + payment.getId() + " save Succesfully", HttpStatus.OK);
 		} catch (Exception e) {
 			resp=new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
 			e.printStackTrace();
 		}
 		return "Employee"+resp;
     }
     
     

 	@GetMapping("/all")
 	public ResponseEntity<?> getAllpayment() {
 		ResponseEntity<?> resp = null;
 		List<Payment> list = service.getAllPayment();
 		if (list == null || list.isEmpty()) {
 			String message = "No data Found";
 			resp = new ResponseEntity<String>(message, HttpStatus.OK);
 		} else {
 			resp = new ResponseEntity<List<Payment>>(list, HttpStatus.OK);
 		}
 		return resp;
 	}
 	
 	@GetMapping("one/{id}")
	public ResponseEntity<?> getOnePayment(@PathVariable String id){
		
		 System.out.println("ID"+id);
		   ResponseEntity<Optional<Payment>> resp=null;
		   //Check for Exist
		   boolean present=service.isPresent(id);
		   if(present) {
			   //if Exist
	                	Optional<Payment> one=service.getOnePayment(id);
			            resp = new ResponseEntity<Optional<Payment>>(one, HttpStatus.OK);
			   
		   }else {
			   //not exist
			   resp=new ResponseEntity<Optional<Payment>>(HttpStatus.BAD_REQUEST);
		   }
		   return resp;
	}
 	
 	//Update Data
	   @PutMapping("/update")
	   public ResponseEntity<String> update(@RequestBody Payment payment){
		   ResponseEntity<String> resp=null;
		   //check for id
		   boolean present=service.isPresent(payment.getPaymentId());
		   if(present) {
			   service.updateEmployee(payment);
			   resp=new ResponseEntity<String>("Updated Successfuly",HttpStatus.OK);
			   
		   }else {
			   resp=new ResponseEntity<String>("Records"+payment.getId()+"Not Found",HttpStatus.BAD_REQUEST);
		   }
		   return resp;
	   }
	 
}
