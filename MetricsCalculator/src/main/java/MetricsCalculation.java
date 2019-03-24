import java.util.LinkedList;
import java.util.List;

/**
 * Facade class, used to provide assistance in using the other classes
 * 
 * @author Nick
 *
 */
public class MetricsCalculation {
	/**
	 * Method used to read the source code from the specified path
	 * 
	 * @param path,
	 *            path of the file to read
	 * @return
	 */
	public List<String> readSourceCode(String path) {
		UtilityIO io = new UtilityIO();
		List<String> lines = io.readFile(path);
		return lines;
	}

	/**
	 * Method used to calculate the metrics of the specified file that contains the
	 * source code
	 * 
	 * @param lines,
	 *            the source code in lines
	 * @param type,
	 *            the type of string comparison to be used
	 * @return integer array with the metrics that were calculated
	 */
	public int[] calculateMetrics(List<String> lines, String type) {
		SourceCodeMetrics scm = SourceCodeMetricsFactory.getInstance(type);
		return scm.calculateMetrics(lines);
	}

	/**
	 * Method used to write the calculated metrics to a file
	 * 
	 * @param path,
	 *            path to write the file
	 * @param metrics,
	 *            integer array with the metrics to be written
	 */
	public void writeToFile(String path, int[] metrics) {
		UtilityIO io = new UtilityIO();
		List<String> metricsLine = new LinkedList<String>();
		metricsLine.add("loc,noc,nom");
		metricsLine
				.add(String.valueOf(metrics[0]) + "," + String.valueOf(metrics[1]) + "," + String.valueOf(metrics[2]));
		io.writeFile(path, metricsLine);
	}
}
