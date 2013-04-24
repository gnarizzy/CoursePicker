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
		
		assertEquals("Parse string 1 start",675, schedule.parseString("11:15A-12:05P")[0]);
	    assertEquals("Parse string 1 end",725, schedule.parseString("11:15A-12:05P")[1]);
	    assertEquals("Parse string 2 start 1",675, schedule.parseString("11:15A-12:05P\n06:00P-06:50P")[0]);
	    assertEquals("Parse string 2 end 1",725, schedule.parseString("11:15A-12:05P\n06:00P-06:50P")[1]);
	    assertEquals("Parse string 2 start 2", 1080,schedule.parseString("11:15A-12:05P\n06:00P-06:50P")[2] );
	    assertEquals("Parse string 2 end 2", 1130,schedule.parseString("11:15A-12:05P\n06:00P-06:50P")[3] );
		assertEquals("Parse string 3 start", 795, schedule.parseString("1:15P-2:30P")[0]);
		assertEquals("Parse string 3 end", 870, schedule.parseString("1:15P-2:30P")[1]);
	}

	public void testGetSchedule() {
		
	}
	
	public void testIsConflicting(){
		
	}
}
