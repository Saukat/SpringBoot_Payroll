package net.connectix.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.connectix.document.Payment;
import net.connectix.repo.PaymentRepository;
import net.connectix.service.IPaymentService;

@Service
public class PaymentServiceImplemention implements IPaymentService{
	@Autowired
	private PaymentRepository repo;
 
	@Override
	public String savePayment(Payment payment) {
		
		return repo.save(payment).getId();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Payment> getAllPayment() {
		
		return repo.findAll();
	}
	@Override
	@Transactional(readOnly = true)
	public Optional<Payment> getOnePayment(String id) {
		
		return repo.findById(id);
	}
	@Override
	@Transactional(readOnly = true)
	public boolean isPresent(String id) {
	
		return repo.existsById(id);
	}
	@Override
	public void updateEmployee(Payment payment) {
		 repo.save(payment);
		
	}
}
