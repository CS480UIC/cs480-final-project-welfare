package recipient.service;


import java.util.List;

import recipient.dao.RecipientDao;
import recipient.domain.Recipient;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class RecipientService {
	private RecipientDao recipientDao = new RecipientDao();
	
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
		recipientDao.add(form);
	}
	
	public void delete(Recipient form) throws RecipientException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		RecipientDao RD = new RecipientDao();
		Recipient entity1 = new Recipient();
		int recipID = form.getID();
		entity1 = RD.findByID(recipID);
		if(entity1.getID()!=(form.getID())) throw new RecipientException("This recipient ID does not exist!");
		recipientDao.add(form);
	}
	
	public List<Object> findRecipientNameNet() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return recipientDao.findRecipientNameNet();
		
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

}
