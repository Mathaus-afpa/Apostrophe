package apostrophe.java.javaee.services;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
public class CookieService {
	public static String JSESSION = "JSESSIONID";
	public static String BADCOOKIE = "Cookie Invalide.";
	private CookieService() {}
	/**
	 * Recupere le cookie dans la requete
	 */
	public static Cookie recupererCookie(HttpServletRequest httpRequest, String nomCookie) {
		Cookie[] cookies = httpRequest.getCookies();
		if (cookies != null && nomCookie != null && nomCookie.trim().length() > 0) {
			for (Cookie cookie : cookies) {
				if (nomCookie.equals(cookie.getName())) {
					return cookie;
				}
			}
		}
		return null;
	}
	/**
	 * Verifie que le cookie a le meme id qu'en session
	 */
	public static boolean isSameAndSafeCookie(Cookie cookie, String sessionId) {
		return cookie != null
//				&& cookie.getSecure()
//				&& cookie.isHttpOnly()
				&& sessionId.equals(cookie.getValue());
	}
}