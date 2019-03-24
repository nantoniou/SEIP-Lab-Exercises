/**
 * Factory class, used to create SourceCodeMetrics objects, depending on the type the user wants
 * @author Nick
 *
 */
public class SourceCodeMetricsFactory {
	/**
	 * Method used to create the requested object of SourceCodeMetrics
	 * @param metricsCalculationType, the type of string comparison to be used
	 * @return SourceCodeMetrics object
	 */
	public static SourceCodeMetrics getInstance(String metricsCalculationType) {
		SourceCodeMetrics scm = null;
		if (metricsCalculationType.equals("string")) {
			scm = new MetricsViaString();
		} else {
			scm = new MetricsViaRegex();
		}
		return scm;
	}
}
