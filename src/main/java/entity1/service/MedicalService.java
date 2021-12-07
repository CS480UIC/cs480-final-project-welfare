package entity1.service;


import entity1.dao.EligibilityDao;
import entity1.domain.Medical;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class MedicalService {
	private EligibilityDao entity1Dao = new EligibilityDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Medical form) throws MedicalException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Medical entity1 = entity1Dao.findByUsername(form.getUsername());
		if(entity1.getUsername()!=null && entity1.getUsername().equals(form.getUsername())) throw new MedicalException("This user name has been registered!");
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
	public void login(Medical form) throws MedicalException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Medical user = entity1Dao.findByUsername(form.getUsername());
		if(user.getUsername()==null) throw new MedicalException("The user is not in the database");
		
		String password = user.getPassword();
		
		if(password!=null && !password.equals(form.getPassword()))
			throw new MedicalException(" The password is not right");
		
	}
}
