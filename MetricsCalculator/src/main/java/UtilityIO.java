import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public final class UtilityIO {

	public List<String> readFile(String path) {
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

	public void writeFile(String path, List<String> lines) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new File("metrics.csv"));
			StringBuilder sb = new StringBuilder();
			sb.append(lines.get(0));
			sb.append(',');
			sb.append(lines.get(1));
			sb.append(',');
			sb.append(lines.get(2));

			writer.write(sb.toString());

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			writer.close();
		}
	}

}
