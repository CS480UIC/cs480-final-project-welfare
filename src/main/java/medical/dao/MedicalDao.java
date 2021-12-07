package medical.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import medical.domain.Medical;

//import java.util.ArrayList;
//import java.util.List;

import medicalfacility.domain.MedicalFacility;

/**
 * DDL functions performed in database
 */
public class MedicalDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "welfare"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "pass123"; //TODO change password

	public Medical findByProgramID(Integer program_ID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Medical medical = new Medical();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
		    String sql = "select * from medical where program_ID=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,program_ID);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer id = Integer.parseInt(resultSet.getString("program_ID"));
		    	if(id == program_ID){
		    		medical.setProgram_ID(Integer.parseInt(resultSet.getString("program_ID")));
		    		medical.setProgram_name(resultSet.getString("program_name"));
		    		medical.setAdministrator_ID(Integer.parseInt(resultSet.getString("administrator_ID")));
		    		medical.setFunds(Integer.parseInt(resultSet.getString("funds")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return medical;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Medical form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
			
			String sql = "insert into medical values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getProgram_ID());
		    preparestatement.setString(2,form.getProgram_name());
		    preparestatement.setInt(3,form.getAdministrator_ID());
		    preparestatement.setInt(4,form.getFunds());
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
	public void update(Medical form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
			
			String sql = "UPDATE medical SET program_name = ?, administrator_ID = ?, funds = ? where program_ID = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setString(1,form.getProgram_name());
		    preparestatement.setInt(2,form.getAdministrator_ID());
		    preparestatement.setInt(3,form.getFunds());
		    preparestatement.setInt(4,form.getProgram_ID());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param username
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(Integer id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
			
			String sql = "delete from medical where program_ID = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
