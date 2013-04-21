package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class is used to add, remove, and list courses from the Courses table.
 * This is the class that interacts the most with the webpage.
 * 
 * @author Tyler Techo
 * 
 */
public class CourseHelper {

	static String JDBC_URL = "jdbc:mysql://localhost/csci4300";

	private PreparedStatement clearCoursesStatement; // Clear all courses from the table
														
	private PreparedStatement listCoursesStatement; // lists all courses from the table
													
	private PreparedStatement addCourseStatement; // Add a course to the table

	/**
	 * public constructor ScheduleHelper will be used to make a connection to
	 * the mysql database and initialize the prepared statements
	 */
	public CourseHelper() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC_URL, "root",
					"mysql");

			clearCoursesStatement = conn
					.prepareStatement("delete from Courses");
			listCoursesStatement = conn
					.prepareStatement("select requirementID, callNumber, department, courseNumber, monday, tuesday, wednesday, thursday, friday from Courses");
			addCourseStatement = conn
					.prepareStatement("insert into Courses(requirementID, callNumber, department, courseNumber, monday, tuesday, wednesday, thursday, friday) values(?, ?, ?, ?, ?, ?, ?, ?, ?)");

		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	/**
	 * Will return a list of all courses in the form of course objects. The
	 * objects in the list all will have the requested requirement ID.
	 * 
	 * @return ArrayList<Course> list -- list of course objects
	 */
	public ArrayList<Course> getCourseWithRequirementList(int id) {
		ArrayList<Course> list = new ArrayList<Course>();
		try {
			ResultSet rs = listCoursesStatement.executeQuery();
			while (rs.next()) {
				if (rs.getInt("requirementID") == id) {
					String requirementID = rs.getString("requirementID");
					String callNumber = rs.getString("callNumber");
					String department = rs.getString("department");
					String courseNumber = rs.getString("courseNumber");
					String monday = rs.getString("monday");
					String tuesday = rs.getString("tuesday");
					String wednesday = rs.getString("wednesday");
					String thursday = rs.getString("thursday");
					String friday = rs.getString("friday");
					Course course = new Course(requirementID, callNumber,
							department, courseNumber, monday, tuesday,
							wednesday, thursday, friday);
					list.add(course);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Will return an array list of all Course objects in the table
	 * 
	 * @return list - the list of all course Objects in the table
	 */
	public ArrayList<Course> getCourseList() {
		ArrayList<Course> list = new ArrayList<Course>();
		try {
			ResultSet rs = listCoursesStatement.executeQuery();
			while (rs.next()) {
				String requirementID = rs.getString("requirementID");
				String callNumber = rs.getString("callNumber");
				String department = rs.getString("department");
				String courseNumber = rs.getString("courseNumber");
				String monday = rs.getString("monday");
				String tuesday = rs.getString("tuesday");
				String wednesday = rs.getString("wednesday");
				String thursday = rs.getString("thursday");
				String friday = rs.getString("friday");
				Course course = new Course(requirementID, callNumber,
						department, courseNumber, monday, tuesday, wednesday,
						thursday, friday);
				list.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * This method is used to clear the list of courses.
	 */
	public void clearCourses() {
		try {
			clearCoursesStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	/**
	 * This method is used to add a course to the table.
	 * 
	 * @param course
	 *            - course object that contains all of the information needed to
	 *            fill in the table columns
	 */
	public void addCourse(Course course) {
		try {
			// First parameter specifies the question mark placeholder starting
			// from index 1
			addCourseStatement.setString(1, course.getRequirementID());
			addCourseStatement.setString(2, course.getCallNumber());
			addCourseStatement.setString(3, course.getDepartment());
			addCourseStatement.setString(4, course.getCourseNumber());
			addCourseStatement.setString(5, course.getMonday());
			addCourseStatement.setString(6, course.getTuesday());
			addCourseStatement.setString(7, course.getWednesday());
			addCourseStatement.setString(8, course.getThursday());
			addCourseStatement.setString(9, course.getFriday());

			addCourseStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	/**
	 * Will return a Course object via the call Number from the table
	 * 
	 * @return list - the list of all course Objects in the table
	 */
	public Course getCourse(String call) {
		// ArrayList<Course> list = new ArrayList<Course>();
		try {
			ResultSet rs = listCoursesStatement.executeQuery();
			while (rs.next()) {
				if (rs.getString("callNumber").equals(call)) {
					String requirementID = rs.getString("requirementID");
					String callNumber = rs.getString("callNumber");
					String department = rs.getString("department");
					String courseNumber = rs.getString("courseNumber");
					String monday = rs.getString("monday");
					String tuesday = rs.getString("tuesday");
					String wednesday = rs.getString("wednesday");
					String thursday = rs.getString("thursday");
					String friday = rs.getString("friday");
					Course course = new Course(requirementID, callNumber,
							department, courseNumber, monday, tuesday,
							wednesday, thursday, friday);

					return course;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
