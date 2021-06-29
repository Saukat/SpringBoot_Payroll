package net.connectix.dto;

public class Data {
	
	private String id;
	private String email;
	private String password;
	private String name;
	public Data() {
		super();
	}
	public Data(String id, String email, String password, String name) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
	}
	
	
	public Data(String id) {
		super();
		this.id = id;
	}
	public Data(String email, String password, String name) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Data [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + "]";
	}
	
	
}
