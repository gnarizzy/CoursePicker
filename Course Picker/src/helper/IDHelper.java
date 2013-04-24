package helper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The class IDHelper is used to view courses from the ID table on the database
 * 
 * @author Tyler Techo
 *
 */
public class IDHelper {

	static String JDBC_URL = "jdbc:mysql://localhost/csci4300";

	private PreparedStatement listCoursesStatement;	

	/**
	 * Initializes the connection to the database and the prepared statement
	 */
	public IDHelper() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC_URL, "root","mysql");

			listCoursesStatement = conn.prepareStatement("select requirementID, department, courseNumber from ID");


		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	/**
	 * Will return a list of all courses in the 
	 * form of course objects.
	 * @return ArrayList<Course> list -- list of course objects 
	 */
	public ArrayList<ID> getCourseWithRequirementList(){
		ArrayList<ID> list = new ArrayList<ID>();
		try{
			ResultSet rs = listCoursesStatement.executeQuery();
			while (rs.next()) {
				String requirementID = rs.getString("requirementID");
				String department = rs.getString("department");
				String courseNumber = rs.getString("courseNumber");
				ID course = new ID(requirementID, department, courseNumber);
				list.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
