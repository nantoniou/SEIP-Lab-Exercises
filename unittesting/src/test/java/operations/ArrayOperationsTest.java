package operations;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import filehandlers.*;

/**
 * Class used to Mock the FileIO and IntegerOperations classes, in order to test
 * the methods of the ArrayOperations class.
 * 
 * @author Nick
 *
 */
public class ArrayOperationsTest {
	// mocking the classes, in order to create an ArrayOperations object.
	FileIO io = mock(FileIO.class);
	IntegerOperations intOp = mock(IntegerOperations.class);
	private ArrayOperrations ao = new ArrayOperrations(io, intOp);

	/**
	 * Test method to test the normal operation of the findMaxInFile method.
	 */
	@Test
	public void findMaxInFileTestNormal() {
		when(io.readFile("")).thenReturn(new int[] { 1, 2, 3, 4 });
		Assert.assertEquals(4, ao.findMaxInFile(""));
	}

	/**
	 * Test method used to test the normal operation of the findMaxInFile method,
	 * when there are two max elements.
	 */
	@Test
	public void findMaxInFileTestTwoMax() {
		when(io.readFile("")).thenReturn(new int[] { 1, 2, 3, 3 });
		Assert.assertEquals(3, ao.findMaxInFile(""));
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * Test method used to test how the method findMaxInFile behaves when an empty
	 * array is passed.
	 */
	@Test
	public void findMaxInFileTestEmpty() {
		when(io.readFile("")).thenReturn(new int[] {});
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The array should not be empty.");
		ao.findMaxInFile("");
	}

	/**
	 * Test method used to test how the reverseArray method operates with a valid
	 * input.
	 */
	@Test
	public void reverseArrayNormal() {
		when(io.readFile("")).thenReturn(new int[] { 1, 2, 3, 4 });
		when(intOp.reverseSign(1)).thenReturn(-1);
		when(intOp.reverseSign(2)).thenReturn(-2);
		when(intOp.reverseSign(3)).thenReturn(-3);
		when(intOp.reverseSign(4)).thenReturn(-4);
		Assert.assertArrayEquals(new int[] { -1, -2, -3, -4 }, ao.reverseArray(""));
	}

	/**
	 * Test method used to test how the ReverseArray method behaves when an empty
	 * array is used as input
	 */
	@Test
	public void reverseArrayEmpty() {
		when(io.readFile("")).thenReturn(new int[] {});
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Cannot reverse the signs of an empty array");
		ao.reverseArray("");
	}

}
