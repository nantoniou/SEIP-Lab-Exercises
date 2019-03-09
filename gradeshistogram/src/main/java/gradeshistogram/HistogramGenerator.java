/**
 * 
 */
package gradeshistogram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;

/**
 * @author Nick
 *
 */
public class HistogramGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File(args[0]);
		String grade;
		List<Integer> grades = new LinkedList<Integer>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			while ((grade = br.readLine()) != null) {
				grades.add(Integer.parseInt(grade));
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
		generateHistogram(grades);

	}

	private static void generateHistogram(List<Integer> grades) {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries data = new XYSeries("random values");
		for (int i = 0; i < grades.size(); i++) {
			data.add(i, grades.get(i));
		}
		dataset.addSeries(data);

		boolean legend = false;
		boolean tooltips = false;
		boolean urls = false;
		
		JFreeChart chart = ChartFactory.createXYLineChart("Chart title", "x_axis title", "y_axis_title", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);
		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		frame.setVisible(true);
	}

}
