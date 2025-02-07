package apostrophe.java.compte;

import apostrophe.java.exceptions.RegExException;
import org.json.JSONObject;

import java.util.regex.Pattern;
/**
 * [Compte] - class
 * @author Mathaus
 */
public class Compte {
	public Compte() {}
	//<editor-fold defaultstate="expanded" desc="Champs JSON">
	public static final String JSON_ID = "id";
	public static final String JSON_LOGIN = "login";
	//</editor-fold>
	//<editor-fold defaultstate="expanded" desc="Champs JSON">
	private static final String REGEX_LOGIN = "^(?!.*[._\\-]{2})[a-zA-Z0-9._\\-@]{1,50}$";
	private static final String REGEX_ROLE = "^[123]$";
	//</editor-fold>
	//<editor-fold defaultstate="expanded" desc="Champs prive">
	private Integer id;
	private String login;
	private Integer role;
	//</editor-fold>
	//<editor-fold defaultstate="expanded" desc="Getter">
	public Integer getId() {
		return id;
	}
	public String getLogin() {
		return login;
	}
	public String getRole() {
		switch (role) {
			case 1: return "administrateur";
			case 2: return "libraire";
			case 3: return "client";
		}
		return "";
	}
	//</editor-fold>
	//<editor-fold defaultstate="expanded" desc="Setter">
	public void setId(int id) {
		this.id = id;
	}
	public void setLogin(String login) throws RegExException {
		if (Pattern.matches(REGEX_LOGIN, login)) {
			this.login = login;
		} else { throw new RegExException("Compte.setLogin"); }
	}
	public void setRole(Integer role) throws RegExException {
		if (role == 1 || role == 2 || role == 3) {
			this.role = role;
		} else { throw new RegExException("Compte.setRole"); }
	}
	//</editor-fold>
	//<editor-fold defaultstate="expanded" desc="Validateurs">
	/**
	 * Verifie la validite d'un objet Compte
	 * @param compte
	 * @return vrai ou faux
	 */
	public static final boolean ValiderCompte(Compte compte) {
		String login = compte.getLogin();
		return Pattern.matches(REGEX_LOGIN, login);
	}
	/**
	 * Verifie la validite d'un json Compte
	 *
	 * @param compteJson
	 * @return vrai ou faux
	 */
	public static final boolean ValiderJson(JSONObject compteJson) {
		return false;
	}
	//</editor-fold>
	//<editor-fold defaultstate="expanded" desc="Serialisation">
	@Override
	public String toString() {
		return this.getLogin();
	}
	public String toJson() {
		JSONObject json = new JSONObject(this);
		return json.toString();
	}

	public boolean authentifier(String jwt, String sessionId) {
		return true;
	}
	//</editor-fold>
}