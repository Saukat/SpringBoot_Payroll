package net.connectix.service;

import java.util.List;
import java.util.Optional;

import net.connectix.document.Reimbursement;

public interface IReimbursementService {

	public String saveReimbursement(Reimbursement reimbursement);

	public List<Reimbursement> getAllReimbursement();

	public Optional<Reimbursement> getOneReimbursement(String id);

	public boolean isPresent(String id);

	public void updateReimbursement(Reimbursement reimbursement);

//	public String insertCurrentPayroll(Reimbursement reimbursement);
}
