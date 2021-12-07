package administrator.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import administrator.domain.Administrator;
import income.domain.Income;




//import java.util.ArrayList;
//import java.util.List;

//import Administrator.domain.administrator;

/**
 * DDL functions performed in database
 */
public class AdministratorDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "welfare"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "pass123"; //TODO change password

	public Administrator findByID(int adminID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Administrator administrator = new Administrator();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
		    String sql = "select * from administrator where ID=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,adminID);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer ID = Integer.parseInt(resultSet.getString("ID"));
		    	if(ID==adminID){
		    		administrator.setFirst_name(resultSet.getString("first_name"));
		    		administrator.setLast_name(resultSet.getString("last_name"));
		    		administrator.setTitle(resultSet.getString("title"));
		    		administrator.setID(ID);
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return administrator;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Administrator form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
			
			String sql = "insert into administrator (first_name, last_name,title,ID) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getFirst_name());
		    preparestatement.setString(2,form.getLast_name());
		    preparestatement.setString(3,form.getTitle());
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
	public void update(Administrator form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
			
			String sql = "UPDATE administrator SET first_name = ?, last_name = ?, title = ?  where ID = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getFirst_name());
			preparestatement.setString(2,form.getLast_name());
		    preparestatement.setString(3,form.getTitle());
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
			String sql = "delete from administrator where ID = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,theID);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> findManager() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
			String sql = "select * from Mangers";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Administrator administrator = new Administrator();
				administrator.setFirst_name(resultSet.getString("first_name"));
				administrator.setLast_name(resultSet.getString("last_name"));
	    		
	    		list.add(administrator);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
}
