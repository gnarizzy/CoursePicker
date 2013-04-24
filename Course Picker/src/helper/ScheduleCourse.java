package helper;

/**
 * A specific type of course object optimized for display
 * @author Gautam Narula
 *
 */

public class ScheduleCourse {

	String callNumber, department, courseNumber;
	double[] monday, tuesday, wednesday, thursday, friday;
	int[] mTimes,tTimes,wTimes,thTimes,fTimes;
	
	public ScheduleCourse(String callNumber, String department, String courseNumber, int[] monTimes, int[] tueTimes, int[] wedTimes, int[]thursTimes, int[]friTimes){
		monday=new double[monTimes.length];
		tuesday=new double[tueTimes.length];
		wednesday=new double[wedTimes.length];
		thursday=new double[thursTimes.length];
		friday=new double[friTimes.length];
		mTimes=monTimes;
		tTimes=tueTimes;
		wTimes=wedTimes;
		thTimes=thursTimes;
		fTimes=friTimes;
		this.callNumber=callNumber;
		this.department=department;
		this.courseNumber=courseNumber;
		format();
		
		
	}
	/**
	 * Takes the course times and formats them into the desired format for display on schedule.jsp
	 */
	
	private void format() {
		int counter=0;
		for (int time : mTimes){ //converts a time in Monday's schedule to new format
			int adjustedTime = time-480;
			double hours= adjustedTime/60;
			double minutes= adjustedTime%60;
			double newTime= hours +(minutes/60);
			monday[counter]= newTime;
			counter++;
		}
		int counter1=0;
		for (int time : tTimes){ //converts a time in Tuesday's schedule to new format
			int adjustedTime = time-480;
			double hours= adjustedTime/60;
			double minutes= adjustedTime%60;
			double newTime= hours +(minutes/60);
			tuesday[counter1]= newTime;
			counter1++;
		}
		int counter2=0;
		for (int time : wTimes){ //converts a time in Wuesday's schedule to new format
			int adjustedTime = time-480;
			double hours= adjustedTime/60;
			double minutes= adjustedTime%60;
			double newTime= hours +(minutes/60);
			wednesday[counter2]= newTime;
			counter2++;
		}
		int counter3=0;
		for (int time : thTimes){ //converts a time in Thursday's schedule to new format
			int adjustedTime = time-480;
			double hours= adjustedTime/60;
			double minutes= adjustedTime%60;
			double newTime= hours +(minutes/60);
			thursday[counter3]= newTime;
			counter3++;
		}
		int counter4=0;
		for (int time : fTimes){ //converts a time in Friday's schedule to new format
			int adjustedTime = time-480;
			double hours= adjustedTime/60;
			double minutes= adjustedTime%60;
			double newTime= hours +(minutes/60);
			friday[counter4]= newTime;
			counter4++;
		}
	}

	public String getCallNumber() {
		return callNumber;
	}

	public String getDepartment() {
		return department;
	}

	public String getCoursenumber() {
		return courseNumber;
	}

	public double[] getMonday() {
		return monday;
	}

	public double[] getTuesday() {
		return tuesday;
	}

	public double[] getWednesday() {
		return wednesday;
	}

	public double[] getThursday() {
		return thursday;
	}

	public double[] getFriday() {
		return friday;
	}
	
	
	
	
}
