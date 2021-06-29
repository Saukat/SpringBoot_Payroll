package net.connectix.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Payment {
    @Id
	private String paymentId;
	private String id;
	private String aadhar;
	private String esiNo;
	private String accNo;
	private String bankName;
	private String ifscCode;
	private String epfo;
	private String branch;
	private String address;
	public Payment() {
		super();
	}
	public Payment(String paymentId, String id, String aadhar, String esiNo, String accNo, String bankName,
			String ifscCode, String epfo, String branch, String address) {
		super();
		this.paymentId = paymentId;
		this.id = id;
		this.aadhar = aadhar;
		this.esiNo = esiNo;
		this.accNo = accNo;
		this.bankName = bankName;
		this.ifscCode = ifscCode;
		this.epfo = epfo;
		this.branch = branch;
		this.address = address;
	}
	public Payment(String paymentId) {
		super();
		this.paymentId = paymentId;
	}
	public Payment(String id, String aadhar, String esiNo, String accNo, String bankName, String ifscCode, String epfo,
			String branch, String address) {
		super();
		this.id = id;
		this.aadhar = aadhar;
		this.esiNo = esiNo;
		this.accNo = accNo;
		this.bankName = bankName;
		this.ifscCode = ifscCode;
		this.epfo = epfo;
		this.branch = branch;
		this.address = address;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getEsiNo() {
		return esiNo;
	}
	public void setEsiNo(String esiNo) {
		this.esiNo = esiNo;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getEpfo() {
		return epfo;
	}
	public void setEpfo(String epfo) {
		this.epfo = epfo;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", id=" + id + ", aadhar=" + aadhar + ", esiNo=" + esiNo + ", accNo="
				+ accNo + ", bankName=" + bankName + ", ifscCode=" + ifscCode + ", epfo=" + epfo + ", branch=" + branch
				+ ", address=" + address + "]";
	}
	
}
