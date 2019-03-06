package tft_garits.Job;

public class Invoice {

	private int invoiceNo;
	private int vehicleRegistrationNo;
	private String make;
	private String model;
	private String descriptionOfWork;
	private List items;
	private String Labour;
	private double total;
	private double vat;
	private double grandTotal;
	private String status = unpaid;

	/**
	 * 
	 * @param data
	 */
	public Invoice generateInvoice(String data) {
		// TODO - implement Invoice.generateInvoice
		throw new UnsupportedOperationException("Invoice.generateInvoice() needs implementation");
	}

	public double calculateLabour() {
		// TODO - implement Invoice.calculateLabour
		throw new UnsupportedOperationException("Invoice.calculateLabour() needs implementation");
	}

	public double calculateTotal() {
		// TODO - implement Invoice.calculateTotal
		throw new UnsupportedOperationException("Invoice.calculateTotal() needs implementation");
	}

	public double calculateGrandTotal() {
		// TODO - implement Invoice.calculateGrandTotal
		throw new UnsupportedOperationException("Invoice.calculateGrandTotal() needs implementation");
	}

	/**
	 * 
	 * @param contents
	 */
	public static Invoice Invoice(String contents) {
		// TODO - implement Invoice.Invoice
		throw new UnsupportedOperationException("Invoice.Invoice() needs implementation");
	}

	public double calculateVat() {
		// TODO - implement Invoice.calculateVat
		throw new UnsupportedOperationException("Invoice.calculateVat() needs implementation");
	}

	public void changeStatus() {
		// TODO - implement Invoice.changeStatus
		throw new UnsupportedOperationException("Invoice.changeStatus() needs implementation");
	}

	public int getInvoiceNo() {
		return this.invoiceNo;
	}

	/**
	 * 
	 * @param invoiceNo
	 */
	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public int getVehicleRegistrationNo() {
		return this.vehicleRegistrationNo;
	}

	/**
	 * 
	 * @param vehicleRegistrationNo
	 */
	public void setVehicleRegistrationNo(int vehicleRegistrationNo) {
		this.vehicleRegistrationNo = vehicleRegistrationNo;
	}

	public String getMake() {
		return this.make;
	}

	/**
	 * 
	 * @param make
	 */
	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return this.model;
	}

	/**
	 * 
	 * @param model
	 */
	public void setModel(String model) {
		this.model = model;
	}

	public String getDescriptionOfWork() {
		return this.descriptionOfWork;
	}

	/**
	 * 
	 * @param descriptionOfWork
	 */
	public void setDescriptionOfWork(String descriptionOfWork) {
		this.descriptionOfWork = descriptionOfWork;
	}

	public List getItems() {
		return this.items;
	}

	/**
	 * 
	 * @param items
	 */
	public void setItems(List items) {
		this.items = items;
	}

	public String getLabour() {
		// TODO - implement Invoice.getLabour
		throw new UnsupportedOperationException("Invoice.getLabour() needs implementation");
	}

	/**
	 * 
	 * @param Labour
	 */
	public void setLabour(String Labour) {
		// TODO - implement Invoice.setLabour
		throw new UnsupportedOperationException("Invoice.setLabour() needs implementation");
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

	public double getVat() {
		return this.vat;
	}

	/**
	 * 
	 * @param vat
	 */
	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getGrandTotal() {
		return this.grandTotal;
	}

	/**
	 * 
	 * @param grandTotal
	 */
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getStatus() {
		return this.status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}