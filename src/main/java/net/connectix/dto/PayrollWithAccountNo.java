package net.connectix.dto;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.bol.secure.Encrypted;

@Document
public class PayrollWithAccountNo {
	
	private String ids;
	
	private String payrollId;
	private String id;
	private String name;
	private String accNo;
	private String ifscCode;
	@Field
	@Encrypted
	private String totalCostToCompany;
	@Field
	@Encrypted
	private String grossPay;
	@Field
	@Encrypted
	private String netSalary;
	@Field
	@Encrypted
	private String salaryMonth;
	@Field
	@Encrypted
	private String addition;
	@Field
	@Encrypted
	private String deduction;
	@Field
	@Encrypted
	private String reimbursements;
	private int monthMaxDays;
	private String addtionRemark;
	private String deductionRemark;
	
	private Integer amount;
	
	private String paidHoliday;
	private String unPaidHoliday;

	private String remark;
	private String status;
	public PayrollWithAccountNo() {
		super();
	}
	public PayrollWithAccountNo(String ids, String payrollId, String id, String name, String accNo, String ifscCode,
			String totalCostToCompany, String grossPay, String netSalary, String salaryMonth, String addition,
			String deduction, String reimbursements, int monthMaxDays, String addtionRemark, String deductionRemark,
			Integer amount, String paidHoliday, String unPaidHoliday, String remark, String status) {
		super();
		this.ids = ids;
		this.payrollId = payrollId;
		this.id = id;
		this.name = name;
		this.accNo = accNo;
		this.ifscCode = ifscCode;
		this.totalCostToCompany = totalCostToCompany;
		this.grossPay = grossPay;
		this.netSalary = netSalary;
		this.salaryMonth = salaryMonth;
		this.addition = addition;
		this.deduction = deduction;
		this.reimbursements = reimbursements;
		this.monthMaxDays = monthMaxDays;
		this.addtionRemark = addtionRemark;
		this.deductionRemark = deductionRemark;
		this.amount = amount;
		this.paidHoliday = paidHoliday;
		this.unPaidHoliday = unPaidHoliday;
		this.remark = remark;
		this.status = status;
	}
	public PayrollWithAccountNo(String ids) {
		super();
		this.ids = ids;
	}
	public PayrollWithAccountNo(String payrollId, String id, String name, String accNo, String ifscCode,
			String totalCostToCompany, String grossPay, String netSalary, String salaryMonth, String addition,
			String deduction, String reimbursements, int monthMaxDays, String addtionRemark, String deductionRemark,
			Integer amount, String paidHoliday, String unPaidHoliday, String remark, String status) {
		super();
		this.payrollId = payrollId;
		this.id = id;
		this.name = name;
		this.accNo = accNo;
		this.ifscCode = ifscCode;
		this.totalCostToCompany = totalCostToCompany;
		this.grossPay = grossPay;
		this.netSalary = netSalary;
		this.salaryMonth = salaryMonth;
		this.addition = addition;
		this.deduction = deduction;
		this.reimbursements = reimbursements;
		this.monthMaxDays = monthMaxDays;
		this.addtionRemark = addtionRemark;
		this.deductionRemark = deductionRemark;
		this.amount = amount;
		this.paidHoliday = paidHoliday;
		this.unPaidHoliday = unPaidHoliday;
		this.remark = remark;
		this.status = status;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
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
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
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
	public int getMonthMaxDays() {
		return monthMaxDays;
	}
	public void setMonthMaxDays(int monthMaxDays) {
		this.monthMaxDays = monthMaxDays;
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
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
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
	@Override
	public String toString() {
		return "PayrollWithAccountNo [ids=" + ids + ", payrollId=" + payrollId + ", id=" + id + ", name=" + name
				+ ", accNo=" + accNo + ", ifscCode=" + ifscCode + ", totalCostToCompany=" + totalCostToCompany
				+ ", grossPay=" + grossPay + ", netSalary=" + netSalary + ", salaryMonth=" + salaryMonth + ", addition="
				+ addition + ", deduction=" + deduction + ", reimbursements=" + reimbursements + ", monthMaxDays="
				+ monthMaxDays + ", addtionRemark=" + addtionRemark + ", deductionRemark=" + deductionRemark
				+ ", amount=" + amount + ", paidHoliday=" + paidHoliday + ", unPaidHoliday=" + unPaidHoliday
				+ ", remark=" + remark + ", status=" + status + "]";
	}
	
}
