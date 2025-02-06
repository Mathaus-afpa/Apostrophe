package apostrophe.java.exceptions;
/**
 * [Exception.DaoException] - class
 * @author Mathaus
 */
public class DaoException extends Exception {
	public static final String ECHEC_REQUETE = ": La requete a echoue : ";
	public DaoException(String location, String contexte) {
		super(location + " : " + contexte, new Throwable("Exception.DaoException"));
	}
}