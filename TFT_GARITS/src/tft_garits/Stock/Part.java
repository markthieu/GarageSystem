package tft_garits.Stock;

public class Part {

	private int partNo;
	private int quantity;
	private String vehicleType;
	private String manufacturer;
	private String name;
	private double traderPrice;
	private double sellingPrice;

	/**
	 * 
	 * @param partId
	 */
	public Part retrieve(int partId) {
		// TODO - implement Part.retrieve
		throw new UnsupportedOperationException("Part.retrieve() needs implementation");
	}

	/**
	 * 
	 * @param name
	 * @param manu
	 * @param vehType
	 * @param qty
	 */
	public static Part Part(String name, String manu, String vehType, int qty) {
		// TODO - implement Part.Part
		throw new UnsupportedOperationException("Part.Part() needs implementation");
	}

	/**
	 * 
	 * @param partId
	 */
	public double calculateSellingPrice(int partId) {
		// TODO - implement Part.calculateSellingPrice
		throw new UnsupportedOperationException("Part.calculateSellingPrice() needs implementation");
	}

	public int getPartNo() {
		return this.partNo;
	}

	/**
	 * 
	 * @param partNo
	 */
	public void setPartNo(int partNo) {
		this.partNo = partNo;
	}

	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getVehicleType() {
		return this.vehicleType;
	}

	/**
	 * 
	 * @param vehicleType
	 */
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	/**
	 * 
	 * @param manufacturer
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public double getTraderPrice() {
		return this.traderPrice;
	}

	/**
	 * 
	 * @param traderPrice
	 */
	public void setTraderPrice(double traderPrice) {
		this.traderPrice = traderPrice;
	}

	public double getSellingPrice() {
		return this.sellingPrice;
	}

	/**
	 * 
	 * @param sellingPrice
	 */
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

}