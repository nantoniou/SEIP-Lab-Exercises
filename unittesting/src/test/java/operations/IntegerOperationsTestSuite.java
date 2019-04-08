package operations;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 * Test Suite class used to group the two test classes of the IntegerOperations class.
 * @author Nick
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({IntegerOperations_PowerOfTwo_ParameterizedTest.class, IntegerOperationsTest.class})
public class IntegerOperationsTestSuite {
	//remains empty, because the class is used as a holder for the annotations.
}
