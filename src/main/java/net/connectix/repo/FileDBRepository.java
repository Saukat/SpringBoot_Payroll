package net.connectix.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.connectix.document.EmployeeSalaryStructure;
import net.connectix.document.FileDB;
@Repository
public interface FileDBRepository extends MongoRepository<FileDB, String>{

	

}
