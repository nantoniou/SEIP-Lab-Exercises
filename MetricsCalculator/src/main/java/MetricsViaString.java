import java.util.List;

/**
 * @author Nick
 *
 */
public class MetricsViaString implements SourceCodeMetrics {
	/**
	 * Method that calculates the lines of code, the number of methods and classes,
	 * from a source code file, using string comparisons
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
			if (!line.isEmpty() && !line.startsWith("//") && !line.startsWith("/*") && !line.startsWith("*")) {
				loc++;
				if (line.contains(" class ") || line.startsWith("class ")) {
					classesNum++;
				} else if ((line.contains("public") || line.contains("protected") || line.contains("static")
						|| line.contains("private")) && line.contains("{") && line.contains("(") && line.contains(")")
						&& !line.contains("=")) {
					methodsNum++;
				}
			}
		}
		int[] metrics = { loc, classesNum, methodsNum };
		return metrics;
	}

}
