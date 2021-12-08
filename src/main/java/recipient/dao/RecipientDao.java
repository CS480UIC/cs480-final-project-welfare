package recipient.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import income.domain.Income;

//import java.util.ArrayList;
//import java.util.List;

import recipient.domain.Recipient;
import recipient.domain.RecipientInfo;

/**
 * DDL functions performed in database
 */
public class RecipientDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "welfare"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "pass123"; //TODO change password

	public Recipient findByID(int UserID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Recipient recipient = new Recipient();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
		    String sql = "select * from recipient where ID=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,UserID);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer ID = Integer.parseInt(resultSet.getString("ID"));
		    	if(ID==UserID){
		    		recipient.setFirst_name(resultSet.getString("first_name"));
		    		recipient.setLast_name(resultSet.getString("last_name"));
		    		recipient.setBirthdate(java.sql.Date.valueOf(resultSet.getString("birthdate")));
		    		recipient.setID(ID);
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return recipient;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Recipient form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
			
			String sql = "insert into recipient (first_name, last_name,birthdate,ID) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getFirst_name());
		    preparestatement.setString(2,form.getLast_name());
		    preparestatement.setDate(3,form.getBirthdate());
		    preparestatement.setInt(4,form.getID());
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
	public void update(Recipient form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
			
			String sql = "UPDATE recipient SET first_name = ?, last_name = ?, birthdate = ?  where ID = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getFirst_name());
			preparestatement.setString(2,form.getLast_name());
		    preparestatement.setDate(3,form.getBirthdate());
		    preparestatement.setInt(4,form.getID());
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
			String sql = "delete from recipient where ID = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,theID);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> findRecipientNameNet() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
			String sql = "select * from recipNameAndIncome";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				RecipientInfo recipientinfo = new RecipientInfo();
				recipientinfo.setFirst_name(resultSet.getString("first_name"));
				recipientinfo.setLast_name(resultSet.getString("last_name"));
				recipientinfo.setTotal_net(resultSet.getInt("total_net"));
	    		
	    		list.add(recipientinfo);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
}
