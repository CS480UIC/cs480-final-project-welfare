package recipient.domain;

public class RecipientInfo {
	private String first_name;

	private String last_name;
	private Integer total_net;
	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
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
}
