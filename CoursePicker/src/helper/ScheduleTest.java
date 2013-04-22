package helper;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * JUnit tests for Schedule.java
 * @author Gautam Narula
 *
 */


public class ScheduleTest {

	@Test
	/**
	 * Test parseString to make sure it correctly parses out class times
	 */
	public void testParseString() {
		Schedule schedule= new Schedule();
		
		assertEquals("Parse string 1 start",740, schedule.parseString("1220P$-0110P")[0]);
		assertEquals("Parse string 1 end",790, schedule.parseString("1220P$-0110P")[1]);
		assertEquals("Parse string 2 start 1",740, schedule.parseString("1220P$0215P-0110P$0305P")[0]);
		assertEquals("Parse string 2 end 1",790, schedule.parseString("1220P$0215P-0110P$0305P")[1]);
		assertEquals("Parse string 2 start 2", 855,schedule.parseString("1220P$0215P-0110P$0305P")[2] );
		assertEquals("Parse string 2 end 2", 905,schedule.parseString("1220P$0215P-0110P$0305P")[3] );
	}

	public void testGetSchedule() {
		
	}
	
	public void testIsConflicting(){
		
	}
}
