package apostrophe.java.javaee.services;
import jakarta.servlet.http.Cookie;
import java.util.UUID;
public class CsrfService {
	public static String CSRF_TOKEN = "USERTOKEN";
	private static final String CSRF_TOKEN_SESSION_KEY = "csrfToken";
	private CsrfService() {}
	/**
	 * Genere un token
	 */
	public static String genererToken() {
		return UUID.randomUUID().toString();
	}
	/**
	 * Recupere le cookie dans la requete
	 */
	public static Cookie genererCookieCSRF(String token, String url) {
		Cookie csrfCookie = new Cookie(CSRF_TOKEN, token);
		url = (url == null) ? "/" : url;
//		csrfCookie.setHttpOnly(true);
//		csrfCookie.setSecure(true);
//		csrfCookie.setAttribute("SameSite", "Strict");
		csrfCookie.setPath(url);
		csrfCookie.setMaxAge(10);
		return csrfCookie;
	}
	/**
	 * Verifie le CSRF
	 */
	public static boolean validerCSRF(String csrfTokenFromRequest, Cookie cookie) {
		if (csrfTokenFromRequest == null || cookie == null) return false;
		String csrfTokenFromCookie = cookie.getValue();
		return csrfTokenFromCookie != null && csrfTokenFromCookie.equals(csrfTokenFromRequest);
	}
}