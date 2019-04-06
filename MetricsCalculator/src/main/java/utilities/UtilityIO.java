package utilities;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * Utility class used to read from a text file and write in a text file
 * 
 * @author Nick
 *
 */
public final class UtilityIO {

	/**
	 * Method used to read the text from a file
	 * 
	 * @param path,
	 *            the path of the file to read
	 * @return a List of the lines of the text file that is read
	 */
	public static List<String> readFile(String path) {
		File file = new File(path);
		String line;
		List<String> lines = new LinkedList<String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				lines.add(line);
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
		return lines;
	}

	/**
	 * Writes the lines of the list in a file named metrics.csv, in the path and name specified
	 * @param path,
	 *            the path of the file to read
	 * @param lines,
	 *            a List of the lines that are to be written in the file
	 */
	public static void writeFile(String path, List<String> metrics) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new File(path));
			for (String line: metrics) {
				writer.write(line);
				writer.write(System.lineSeparator());
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			writer.close();
		}
	}

}
