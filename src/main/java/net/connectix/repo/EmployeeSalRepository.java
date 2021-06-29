package net.connectix.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.connectix.document.EmployeeSalaryStructure;


@Repository
public interface EmployeeSalRepository extends MongoRepository<EmployeeSalaryStructure, String>{

}
