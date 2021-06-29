package net.connectix.document;

import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Reimbursement {
	private String id;
	private String empId;
	private String empName;
	private String title;
	private String subject;
	private String billDate;
	private Integer amount;
	private String attachmentOfBill;
	private String higherAuth;
	private String highAuthName;
	private String status;
	private String higherAuthremark;
	private String[] fileName;
	private String supHigherAuth;
	private String[] filePath;
	
	private String reportStatus;
	private String paymentStatus;

	private String createdBy;
	private String createdDate;
	private String updatedBy;
	private String updatedDate;

	public Reimbursement() {
		super();
	}

	public Reimbursement(String id, String empId, String empName, String title, String subject, String billDate,
			Integer amount, String attachmentOfBill, String higherAuth, String highAuthName, String status,
			String higherAuthremark, String[] fileName, String supHigherAuth, String[] filePath, String reportStatus,
			String paymentStatus, String createdBy, String createdDate, String updatedBy, String updatedDate) {
		super();
		this.id = id;
		this.empId = empId;
		this.empName = empName;
		this.title = title;
		this.subject = subject;
		this.billDate = billDate;
		this.amount = amount;
		this.attachmentOfBill = attachmentOfBill;
		this.higherAuth = higherAuth;
		this.highAuthName = highAuthName;
		this.status = status;
		this.higherAuthremark = higherAuthremark;
		this.fileName = fileName;
		this.supHigherAuth = supHigherAuth;
		this.filePath = filePath;
		this.reportStatus = reportStatus;
		this.paymentStatus = paymentStatus;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public Reimbursement(String id) {
		super();
		this.id = id;
	}

	public Reimbursement(String empId, String empName, String title, String subject, String billDate, Integer amount,
			String attachmentOfBill, String higherAuth, String highAuthName, String status, String higherAuthremark,
			String[] fileName, String supHigherAuth, String[] filePath, String reportStatus, String paymentStatus,
			String createdBy, String createdDate, String updatedBy, String updatedDate) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.title = title;
		this.subject = subject;
		this.billDate = billDate;
		this.amount = amount;
		this.attachmentOfBill = attachmentOfBill;
		this.higherAuth = higherAuth;
		this.highAuthName = highAuthName;
		this.status = status;
		this.higherAuthremark = higherAuthremark;
		this.fileName = fileName;
		this.supHigherAuth = supHigherAuth;
		this.filePath = filePath;
		this.reportStatus = reportStatus;
		this.paymentStatus = paymentStatus;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getAttachmentOfBill() {
		return attachmentOfBill;
	}

	public void setAttachmentOfBill(String attachmentOfBill) {
		this.attachmentOfBill = attachmentOfBill;
	}

	public String getHigherAuth() {
		return higherAuth;
	}

	public void setHigherAuth(String higherAuth) {
		this.higherAuth = higherAuth;
	}

	public String getHighAuthName() {
		return highAuthName;
	}

	public void setHighAuthName(String highAuthName) {
		this.highAuthName = highAuthName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHigherAuthremark() {
		return higherAuthremark;
	}

	public void setHigherAuthremark(String higherAuthremark) {
		this.higherAuthremark = higherAuthremark;
	}

	public String[] getFileName() {
		return fileName;
	}

	public void setFileName(String[] fileName) {
		this.fileName = fileName;
	}

	public String getSupHigherAuth() {
		return supHigherAuth;
	}

	public void setSupHigherAuth(String supHigherAuth) {
		this.supHigherAuth = supHigherAuth;
	}

	public String[] getFilePath() {
		return filePath;
	}

	public void setFilePath(String[] filePath) {
		this.filePath = filePath;
	}

	public String getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", empId=" + empId + ", empName=" + empName + ", title=" + title
				+ ", subject=" + subject + ", billDate=" + billDate + ", amount=" + amount + ", attachmentOfBill="
				+ attachmentOfBill + ", higherAuth=" + higherAuth + ", highAuthName=" + highAuthName + ", status="
				+ status + ", higherAuthremark=" + higherAuthremark + ", fileName=" + Arrays.toString(fileName)
				+ ", supHigherAuth=" + supHigherAuth + ", filePath=" + Arrays.toString(filePath) + ", reportStatus="
				+ reportStatus + ", paymentStatus=" + paymentStatus + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + "]";
	}

	
	
}
