package housing.service;


import housing.dao.HousingDao;
import housing.domain.Housing;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class HousingService {
	private HousingDao housingDao = new HousingDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Housing form) throws HousingException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Housing housing = housingDao.findByProgramID(form.getProgram_ID());
		if(housing.getProgram_ID()!=null && housing.getProgram_ID().equals(form.getProgram_ID())) throw new HousingException("This Housing program has been registered!");
		housingDao.add(form);
	}
}
