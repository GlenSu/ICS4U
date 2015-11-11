/**
 * 
 */
package su;

/**
 * InvalidInputException extends Exception for invalid
 * entries that the user inputs
 * 
 * @author Glen Su
 * Nov 11 2015
 */
public class InvalidInputException extends Exception {

	/**
	 * Constructs a new exception case without any message
	 */
	public InvalidInputException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructs a new exception case with a specified argument
	 * @param arg0
	 */
	public InvalidInputException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructs a new exception case with a specified cause
	 * @param cause
	 */
	public InvalidInputException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructs a new exception case with a specified cause and message
	 * @param message
	 * @param cause
	 */
	public InvalidInputException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 *  Constructs a new exception case with a specified cause and message with 
	 *  enableSuppressionenabled or disabled and writableStackTrace enabled or disabled 
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidInputException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
