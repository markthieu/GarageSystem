package tft_garits.Documents;

public class StockReport extends Report {

	private String reportPeriod;

	/**
	 * 
	 * @param contents
	 */
	public Report generateReport(String contents) {
		// TODO - implement StockReport.generateReport
		throw new UnsupportedOperationException("StockReport.generateReport() needs implementation");
	}

	public String getReportPeriod() {
		return this.reportPeriod;
	}

	/**
	 * 
	 * @param reportPeriod
	 */
	public void setReportPeriod(String reportPeriod) {
		this.reportPeriod = reportPeriod;
	}

	/**
	 * 
	 * @param contents
	 */
	public static StockReport StockReport(String contents) {
		// TODO - implement StockReport.StockReport
		throw new UnsupportedOperationException("StockReport.StockReport() needs implementation");
	}

}