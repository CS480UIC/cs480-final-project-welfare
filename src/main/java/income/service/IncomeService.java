package income.service;


import java.util.List;

import income.dao.IncomeDao;
import income.domain.Income;

/**
 * logic functions such as register, login
 * @author Harshal Patel
 *
 */
public class IncomeService {
	private IncomeDao incomeDao = new IncomeDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Income form) throws IncomeException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Income entity1 = incomeDao.findByRecipientID(form.getRecipient_ID());
		if(entity1.getRecipient_ID()!=null && entity1.getRecipient_ID() == form.getRecipient_ID()) throw new IncomeException("This income recipient has been registered before!");
		incomeDao.add(form);
	}
	
	public List<Object> findRecipientIncome() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return incomeDao.findRecipientIncome();
		
	}
	
}
