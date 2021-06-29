package net.connectix.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class EmployeeTask {
     @Id
	 private String id;
	 private String taskId;
	 private String title;
	 private String higherAuthId;
	 private String higherAuthName;
	 private String projectName;
	 private String timeAndDate;
	 private String description;
	 private String employeeId;
	 private String employeeName;
	 private String completeDateAndTime;
	 private String empRemark;
	 private String status;
	 private String supHigherAuth;
	 
	 private String createdBy;//higher auth
	 private String createdDate;
	 private String updatedBy;
	 private String updatedDate;
	 private String authRemark;
	 
	public EmployeeTask() {
		super();
	}

	public EmployeeTask(String id, String taskId, String title, String higherAuthId, String higherAuthName,
			String projectName, String timeAndDate, String description, String employeeId, String employeeName,
			String completeDateAndTime, String empRemark, String status, String supHigherAuth, String createdBy,
			String createdDate, String updatedBy, String updatedDate, String authRemark) {
		super();
		this.id = id;
		this.taskId = taskId;
		this.title = title;
		this.higherAuthId = higherAuthId;
		this.higherAuthName = higherAuthName;
		this.projectName = projectName;
		this.timeAndDate = timeAndDate;
		this.description = description;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.completeDateAndTime = completeDateAndTime;
		this.empRemark = empRemark;
		this.status = status;
		this.supHigherAuth = supHigherAuth;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.authRemark = authRemark;
	}

	public EmployeeTask(String id) {
		super();
		this.id = id;
	}

	public EmployeeTask(String taskId, String title, String higherAuthId, String higherAuthName, String projectName,
			String timeAndDate, String description, String employeeId, String employeeName, String completeDateAndTime,
			String empRemark, String status, String supHigherAuth, String createdBy, String createdDate,
			String updatedBy, String updatedDate, String authRemark) {
		super();
		this.taskId = taskId;
		this.title = title;
		this.higherAuthId = higherAuthId;
		this.higherAuthName = higherAuthName;
		this.projectName = projectName;
		this.timeAndDate = timeAndDate;
		this.description = description;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.completeDateAndTime = completeDateAndTime;
		this.empRemark = empRemark;
		this.status = status;
		this.supHigherAuth = supHigherAuth;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.authRemark = authRemark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHigherAuthId() {
		return higherAuthId;
	}

	public void setHigherAuthId(String higherAuthId) {
		this.higherAuthId = higherAuthId;
	}

	public String getHigherAuthName() {
		return higherAuthName;
	}

	public void setHigherAuthName(String higherAuthName) {
		this.higherAuthName = higherAuthName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTimeAndDate() {
		return timeAndDate;
	}

	public void setTimeAndDate(String timeAndDate) {
		this.timeAndDate = timeAndDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getCompleteDateAndTime() {
		return completeDateAndTime;
	}

	public void setCompleteDateAndTime(String completeDateAndTime) {
		this.completeDateAndTime = completeDateAndTime;
	}

	public String getEmpRemark() {
		return empRemark;
	}

	public void setEmpRemark(String empRemark) {
		this.empRemark = empRemark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSupHigherAuth() {
		return supHigherAuth;
	}

	public void setSupHigherAuth(String supHigherAuth) {
		this.supHigherAuth = supHigherAuth;
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

	public String getAuthRemark() {
		return authRemark;
	}

	public void setAuthRemark(String authRemark) {
		this.authRemark = authRemark;
	}

	@Override
	public String toString() {
		return "EmployeeTask [id=" + id + ", taskId=" + taskId + ", title=" + title + ", higherAuthId=" + higherAuthId
				+ ", higherAuthName=" + higherAuthName + ", projectName=" + projectName + ", timeAndDate=" + timeAndDate
				+ ", description=" + description + ", employeeId=" + employeeId + ", employeeName=" + employeeName
				+ ", completeDateAndTime=" + completeDateAndTime + ", empRemark=" + empRemark + ", status=" + status
				+ ", supHigherAuth=" + supHigherAuth + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", authRemark=" + authRemark + "]";
	}

	
	 
}
