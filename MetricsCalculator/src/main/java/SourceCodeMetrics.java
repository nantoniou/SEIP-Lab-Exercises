import java.util.List;

/**
 * Interface used for calculating the metrics of a source code file, given as input.
 * @author Nick
 *
 */
public interface SourceCodeMetrics {
	
	/**
	 * Public method used to calculate the metrics
	 * @param code, a List of lines of the source code
	 * @return a list og Integers with the values of the metrics calculated
	 */
	public List<Integer> calculateMetrics(List<String> code);
}
