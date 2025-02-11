package apostrophe.java.javaee;
import apostrophe.java.compte.Compte;
import apostrophe.java.javaee.erreur.exceptions.EchecAuthentificationException;
import apostrophe.java.javaee.erreur.exceptions.ExpirationException;
import apostrophe.java.javaee.services.SessionService;
import apostrophe.java.javaee.services.SuiviConnexionService;
import apostrophe.java.utilitaires.Log;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
/**
 * [AppostropheFIlter] - class
 * @author Mathaus
 */
@WebFilter("/*")
public class AppostropheFilter implements Filter {
	//<editor-fold defaultstate="expanded" desc="GET / POST / PUT / DELETE">
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String uri = httpRequest.getRequestURI();
		if (uri.contains(".") || uri.equals("/")) {
			chain.doFilter(request, response);
		} else {
			traiterRequetes(httpRequest, httpResponse, chain);
		}
		SuiviConnexionService.nettoyer();
	}

	private void traiterRequetes(HttpServletRequest httpRequest, HttpServletResponse httpResponse, FilterChain chain) throws ServletException, IOException {
		HttpSession session = httpRequest.getSession(false);
		SuiviConnexionService.definirRequeteConnecte(false);
		try {
			if (session != null) {
				SessionService.isSessionTimeout(session); // => ExpirationException si echec.
				SessionService.verifierLaSessionActive(httpRequest, session); // => EchecAuthentificationException si echec
				Compte compteUtilisateur = (Compte) session.getAttribute("compteUtilisateur");
				if (compteUtilisateur != null) {
					httpRequest.setAttribute("role", compteUtilisateur.getRole());
					httpRequest.setAttribute("utilisateur", compteUtilisateur.getLogin());
				} else throw new EchecAuthentificationException(EchecAuthentificationException.UTILISATEUR_NULL);
			}
			chain.doFilter(httpRequest, httpResponse);
		} catch (ExpirationException e) {
			httpResponse.sendRedirect(ROUTES.CONNEXION + "?expire=true");
		} catch (EchecAuthentificationException e) {
			Log.error(e.getMessage());
			SessionService.nettoyerSession(httpRequest);
			httpResponse.sendRedirect(ROUTES.UNAUTHORIZED);
		}
	}
	//</editor-fold>
	//<editor-fold defaultstate="expanded" desc="FACTORISATION">

	//</editor-fold>
}