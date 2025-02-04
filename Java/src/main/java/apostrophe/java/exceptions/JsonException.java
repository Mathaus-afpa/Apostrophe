package apostrophe.java.exceptions;
import apostrophe.java.utilitaires.Log;

/**
 * [Exception.JsonException] - class
 * @author Mathaus
 */
public class JsonException extends Exception {
	public JsonException(String location) {
		super(location + ": Le json n'est pas valide." , new Throwable("Exception.JsonException"));
		Log.error(this.getMessage(), this.getCause());
	}
}