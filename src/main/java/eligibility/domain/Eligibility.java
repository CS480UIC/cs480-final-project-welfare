package eligibility.domain;

/**
 * User object
 * 
 * @author Daniel Levert
 * 
 */
public class Eligibility {
	/*
	 * Correspond to the user table
	 */
	
	private Integer recipient_ID;
	private String citizenship;
	private String residency;
	private Integer family;
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
	 * @return the citizenship
	 */
	public String getCitizenship() {
		return citizenship;
	}
	/**
	 * @param citizenship the citizenship to set
	 */
	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}
	/**
	 * @return the residency
	 */
	public String getResidency() {
		return residency;
	}
	/**
	 * @param residency the residency to set
	 */
	public void setResidency(String residency) {
		this.residency = residency;
	}
	/**
	 * @return the family
	 */
	public Integer getFamily() {
		return family;
	}
	/**
	 * @param family the family to set
	 */
	public void setFamily(Integer family) {
		this.family = family;
	}
	
	
}
