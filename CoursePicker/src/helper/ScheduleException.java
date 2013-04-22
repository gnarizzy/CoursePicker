package helper;

/**
 * Custom exception class, thrown when schedule conflict occurs
 * 
 * @author Gautam Narula
 * 
 */
public class ScheduleException extends Exception {

	public ScheduleException() {
	}

	public ScheduleException(String message) {
		super(message);
	}

	public ScheduleException(Throwable cause) {
		super(cause);
	}

	public ScheduleException(String message, Throwable cause) {
		super(message, cause);
	}

}
