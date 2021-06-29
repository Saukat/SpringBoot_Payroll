package net.connectix.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import net.connectix.document.Payment;
import net.connectix.document.Payroll;



@Repository
public interface PaymentRepository extends MongoRepository<Payment, String>{
    
	
}
