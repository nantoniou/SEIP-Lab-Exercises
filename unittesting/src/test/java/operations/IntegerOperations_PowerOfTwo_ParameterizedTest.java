package operations;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * Parameterized test class used to test the
 * {@link IntegerOperations#powerOfTwo(int) PowerOfTwo} method.
 * 
 * @author Nick
 *
 */
@RunWith(Parameterized.class)
public class IntegerOperations_PowerOfTwo_ParameterizedTest {

	@Parameter(0)
	public int power;
	@Parameter(1)
	public int result;

	public IntegerOperations intOp = new IntegerOperations();

	/**
	 * Method used to create the values that will test the method
	 * @return the values
	 */
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { 0, 1 }, { 1, 2 }, { 4, 16 }, { 30, 1073741824} };

		return Arrays.asList(data);
	}

	/**
	 * Test method for the PowerOfTwo method, using the values above.
	 */
	@Test
	public void testPowerOfTwoWithNormalCases() {
		Assert.assertEquals(result, intOp.powerOfTwo(power));
	}
}
