package tft_garits.Job;

public class Vehicle {

	private int registrationNo;
	private String vechicleType;
	private String carMake;
	private String model;
	private int engineSerialNumber;
	private int chasisNumber;
	private String colour;
	private String status;

	/**
	 * 
	 * @param type
	 * @param make
	 * @param model
	 * @param serialNo
	 * @param chasisNo
	 * @param colour
	 */
	public static Vehicle Vehicle(String type, String make, String model, int serialNo, int chasisNo, String colour) {
		// TODO - implement Vehicle.Vehicle
		throw new UnsupportedOperationException("Vehicle.Vehicle() needs implementation");
	}

	public int getRegistrationNo() {
		return this.registrationNo;
	}

	/**
	 * 
	 * @param registrationNo
	 */
	public void setRegistrationNo(int registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getVechicleType() {
		return this.vechicleType;
	}

	/**
	 * 
	 * @param vechicleType
	 */
	public void setVechicleType(String vechicleType) {
		this.vechicleType = vechicleType;
	}

	public String getCarMake() {
		return this.carMake;
	}

	/**
	 * 
	 * @param carMake
	 */
	public void setCarMake(String carMake) {
		this.carMake = carMake;
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

	public int getEngineSerialNumber() {
		return this.engineSerialNumber;
	}

	/**
	 * 
	 * @param engineSerialNumber
	 */
	public void setEngineSerialNumber(int engineSerialNumber) {
		this.engineSerialNumber = engineSerialNumber;
	}

	public int getChasisNumber() {
		return this.chasisNumber;
	}

	/**
	 * 
	 * @param chasisNumber
	 */
	public void setChasisNumber(int chasisNumber) {
		this.chasisNumber = chasisNumber;
	}

	public String getColour() {
		return this.colour;
	}

	/**
	 * 
	 * @param colour
	 */
	public void setColour(String colour) {
		this.colour = colour;
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