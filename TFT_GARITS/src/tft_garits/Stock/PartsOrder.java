package tft_garits.Stock;

public class PartsOrder {

	private int orderID;
	private Date orderDate;
	private String company;
	private String address;
	private String contents;
	private double total;

	/**
	 * 
	 * @param orderId
	 */
	public PartsOrder generateOrder(int orderId) {
		// TODO - implement PartsOrder.generateOrder
		throw new UnsupportedOperationException("PartsOrder.generateOrder() needs implementation");
	}

	/**
	 * 
	 * @param orderDate
	 * @param company
	 * @param contents
	 * @param total
	 */
	public static PartsOrder PartsOrder(Date orderDate, String company, String contents, double total) {
		// TODO - implement PartsOrder.PartsOrder
		throw new UnsupportedOperationException("PartsOrder.PartsOrder() needs implementation");
	}

	public int getOrderID() {
		return this.orderID;
	}

	/**
	 * 
	 * @param orderID
	 */
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	/**
	 * 
	 * @param orderDate
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getCompany() {
		return this.company;
	}

	/**
	 * 
	 * @param company
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return this.address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public String getContents() {
		return this.contents;
	}

	/**
	 * 
	 * @param contents
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}

	public double getTotal() {
		return this.total;
	}

	/**
	 * 
	 * @param total
	 */
	public void setTotal(double total) {
		this.total = total;
	}

}