package recipient.service;


import recipient.dao.RecipientDao;
import recipient.domain.Recipient;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class RecipientService {
	private RecipientDao entity1Dao = new RecipientDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Recipient form) throws RecipientException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		RecipientDao RD = new RecipientDao();
		Recipient entity1 = new Recipient();
		int recipID = form.getID();
		entity1 = RD.findByID(recipID);
		if(entity1.getID()==(form.getID())) throw new RecipientException("This recipient ID has already been registered!");
		entity1Dao.add(form);
	}
	
	public void delete(Recipient form) throws RecipientException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		RecipientDao RD = new RecipientDao();
		Recipient entity1 = new Recipient();
		int recipID = form.getID();
		entity1 = RD.findByID(recipID);
		if(entity1.getID()!=(form.getID())) throw new RecipientException("This recipient ID does not exist!");
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
	public void login(Recipient form) throws RecipientException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Recipient user = entity1Dao.findByID(form.getUsername());
		if(user.getUsername()==null) throw new RecipientException("The user is not in the database");
		
		String password = user.getPassword();
		
		if(password!=null && !password.equals(form.getPassword()))
			throw new RecipientException(" The password is not right");
		
	}
}
