package net.connectix.dto;

import org.springframework.http.ResponseEntity;

import net.connectix.document.EmployeeTask;

public class RestResponseData {
	private ResponseEntity<String> message;
	private String status;
	
	private EmployeeTask data;

	public RestResponseData() {
		super();
	}

	public RestResponseData(ResponseEntity<String> message, String status, EmployeeTask data) {
		super();
		this.message = message;
		this.status = status;
		this.data = data;
	}

	public RestResponseData(String status, EmployeeTask data) {
		super();
		this.status = status;
		this.data = data;
	}

	public RestResponseData(ResponseEntity<String> message) {
		super();
		this.message = message;
	}

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

	public EmployeeTask getData() {
		return data;
	}

	public void setData(EmployeeTask data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "RestResponseData [message=" + message + ", status=" + status + ", data=" + data + "]";
	}
	
	
}
