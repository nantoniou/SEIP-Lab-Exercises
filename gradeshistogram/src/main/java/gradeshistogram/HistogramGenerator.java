package gradeshistogram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;

/**
 * Class that is responsible for reading grades from a user's file and making a
 * graph with them.
 * 
 * @author Nick
 *
 */
public class HistogramGenerator {

	/**
	 * Main method that reads the grades.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File(args[0]);
		String grade;
		BufferedReader br = null;
		int[] gradesArray = new int[11];
		try {
			br = new BufferedReader(new FileReader(file));
			while ((grade = br.readLine()) != null) {
				gradesArray[Integer.parseInt(grade)]++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		generateHistogram(gradesArray);

	}

	/**
	 * Method used to create the graph.
	 * 
	 * @param grades
	 */
	private static void generateHistogram(int[] grades) {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries data = new XYSeries("grades");
		for (int i = 0; i < grades.length; i++) {
			data.add(i, grades[i]);
		}
		dataset.addSeries(data);

		boolean legend = false;
		boolean tooltips = false;
		boolean urls = false;

		JFreeChart chart = ChartFactory.createXYLineChart("Grades frequency", "grades", "frequency", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);
		ChartFrame frame = new ChartFrame("Frame", chart);
		frame.pack();
		frame.setVisible(true);
	}

}
