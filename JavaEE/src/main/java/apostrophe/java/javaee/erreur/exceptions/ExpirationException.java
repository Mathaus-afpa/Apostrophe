package apostrophe.java.javaee.erreur.exceptions;
public class ExpirationException extends Exception {
	public ExpirationException() {
		super("Session expiree");
	}
}