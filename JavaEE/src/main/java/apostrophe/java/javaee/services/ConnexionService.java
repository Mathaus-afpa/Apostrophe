package apostrophe.java.javaee.services;
import apostrophe.java.compte.Compte;
import apostrophe.java.compte.CompteDAO;
import apostrophe.java.javaee.ROUTES;
import org.springframework.security.crypto.bcrypt.BCrypt;
public class ConnexionService {
	private ConnexionService() {}
	/**
	 * Verifie les données du formulaire
	 */
	public static boolean validerFormulaire(String username, String password) {
		if (username == null || password == null) {
			return false;
		}
		String trim_username = username.trim();
		String trim_password = password.trim();
		return !trim_username.isEmpty() && !trim_password.isEmpty()
				&& trim_username.length() > 3 && trim_password.length() > 3
				&& trim_username.matches("^[a-zA-Z0-9_]{3,20}$");
	}
	/**
	 * Redirige selon les roles
	 */
	public static String redirigerVersDashboard(String role) {
		switch (role) {
			case "administrateur": return ROUTES.ADMINISTRATEUR;
			case "libraire": return ROUTES.LIBRAIRE;
			case "client": return ROUTES.CLIENT;
			default: return ROUTES.FORBIDDEN_ERR;
		}
	}
	/**
	 * Verifie les informations du compte
	 */
	public static boolean validerCompte(Compte compte, String password) {
		if (compte != null) {
			return BCrypt.checkpw(password, CompteDAO.motDePasse(compte));
		} else return false;
	}
}