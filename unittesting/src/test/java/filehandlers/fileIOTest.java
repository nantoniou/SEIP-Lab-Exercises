package filehandlers;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Class used to test the FileIO class, by passing valid, invalid
 * (containing a String) files and by trying to read non-existent files.
 * 
 * @author Nick
 *
 */
public class fileIOTest {
	FileIO io = new FileIO();

	/**
	 * Method used to test the normal behaviour of the FileIO.readFile method.
	 */
	@Test
	public void testReadFileValid() {
		int[] numbers = { 1, 2, 3, 4 };
		Assert.assertArrayEquals(numbers, io.readFile("src/test/resources/valid.txt"));
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * Method used to test the behaviour of the FileIO.readFile method, in case it
	 * tries to read a file that contains a String character.
	 */
	@Test
	public void testReadFileWrongNumberFormat() {
		thrown.expect(NumberFormatException.class);
		io.readFile("src/test/resources/invalid.txt");
	}

	/**
	 * Method used to test the behaviour of the FileIO.readFile method, in case it
	 * tries to read a non-existent file.
	 */
	@Test
	public void testReadFileNotExists() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("File file does not exist");
		io.readFile("file");
	}
}
