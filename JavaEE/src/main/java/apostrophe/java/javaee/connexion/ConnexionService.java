package apostrophe.java.javaee.connexion;
import apostrophe.java.compte.Compte;
import apostrophe.java.compte.CompteDAO;
import apostrophe.java.javaee.ROUTES;
import apostrophe.java.javaee.exceptions.EchecAuthentificationException;
import apostrophe.java.javaee.exceptions.ExpirationException;
import apostrophe.java.utilitaires.Log;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCrypt;
import java.io.IOException;
import java.util.Date;
/**
 * [ConnexionService] - class
 * @author Mathaus
 */
public class ConnexionService {

	public static String CSRF_TOKEN = "USERTOKEN";

	public static void processSession(HttpServletRequest httpRequest, HttpServletResponse httpResponse, FilterChain chain) throws ServletException, IOException {
		HttpSession session = httpRequest.getSession(false);
		SuiviConnexion.definirRequeteConnecte(false);
		try {
			if (session != null) {
				Log.info("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ Session active ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
				Log.info(httpRequest.getRequestURI());
				isSessionTimeout(session); // => ExpirationException si echec
				processSessionActive(httpRequest, session); // => EchecAuthentificationException si echec
			} else {
				Log.info("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ Session inactive ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
			}
			chain.doFilter(httpRequest, httpResponse);
		} catch (ExpirationException e) {
			httpResponse.sendRedirect("/Connexion?expire=true");
		} catch (EchecAuthentificationException e) {
			if (session != null) { session.invalidate(); }
			httpResponse.sendRedirect("/401");
        }
    }
	private static void isSessionTimeout(HttpSession session) throws ExpirationException {
		long now = System.currentTimeMillis();
		long lastAccessedTime = session.getLastAccessedTime();
		int inactiveInterval = session.getMaxInactiveInterval();
		if ((now - lastAccessedTime) > (inactiveInterval * 1000L)) {
			session.invalidate();
			throw new ExpirationException();
		}
	}
	private static void processSessionActive(HttpServletRequest httpRequest, HttpSession session) throws EchecAuthentificationException {
		Cookie cookie = ConnexionService.recupererCookie(httpRequest);
		String sessionId = session.getId();
		if (!isSameAndSafeCookie(cookie, sessionId)) throw new EchecAuthentificationException("Cookie invalide");
		String jwt = ConnexionService.recupererJWT(httpRequest);
		String nomUtilisateur = (String) session.getAttribute("utilisateur");
		if (!JwtUtil.validerJWT(jwt, nomUtilisateur)) throw new EchecAuthentificationException("JWT invalide");
		Compte utilisateur = (Compte) session.getAttribute("compteUtilisateur");
		if (utilisateur.authentifier(jwt, sessionId)) {
			SuiviConnexion.definirRequeteConnecte(true);
		} else throw new EchecAuthentificationException("Utilisateur invalide");
	}

	private static Cookie recupererCookie(HttpServletRequest httpRequest) {
		Cookie[] cookies = httpRequest.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("JSESSIONID".equals(cookie.getName())) {
					return cookie; // Retourner la valeur du cookie JSESSIONID
				}
			}
		}
		return null; // Si le cookie n'est pas trouvé, retourner null
	}

	private static boolean isSameAndSafeCookie(Cookie cookie, String sessionId) {
		return cookie != null
				&& cookie.getSecure()
				&& cookie.isHttpOnly()
				&& sessionId.equals(cookie.getValue());
	}

	public static String recupererJWT(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		if (header != null && header.startsWith("Bearer ")) {
			return header.substring(7);  // Récupère le token après "Bearer "
		}
		return null;
	}

	public static boolean ValiderFormulaire(String username, String password) {
		if (username == null || password == null) {
			return false;
		}
		String trim_username = username.trim();
		String trim_password = password.trim();
		return !trim_username.isEmpty() && !trim_password.isEmpty()
				&& trim_username.length() > 3 && trim_password.length() > 3
				&& trim_username.matches("^[a-zA-Z0-9_]{3,20}$");
	}

	public static void CreerSessionSecurisee(HttpServletRequest request, String login) {
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(1800); // Expiration en 30 minutes
		session.setAttribute("utilisateur", login);
	}


	public static String Redirection(String role) {
		switch (role) {
			case "administrateur": return ROUTES.ADMINISTRATEUR;
			case "libraire": return ROUTES.LIBRAIRE;
			case "client": return ROUTES.CLIENT;
			default: return "/404";
		}
	}
	public static boolean ValiderToken(String csrfTokenFromRequest, Cookie[] cookies) {
		if (csrfTokenFromRequest == null || cookies == null) return false;

		String csrfTokenFromCookie = null;
		for (Cookie cookie : cookies) {
			if (ConnexionService.CSRF_TOKEN.equals(cookie.getName())) {
				csrfTokenFromCookie = cookie.getValue();
				break;
			}
		}
		return csrfTokenFromCookie != null && csrfTokenFromCookie.equals(csrfTokenFromRequest);
	}

	public static boolean ValiderCompte(Compte compte, String password) {
		if (compte != null) {
			return BCrypt.checkpw(password, CompteDAO.motDePasse(compte));
		} else return false;
	}




	public static String CreerJWT(String username) {
		try {
			// Clé secrète (doit être stockée en variable d'environnement)
			String secretKey = "SuperSecretKeyForJWT123!SuperSecretKeyForJWT123!";
			byte[] secret = secretKey.getBytes();

			// Création de l'en-tête JWT avec algorithme HMAC-SHA256
			JWSHeader header = new JWSHeader(JWSAlgorithm.HS256);

			// Création des revendications (claims)
			JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
					.subject(username)
					.issuer("ton-serveur.com") // Remplace par ton domaine
					.expirationTime(new Date(System.currentTimeMillis() + 3600000)) // Expiration 1h
					.issueTime(new Date())
					.build();

			// Création du JWT signé
			SignedJWT signedJWT = new SignedJWT(header, claimsSet);
			JWSSigner signer = new MACSigner(secret);
			signedJWT.sign(signer);

			// Retourne le token JWT encodé en String
			return signedJWT.serialize();

		} catch (JOSEException e) {
			throw new RuntimeException("Erreur lors de la génération du JWT", e);
		}
	}

	//Etape 1 : L'utilisateur soumet ses informations de connexion
	//Étape 2 : Traitement de la soumission de la requête (Servlet login)
	//	# Récupérer les informations
	//	# Vérification CSRF
	//Étape 3 : Vérification des informations de connexion (Authentification)
	//	# Vérifier l'existence de l'utilisateur dans la base de données
	//	# Vérification du mot de passe
	//Étape 4 : Création et gestion de la session
	//	# Générer une session sécurisée pour l'utilisateur authentifié
	//	# Configurer les cookies de session
	//	# Définir une expiration pour la session
	//Étape 5 : Vérification continue de l'intégrité de la session
	//	# Vérification de l'IP et du User-Agent
	//Étape 6 : Gestion des pages protégées et contrôle d'accès
	//	# Accès restreint pour les pages sécurisées :
	//	# Utilisation de filtres pour contrôler l'accès :
	//Étape 7 : Protection contre le vol de session (fixation et hijacking)
	//	#Protéger contre la fixation de session :
	//	#Validation de la session par un double contrôle :
	//	#Cryptage des données sensibles :
	//Étape 8 : Déconnexion de l'utilisateur
	//	#Logique de déconnexion :
	//
	//	#
	//
	//	#
	//	#
	//
	//	#
	//	#
}