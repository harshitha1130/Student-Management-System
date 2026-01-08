package ExceptionHandler;

public class EnrollmentNotFoundException extends RuntimeException{

	public EnrollmentNotFoundException(String message) {
		super(message);
	}

}
