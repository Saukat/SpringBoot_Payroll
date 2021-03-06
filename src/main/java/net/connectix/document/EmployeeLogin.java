package net.connectix.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import com.bol.secure.Encrypted;

public class EmployeeLogin {
	@Id
	private String id;

	private String email;
	@Field
	@Encrypted
	private String password;

	public EmployeeLogin() {
		super();
	}

	public EmployeeLogin(String id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public EmployeeLogin(String id) {
		super();
		this.id = id;
	}

	public EmployeeLogin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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
		return "EmployeeLogin [id=" + id + ", email=" + email + ", password=" + password + "]";
	}

}
