package administrator.service;


import java.util.List;

import administrator.dao.AdministratorDao;
import administrator.domain.Administrator;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class AdministratorService {
	private AdministratorDao administratorDao = new AdministratorDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Administrator form) throws AdministratorException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		AdministratorDao RD = new AdministratorDao();
		Administrator entity1 = new Administrator();
		int AdminID = form.getID();
		entity1 = RD.findByID(AdminID);
		if(entity1.getID()==(form.getID())) throw new AdministratorException("This administrator ID has already been registered!");
		administratorDao.add(form);
	}
	
	public void delete(Administrator form) throws AdministratorException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		AdministratorDao RD = new AdministratorDao();
		Administrator entity1 = new Administrator();
		int AdminID = form.getID();
		entity1 = RD.findByID(AdminID);
		if(entity1.getID()!=(form.getID())) throw new AdministratorException("This administrator ID does not exist!");
		administratorDao.add(form);
	}
	
	public List<Object> findManager() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return administratorDao.findManager();
		
	}

}