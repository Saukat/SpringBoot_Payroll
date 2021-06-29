package net.connectix.dto;

import org.springframework.http.ResponseEntity;

import net.connectix.document.EmployeeTask;
import net.connectix.document.Leave;

public class LeaveDTO {
	private ResponseEntity<String> message;
	private String status;
	
	private Leave data;

	
	public LeaveDTO() {
		super();
	}


	public LeaveDTO(ResponseEntity<String> message, String status, Leave data) {
		super();
		this.message = message;
		this.status = status;
		this.data = data;
	}


	public LeaveDTO(ResponseEntity<String> message) {
		super();
		this.message = message;
	}


	public LeaveDTO(String status, Leave data) {
		super();
		this.status = status;
		this.data = data;
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


	public Leave getData() {
		return data;
	}


	public void setData(Leave data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return "LeaveDTO [message=" + message + ", status=" + status + ", data=" + data + "]";
	}
	
	
	
}
