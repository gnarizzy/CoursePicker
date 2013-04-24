package helper;
import java.util.ArrayList;

/**
 * This class is used to set up the Courses table on the database.
 * It is important because it actually parses all of the days from
 * the CSV and assigns each day a begin time and end time. 
 * 
 * @author Tyler Techo
 *
 */
public class RequirementIDInitializer {

	public RequirementIDInitializer(){}

	public boolean alreadyInTable(Course course, ArrayList<CourseFromCSV> array){

		return false;
	}

	/**
	 * This method is what actually creates the Course table.
	 * This method will find all courses requirement ID and add them to a table
	 */
	public void setUpCourseTable() {
		CourseFromCSVHelper csv = new CourseFromCSVHelper();
		ArrayList<CourseFromCSV> CSVlist = csv.getCourseFromCSVList();
		//CSVlist is the list of courses from the csv

		IDHelper id = new IDHelper();
		ArrayList<ID> IDlist = id.getCourseWithRequirementList();
		//IDlist is the list of courses with their requirement ID

		//This clears the previous table so the table will only have new data.
		CourseHelper helper = new CourseHelper();
		helper.clearCourses();

		//Objects used for convenience and readability
		CourseFromCSV c;
		ID idObject;
		String idNum;
		String cNum;
		int y;

		//For each CSVCourse find it's requirement ID
		for(int i = 0; i < CSVlist.size(); i++){
			c = CSVlist.get(i);
			cNum = c.getCourseNum();

			//For each ID object compare its course number 
			//and department to the current CSVCourse
			for(int x = 0; x < IDlist.size(); x++){

				idObject = IDlist.get(x);
				idNum = idObject.getCourseNumber();
				//Compare the course numbers
				if(cNum.substring(0, 3).equals(idNum.substring(0,3))){
					//Compare the course Prefixes or departments
					if(c.getCoursePrefix().equals(idObject.getDepartment())){
						//HERE Means we have a match with the course department 
						//and the course number so we can assign this the reqID from the ID Array LIst
						//Create a new course and then use the addCourse method in CourseHelper named helper

						//Create an array list to be used to find all matching call numbers 
						ArrayList<CourseFromCSV> coursesWithSameCallNumber = new ArrayList<CourseFromCSV>();
						coursesWithSameCallNumber.add(c);

						String call = c.getCallNumber();

						//For each CourseFromCSV in the list check if it has the same call number
						// as the course being assigned a requirement id
						for(int q = i+1; q < CSVlist.size(); q++){
							if(CSVlist.get(q).getCallNumber().equals(call)){
								coursesWithSameCallNumber.add(CSVlist.get(q));
								//System.out.println(coursesWithSameCallNumber.size());
							}
						}

						//System.out.println("false");
						//ArrayHelper aHelp = new ArrayHelper();
						String days = "";
						String timeBegin = "";
						String timeEnd = "";
						for(int d = 0; d < coursesWithSameCallNumber.size(); d++){
							if(days.equals(coursesWithSameCallNumber.get(d).getDays().trim()+ "*") && timeBegin.equals(coursesWithSameCallNumber.get(d).getPeriodBegin() + "*")){}
							else{
								days = days + coursesWithSameCallNumber.get(d).getDays().trim() + "*";
								timeBegin = timeBegin + coursesWithSameCallNumber.get(d).getPeriodBegin() + "*";
								timeEnd = timeEnd + coursesWithSameCallNumber.get(d).getPeriodEnd() + "*";
							}
						}

						//Now must parse the days and the times to create strings for the course
						String m = dayAndTimeParse(days, timeBegin, timeEnd, 1);
						String t = dayAndTimeParse(days, timeBegin, timeEnd, 2);
						String w = dayAndTimeParse(days, timeBegin, timeEnd, 3);
						String r = dayAndTimeParse(days, timeBegin, timeEnd, 4);
						String f =dayAndTimeParse(days, timeBegin, timeEnd, 5);

						//Add the course to the table
						
						Course course = new Course(idObject.getRequirementID(), c.getCallNumber(), c.getCoursePrefix(), c.getCourseNum(), m, t, w, r, f);
						ArrayList<Course> aH = helper.getCourseList();
						y = 0;
						for(int u = 0; u < aH.size(); u++){
							if(course.getCallNumber().equals(aH.get(u).getCallNumber()) && course.getRequirementID().equals(aH.get(u).getRequirementID())){
								u = aH.size();
								y = 100;
							}
						}
						if(y == 0){
							helper.addCourse(course);
							//System.out.println("added");
						}
					}

				}
			}
		}
	}

	/**
	 * Will return a String that contains the appropriate day's meeting times
	 * @param days String of days this course meets
	 * @param begin String with all beginning times
	 * @param end String with all ending times
	 * @param choice Choice of day (1,2,3,4,5) and (M,T,W,R,F) respectively
	 * @return String of all times concatenated
	 */
	public String dayAndTimeParse(String days, String begin, String end, int choice){
		//Need to break down the days and what times they meet on each day
		String mS = "";
		String mE = "";
		String tS = "";
		String tE = "";
		String wS = "";
		String wE = "";
		String rS = "";
		String rE = "";
		String fS = "";
		String fE = "";

		String currBegin = "";
		String currEnd = "";
		String currDays = "";

		int index = 0;

		ArrayList<String> monB = new ArrayList<String>();
		ArrayList<String> monE = new ArrayList<String>();
		ArrayList<String> tuesB = new ArrayList<String>();
		ArrayList<String> tuesE = new ArrayList<String>();
		ArrayList<String> wedB = new ArrayList<String>();
		ArrayList<String> wedE = new ArrayList<String>();
		ArrayList<String> thurB = new ArrayList<String>();
		ArrayList<String> thurE = new ArrayList<String>();
		ArrayList<String> friB = new ArrayList<String>();
		ArrayList<String> friE = new ArrayList<String>();

		//While the length of the days string is > 1 loop
		while(days.length() > 1){
			//Find the * and make a substring of things before this (will be repeated for times)
			index = days.indexOf("*");
			currDays = days.substring(0, index);
			//Cut of the first portion of this (will be repeated for times)
			days = days.substring(index + 1);
			index = begin.indexOf("*");
			currBegin = begin.substring(0, index);
			begin = begin.substring(index + 1);
			index = end.indexOf("*");
			currEnd = end.substring(0, index);
			end = end.substring(index + 1);

			currBegin = currBegin.substring(0, 2)+ ":" + currBegin.substring(2);
			currEnd =  currEnd.substring(0, 2)+ ":" + currEnd.substring(2);

			if(currDays.contains("M")){
				int count = 0;
				for(int i = 0; i < monB.size(); i++){
					if(monB.get(i).equals(currBegin)){
						count = 1;
					}
				}
				if(count == 0){
					monB.add(currBegin);
					monE.add(currEnd);
				}
			}
			if(currDays.contains("T")){
				int count = 0;
				for(int i = 0; i < tuesB.size(); i++){
					if(tuesB.get(i).equals(currBegin)){
						count = 1;
					}
				}
				if(count == 0){
					tuesB.add(currBegin);
					tuesE.add(currEnd);
				}		
			}
			if(currDays.contains("W")){
				int count = 0;
				for(int i = 0; i < wedB.size(); i++){
					if(wedB.get(i).equals(currBegin)){
						count = 1;
					}
				}
				if(count == 0){
					wedB.add(currBegin);
					wedE.add(currEnd);
				}
			}
			if(currDays.contains("R")){
				int count = 0;
				for(int i = 0; i < thurB.size(); i++){
					if(thurB.get(i).equals(currBegin)){
						count = 1;
					}
				}
				if(count == 0){
					thurB.add(currBegin);
					thurE.add(currEnd);
				}
			}
			if(currDays.contains("F")){
				int count = 0;
				for(int i = 0; i < friB.size(); i++){
					if(friB.get(i).equals(currBegin)){
						count = 1;
					}
				}
				if(count == 0){
					friB.add(currBegin);
					friE.add(currEnd);
				}
			}
		}
		for(int j = 0; j < monB.size(); j++){
			mS += monB.get(j) + "-" + monE.get(j) + "\n";
		}
		for(int j = 0; j < tuesB.size(); j++){
			tS += tuesB.get(j) + "-" + tuesE.get(j) + "\n";
		}
		for(int j = 0; j < wedB.size(); j++){
			wS += wedB.get(j) + "-" + wedE.get(j) + "\n";
		}
		for(int j = 0; j < thurB.size(); j++){
			rS += thurB.get(j) + "-" + thurE.get(j) + "\n";
		}
		for(int j = 0; j < friB.size(); j++){
			fS += friB.get(j) + "-" + friE.get(j) + "\n";
		}

		//Make decision of which day based on choice parameter
		if(choice == 1){
			return mS.trim(); 
		}
		else if(choice == 2){
			return tS.trim(); 
		}
		else if(choice == 3){
			return wS.trim(); 
		}
		else if(choice == 4){
			return rS.trim(); 
		}
		else {
			return fS.trim(); 
		}
	}
}
