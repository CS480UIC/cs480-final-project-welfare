package housing.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Housing {
	/*
	 * Correspond to the user table
	 */
	
	private String program_name;
	private Integer program_ID; 
	private Integer administrator_ID;
	private Integer housing_size; 
	private Integer funds;
	/**
	 * @return the program_name
	 */
	public String getProgram_name() {
		return program_name;
	}
	/**
	 * @param program_name the program_name to set
	 */
	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}
	/**
	 * @return the program_ID
	 */
	public Integer getProgram_ID() {
		return program_ID;
	}
	/**
	 * @param program_ID the program_ID to set
	 */
	public void setProgram_ID(Integer program_ID) {
		this.program_ID = program_ID;
	}
	/**
	 * @return the administrator_ID
	 */
	public Integer getAdministrator_ID() {
		return administrator_ID;
	}
	/**
	 * @param administrator_ID the administrator_ID to set
	 */
	public void setAdministrator_ID(Integer administrator_ID) {
		this.administrator_ID = administrator_ID;
	}
	/**
	 * @return the housing_size
	 */
	public Integer getHousing_size() {
		return housing_size;
	}
	/**
	 * @param housing_size the housing_size to set
	 */
	public void setHousing_size(Integer housing_size) {
		this.housing_size = housing_size;
	}
	/**
	 * @return the funds
	 */
	public Integer getFunds() {
		return funds;
	}
	/**
	 * @param funds the funds to set
	 */
	public void setFunds(Integer funds) {
		this.funds = funds;
	}

}
