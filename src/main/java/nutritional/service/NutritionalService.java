package nutritional.service;


import java.util.List;

import nutritional.dao.NutritionalDao;
import nutritional.domain.Nutritional;

/**
 * logic functions such as register, login
 * @author Yashasvi Patel
 *
 */
public class NutritionalService {
	private NutritionalDao nutritionalDao = new NutritionalDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Nutritional form) throws NutritionalException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Nutritional entity1 = nutritionalDao.findByProgram_ID(form.getProgram_ID());
		if(entity1.getProgram_ID()!=null && entity1.getProgram_ID().equals(form.getProgram_ID())) throw new NutritionalException("This program name has been registered!");
		nutritionalDao.add(form);
	}
	
	public List<Object> findNutritionalFund() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return nutritionalDao.findNutritionalFund();
		
	}

}
