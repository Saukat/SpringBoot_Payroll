package net.connectix.dto;

public class EmployeeLoginData {
	
	private String id;
	private String email;
	private String password;
	public EmployeeLoginData(String id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}
	public EmployeeLoginData() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Data [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
