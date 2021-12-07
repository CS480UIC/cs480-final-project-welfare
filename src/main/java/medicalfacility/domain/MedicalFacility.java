package medicalfacility.domain;

/**
 * User object
 * 
 * @author Daniel Levert
 * 
 */
public class MedicalFacility {
	/*
	 * Correspond to the user table
	 */
	private Integer program_ID;
	private Integer medicalfacility_ID;
	private String facility;
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
	 * @return the medicalfacility_ID
	 */
	public Integer getMedicalfacility_ID() {
		return medicalfacility_ID;
	}
	/**
	 * @param medicalfacility_ID the medicalfacility_ID to set
	 */
	public void setMedicalfacility_ID(Integer medicalfacility_ID) {
		this.medicalfacility_ID = medicalfacility_ID;
	}
	/**
	 * @return the facility
	 */
	public String getFacility() {
		return facility;
	}
	/**
	 * @param facility the facility to set
	 */
	public void setFacility(String facility) {
		this.facility = facility;
	}
	
}
