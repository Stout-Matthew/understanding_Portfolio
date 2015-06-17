package exceptions;

public class DatabaseSubmissionException extends Exception {

	public String submissionFailed(){
		return "Submission attempt was unsuccessful";
	}
	
	
}
