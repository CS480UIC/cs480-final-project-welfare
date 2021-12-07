package medicalfacility.service;


import medicalfacility.dao.MedicalFacilityDao;
import medicalfacility.domain.MedicalFacility;

/**
 * logic functions such as register, login
 * @author Daniel Levert
 *
 */
public class MedicalFacilityService {
	private MedicalFacilityDao medicalfacilityDao = new MedicalFacilityDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(MedicalFacility form) throws MedicalFacilityException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		MedicalFacility medicalfacility = medicalfacilityDao.findByProgramID(form.getProgram_ID());
		if(medicalfacility.getProgram_ID()!=null && medicalfacility.getProgram_ID().equals(form.getProgram_ID())) throw new MedicalFacilityException("This program ID has already been registered!");
		medicalfacilityDao.add(form);
	}
}
