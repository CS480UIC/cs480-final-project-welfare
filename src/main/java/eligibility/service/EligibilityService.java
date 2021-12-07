package eligibility.service;


import eligibility.dao.EligibilityDao;
import eligibility.domain.Eligibility;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class EligibilityService {
	private EligibilityDao eligibilityDao = new EligibilityDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Eligibility form) throws EligibilityException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Eligibility eligibility = eligibilityDao.findByRecipientID(form.getRecipient_ID());
		if(eligibility.getRecipient_ID()!=null && eligibility.getRecipient_ID() == form.getRecipient_ID()) throw new EligibilityException("This recipient ID has been registered!");
		eligibilityDao.add(form);
	}
	
}
