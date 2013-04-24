package helper;

import static org.junit.Assert.*;

import org.junit.Test;


public class CourseTester {

	@Test
	/**
	 * Test method to test the constructor and see if the object created actually contains the values provided to it
	 * via the constructor
	 */
	public void testConstructor() 
	{

		Course courseOne = new Course("01234", "567890", "Computer Science", "1301", "10:00-11:00", "12:30-1:45", "1:00-2:00", "12:30-1:45", "-----");

		//Asserts that the created object is in fact a non-null value (i.e. was it constructed)
		assertNotNull("Course One is instantiated", courseOne);

		//Various statements to assert the values that are contained in a course object 
		assertEquals("Requirement ID check", "01234", courseOne.getRequirementID());
		assertEquals("Call Number check", "567890", courseOne.getCallNumber());
		assertEquals("Department check", "Computer Science", courseOne.getDepartment());
		assertEquals("Course Number Check", "1301", courseOne.getCourseNumber());
		assertEquals("Monday Time check", "10:00-11:00", courseOne.getMonday());
		assertEquals("Tuesday Time check", "12:30-1:45", courseOne.getTuesday());
		assertEquals("Wednesday Time check", "1:00-2:00", courseOne.getWednesday());
		assertEquals("Thursday Time check", "12:30-1:45", courseOne.getThursday());
		assertEquals("Friday Time  check", "-----", courseOne.getFriday());


	}

}