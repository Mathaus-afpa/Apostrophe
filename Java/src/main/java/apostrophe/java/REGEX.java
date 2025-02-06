package apostrophe.java;
/**
 * [REGEX] - class
 * @author Mathaus
 */
public class REGEX {
	public static final String REGEX_NOM = "^[A-ZÀ-ÖØ-Ý][a-zà-öø-ÿ\\-\\s]{1,49}$";
	public static final String REGEX_PRENOM = "^[A-ZÀ-ÖØ-Ý-a-zà-öø-ÿ\\-\\.\\s]{1,49}$";
	public static final String REGEX_URL = ".*";//"^[\\w\\d_\\-]+\\.(jpg|jpeg|png|bmp)$";
}