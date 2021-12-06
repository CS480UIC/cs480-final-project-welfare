package administrator.domain;

import java.sql.Date;

/**
 * recipient object
 * 
 * @author
 * 
 */
public class Administrator {
	/*
	 * Correspond to the user table
	 */
	
	private String email;
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	/**
	 * @return the iD
	 */
	public Integer getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(Integer iD) {
		ID = iD;
	}
	private String first_name;
	private String last_name; 
	private Integer ID;
	private String title;
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
}