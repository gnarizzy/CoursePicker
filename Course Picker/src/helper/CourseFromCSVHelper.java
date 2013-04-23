package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The CourseFromCSVHelper class is used as our MySQL access object
 * of the CourseFromCSV objects. This class is capable of listing
 * all of the courses in the CSV file organized into a mySql table.
 * It can also clear this table, or add new rows.
 * 
 * @author Tyler Techo
 *
 */
public class CourseFromCSVHelper {

	static String JDBC_URL = "jdbc:mysql://localhost/csci4300";

	private PreparedStatement clearCoursesStatement; //Used to clear the table
	private PreparedStatement listCoursesStatement;	 //Used to list all courses
	private PreparedStatement addCourseStatement;	//Used to add a new course

	/**
	 * The constructor initializes our connection to the database
	 * and initializes the prepared statemens to clear, or list courses
	 */
	public CourseFromCSVHelper() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC_URL, "root","mysql");

			clearCoursesStatement = conn.prepareStatement("delete from CSVCourses");
			listCoursesStatement = conn.prepareStatement("select * from CSVCourses");
			addCourseStatement = conn.prepareStatement("insert into CSVCourses(term, callNumber, coursePrefix, courseNumber, courseTitle, instructor, available, creditHours, session, days, periodBegin, periodEnd, casTaken, casReq, dasReq, totTaken, totReq, totAllow, building, room, sch, currProgram) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
/**
 * This method will list all courses in the CSV file, this method
 * is used for setting up the requirements table (Courses) that is accessed 
 * by the web pages
 * 
 * @return list this is an ArrayList of CourseFromCSV objects
 */
	public ArrayList<CourseFromCSV> getCourseFromCSVList(){
		ArrayList<CourseFromCSV> list = new ArrayList<CourseFromCSV>();
		try{
			ResultSet rs = listCoursesStatement.executeQuery();
			while (rs.next()) {
				String term = rs.getString("term");
				String callNumber = rs.getString("callNumber");
				String coursePrefix = rs.getString("coursePrefix");
				String courseNumber = rs.getString("courseNumber");
				String courseTitle = rs.getString("courseTitle");
				String instructor = rs.getString("instructor");
				String available = rs.getString("available");
				String creditHours =  rs.getString("creditHours");
				String session =  rs.getString("session");
				String days =  rs.getString("days");
				String periodBegin =  rs.getString("periodBegin");
				String periodEnd =  rs.getString("periodEnd");
				String casTaken =  rs.getString("casTaken");
				String casReq =  rs.getString("casReq");
				String dasReq =  rs.getString("dasReq");
				String totTaken =  rs.getString("totTaken");
				String totReq =  rs.getString("totReq");
				String totAllow =  rs.getString("totAllow");
				String building =  rs.getString("building");
				String room =  rs.getString("room");
				String sch =  rs.getString("sch");
				String currProgram =  rs.getString("currProgram");
				
				CourseFromCSV course = new CourseFromCSV(term, callNumber, coursePrefix, courseNumber, courseTitle, instructor, available, creditHours, session, days, periodBegin, periodEnd, casTaken, casReq, dasReq, totTaken, totReq, totAllow, building, room, sch, currProgram);
				list.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Will return a list of all courses in the 
	 * form of course objects.
	 * @return ArrayList<Course> list -- list of course objects 
	 */
	public ArrayList<Course> getCourseWithRequirementList(int id){
		ArrayList<Course> list = new ArrayList<Course>();
		try{
			ResultSet rs = listCoursesStatement.executeQuery();
			while (rs.next()) {
				if(rs.getInt("requirementID") == id){

				}
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
	 * This method will add a course to the table.
	 * @param course this is a CourseFromCSV object 
	 */
	public void addCourse(CourseFromCSV course){
		try {
			// First parameter specifies the question mark placeholder starting from index 1

			addCourseStatement.setString(1, course.getTerm());
			addCourseStatement.setString(2, course.getCallNumber());
			addCourseStatement.setString(3, course.getCoursePrefix());
			addCourseStatement.setString(4, course.getCourseNum());
			addCourseStatement.setString(5, course.getCourseTitle());
			addCourseStatement.setString(6, course.getProffessor());
			addCourseStatement.setString(7, course.getAvailable());
			addCourseStatement.setString(8, course.getCreditHours());
			addCourseStatement.setString(9, course.getSession());
			addCourseStatement.setString(10, course.getDays());
			addCourseStatement.setString(11, course.getPeriodBegin());
			addCourseStatement.setString(12, course.getPeriodEnd());
			addCourseStatement.setString(13, course.getCASTaken());
			addCourseStatement.setString(14, course.getCASReq());
			addCourseStatement.setString(15, course.getDASTaken());
			addCourseStatement.setString(16, course.getTotTaken());
			addCourseStatement.setString(17, course.getTotReq());
			addCourseStatement.setString(18, course.getTotAllow());
			addCourseStatement.setString(19, course.getBldg());
			addCourseStatement.setString(20, course.getRoom());
			addCourseStatement.setString(21, course.getSch());
			addCourseStatement.setString(22, course.getCurrentProgram());

			addCourseStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
}

