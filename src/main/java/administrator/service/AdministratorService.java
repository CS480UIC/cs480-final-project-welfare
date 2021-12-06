package administrator.service;


import administrator.dao.AdministratorDao;
import administrator.domain.Administrator;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class AdministratorService {
	private AdministratorDao entity1Dao = new AdministratorDao();
	
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
		entity1Dao.add(form);
	}
	
	public void delete(Administrator form) throws AdministratorException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		AdministratorDao RD = new AdministratorDao();
		Administrator entity1 = new Administrator();
		int AdminID = form.getID();
		entity1 = RD.findByID(AdminID);
		if(entity1.getID()!=(form.getID())) throw new AdministratorException("This administrator ID does not exist!");
		entity1Dao.add(form);
	}

}