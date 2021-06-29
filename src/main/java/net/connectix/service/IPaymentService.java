package net.connectix.service;

import java.util.List;
import java.util.Optional;

import net.connectix.document.Payment;

public interface IPaymentService {
    
	public String savePayment(Payment payment);
	
	
	public List<Payment> getAllPayment();
	public Optional<Payment> getOnePayment(String id);
	public boolean isPresent(String id);
	public void updateEmployee(Payment employee);
	

}
