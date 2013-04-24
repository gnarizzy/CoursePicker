package helper;
import static org.junit.Assert.*;

import java.util.ArrayList;

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
@Test
/**
 * Tests deleteCourse to ensure that it deletes the correct course
 */
	public void testDeleteCourse() {
		Course course1= new Course("2","123","MIST","1312", "01:15P-02:30P","", "01:15P-02:30P","","03:20P-3:40P");
		Course course2= new Course("4","152","PHIL","2000H", "02:31P-02:45P","", "03:15P-03:30P","","03:45P-3:50P");
		Schedule schedule= new Schedule();
		try {
			schedule.addCourse(course1);
			schedule.addCourse(course2);
		} catch (ScheduleException e) {
	
		}
		assertEquals("Initial size", 2, schedule.getSchedule().size());
		schedule.deleteCourse("555");//dummy course that doesn't exist in schedule
		assertEquals("After fake delete", 2, schedule.getSchedule().size());
		schedule.deleteCourse("123");
		assertEquals("Delete first course", 1, schedule.getSchedule().size());
		schedule.deleteCourse("152");
		assertEquals("Delete second course", 0, schedule.getSchedule().size());
		
	}
	@Test
	/**
	 * Tests that ensure the courses/times in the schedule are correct
	 */
	public void testSchedule() {
		Course course1= new Course("2","123","MIST","1312", "01:15P-02:30P","", "01:15P-02:30P","","03:20P-3:40P");
		Course course2= new Course("4","152","PHIL","2000H", "02:31P-02:45P","", "03:15P-03:30P","","03:45P-3:50P");
		Schedule schedule= new Schedule();
		try {
			schedule.addCourse(course1);
			schedule.addCourse(course2);
		} catch (ScheduleException e) {
	
		}
		ArrayList<ScheduleCourse> courses=schedule.getSchedule();
		 
		assertEquals("course1 start",5.25, courses.get(0).getMonday()[0],.001);
		assertEquals("course1 end",6.5, courses.get(0).getMonday()[1],.001);
		assertEquals("course2 start",6.5166, courses.get(1).getMonday()[0],.001);
		assertEquals("course2 end",6.75, courses.get(1).getMonday()[1],.001);
		assertEquals("course1 call number","123", courses.get(0).getCallNumber());
		assertEquals("course2 call number","152", courses.get(1).getCallNumber());
		
	}
	@Test
	/**
	 * Tests addCourse to make sure it correctly identifies conflicting courses
	 */
	public void testAddCourse(){
		Course course1= new Course("1","123","CSCI","1212", "11:05A-12:05P","", "11:05A-12:05P","","11:05A-12:05P");
		Course course2= new Course("1","123","CSCI","1212", "11:15A-12:05P","", "11:15A-12:05P","","11:15A-12:05P");
		Course course3= new Course("2","123","MIST","1312", "01:15P-02:30P","", "01:15P-02:30P","","03:20P-3:40P");
		Course course4= new Course("4","152","PHIL","2000H", "02:31P-02:45P","", "03:15P-03:30P","","03:15P-3:30P");
		Course course5= new Course("5", "145","POLS","4300","07:00A-07:50A\n08:00A-08:50A","06:45P-07:15P","","","05:15P-06:00P");
		Course course6= new Course("6", "531", "CMLT", "2100", "07:45A-8:15A","","","","");
		Schedule schedule= new Schedule();
		try{
		schedule.addCourse(course1);
		schedule.addCourse(course2);
		}
		catch (Exception e){
			System.out.println("This better print!");
			System.out.println(e.getMessage());
		}
		assertEquals("Course conflict 1",1,schedule.getSchedule().size());
		try {
			schedule.addCourse(course3);
		} catch (ScheduleException e) {
			
		}
		assertEquals("Course no conflict 2", 2,schedule.getSchedule().size());
		try {
			schedule.addCourse(course4);
		} catch (ScheduleException e) {
			
		}
		assertEquals("Course conflict 4",2, schedule.getSchedule().size());
		try {
			schedule.addCourse(course5);
			schedule.addCourse(course6);
		} catch (ScheduleException e) {
			
		}
		
		assertEquals("Course conflict 6 with multi-meeting time conflict",3,schedule.getSchedule().size());
	}
}
