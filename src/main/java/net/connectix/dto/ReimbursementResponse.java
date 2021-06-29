package net.connectix.dto;

public class ReimbursementResponse {
	private String id;
	private String message;

	public ReimbursementResponse() {
		super();
	}

	public ReimbursementResponse(String id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

	public ReimbursementResponse(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ReimbursementResponse [id=" + id + ", message=" + message + "]";
	}

}
