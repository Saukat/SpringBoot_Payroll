package net.connectix.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.connectix.document.Admin;
import net.connectix.repo.AdminRepository;
import net.connectix.service.IAdminService;

@Service
public class AdminServiceImplementation implements IAdminService {

	@Autowired
	private AdminRepository repo;

	@Override
	@Transactional(readOnly = true)
	public List<Admin> getAllAdmin() {
		return repo.findAll();
	}

	@Override
	@Transactional
	public Admin saveAdmin(Admin admin) {
		return repo.save(admin);
	}

	@Transactional(readOnly = true)
	public boolean isPresent(String id) {

		return repo.existsById(id);
	}

	@Override
	public void ResetPassword(Admin admin) {
		repo.save(admin);

	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Admin> getOneAdmin(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

}
