package nutritionalsource.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import nutritionalsource.domain.NutritionalSource;

/**
 * DDL functions performed in database
 */
public class NutritionalSourceDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "welfare"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "pass123"; //TODO change password

	public NutritionalSource findByID(int ProgramID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		NutritionalSource nutritionalsource = new NutritionalSource();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
		    String sql = "select * from nutritionalsource where program_ID=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,ProgramID);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer ID = Integer.parseInt(resultSet.getString("program_ID"));
		    	if(ID==ProgramID){
		    		nutritionalsource.setProgram_ID(Integer.parseInt(resultSet.getString("program_ID")));
		    		nutritionalsource.setNutritionalsource_ID(Integer.parseInt(resultSet.getString("nutritionalsource_ID")));
		    		nutritionalsource.setSource(resultSet.getString("source"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return nutritionalsource;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(NutritionalSource form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
			String sql = "SET FOREIGN_KEY_CHECKS=0";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.executeUpdate();
			sql =  "insert into nutritionalsource (program_ID, nutritionalsource_ID,source) values(?,?,?)";
			preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getProgram_ID());
		    preparestatement.setInt(2,form.getNutritionalsource_ID());
		    preparestatement.setString(3,form.getSource());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(NutritionalSource form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
			
			String sql = "UPDATE nutritionalsource SET nutritionalsource_ID = ?, source = ?  where program_ID = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getNutritionalsource_ID());
		    System.out.println("TEST");
		    System.out.println(form.getNutritionalsource_ID());
			preparestatement.setString(2,form.getSource());
		    preparestatement.setInt(3,form.getProgram_ID());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param ID
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String IDs) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
			Integer theID = Integer.parseInt(IDs);
			String sql = "delete from nutritionalsource where program_ID = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,theID);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
