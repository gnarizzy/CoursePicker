package helper;

/**
 * The Course From CSV page is the java class used to
 * create objects containing all of the information pulled
 * from the UGA Static Reports CSV file
 * 
 * @author Tyler Techo
 *
 */

public class CourseFromCSV {

	private String term;
	private String callNumber;
	private String coursePrefix;
	private String courseNum;
	private String courseTitle;
	private String proffessor;
	private String available;
	private String creditHours;
	private String session;
	private String days;
	private String periodBegin;
	private String periodEnd;
	private String CASTaken;
	private String CASReq;
	private String DASTaken;
	private String TotTaken;
	private String TotReq;
	private String TotAllow;
	private String Bldg;
	private String room;
	private String sch;
	private String currentProgram;

	/**
	 * The constructor will initialize all appropriate variables
	 * @param term class term
	 * @param callNumber The call number
	 * @param coursePrefix The department or course prefix
	 * @param courseNum The course section or number
	 * @param courseTitle Title of the course
	 * @param proffessor Instructor
	 * @param available Course Availability
	 * @param creditHours # of credit hours
	 * @param session session
	 * @param days days it meets
	 * @param periodBegin time begin
	 * @param periodEnd time end
	 * @param CASTaken
	 * @param CASReq
	 * @param DASTaken
	 * @param TotTaken
	 * @param TotReq
	 * @param TotAllow
	 * @param Bldg building
	 * @param room room number
	 * @param sch 
	 * @param currentProgram
	 */
	public CourseFromCSV( String term, String callNumber,String coursePrefix, String courseNum, String courseTitle, String proffessor, String available, String creditHours, String session, String days, String periodBegin, String periodEnd, String CASTaken, String CASReq, String DASTaken, String TotTaken, String TotReq, String TotAllow, String Bldg, String room, String sch, String currentProgram){
		
		this.term = term;
		this.callNumber = callNumber;
		this.coursePrefix = coursePrefix;
		this.courseNum = courseNum;
		this.courseTitle = courseTitle;
		this.proffessor = proffessor;
		this.available = available;
		this.creditHours = creditHours;
		this.session = session;
		this.days = days;
		this.periodBegin = periodBegin;
		this.periodEnd = periodEnd;
		this.CASTaken = CASTaken;
		this.CASReq = CASReq;
		this.DASTaken = DASTaken;
		this.TotTaken = TotTaken;
		this.TotReq = TotReq;
		this.TotAllow = TotAllow;
		this.Bldg = Bldg;
		this.room = room;
		this.sch = sch;
		this.currentProgram = currentProgram;
		
		//System.out.println("yes");
	}

	/**
	 * @return the term
	 */
	public String getTerm() {
		return term;
	}

	/**
	 * @return the callNumber
	 */
	public String getCallNumber() {
		return callNumber;
	}

	/**
	 * @return the coursePrefix
	 */
	public String getCoursePrefix() {
		return coursePrefix;
	}

	/**
	 * @return the courseNum
	 */
	public String getCourseNum() {
		return courseNum;
	}

	/**
	 * @return the courseTitle
	 */
	public String getCourseTitle() {
		return courseTitle;
	}

	/**
	 * @return the proffessor
	 */
	public String getProffessor() {
		return proffessor;
	}

	/**
	 * @return the available
	 */
	public String getAvailable() {
		return available;
	}

	/**
	 * @return the creditHours
	 */
	public String getCreditHours() {
		return creditHours;
	}

	/**
	 * @return the session
	 */
	public String getSession() {
		return session;
	}

	/**
	 * @return the days
	 */
	public String getDays() {
		return days;
	}

	/**
	 * @return the periodBegin
	 */
	public String getPeriodBegin() {
		return periodBegin;
	}

	/**
	 * @return the periodEnd
	 */
	public String getPeriodEnd() {
		return periodEnd;
	}

	/**
	 * @return the cASTaken
	 */
	public String getCASTaken() {
		return CASTaken;
	}

	/**
	 * @return the cASReq
	 */
	public String getCASReq() {
		return CASReq;
	}

	/**
	 * @return the dASTaken
	 */
	public String getDASTaken() {
		return DASTaken;
	}

	/**
	 * @return the totTaken
	 */
	public String getTotTaken() {
		return TotTaken;
	}

	/**
	 * @return the totReq
	 */
	public String getTotReq() {
		return TotReq;
	}

	/**
	 * @return the totAllow
	 */
	public String getTotAllow() {
		return TotAllow;
	}

	/**
	 * @return the bldg
	 */
	public String getBldg() {
		return Bldg;
	}

	/**
	 * @return the room
	 */
	public String getRoom() {
		return room;
	}

	/**
	 * @return the sch
	 */
	public String getSch() {
		return sch;
	}

	/**
	 * @return the currentProgram
	 */
	public String getCurrentProgram() {
		return currentProgram;
	}
}
