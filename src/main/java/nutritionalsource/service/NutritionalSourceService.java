package nutritionalsource.service;


import nutritionalsource.dao.NutritionalSourceDao;
import nutritionalsource.domain.NutritionalSource;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class NutritionalSourceService {
	private NutritionalSourceDao entity1Dao = new NutritionalSourceDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(NutritionalSource form) throws NutritionalSourceException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		NutritionalSourceDao RD = new NutritionalSourceDao();
		NutritionalSource entity1 = new NutritionalSource();
		Integer ProgramID = form.getProgram_ID();
		entity1 = RD.findByID(ProgramID);
		if(entity1.getProgram_ID()==(form.getProgram_ID())) throw new NutritionalSourceException("This NutritionalSource Program ID has already been registered!");
		entity1Dao.add(form);
	}
	
	public void delete(NutritionalSource form) throws NutritionalSourceException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		NutritionalSourceDao RD = new NutritionalSourceDao();
		NutritionalSource entity1 = new NutritionalSource();
		int recipID = form.getProgram_ID();
		entity1 = RD.findByID(recipID);
		if(entity1.getProgram_ID()!=(form.getProgram_ID())) throw new NutritionalSourceException("This NutritionalSource ID does not exist!");
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

}
