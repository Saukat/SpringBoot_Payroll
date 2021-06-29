package net.connectix.document;

public class Leave {
	private String id;
	private String empId;
	private String attendEmpId;
	private String higAuthId;
	private String hr;
	private String admin;
	private String title;
	private String subject;
	private String from;
	private String to;
	private String numberOfDays;
	private String leaveType;
	
    
	private String backupEmpId;
	private String backupEmpRemark;
	public String getBackupEmpRemark() {
		return backupEmpRemark;
	}

	public void setBackupEmpRemark(String backupEmpRemark) {
		this.backupEmpRemark = backupEmpRemark;
	}

	private String hrRemark;
	private String repAuthRemark;
	private String paidorNonPaid;
	private String status;
	private String description;

	private String createdBy;
	private String createdDate;
	private String updateBy;
	private String updateDate;
	public Leave() {
		super();
	}

	public Leave(String id, String empId, String attendEmpId, String higAuthId, String hr, String admin, String title,
			String subject, String from, String to, String numberOfDays, String leaveType, String backupEmpId,
			String backupEmpRemark, String hrRemark, String repAuthRemark, String paidorNonPaid, String status,
			String description, String createdBy, String createdDate, String updateBy, String updateDate) {
		super();
		this.id = id;
		this.empId = empId;
		this.attendEmpId = attendEmpId;
		this.higAuthId = higAuthId;
		this.hr = hr;
		this.admin = admin;
		this.title = title;
		this.subject = subject;
		this.from = from;
		this.to = to;
		this.numberOfDays = numberOfDays;
		this.leaveType = leaveType;
		this.backupEmpId = backupEmpId;
		this.backupEmpRemark = backupEmpRemark;
		this.hrRemark = hrRemark;
		this.repAuthRemark = repAuthRemark;
		this.paidorNonPaid = paidorNonPaid;
		this.status = status;
		this.description = description;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updateBy = updateBy;
		this.updateDate = updateDate;
	}

	public Leave(String id) {
		super();
		this.id = id;
	}

	public Leave(String empId, String attendEmpId, String higAuthId, String hr, String admin, String title,
			String subject, String from, String to, String numberOfDays, String leaveType, String backupEmpId,
			String backupEmpRemark, String hrRemark, String repAuthRemark, String paidorNonPaid, String status,
			String description, String createdBy, String createdDate, String updateBy, String updateDate) {
		super();
		this.empId = empId;
		this.attendEmpId = attendEmpId;
		this.higAuthId = higAuthId;
		this.hr = hr;
		this.admin = admin;
		this.title = title;
		this.subject = subject;
		this.from = from;
		this.to = to;
		this.numberOfDays = numberOfDays;
		this.leaveType = leaveType;
		this.backupEmpId = backupEmpId;
		this.backupEmpRemark = backupEmpRemark;
		this.hrRemark = hrRemark;
		this.repAuthRemark = repAuthRemark;
		this.paidorNonPaid = paidorNonPaid;
		this.status = status;
		this.description = description;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updateBy = updateBy;
		this.updateDate = updateDate;
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

	public String getAttendEmpId() {
		return attendEmpId;
	}

	public void setAttendEmpId(String attendEmpId) {
		this.attendEmpId = attendEmpId;
	}

	public String getHigAuthId() {
		return higAuthId;
	}

	public void setHigAuthId(String higAuthId) {
		this.higAuthId = higAuthId;
	}

	public String getHr() {
		return hr;
	}

	public void setHr(String hr) {
		this.hr = hr;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
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

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(String numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getBackupEmpId() {
		return backupEmpId;
	}

	public void setBackupEmpId(String backupEmpId) {
		this.backupEmpId = backupEmpId;
	}

	public String getHrRemark() {
		return hrRemark;
	}

	public void setHrRemark(String hrRemark) {
		this.hrRemark = hrRemark;
	}

	public String getRepAuthRemark() {
		return repAuthRemark;
	}

	public void setRepAuthRemark(String repAuthRemark) {
		this.repAuthRemark = repAuthRemark;
	}

	public String getPaidorNonPaid() {
		return paidorNonPaid;
	}

	public void setPaidorNonPaid(String paidorNonPaid) {
		this.paidorNonPaid = paidorNonPaid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Leave [id=" + id + ", empId=" + empId + ", attendEmpId=" + attendEmpId + ", higAuthId=" + higAuthId
				+ ", hr=" + hr + ", admin=" + admin + ", title=" + title + ", subject=" + subject + ", from=" + from
				+ ", to=" + to + ", numberOfDays=" + numberOfDays + ", leaveType=" + leaveType + ", backupEmpId="
				+ backupEmpId + ", backupEmpRemark=" + backupEmpRemark + ", hrRemark=" + hrRemark + ", repAuthRemark="
				+ repAuthRemark + ", paidorNonPaid=" + paidorNonPaid + ", status=" + status + ", description="
				+ description + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updateBy=" + updateBy
				+ ", updateDate=" + updateDate + "]";
	}

	
	
}
