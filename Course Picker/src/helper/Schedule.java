package helper;


import java.util.ArrayList;

/**
 * Manages the users schedule in session scope, and deals with any conflicts
 * 
 * @author Gautam Narula
 * 
 */

/*
 * addCourse will call parseString on each day within a course, to extract the
 * times, in minutes. These will then be compared to the five day slots in the
 * Schedule ArrayList. If there is a conflict, a ScheduleException will be
 * thrown (which can be handled by the Controller). If not, it will be added to
 * the appropriate day slot in the Schedule ArrayList.
 */
public class Schedule {

	ArrayList<ScheduleCourse> schedule;

	/**
	 * Constructor that instantiates the schedule arraylist
	 */
	public Schedule() {
		schedule = new ArrayList<ScheduleCourse>();
	}

	/**
	 * Adds a course to the schedule, unless there is a conflict
	 * 
	 * @throws ScheduleException
	 */
	public void addCourse() throws ScheduleException {

	}

	/**
	 * Deletes the course with given call number
	 * 
	 * @param callNumber
	 *            The call number of the course to delete
	 */
	public void deleteCourse(String callNumber) {

	}

	/**
	 * Getter for the current schedule
	 * 
	 * @return the current schedule
	 */
	public ArrayList<ScheduleCourse> getSchedule() {
		return schedule;
	}

	/**
	 * 
	 * @param input
	 * @return array of integers representing start and end times, in minutes
	 */
	public int[] parseString(String input) {
		
		if (input.length() <= 13) // class only meets one time per day, since
									// string is <= 13 characters long
		{
			int[] times=new int[2];
			String[] tokens = input.split("-"); // splits into beginning and end
												// times
			System.out.println("The beginning token is " + tokens[0]);
			String[] beginTokens = tokens[0].split(":"); // splits start time
															// into hours and
															// minutes
			System.out.println("The end token is "+tokens[1]);
			String[] endTokens = tokens[1].split(":");
			try {
				int hours = Integer.parseInt(beginTokens[0]);
				int endHours= Integer.parseInt(endTokens[0]);
				System.out.println("Hours is " + hours);
				System.out.println("End hours is "+ endHours);
				int minutes = Integer.parseInt(beginTokens[1].substring(0,
						beginTokens[1].length() - 1));
				int endMinutes= Integer.parseInt(endTokens[1].substring(0,endTokens[1].length()-1));
				System.out.println("Minutes is " + minutes);
				System.out.println("End minutes is "+endMinutes);
				times[0] = 60 * hours + minutes;
				times[1] = 60 * endHours + endMinutes;
				if (beginTokens[1].contains("P")&& hours!=12) // PM class that is not 12:XX
					times[0] += (12 * 60); // adds minutes for first 12 hours of
											// the day
				if (endTokens[1].contains("P")&& endHours!=12) // PM class that is not 12:XX
					times[1] += (12*60);
			} catch (NumberFormatException e) {
				System.out.println("Number Format error in parsing string "
						+ e.getMessage());
			} catch (Exception e) {
				System.out.println("Unknown error in parsing string "
						+ e.getMessage());
			}
				return times;
		} else // class meets multiple times per day, since string is >13
				// characters long
		{
			String[] classTokens=input.split("\\n");
			System.out.println("Input was more than 13?");
			int times[]= new int[classTokens.length*2];
			System.out.println("The length of times is "+times.length);
			int counter=0;
			for(String classTime : classTokens) {
				String[] tokens= classTime.split("-");
				System.out.println("The beginning token is "+tokens[0]);
				String[] beginTokens = tokens[0].split(":"); // splits start time
				// into hours and
				// minutes
				System.out.println("The end token is "+tokens[1]);
				String[] endTokens = tokens[1].split(":");
				try {
					int hours = Integer.parseInt(beginTokens[0]);
					int endHours= Integer.parseInt(endTokens[0]);
					System.out.println("Hours is " + hours);
					System.out.println("End hours is "+ endHours);
					int minutes = Integer.parseInt(beginTokens[1].substring(0,
							beginTokens[1].length() - 1));
					int endMinutes= Integer.parseInt(endTokens[1].substring(0,endTokens[1].length()-1));
					System.out.println("Minutes is " + minutes);
					System.out.println("End minutes is "+endMinutes);
					times[counter] = 60 * hours + minutes;
					times[counter+1] = 60 * endHours + endMinutes;
					if (beginTokens[1].contains("P")&& hours!=12) // PM class that is not 12:XX
						times[counter] += (12 * 60); // adds minutes for first 12 hours of
												// the day
					if (endTokens[1].contains("P")&& endHours!=12) // PM class that is not 12:XX
						times[counter+1] += (12*60);
				} catch (NumberFormatException e) {
					System.out.println("Number Format error in parsing string "
							+ e.getMessage());
				} //catch (Exception e) {
					//System.out.println("Unknown error in parsing string "
					//		+ e.getMessage());
				//}
				counter=counter+2;
			}
			return times;
		} 
		 

	}

	/**
	 * Helper method that checks if the most recently added course conflicts
	 * with the current schedule
	 * 
	 * @return
	 */
	public boolean isConflicting() {
		return true;
	}
}
