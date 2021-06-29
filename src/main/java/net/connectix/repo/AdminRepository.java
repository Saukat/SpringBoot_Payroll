package net.connectix.repo;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import net.connectix.document.Admin;
import net.connectix.document.Employee;
@Repository
public interface AdminRepository extends MongoRepository<Admin, String>{
    
//  @Query("{ 'email' : ?0 }")	
	
	
//  public Admin findAdminByEmail(String email);
	
	Admin findAdminById(String id);
	List<Admin> findAdminByEmail(String email);
	
	List<Admin> findAdminEmailById(String id);
}
