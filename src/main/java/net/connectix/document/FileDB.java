package net.connectix.document;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class FileDB {

	 private String id;

	  private String name;

	  private String type;

	  
	  private byte[] data;
	  

	  public FileDB() {
	  }

	  public FileDB(String name, String type, byte[] data) {
	    this.name = name;
	    this.type = type;
	    this.data = data;
	  }

	  public FileDB(String name) {
		super();
		this.name = name;
	}

	public String getId() {
	    return id;
	  }

	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public String getType() {
	    return type;
	  }

	  public void setType(String type) {
	    this.type = type;
	  }

	  public byte[] getData() {
	    return data;
	  }

	  public void setData(byte[] data) {
	    this.data = data;
	  }

}
