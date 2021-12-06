package address.service;


import address.dao.AddressDao;
import address.domain.Address;

/**
 * logic functions such as register, login
 * @author Harshal Patel
 *
 */
public class AddressService {
	private AddressDao addressDao = new AddressDao();
	
	/**
	 * register a Address
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Address form) throws AddressException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Address
		Address address = addressDao.findByRecipientID(form.getRecipient_ID());
		if(address.getRecipient_ID()!=null && address.getRecipient_ID().equals(form.getRecipient_ID())) throw new AddressException("This address has been registered!");
		addressDao.add(form);
	}

}
