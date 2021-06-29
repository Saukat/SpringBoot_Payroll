package net.connectix.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.connectix.document.EmployeeTask;
import net.connectix.repo.EmployeeTaskRepository;
import net.connectix.service.IEmployeeTaskService;

@Service
public class EmployeeTaskImplementation implements IEmployeeTaskService {
	@Autowired
	private EmployeeTaskRepository repo;

	@Override
	public String saveEmployeeTask(EmployeeTask employeeTask) {

		return repo.save(employeeTask).getId();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<EmployeeTask> getAllEmployeeTask() {
		return repo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<EmployeeTask> getOneEmployeeTAsk(String id) {
		return repo.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isPresent(String id) {
		// TODO Auto-generated method stub
		return repo.existsById(id);
	}

	@Transactional
	public void updateEmployee(EmployeeTask employeeTask) {
		repo.save(employeeTask);

	}
}
