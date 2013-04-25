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
	int[] mOccupiedMinutes;
	int[] tOccupiedMinutes;
	int[] wOccupiedMinutes;
	int[] thOccupiedMinutes;
	int[] fOccupiedMinutes;
	/**
	 * Constructor that instantiates the schedule arraylist and the internal array for checking conflicts
	 */
	public Schedule() {
		schedule = new ArrayList<ScheduleCourse>();
		mOccupiedMinutes= new int[1440];
		tOccupiedMinutes= new int[1440];
		wOccupiedMinutes= new int[1440];
		thOccupiedMinutes= new int[1440];
		fOccupiedMinutes= new int[1440];
	}

	/**
	 * Adds a course to the schedule, unless there is a conflict
	 * 
	 * @throws ScheduleException Exception thrown when there is a conflict
	 */
	public void addCourse(Course newCourse) throws ScheduleException {
		String monday = newCourse.getMonday();
		String tuesday = newCourse.getTuesday();
		String wednesday = newCourse.getWednesday();
		String thursday = newCourse.getThursday();
		String friday = newCourse.getFriday();
		String[] classTimes={monday,tuesday,wednesday,thursday,friday};
		String[] days={"Monday","Tuesday","Wednesday","Thursday","Friday"};
		int counter=0;
		for (String classTime :classTimes){ //checks for conflict on current day
			int[] times=parseString(classTime);
			if (isConflicting(times, days[counter]))
				throw new ScheduleException("Conflict on "+ days[counter]);
			counter++;
		}
		for (int j=0;j<classTimes.length;j++){ //Adds course times to internal representation to check for future conflicts
			int[] times=parseString(classTimes[j]);
			if (times.length==1)//class doesn't meet that day
				continue;
			for (int i=0;i<times.length;i++)
			{
				if(i%2==1)//an end time
				{
					if (j==0){
						for (int k=times[i-1];k<=times[i];k++)
							mOccupiedMinutes[k]=1; //flips the index of minutes occupied by class from 0 to 1		
					}
					else if (j==1) {
						for (int k=times[i-1];k<=times[i];k++)
							tOccupiedMinutes[k]=1;
					}
					else if (j==2) {
						for (int k=times[i-1];k<=times[i];k++)
							wOccupiedMinutes[k]=1;
					}
					else if (j==3) {
						for (int k=times[i-1];k<=times[i];k++)
							thOccupiedMinutes[k]=1;
					}
					else if (j==4) {
						for (int k=times[i-1];k<=times[i];k++)
							fOccupiedMinutes[k]=1;
					}
				}
					
			}
		}
		
		schedule.add(new ScheduleCourse(newCourse.getCallNumber(),newCourse.getDepartment(),newCourse.getCourseNumber(), parseString(monday), parseString(tuesday), parseString(wednesday),parseString(thursday), parseString(friday)));
		
	}

	/**
	 * Deletes the course with given call number
	 * 
	 * @param callNumber
	 *            The call number of the course to delete
	 */
	public void deleteCourse(String callNumber) {
		
		for (ScheduleCourse course : schedule){ //checks if a course in the schedule is the course to be deleted. If so, it is deleted. 
			if(callNumber.equals(course.getCallNumber())) {
				schedule.remove(course);
				int[] mon=course.getmTimes();
				int[] tue=course.gettTimes();
				int[] wed=course.getwTimes();
				int[] thu=course.getThTimes();
				int[] fri=course.getfTimes();
				
				if(mon.length!=1) //class meets on Monday
					for(int i=0;i<mon.length;i++)
						if (i%2==1) //end time
							for(int j=mon[i-1];j<=mon[i];j++)
								mOccupiedMinutes[j]=0;
				if(tue.length!=1) //class meets on Tuesday
					for(int i=0;i<tue.length;i++)
						if (i%2==1) //end time
							for(int j=tue[i-1];j<=tue[i];j++)
								tOccupiedMinutes[j]=0;
				if(wed.length!=1) //class meets on Wednesday
					for(int i=0;i<wed.length;i++)
						if (i%2==1) //end time
							for(int j=wed[i-1];j<=wed[i];j++)
								wOccupiedMinutes[j]=0;
				if(thu.length!=1) //class meets on Thursday
					for(int i=0;i<thu.length;i++)
						if (i%2==1) //end time
							for(int j=thu[i-1];j<=thu[i];j++)
								thOccupiedMinutes[j]=0;
				if(fri.length!=1) //class meets on Friday
					for(int i=0;i<fri.length;i++)
						if (i%2==1) //end time
							for(int j=fri[i-1];j<=fri[i];j++)
								fOccupiedMinutes[j]=0;
					
				
				
				break;
				}
							
				
				
				}
				
				
				 //break statement required to avoid concurrentmodificationexception!
		
		
		
			//TODO- remove class from internal array representation to avoid incorrect conflicts!
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
	 * @param input The input class meeting time
	 * @return array of integers representing start and end times, in minutes
	 */
	public int[] parseString(String input) {
		if (input.length()==0) //empty string, meaning class does not meet that day
		{
			int[] empty={0};
			return empty;
		}
		if (input.length() <= 13) // class only meets one time per day, since
									// string is <= 13 characters long
		{
			int[] times=new int[2];
			String[] tokens = input.split("-"); // splits into beginning and end
												// times
			
			String[] beginTokens = tokens[0].split(":"); // splits start time
															// into hours and
															// minutes
			
			String[] endTokens = tokens[1].split(":");
			try {
				int hours = Integer.parseInt(beginTokens[0]);
				int endHours= Integer.parseInt(endTokens[0]);
				
				int minutes = Integer.parseInt(beginTokens[1].substring(0,
						beginTokens[1].length() - 1));
				int endMinutes= Integer.parseInt(endTokens[1].substring(0,endTokens[1].length()-1));
		
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
			
			int times[]= new int[classTokens.length*2];
						int counter=0;
			for(String classTime : classTokens) {
				String[] tokens= classTime.split("-");
				
				String[] beginTokens = tokens[0].split(":"); // splits start time
				// into hours and
				// minutes
			
				String[] endTokens = tokens[1].split(":");
				try {
					int hours = Integer.parseInt(beginTokens[0]);
					int endHours= Integer.parseInt(endTokens[0]);
					
					int minutes = Integer.parseInt(beginTokens[1].substring(0,
							beginTokens[1].length() - 1));
					int endMinutes= Integer.parseInt(endTokens[1].substring(0,endTokens[1].length()-1));
					
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
				} catch (Exception e) {
					System.out.println("Unknown error in parsing string "
							+ e.getMessage());
				}
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
	private boolean isConflicting(int[] times, String day) {
		for (int i=0;i<times.length;i++)
			if (i%2==1)//end time
				for (int j=times[i-1];j<=times[i];j++){
					if (day.equals("Monday")) {
						if (mOccupiedMinutes[j]==1)
							return true; 
					}
					if (day.equals("Tuesday")) {
						if (tOccupiedMinutes[j]==1)
							return true; 
					}
					if (day.equals("Wednesday")) {
						if (wOccupiedMinutes[j]==1)
							return true; 
					}
					if (day.equals("Thursday")) {
						if (thOccupiedMinutes[j]==1)
							return true; 
					}
					if (day.equals("Friday")) {
						if (fOccupiedMinutes[j]==1)
							return true; 
					}
					
						
				}
					
					
					
					
		return false;
	}
}
