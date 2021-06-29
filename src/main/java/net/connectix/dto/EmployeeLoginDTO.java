package net.connectix.dto;

import org.springframework.http.ResponseEntity;

public class EmployeeLoginDTO {
	private ResponseEntity<String> message;
	private String status;
	
	private Data data;
	
	public ResponseEntity<String> getMessage() {
		return message;
	}
	public void setMessage(ResponseEntity<String> message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public EmployeeLoginDTO(ResponseEntity<String> message, String status, Data data) {
		super();
		this.message = message;
		this.status = status;
		this.data = data;
	}
	public EmployeeLoginDTO() {
		super();
	}
	@Override
	public String toString() {
		return "AdminDTO [message=" + message + ", status=" + status + ", data=" + data + "]";
	}
	
	
}
