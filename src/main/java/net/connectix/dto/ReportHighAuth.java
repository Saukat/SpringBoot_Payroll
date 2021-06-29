package net.connectix.dto;

import java.util.List;

import net.connectix.document.Admin;

public class ReportHighAuth {
     private String id;
     private String name;
     private List<Admin> admin;
	public ReportHighAuth() {
		super();
	}
	public ReportHighAuth(String id, String name, List<Admin> admin) {
		super();
		this.id = id;
		this.name = name;
		this.admin = admin;
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
	public List<Admin> getAdmin() {
		return admin;
	}
	public void setAdmin(List<Admin> admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "ReportHighAuth [id=" + id + ", name=" + name + ", admin=" + admin + "]";
	}
	
	
}
