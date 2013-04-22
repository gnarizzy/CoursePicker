package helper;

import java.util.ArrayList;

/**
 * Manages the users schedule in session scope, and deals with any conflicts
 * @author Gautam Narula
 *
 */

/*
 * addCourse will call parseString on each day within a course, to extract the times, in minutes. 
 * These will then be compared to the five day slots in the Schedule ArrayList. If there is a conflict, 
 * a ScheduleException will be thrown (which can be handled by the Controller). If not, it will be added
 * to the appropriate day slot in the Schedule ArrayList. 
 */
public class Schedule {
	
 ArrayList<boolean[]> schedule;
	/**
	 * Constructor that instantiates the schedule arraylist
	 */
	public Schedule() {
		schedule= new ArrayList<boolean[]>();
	}
	/**
	 * Adds a course to the schedule, unless there is a conflict
	 * @throws ScheduleException
	 */
	public void addCourse() throws ScheduleException{
		
		
	}
	
	public ArrayList<boolean[]> getSchedule() {
		return schedule;
	}
	/**
	 * 
	 * @param input
	 * @return array of integers representing start and end times, in minutes
	 */
	public int[] parseString(String input) {
		if(input.length()<=11) //class only meets one time per day, since string is <= 11 characters long
		{
			String[] tokens=input.split("\\$-");
			if(tokens[0].contains("P")) { //PM class
			   tokens[0].replace("P","");
			try {
				int start=Integer.parseInt(tokens[0]);
				int end= Integer.parseInt(tokens[1]);
				int startMinutes=  ((start/1000)+ ((start%1000)/100)+((start%1000)%100))*60;
				int endMinutes= ( (end/1000)+ ((start%1000)/100)+ ((start%1000)%100))*60;
				int[] times= {startMinutes, endMinutes};
				return times;
			}
			catch (NumberFormatException e)
			{
				System.out.println(e.getMessage());
			}
		}
		}
		else //class meets multiple times per day, since string is >11 characters long
			return new int[2]; //dummy return statement 
		return new int[2]; //dummy return statement
		
	}
	
	public boolean isConflicting(){
		return true;
	}
}
