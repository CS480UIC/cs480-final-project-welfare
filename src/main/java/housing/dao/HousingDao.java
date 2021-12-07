package housing.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import housing.domain.Housing;

/**
 * DDL functions performed in database
 */
public class HousingDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "welfare"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "pass123"; //TODO change password

	public Housing findByProgramID(Integer program_ID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Housing housing = new Housing();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
		    String sql = "select * from housing where program_ID=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,program_ID);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer programID = Integer.parseInt(resultSet.getString("program_ID"));
		    	if(programID.equals(program_ID)){
		    		housing.setProgram_name(resultSet.getString("program_name"));
		    		housing.setProgram_ID(Integer.parseInt(resultSet.getString("program_ID")));
		    		housing.setAdministrator_ID(Integer.parseInt(resultSet.getString("administrator_ID")));
		    		housing.setHousing_size(Integer.parseInt(resultSet.getString("housing_size")));
		    		housing.setFunds(Integer.parseInt(resultSet.getString("funds")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return housing;
	}	
	
	/**
	 * insert Housing
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Housing form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
			
			String sql = "insert into housing (program_name,program_ID,administrator_ID,housing_size,funds) values(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getProgram_name());
		    preparestatement.setInt(2,form.getProgram_ID());
		    preparestatement.setInt(3,form.getAdministrator_ID());
		    preparestatement.setInt(4,form.getHousing_size());
		    preparestatement.setInt(5,form.getFunds());
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
	
	public void update(Housing form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
			
			String sql = "UPDATE housing SET program_name = ?, administrator_ID = ?, housing_size = ?, funds = ?  where program_ID = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setString(1,form.getProgram_name());
			preparestatement.setInt(2,form.getAdministrator_ID());
		    preparestatement.setInt(3,form.getHousing_size());
		    preparestatement.setInt(4,form.getFunds());
		    preparestatement.setInt(5,form.getProgram_ID());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param program_ID
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	
	public void delete(Integer program_ID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
			
			String sql = "delete from housing where program_ID = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,program_ID);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
