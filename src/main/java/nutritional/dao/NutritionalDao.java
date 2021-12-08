package nutritional.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import nutritional.domain.Nutritional;
import nutritional.domain.NutritionalProgramSourceInfo;
import user.domain.User;

/**
 * DDL functions performed in database
 */
public class NutritionalDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "welfare"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "pass123"; //TODO change password

	public Nutritional findByProgram_ID(Integer program_ID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Nutritional nutritional = new Nutritional();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
		    String sql = "select * from nutritional where program_ID=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,program_ID);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer Program_ID = Integer.parseInt(resultSet.getString("program_ID"));
		    	System.out.println(program_ID);
		    	System.out.println(Program_ID);
		    	if(Program_ID == program_ID){
		    		
		    		nutritional.setProgram_ID(program_ID);
		    		nutritional.setAdministrator_ID(Integer.parseInt(resultSet.getString("administrator_ID")));
		    		nutritional.setProgram_name(resultSet.getString("program_name"));
		    		nutritional.setFunds(Integer.parseInt(resultSet.getString("funds")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return nutritional;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Nutritional form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
			
			String sql = "insert into nutritional (program_name, program_ID, administrator_ID, funds) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setString(1,form.getProgram_name());
		    preparestatement.setInt(2,form.getProgram_ID());
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
	public void update(Nutritional form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
			
			String sql = "UPDATE nutritional SET program_name = ?, administrator_ID = ?, funds = ?  where program_ID = ?;";
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
	 * @param program_ID
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(Integer program_ID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
			
			String sql = "delete from nutritional where program_ID = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,program_ID);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> findNutritionalFund() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
			String sql = "select * from NutritionalFundsOverOrUnder";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Nutritional nutritional = new Nutritional();
				nutritional.setFunds(resultSet.getInt("funds"));
	    		list.add(nutritional);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> findNutritionalProgramSource() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/welfare", MySQL_user, MySQL_password);
			String sql = "select * from getNutritionalSource";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				NutritionalProgramSourceInfo nutritionalsourceinfo = new NutritionalProgramSourceInfo();
				nutritionalsourceinfo.setProgram_name(resultSet.getString("program_name"));
				nutritionalsourceinfo.setSource(resultSet.getString("source"));
	    		list.add(nutritionalsourceinfo);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
}
