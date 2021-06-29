package net.connectix.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class leaveAttendance {
	@Id
	private String id;
	private String attendEmpId;
	private int totalDayOfMonth;
	private String leaveTaken;
	private String remain;
	private String totalLeave;
	public leaveAttendance() {
		super();
	}
	public leaveAttendance(String id, String attendEmpId, int totalDayOfMonth, String leaveTaken, String remain,
			String totalLeave) {
		super();
		this.id = id;
		this.attendEmpId = attendEmpId;
		this.totalDayOfMonth = totalDayOfMonth;
		this.leaveTaken = leaveTaken;
		this.remain = remain;
		this.totalLeave = totalLeave;
	}
	public leaveAttendance(String id) {
		super();
		this.id = id;
	}
	public leaveAttendance(String attendEmpId, int totalDayOfMonth, String leaveTaken, String remain,
			String totalLeave) {
		super();
		this.attendEmpId = attendEmpId;
		this.totalDayOfMonth = totalDayOfMonth;
		this.leaveTaken = leaveTaken;
		this.remain = remain;
		this.totalLeave = totalLeave;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAttendEmpId() {
		return attendEmpId;
	}
	public void setAttendEmpId(String attendEmpId) {
		this.attendEmpId = attendEmpId;
	}
	public int getTotalDayOfMonth() {
		return totalDayOfMonth;
	}
	public void setTotalDayOfMonth(int totalDayOfMonth) {
		this.totalDayOfMonth = totalDayOfMonth;
	}
	public String getLeaveTaken() {
		return leaveTaken;
	}
	public void setLeaveTaken(String leaveTaken) {
		this.leaveTaken = leaveTaken;
	}
	public String getRemain() {
		return remain;
	}
	public void setRemain(String remain) {
		this.remain = remain;
	}
	public String getTotalLeave() {
		return totalLeave;
	}
	public void setTotalLeave(String totalLeave) {
		this.totalLeave = totalLeave;
	}
	@Override
	public String toString() {
		return "leaveAttendance [id=" + id + ", attendEmpId=" + attendEmpId + ", totalDayOfMonth=" + totalDayOfMonth
				+ ", leaveTaken=" + leaveTaken + ", remain=" + remain + ", totalLeave=" + totalLeave + "]";
	}

	

}
