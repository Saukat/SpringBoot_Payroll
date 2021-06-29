package net.connectix.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.bol.secure.Encrypted;

@Document(collection = "EmpPersonalInfo")
public class Employee {

	@Id
	private String id;
	private String employeeId;
	private String title;
	private String name;
	@Field
	@Encrypted
	private String password;
	private String email;
	private String hireDate;
	private String jobTitle;
	private String location;
	private String department;
	private String rollType;
	private String gender;
	private String photo;
	private String reportHighAuth;
	private String repostHighAuthId;

	private String createdBy;
	private String createdDate;
	private String updatedBy;
	private String updatedDate;
	private String status;
	private String description;
	private String trash;
//    private Payroll payroll;
	
	private EmployeeSalaryStructure empSalStructure;

	public Employee() {
		super();
	}

	public Employee(String id, String employeeId, String title, String name, String password, String email,
			String hireDate, String jobTitle, String location, String department, String rollType, String gender,
			String photo, String reportHighAuth, String repostHighAuthId, String createdBy, String createdDate,
			String updatedBy, String updatedDate, String status, String description, String trash,
			EmployeeSalaryStructure empSalStructure) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.title = title;
		this.name = name;
		this.password = password;
		this.email = email;
		this.hireDate = hireDate;
		this.jobTitle = jobTitle;
		this.location = location;
		this.department = department;
		this.rollType = rollType;
		this.gender = gender;
		this.photo = photo;
		this.reportHighAuth = reportHighAuth;
		this.repostHighAuthId = repostHighAuthId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.status = status;
		this.description = description;
		this.trash = trash;
		this.empSalStructure = empSalStructure;
	}

	public Employee(String id) {
		super();
		this.id = id;
	}

	public Employee(String employeeId, String title, String name, String password, String email, String hireDate,
			String jobTitle, String location, String department, String rollType, String gender, String photo,
			String reportHighAuth, String repostHighAuthId, String createdBy, String createdDate, String updatedBy,
			String updatedDate, String status, String description, String trash,
			EmployeeSalaryStructure empSalStructure) {
		super();
		this.employeeId = employeeId;
		this.title = title;
		this.name = name;
		this.password = password;
		this.email = email;
		this.hireDate = hireDate;
		this.jobTitle = jobTitle;
		this.location = location;
		this.department = department;
		this.rollType = rollType;
		this.gender = gender;
		this.photo = photo;
		this.reportHighAuth = reportHighAuth;
		this.repostHighAuthId = repostHighAuthId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.status = status;
		this.description = description;
		this.trash = trash;
		this.empSalStructure = empSalStructure;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRollType() {
		return rollType;
	}

	public void setRollType(String rollType) {
		this.rollType = rollType;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getReportHighAuth() {
		return reportHighAuth;
	}

	public void setReportHighAuth(String reportHighAuth) {
		this.reportHighAuth = reportHighAuth;
	}

	public String getRepostHighAuthId() {
		return repostHighAuthId;
	}

	public void setRepostHighAuthId(String repostHighAuthId) {
		this.repostHighAuthId = repostHighAuthId;
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

	public String getTrash() {
		return trash;
	}

	public void setTrash(String trash) {
		this.trash = trash;
	}

	public EmployeeSalaryStructure getEmpSalStructure() {
		return empSalStructure;
	}

	public void setEmpSalStructure(EmployeeSalaryStructure empSalStructure) {
		this.empSalStructure = empSalStructure;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeId=" + employeeId + ", title=" + title + ", name=" + name
				+ ", password=" + password + ", email=" + email + ", hireDate=" + hireDate + ", jobTitle=" + jobTitle
				+ ", location=" + location + ", department=" + department + ", rollType=" + rollType + ", gender="
				+ gender + ", photo=" + photo + ", reportHighAuth=" + reportHighAuth + ", repostHighAuthId="
				+ repostHighAuthId + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + ", status=" + status + ", description=" + description
				+ ", trash=" + trash + ", empSalStructure=" + empSalStructure + "]";
	}

}
