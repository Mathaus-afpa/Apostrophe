package apostrophe.java.javaee.erreur.exceptions;
public class EchecAuthentificationException extends Exception {
	public static final String TOKEN_INVALIDE = "Token invalide.";
	public static final String ENTREE_INVALIDE = "Donnees du formulaires invalides.";
	public static final String UTILISATEUR_NULL = "La session n'a pas d'utilisateur.";
	public static final String AUTHENTIFICATION_REFUSEE = "Authentication refusee.";
	public EchecAuthentificationException(String message) {
		super(message);
	}
}