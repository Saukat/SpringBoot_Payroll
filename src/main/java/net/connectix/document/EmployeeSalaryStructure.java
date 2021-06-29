package net.connectix.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.bol.secure.Encrypted;

@Document
public class EmployeeSalaryStructure {
	 
	 @Id
	  private String saId;
      private String id;
      @Field
      @Encrypted
	  private String basic;
      @Field
      @Encrypted
	  private String hra;
      @Field
      @Encrypted
	  private String conveyanceAllowance;
      @Field
      @Encrypted
	  private Double otherAllowance;
      @Field
      @Encrypted
	  private String grossPay;
      @Field
      @Encrypted
	  private String employeeEpf;
      @Field
      @Encrypted
	  private String employeeESI;
      @Field
      @Encrypted
	  private String netSalary;
      @Field
      @Encrypted
	  private String employerESI;
      @Field
      @Encrypted
	  private String employerEpf;
      @Field
      @Encrypted
	  private String totalCostToCompany;
	public EmployeeSalaryStructure() {
		super();
	}
	public EmployeeSalaryStructure(String saId, String id, String basic, String hra, String conveyanceAllowance,
			Double otherAllowance, String grossPay, String employeeEpf, String employeeESI, String netSalary,
			String employerESI, String employerEpf, String totalCostToCompany) {
		super();
		this.saId = saId;
		this.id = id;
		this.basic = basic;
		this.hra = hra;
		this.conveyanceAllowance = conveyanceAllowance;
		this.otherAllowance = otherAllowance;
		this.grossPay = grossPay;
		this.employeeEpf = employeeEpf;
		this.employeeESI = employeeESI;
		this.netSalary = netSalary;
		this.employerESI = employerESI;
		this.employerEpf = employerEpf;
		this.totalCostToCompany = totalCostToCompany;
	}
	public EmployeeSalaryStructure(String saId) {
		super();
		this.saId = saId;
	}
	public EmployeeSalaryStructure(String id, String basic, String hra, String conveyanceAllowance,
			Double otherAllowance, String grossPay, String employeeEpf, String employeeESI, String netSalary,
			String employerESI, String employerEpf, String totalCostToCompany) {
		super();
		this.id = id;
		this.basic = basic;
		this.hra = hra;
		this.conveyanceAllowance = conveyanceAllowance;
		this.otherAllowance = otherAllowance;
		this.grossPay = grossPay;
		this.employeeEpf = employeeEpf;
		this.employeeESI = employeeESI;
		this.netSalary = netSalary;
		this.employerESI = employerESI;
		this.employerEpf = employerEpf;
		this.totalCostToCompany = totalCostToCompany;
	}
	public String getSaId() {
		return saId;
	}
	public void setSaId(String saId) {
		this.saId = saId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBasic() {
		return basic;
	}
	public void setBasic(String basic) {
		this.basic = basic;
	}
	public String getHra() {
		return hra;
	}
	public void setHra(String hra) {
		this.hra = hra;
	}
	public String getConveyanceAllowance() {
		return conveyanceAllowance;
	}
	public void setConveyanceAllowance(String conveyanceAllowance) {
		this.conveyanceAllowance = conveyanceAllowance;
	}
	public Double getOtherAllowance() {
		return otherAllowance;
	}
	public void setOtherAllowance(Double otherAllowance) {
		this.otherAllowance = otherAllowance;
	}
	public String getGrossPay() {
		return grossPay;
	}
	public void setGrossPay(String grossPay) {
		this.grossPay = grossPay;
	}
	public String getEmployeeEpf() {
		return employeeEpf;
	}
	public void setEmployeeEpf(String employeeEpf) {
		this.employeeEpf = employeeEpf;
	}
	public String getEmployeeESI() {
		return employeeESI;
	}
	public void setEmployeeESI(String employeeESI) {
		this.employeeESI = employeeESI;
	}
	public String getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(String netSalary) {
		this.netSalary = netSalary;
	}
	public String getEmployerESI() {
		return employerESI;
	}
	public void setEmployerESI(String employerESI) {
		this.employerESI = employerESI;
	}
	public String getEmployerEpf() {
		return employerEpf;
	}
	public void setEmployerEpf(String employerEpf) {
		this.employerEpf = employerEpf;
	}
	public String getTotalCostToCompany() {
		return totalCostToCompany;
	}
	public void setTotalCostToCompany(String totalCostToCompany) {
		this.totalCostToCompany = totalCostToCompany;
	}
	@Override
	public String toString() {
		return "EmployeeSalaryStructure [saId=" + saId + ", id=" + id + ", basic=" + basic + ", hra=" + hra
				+ ", conveyanceAllowance=" + conveyanceAllowance + ", otherAllowance=" + otherAllowance + ", grossPay="
				+ grossPay + ", employeeEpf=" + employeeEpf + ", employeeESI=" + employeeESI + ", netSalary="
				+ netSalary + ", employerESI=" + employerESI + ", employerEpf=" + employerEpf + ", totalCostToCompany="
				+ totalCostToCompany + "]";
	}
	
	
}
