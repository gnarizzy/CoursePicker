package helper;

/**
 * The ID class is used to create objects from the class
 * created requirement look up table
 * 
 * @author Tyler Techo
 *
 */
public class ID {

	private String requirementID;
	private String department;
	private String courseNumber;

	/**
	 * Initializes all variables for the object
	 * @param requirementID
	 * @param department
	 * @param courseNumber
	 */
	public ID(String requirementID, String department, String courseNumber) {
		this.requirementID = requirementID;
		this.department = department;
		this.courseNumber = courseNumber;
	}

	/**
	 * @return the requirementID
	 */
	public String getRequirementID() {
		return requirementID;
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

}
