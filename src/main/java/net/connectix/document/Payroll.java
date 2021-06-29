package net.connectix.document;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.bol.secure.Encrypted;

@Document
public class Payroll {
    @Id
	private String payrollId;
	private String id;
	private String name;
	@Field
	@Encrypted
	private String totalCostToCompany;
	@Field
	@Encrypted
	private String grossPay;
	@Field
	@Encrypted	
	private String netSalary;
	private String salaryMonth;
	private int monthMaxDays;
	@Field
	@Encrypted
	private String addition;
	@Field
	@Encrypted
	private String deduction;
	@Field
	@Encrypted
	private String reimbursements;
	
	private String addtionRemark;
	private String deductionRemark;
	
	private String paidHoliday;
	private String unPaidHoliday;

	private String remark;
	private String status;
	
	private String createdBy;
	private String createdDate;
	private String updatedBy;
	private String updatedDate;
	private String description;
	private String trash;
	public Payroll() {
		super();
	}
	public Payroll(String payrollId, String id, String name, String totalCostToCompany, String grossPay,
			String netSalary, String salaryMonth, int monthMaxDays, String addition, String deduction,
			String reimbursements, String addtionRemark, String deductionRemark, String paidHoliday,
			String unPaidHoliday, String remark, String status, String createdBy, String createdDate, String updatedBy,
			String updatedDate, String description, String trash) {
		super();
		this.payrollId = payrollId;
		this.id = id;
		this.name = name;
		this.totalCostToCompany = totalCostToCompany;
		this.grossPay = grossPay;
		this.netSalary = netSalary;
		this.salaryMonth = salaryMonth;
		this.monthMaxDays = monthMaxDays;
		this.addition = addition;
		this.deduction = deduction;
		this.reimbursements = reimbursements;
		this.addtionRemark = addtionRemark;
		this.deductionRemark = deductionRemark;
		this.paidHoliday = paidHoliday;
		this.unPaidHoliday = unPaidHoliday;
		this.remark = remark;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.description = description;
		this.trash = trash;
	}
	public Payroll(String payrollId) {
		super();
		this.payrollId = payrollId;
	}
	public Payroll(String id, String name, String totalCostToCompany, String grossPay, String netSalary,
			String salaryMonth, int monthMaxDays, String addition, String deduction, String reimbursements,
			String addtionRemark, String deductionRemark, String paidHoliday, String unPaidHoliday, String remark,
			String status, String createdBy, String createdDate, String updatedBy, String updatedDate,
			String description, String trash) {
		super();
		this.id = id;
		this.name = name;
		this.totalCostToCompany = totalCostToCompany;
		this.grossPay = grossPay;
		this.netSalary = netSalary;
		this.salaryMonth = salaryMonth;
		this.monthMaxDays = monthMaxDays;
		this.addition = addition;
		this.deduction = deduction;
		this.reimbursements = reimbursements;
		this.addtionRemark = addtionRemark;
		this.deductionRemark = deductionRemark;
		this.paidHoliday = paidHoliday;
		this.unPaidHoliday = unPaidHoliday;
		this.remark = remark;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.description = description;
		this.trash = trash;
	}
	public String getPayrollId() {
		return payrollId;
	}
	public void setPayrollId(String payrollId) {
		this.payrollId = payrollId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTotalCostToCompany() {
		return totalCostToCompany;
	}
	public void setTotalCostToCompany(String totalCostToCompany) {
		this.totalCostToCompany = totalCostToCompany;
	}
	public String getGrossPay() {
		return grossPay;
	}
	public void setGrossPay(String grossPay) {
		this.grossPay = grossPay;
	}
	public String getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(String netSalary) {
		this.netSalary = netSalary;
	}
	public String getSalaryMonth() {
		return salaryMonth;
	}
	public void setSalaryMonth(String salaryMonth) {
		this.salaryMonth = salaryMonth;
	}
	public int getMonthMaxDays() {
		return monthMaxDays;
	}
	public void setMonthMaxDays(int monthMaxDays) {
		this.monthMaxDays = monthMaxDays;
	}
	public String getAddition() {
		return addition;
	}
	public void setAddition(String addition) {
		this.addition = addition;
	}
	public String getDeduction() {
		return deduction;
	}
	public void setDeduction(String deduction) {
		this.deduction = deduction;
	}
	public String getReimbursements() {
		return reimbursements;
	}
	public void setReimbursements(String reimbursements) {
		this.reimbursements = reimbursements;
	}
	public String getAddtionRemark() {
		return addtionRemark;
	}
	public void setAddtionRemark(String addtionRemark) {
		this.addtionRemark = addtionRemark;
	}
	public String getDeductionRemark() {
		return deductionRemark;
	}
	public void setDeductionRemark(String deductionRemark) {
		this.deductionRemark = deductionRemark;
	}
	public String getPaidHoliday() {
		return paidHoliday;
	}
	public void setPaidHoliday(String paidHoliday) {
		this.paidHoliday = paidHoliday;
	}
	public String getUnPaidHoliday() {
		return unPaidHoliday;
	}
	public void setUnPaidHoliday(String unPaidHoliday) {
		this.unPaidHoliday = unPaidHoliday;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	@Override
	public String toString() {
		return "Payroll [payrollId=" + payrollId + ", id=" + id + ", name=" + name + ", totalCostToCompany="
				+ totalCostToCompany + ", grossPay=" + grossPay + ", netSalary=" + netSalary + ", salaryMonth="
				+ salaryMonth + ", monthMaxDays=" + monthMaxDays + ", addition=" + addition + ", deduction=" + deduction
				+ ", reimbursements=" + reimbursements + ", addtionRemark=" + addtionRemark + ", deductionRemark="
				+ deductionRemark + ", paidHoliday=" + paidHoliday + ", unPaidHoliday=" + unPaidHoliday + ", remark="
				+ remark + ", status=" + status + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", description=" + description
				+ ", trash=" + trash + "]";
	}
	
}
