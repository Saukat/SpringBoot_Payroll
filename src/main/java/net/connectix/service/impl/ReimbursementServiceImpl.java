package net.connectix.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.connectix.document.Reimbursement;
import net.connectix.repo.ReimbursementRepo;
import net.connectix.service.IReimbursementService;

@Service
public class ReimbursementServiceImpl implements IReimbursementService {

	@Autowired
	private ReimbursementRepo repo;

	public String saveReimbursement(Reimbursement reimbursement) {
		return repo.save(reimbursement).getId();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Reimbursement> getAllReimbursement() {
		return repo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Reimbursement> getOneReimbursement(String id) {
		return repo.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isPresent(String id) {
		// TODO Auto-generated method stub
		return repo.existsById(id);
	}

	@Override
	public void updateReimbursement(Reimbursement reimbursement) {
		repo.save(reimbursement);

	}

}
