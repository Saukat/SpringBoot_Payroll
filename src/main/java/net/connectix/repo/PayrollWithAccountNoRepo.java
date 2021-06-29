package net.connectix.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.connectix.dto.PayrollWithAccountNo;

public interface PayrollWithAccountNoRepo extends MongoRepository<PayrollWithAccountNo, String>{
	 boolean existsById(String id);
	 
	 PayrollWithAccountNo findPayrollWithAccountNoById(String id);
}
