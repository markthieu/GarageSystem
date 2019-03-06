package tft_garits.Documents;

public class Report {

	private Date issueDate;
	private String contents;

	public Date getIssueDate() {
		return this.issueDate;
	}

	/**
	 * 
	 * @param issueDate
	 */
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
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

	/**
	 * 
	 * @param contents
	 */
	public static Report Report(String contents) {
		// TODO - implement Report.Report
		throw new UnsupportedOperationException("Report.Report() needs implementation");
	}

}