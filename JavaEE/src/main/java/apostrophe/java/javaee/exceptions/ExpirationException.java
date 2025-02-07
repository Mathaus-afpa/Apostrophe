package apostrophe.java.javaee.exceptions;
public class ExpirationException extends Exception {
	public ExpirationException() {
		super("Session expiree");
	}
}