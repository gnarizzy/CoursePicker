package helper;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * The CSV Reader is the driver class for the application
 * Upon execution this class will pull the CSV file from the specified 
 * URL and will parse this data and insert it into a table. From here the
 * class will reparse this table to assign each course a requirement id.
 * 
 * @author Tyler Techo
 *
 */
public class CSVReader{
	/**
	 * Will pull the CSV file from the specified 
	 * URL and will parse this data and insert it into a table. From here the
	 * class will reparse this table to assign each course a requirement id.
	 */
	public static void main(String[] args) {

		//Initialize the variables needed
		String term = "";
		String callNumber = "";
		String coursePrefix = "";
		String courseNum = "";
		String courseTitle = "";
		String proffessor = "";
		String available = "";
		String creditHours = "";
		String session = "";
		String days = "";
		String periodBegin = "";
		String periodEnd = "";
		String CASTaken = "";
		String CASReq = "";
		String DASTaken = "";
		String TotTaken = "";
		String TotReq = "";
		String TotAllow = "";
		String Bldg = "";
		String room = "";
		String sch = "";
		String currentProgram = "";

		try {
			//Create a URL object to access the CSV page
			URL url = new URL("https://apps.reg.uga.edu/reporting/static_reports/course_offering_UNIV_201308.csv");
			//Read from scanner
			Scanner s = new Scanner(url.openStream());

			//Create a CourseFromCSVHelper used to add courses to the table
			CourseFromCSVHelper helper = new CourseFromCSVHelper();
			helper.clearCourses();

			//Indexes used in the parsing of the data
			int startIndex = 0;
			int endIndex = 0;

			//count is a counter used to make decisions on which column the read in string should be assigned to
			int count = -1;

			//While the CSV still has another line
			while(s.hasNextLine()){
				//Assign line the nextLine in s
				String line = s.nextLine();
				//Reinitialize count to -1
				count = -1;

				//Loop until the length of the line is less than or equal to 2
				//This is to detect when we have reached the end of the line
				while(line.length() > 2){
					//The String test is each string between ',' 's
					String test;
					//If the length of the remaining line is less than 7 we know that we are on the last element
					if(line.length() > 6){
						//Find the next comma and make this the end index
						endIndex = line.indexOf(",");
						//Assign test as the substring from the start to end index
						test = line.substring(startIndex, endIndex);
					}
					else {
						//Since this is the last string on the line we assign it the rest of line
						test = line.substring(startIndex);
					}
					//Based on the count variable we can decide which column we are reading in
					//So we assign that variable test and then replace and trim it
					switch(count){
					case -1: term = replaceAndTrim(test);
					break;
					case 0: callNumber = replaceAndTrim(test); 
					break;
					case 1:  coursePrefix = replaceAndTrim(test); 
					break;
					case 2:   courseNum = replaceAndTrim(test); 
					break;
					case 3:  courseTitle = replaceAndTrim(test); 
					break;
					case 4:  proffessor = replaceAndTrim(test); 
					break;
					case 5:  available = replaceAndTrim(test); 
					break;
					case 6:  creditHours = replaceAndTrim(test); 
					break;
					case 7:  session = replaceAndTrim(test); 
					break;
					case 8:   days = replaceAndTrim(test); 
					break;
					case 9:  periodBegin = replaceAndTrim(test); 
					break;
					case 10:  periodEnd = replaceAndTrim(test); 
					break;
					case 11:  CASTaken = replaceAndTrim(test); 
					break;
					case 12:  CASReq = replaceAndTrim(test); 
					break;
					case 13:  DASTaken = replaceAndTrim(test); 
					break;
					case 14:   TotTaken = replaceAndTrim(test);
					break;
					case 15:  TotReq = replaceAndTrim(test); 
					break;
					case 16:  TotAllow = replaceAndTrim(test); 
					break;
					case 17:  Bldg = replaceAndTrim(test); 
					break;
					case 18:  room = replaceAndTrim(test); 
					break;
					case 19:  sch = replaceAndTrim(test); 
					break;
					case 20:   currentProgram = replaceAndTrim(test); 
					break;
					}
					count++;
					if(line.length() >= 2){

						line = line.substring(endIndex+ 1);
					}
					else {
						line = "";
					}
				}			
				//Here we are only listing courses that are available
				if(available.equalsIgnoreCase("Available")){
					CourseFromCSV course = new CourseFromCSV(term, callNumber, coursePrefix, courseNum,	courseTitle, proffessor, available, creditHours, session, days, periodBegin, periodEnd, CASTaken, CASReq, DASTaken, TotTaken, TotReq, TotAllow, Bldg, room, sch, currentProgram);
					helper.addCourse(course);
				}
				else{}
			}
			//Close the scanner to prevent leaks
			s.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		//Create a RequirementIDInitializer object. This object is used to set up the Courses table
		RequirementIDInitializer reqID = new RequirementIDInitializer();
		reqID.setUpCourseTable();
	}

	/**
	 * Will take the parameter string and replace all '\' 
	 * with an empty string. It will then remove the whitespace
	 * from the ends of the String.
	 * 
	 * @param original the original string to be processed
	 * @return currentString -  a String that has been trimmed and replaced the appropriate chars
	 */
	public static String replaceAndTrim(String original){
		//trimAndAdd
		String currentString;
		currentString = original.replace("\"", "");
		currentString.trim();
		return currentString;
	}
}
