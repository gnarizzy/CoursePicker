package helper;
import static org.junit.Assert.*;

import org.junit.Test;


public class IDTester {
/**
 * Tests whether or not the constructor actually creates an ID object and if the newly created ID object contains any
 * information (i.e. not null) and compares the values passed from the constructor to the newly created ID object to the 
 * expected values they should contain
 */
	@Test
	public void testConstructor() 
	{

		//Creates a new ID object for testing
		ID courseID = new ID("012345", "Computer Science", "1301");

		//Tests to see if the newly created ID object is null or not
		assertNotNull("Tests to see if the newly created ID object is not null", courseID);

		//Tests the values passed by the constructor to the object under consideration to see if they match up against expected values

		assertEquals("Requirement ID Validation", "012345", courseID.getRequirementID());
		assertEquals("Department Validation", "Computer Science", courseID.getDepartment());
		assertEquals("Course Number Validation", "1301", courseID.getCourseNumber());


	}

}