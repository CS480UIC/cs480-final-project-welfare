package entity1.service;


import entity1.dao.AddressDao;
import entity1.domain.Address;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class AddressService {
	private AddressDao entity1Dao = new AddressDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Address form) throws AddressException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Address entity1 = entity1Dao.findByUsername(form.getUsername());
		if(entity1.getUsername()!=null && entity1.getUsername().equals(form.getUsername())) throw new AddressException("This user name has been registered!");
		entity1Dao.add(form);
	}
	/**
	 * Login function
	 * @param form
	 * @return
	 * @throws UserException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void login(Address form) throws AddressException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Address user = entity1Dao.findByUsername(form.getUsername());
		if(user.getUsername()==null) throw new AddressException("The user is not in the database");
		
		String password = user.getPassword();
		
		if(password!=null && !password.equals(form.getPassword()))
			throw new AddressException(" The password is not right");
		
	}
}
