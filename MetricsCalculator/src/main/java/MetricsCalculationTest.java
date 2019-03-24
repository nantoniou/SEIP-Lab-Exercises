import java.util.LinkedList;
import java.util.List;

/**
 * Class used to test the Metrics calculation module
 * @author Nick
 *
 */
public class MetricsCalculationTest {

	/**
	 * Main method that calls the facade class, in order to test the application
	 * @param args
	 */
	public static void main(String[] args) {
		MetricsCalculation mc = new MetricsCalculation();
		List<String> lines = new LinkedList<String>();
		lines = mc.readSourceCode(args[0]);
		int[] metrics = mc.calculateMetrics(lines, args[1]);
		mc.writeToFile("./metrics.csv", metrics);
	}

}
