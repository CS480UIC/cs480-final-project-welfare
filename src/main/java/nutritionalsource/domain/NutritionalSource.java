package nutritionalsource.domain;

import java.sql.Date;

/**
 * recipient object
 * 
 * @author
 * 
 */
public class NutritionalSource {
	/*
	 * Correspond to the user table
	 */
	
	private String source;
	private Integer nutritionalsource_ID; 
	private Integer program_ID;
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return the nutritionalsource_ID
	 */
	public Integer getNutritionalsource_ID() {
		return nutritionalsource_ID;
	}
	/**
	 * @param nutritionalsource_ID the nutritionalsource_ID to set
	 */
	public void setNutritionalsource_ID(Integer nutritionalsource_ID) {
		this.nutritionalsource_ID = nutritionalsource_ID;
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
}