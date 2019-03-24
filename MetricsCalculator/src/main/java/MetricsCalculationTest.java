import java.util.LinkedList;
import java.util.List;

/**
 * @author Nick
 *
 */
public class MetricsCalculationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MetricsCalculation mc = new MetricsCalculation();
		List<String> lines = new LinkedList<String>();
		lines = mc.readSourceCode(args[0]);
		int[] metrics = mc.calculateMetrics(lines, args[1]);
		mc.writeToFile("metrics.csv", metrics);
	}

}
