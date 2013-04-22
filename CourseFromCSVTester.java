import static org.junit.Assert.*;

import org.junit.Test;


public class CourseFromCSVTester {
/**
 * This method tests the constructor and verifies that an actual object was created (i.e. not null) and tests the values that
 * the constructor assigned to the newly created object (i.e. tests the getter methods)
 */
	@Test
	public void testConstructor() 
	{
		//Create test object
		CourseFromCSV CSVcourseOne = new CourseFromCSV("Fall 2013", "01234", "CSCI", "1301", "Introduction to Computing and Programming", "Chris Plaue", "Available", "4", "Fall 2013", "M, T, TR", "12:30", "1:45", "CASTaken", "CASReq", "DASTaken", "TotTaken", "TotReq", "TotAllow", "1023", "208", "Franklin College of Arts & Sciences", "Computer Science" );
		
		//Test if object was actually created (i.e. not null)
		assertNotNull("Test if actual object was created", CSVcourseOne);
		
		//Test various values passed to newly created object from the constructor
		assertEquals("Term validation", "Fall 2013", CSVcourseOne.getTerm());
		assertEquals("Call Number validation", "01234", CSVcourseOne.getCallNumber());
		assertEquals("Prefix validation", "CSCI", CSVcourseOne.getCoursePrefix());
		assertEquals("Course Number validation", "1301", CSVcourseOne.getCourseNum());
		assertEquals("Course Title validation", "Introduction to Computing and Programming", CSVcourseOne.getCourseTitle());
		assertEquals("Instructor validation", "Chris Plaue", CSVcourseOne.getProffessor());
		assertEquals("Course Availability validation", "Available", CSVcourseOne.getAvailable());
		assertEquals("Credit Hours validation", "4", CSVcourseOne.getCreditHours());
		assertEquals("Session validation", "Fall 2013", CSVcourseOne.getSession());
		assertEquals("Days validation", "M, T, TR", CSVcourseOne.getDays());
		assertEquals("Period begin validation", "12:30", CSVcourseOne.getPeriodBegin());
		assertEquals("Period End validation", "1:45", CSVcourseOne.getPeriodEnd());
		assertEquals("CAS Taken validation", "CASTaken", CSVcourseOne.getCASTaken());
		assertEquals("CAS Required validation", "CASReq", CSVcourseOne.getCASReq());
		assertEquals("DAS Taken validation", "DASTaken", CSVcourseOne.getDASTaken());
		assertEquals("Total Taken validation", "TotTaken", CSVcourseOne.getTotTaken());
		assertEquals("Total Required validation", "TotReq", CSVcourseOne.getTotReq());
		assertEquals("Total Allowed validation", "TotAllow", CSVcourseOne.getTotAllow());
		assertEquals("Building validation", "1023", CSVcourseOne.getBldg());
		assertEquals("Room validation", "208", CSVcourseOne.getRoom());
		assertEquals("School validation", "Franklin College of Arts & Sciences", CSVcourseOne.getSch());
		assertEquals("Current Program validation", "Computer Science", CSVcourseOne.getCurrentProgram());
		
	}

}
