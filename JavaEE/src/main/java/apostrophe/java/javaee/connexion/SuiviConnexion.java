package apostrophe.java.javaee.connexion;
/**
 * [SuiviConnexion] - class
 * @author Mathaus
 */
public class SuiviConnexion {
	// Variable ThreadLocal pour suivre si l'utilisateur est connecte ou non
	private static ThreadLocal<Boolean> utilisateurConnecte = new ThreadLocal<>();
	/**
	 * Defini si un utilisateur est connecte ou non
	 * @param estConnecte
	 */
	public static void definirRequeteConnecte(boolean estConnecte) {
		utilisateurConnecte.set(estConnecte);
	}
	/**
	 * Recuperer l'état de connexion de l'utilisateur
	 * @return
	 */
	public static boolean estUtilisateurConnecte() {
		Boolean estConnecte = utilisateurConnecte.get();
		return estConnecte != null && estConnecte;
	}
	public static void nettoyer() {
		utilisateurConnecte.remove();
	}
}