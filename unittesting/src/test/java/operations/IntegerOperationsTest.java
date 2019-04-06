package operations;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Class used to test the IntegerOperations class.
 * @author Nick
 *
 */
public class IntegerOperationsTest {
	public IntegerOperations intOp = new IntegerOperations();

	/**
	 * Method used to test the behaviour of the IntegerOperations.reverseSign method
	 * when passing a positive number.
	 */
	@Test
	public void testReverseSignPositive() {
		Assert.assertEquals(-2, intOp.reverseSign(2));
	}

	/**
	 * Method used to test the behaviour of the IntegerOperations.reverseSign method
	 * when passing a negative number.
	 */
	@Test
	public void testReverseSignNegative() {
		Assert.assertEquals(2, intOp.reverseSign(-2));
	}
	
	/**
	 * Method used to test the behaviour of the IntegerOperations.reverseSign method
	 * when passing zero.
	 */
	@Test
	public void testReverseSignZero() {
		Assert.assertEquals(0, intOp.reverseSign(0));
	}
	
	/**
	 * Method used to test the behaviour of the IntegerOperations.add method
	 * when passing valid input.
	 */
	@Test
	public void testAddNormal() {
		Assert.assertEquals(2, intOp.add(1, 1));
	}
	
	/**
	 * Method used to test the behaviour of the IntegerOperations.add method
	 * when passing an almost invalid (too big) input.
	 */
	@Test
	public void testAddAlmostMaxInteger() {
		Assert.assertEquals(Integer.MAX_VALUE, intOp.add(Integer.MAX_VALUE - 1, 1));
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * Method used to test the behaviour of the IntegerOperations.add method
	 * when passing a negative number as input.
	 */
	@Test
	public void testAddNegative() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input numbers should be positive.");
		intOp.add(-1, 1);
	}
	
	/**
	 * Method used to test the behaviour of the IntegerOperations.add method
	 * when passing values that will overflow when added.
	 */
	@Test
	public void testAddMaxInteger() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Cannot fit the result in an Integer.");
		intOp.add(Integer.MAX_VALUE, 1);
	}
	
	/**
	 * Method used to test the behaviour of the IntegerOperations.powerOfTwo method
	 * when passing a negative number.
	 */
	@Test
	public void testPowerOfTwoNotPositive() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("-1 is not a positive integer.");
		intOp.powerOfTwo(-1);
	}
	
	/**
	 * Method used to test the behaviour of the IntegerOperations.add method
	 * when passing a number that will cause an integer overflow.
	 */
	@Test
	public void testPowerOfTwoOverflow() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("31^2 causes an integer overflow.");
		intOp.powerOfTwo(31);
	}
	
}
