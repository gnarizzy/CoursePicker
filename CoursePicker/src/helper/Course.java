package helper;

/**
 * The Course class is a class that is used to 
 * store information about an individual course
 * so that the webpage can access this information 
 * and display it.
 * 
 * @author Tyler Techo
 *
 */
public class Course {
	private String requirementID;
	private String callNumber;
	private String department;
	private String courseNumber;
	private String monday;
	private String tuesday;
	private String wednesday;
	private String thursday;
	private String friday;

	/**
	 * Constructor will initialize the Course object
	 * @param requirementID requirement id for course
	 * @param callNumber course call number
	 * @param department department offering course
	 * @param courseNumber course number
	 * @param monday time meeting on Mondays
	 * @param tuesday time meeting on Tuesdays
	 * @param wednesday time meeting on Wednesdays
	 * @param thursday time meeting on Thursdays
	 * @param friday time meeting on Fridays
	 */
	public Course(String requirementID, String callNumber, String department, String courseNumber,
			String monday, String tuesday, String wednesday, String thursday,
			String friday) {
		
		this.requirementID = requirementID;
		this.callNumber = callNumber;
		this.department = department;
		this.courseNumber = courseNumber;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
	}

	/**
	 * @return the callNumber
	 */
	public String getCallNumber() {
		return callNumber;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @return the courseNumber
	 */
	public String getCourseNumber() {
		return courseNumber;
	}

	/**
	 * @return the Monday meeting time
	 */
	public String getMonday() {
		return monday;
	}

	/**
	 * @return the Tuesday meeting time
	 */
	public String getTuesday() {
		return tuesday;
	}

	/**
	 * @return the Wednesday meeting time
	 */
	public String getWednesday() {
		return wednesday;
	}

	/**
	 * @return the Thursday meeting time
	 */
	public String getThursday() {
		return thursday;
	}

	/**
	 * @return the Friday meeting time
	 */
	public String getFriday() {
		return friday;
	}

	/**
	 * @return the requirementID
	 */
	public String getRequirementID() {
		return requirementID;
	}

}
