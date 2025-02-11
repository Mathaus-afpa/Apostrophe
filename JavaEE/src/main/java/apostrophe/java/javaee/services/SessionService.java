package apostrophe.java.javaee.services;
import apostrophe.java.compte.Compte;
import apostrophe.java.javaee.erreur.exceptions.EchecAuthentificationException;
import apostrophe.java.javaee.erreur.exceptions.ExpirationException;
import com.nimbusds.jose.JOSEException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
public class SessionService {
	public static String BADUSER = "Utilisateur Invalide.";
	private SessionService() {}
	/**
	 * Teste si la connexion est suspendue
	 */
	public static void isSessionTimeout(HttpSession session) throws ExpirationException {
		long now = System.currentTimeMillis();
		long dernierAccesSession = session.getLastAccessedTime();
		int intervalMaximum = session.getMaxInactiveInterval();
		if ((now - dernierAccesSession) > (intervalMaximum * 1000L)) {
			session.invalidate();
			throw new ExpirationException();
		}
	}
	/**
	 * creer une session securisee
	 */
	public static void creerSessionSecurisee(HttpServletRequest request, HttpServletResponse response, Compte compte) throws JOSEException {
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(1800); // Expiration en 30 minutes
		session.setAttribute("utilisateur", compte.getLogin());
		session.setAttribute("compteUtilisateur", compte);
	}
	/**
	 * Processus de verification de la session
	 */
	public static void verifierLaSessionActive(HttpServletRequest httpRequest, HttpSession session) throws EchecAuthentificationException {
		System.out.println("---> Session Active 1");
		//<editor-fold defaultstate="collapsed" desc="Validation des cookies">
		Cookie cookieSession = CookieService.recupererCookie(httpRequest, CookieService.JSESSION);
		String sessionId = session.getId();
		if (cookieSession != null) System.out.println("::: cookieSession: " + cookieSession.getValue());
		else System.out.println("::: cookieSession is null");
		System.out.println("::: sessionId: " + sessionId);
		System.out.println("::: isSame: " + CookieService.isSameAndSafeCookie(cookieSession, sessionId));
		if (!CookieService.isSameAndSafeCookie(cookieSession, sessionId)) throw new EchecAuthentificationException(CookieService.BADCOOKIE);
		//</editor-fold>
		//<editor-fold defaultstate="expanded" desc="Validation de l'utilisateur de session">
		String nomUtilisateur = (String) session.getAttribute("utilisateur");
		System.out.println("::: nomUtilisateur: " + nomUtilisateur);
		if (nomUtilisateur == null) throw new EchecAuthentificationException(BADUSER);
		//</editor-fold>
		//<editor-fold defaultstate="expanded" desc="Validation de l'authentification JWT">
		Compte compteUtilisateur = (Compte) session.getAttribute("compteUtilisateur");
		if (compteUtilisateur == null) throw new EchecAuthentificationException(EchecAuthentificationException.UTILISATEUR_NULL);
		else {
			SuiviConnexionService.definirRequeteConnecte(true);
			System.out.println("::: compteUtilisateur : " + compteUtilisateur.getLogin());
		}
		//</editor-fold>
	}
	/**
	 * Supprime la session
	 */
	public static void nettoyerSession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) session.invalidate();
		System.out.println("---> Session Supprimee !!!!!");
	}
	/**
	 * Recupere le compte depuis la session
	 */
	public static Compte recuperationCompte(HttpServletRequest request) {
		if (SuiviConnexionService.estUtilisateurConnecte()) {
			HttpSession session = request.getSession(false);
			if (session != null) return (Compte) session.getAttribute("compteUtilisateur");
		}
		return null;
	}
}