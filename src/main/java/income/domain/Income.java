package income.domain;

/**
 * User object
 * 
 * @author Harshal Patel
 * 
 */
public class Income {
	
	private Integer recipient_ID;
	private Integer total_gross; 
	private Integer total_net;
	private Integer investments;
	/**
	 * @return the recipient_ID
	 */
	public Integer getRecipient_ID() {
		return recipient_ID;
	}
	/**
	 * @param recipient_ID the recipient_ID to set
	 */
	public void setRecipient_ID(Integer recipient_ID) {
		this.recipient_ID = recipient_ID;
	}
	/**
	 * @return the total_gross
	 */
	public Integer getTotal_gross() {
		return total_gross;
	}
	/**
	 * @param total_gross the total_gross to set
	 */
	public void setTotal_gross(Integer total_gross) {
		this.total_gross = total_gross;
	}
	/**
	 * @return the total_net
	 */
	public Integer getTotal_net() {
		return total_net;
	}
	/**
	 * @param total_net the total_net to set
	 */
	public void setTotal_net(Integer total_net) {
		this.total_net = total_net;
	}
	/**
	 * @return the investments
	 */
	public Integer getInvestments() {
		return investments;
	}
	/**
	 * @param investments the investments to set
	 */
	public void setInvestments(Integer investments) {
		this.investments = investments;
	}
}
