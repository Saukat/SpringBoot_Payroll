package net.connectix.dto;

import org.springframework.data.mongodb.core.mapping.Field;

import com.bol.secure.Encrypted;

public class EmployeeChangePassword {
	private String id;
	@Field
	@Encrypted
	private String oldPassword;
	@Field
	@Encrypted
	private String newPassword;

	public EmployeeChangePassword() {
		super();
	}

	public EmployeeChangePassword(String id, String oldPassword, String newPassword) {
		super();
		this.id = id;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}

	public EmployeeChangePassword(String id) {
		super();
		this.id = id;
	}

	public EmployeeChangePassword(String oldPassword, String newPassword) {
		super();
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "EmployeeChangePassword [id=" + id + ", oldPassword=" + oldPassword + ", newPassword=" + newPassword
				+ "]";
	}

}
