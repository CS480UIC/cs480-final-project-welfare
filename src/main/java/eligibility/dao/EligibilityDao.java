package eligibility.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import eligibility.domain.Eligibility;

/**
 * DDL functions performed in database
 */
public class EligibilityDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "welfare"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "pass123"; //TODO change password

	public Eligibility findByRecipientID(Integer recipient_ID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Eligibility eligibility = new Eligibility();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
		    String sql = "select * from eligibility where recipient_ID =?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,recipient_ID);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer id = Integer.parseInt(resultSet.getString("recipient_ID"));
		    	if(id == recipient_ID){
		    		eligibility.setRecipient_ID(Integer.parseInt(resultSet.getString("recipient_ID")));
		    		eligibility.setCitizenship(resultSet.getString("citizenship"));
		    		eligibility.setResidency(resultSet.getString("residency"));
		    		eligibility.setFamily(resultSet.getString("family"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return eligibility;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Eligibility form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
			
			String sql = "insert into eligibility (recipient_ID, citizenship, residency, family) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setInt(1,form.getRecipient_ID());
		    preparestatement.setString(2,form.getCitizenship());
		    preparestatement.setString(3,form.getResidency());
		    preparestatement.setString(4,form.getFamily());
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
	public void update(Eligibility form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
			
			String sql = "UPDATE eligibility SET citizenship = ?, residency = ?, family = ? where recipient_ID = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
		    preparestatement.setString(1,form.getCitizenship());
		    preparestatement.setString(2,form.getResidency());
		    preparestatement.setString(3,form.getFamily());
		    preparestatement.setInt(4,form.getRecipient_ID());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param recipient_ID
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(Integer id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
			
			String sql = "delete from eligibility where recipient_ID = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
