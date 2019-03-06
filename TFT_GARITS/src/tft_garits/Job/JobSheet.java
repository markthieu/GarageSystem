package tft_garits.Job;

public class JobSheet {

	Vehicle vehicle;
	private int jobNo;
	private int estimatedTime;
	private Time actualTime;
	private String requiredTasks;
	private String completedTasks;
	private int dateBooked;
	private boolean status = false;

	/**
	 * 
	 * @param estTime
	 * @param actualTime
	 * @param tasks
	 * @param dateBooked
	 */
	public static JobSheet JobSheet(Time estTime, Time actualTime, String tasks, Date dateBooked) {
		// TODO - implement JobSheet.JobSheet
		throw new UnsupportedOperationException("JobSheet.JobSheet() needs implementation");
	}

	public JobSheet generate() {
		// TODO - implement JobSheet.generate
		throw new UnsupportedOperationException("JobSheet.generate() needs implementation");
	}

	public JobSheetForm view() {
		// TODO - implement JobSheet.view
		throw new UnsupportedOperationException("JobSheet.view() needs implementation");
	}

	public Invoice generateInvoice() {
		// TODO - implement JobSheet.generateInvoice
		throw new UnsupportedOperationException("JobSheet.generateInvoice() needs implementation");
	}

	public int getJobNo() {
		return this.jobNo;
	}

	/**
	 * 
	 * @param jobNo
	 */
	public void setJobNo(int jobNo) {
		this.jobNo = jobNo;
	}

	public void getEstimatedTime() {
		// TODO - implement JobSheet.getEstimatedTime
		throw new UnsupportedOperationException("JobSheet.getEstimatedTime() needs implementation");
	}

	/**
	 * 
	 * @param estimatedTime
	 */
	public void setEstimatedTime(int estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public Time getActualTime() {
		return this.actualTime;
	}

	/**
	 * 
	 * @param actualTime
	 */
	public void setActualTime(Time actualTime) {
		this.actualTime = actualTime;
	}

	public String getRequiredTasks() {
		return this.requiredTasks;
	}

	/**
	 * 
	 * @param requiredTasks
	 */
	public void setRequiredTasks(String requiredTasks) {
		this.requiredTasks = requiredTasks;
	}

	public String getCompletedTasks() {
		return this.completedTasks;
	}

	/**
	 * 
	 * @param completedTasks
	 */
	public void setCompletedTasks(String completedTasks) {
		this.completedTasks = completedTasks;
	}

	public void getDateBooked() {
		// TODO - implement JobSheet.getDateBooked
		throw new UnsupportedOperationException("JobSheet.getDateBooked() needs implementation");
	}

	/**
	 * 
	 * @param dateBooked
	 */
	public void setDateBooked(int dateBooked) {
		this.dateBooked = dateBooked;
	}

	public boolean getStatus() {
		return this.status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

}