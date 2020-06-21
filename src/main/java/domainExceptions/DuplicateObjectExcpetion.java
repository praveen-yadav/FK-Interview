package domainExceptions;

public class DuplicateObjectExcpetion extends Exception {

	//When you're trying to insert an object with a duplicate ID
	
	
	public DuplicateObjectExcpetion() {
		// TODO Auto-generated constructor stub
	}

	public DuplicateObjectExcpetion(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DuplicateObjectExcpetion(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public DuplicateObjectExcpetion(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DuplicateObjectExcpetion(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
