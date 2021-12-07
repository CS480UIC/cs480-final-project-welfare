package address.domain;

/**
 * User object
 * 
 * @author Harshal Patel
 * 
 */
public class Address {
	/*
	 * Correspond to the user table
	 */
	private Integer recipient_ID;
	private String city;
	private String state; 
	private String street;
	/**
	 * @return the recipient_ID
	 */
	public Integer getRecipient_ID() {
		return recipient_ID;
	}
	/**
	 * @param recipient_ID the recipient_ID to set
	 */
	public void setRecipient_ID(Integer recipient_ID) {
		this.recipient_ID = recipient_ID;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	
	
}
