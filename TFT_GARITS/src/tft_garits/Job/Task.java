package tft_garits.Job;

public class Task {

	private String description;
	private int taskID;
	private String status;

	public String getDescription() {
		return this.description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public int getTaskID() {
		return this.taskID;
	}

	/**
	 * 
	 * @param taskID
	 */
	public void setTaskID(int taskID) {
		this.taskID = taskID;
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

	/**
	 * 
	 * @param description
	 */
	public static Task Task(String description) {
		// TODO - implement Task.Task
		throw new UnsupportedOperationException("Task.Task() needs implementation");
	}

}