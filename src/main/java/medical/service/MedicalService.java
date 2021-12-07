package medical.service;


import medical.dao.MedicalDao;
import medical.domain.Medical;

/**
 * logic functions such as register, login
 * @author Daniel Levert
 *
 */
public class MedicalService {
	private MedicalDao medicalDao = new MedicalDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Medical form) throws MedicalException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Medical medical = medicalDao.findByProgramID(form.getProgram_ID());
		if(medical.getProgram_ID()!=null && medical.getProgram_ID().equals(form.getProgram_ID())) throw new MedicalException("This program ID has already been registered!");
		medicalDao.add(form);
	}
}
