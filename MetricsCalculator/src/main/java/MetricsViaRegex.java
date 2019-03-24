import java.util.List;

/**
 * Class implementation of SourceCodeMetrics, that finds the metrics using
 * regular expressions
 * 
 * @author Nick
 *
 */
public class MetricsViaRegex implements SourceCodeMetrics {
	/**
	 * Method that calculates the lines of code and the number of methods and
	 * classes, from a source code file, using regular expressions
	 * 
	 * @param code,
	 *            a List of lines of the source code
	 * @return an array of the three metrics calculated
	 */
	public int[] calculateMetrics(List<String> code) {
		int loc = 0;
		int methodsNum = 0;
		int classesNum = 0;
		for (String line : code) {
			line = line.trim();
			if (!line.isEmpty() && !line.matches("^(\\*|\\/\\*|\\/{2,}).*")) {
				loc++;
				if (line.matches(".*\\s*class\\s+.*")) {
					classesNum++;
				} else if (line.matches(
						".*(public |protected |private |static )[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*")) {
					methodsNum++;
				}
			}
		}
		int[] metrics = { loc, classesNum, methodsNum };
		return metrics;
	}

}
