package apostrophe.java.javaee.visiteur.auth;
import apostrophe.java.Cache;
import apostrophe.java.compte.Compte;
import apostrophe.java.javaee.services.*;
import apostrophe.java.javaee.PAGES;
import apostrophe.java.javaee.ROUTES;
import apostrophe.java.javaee.erreur.exceptions.EchecAuthentificationException;
import apostrophe.java.utilitaires.Log;
import com.nimbusds.jose.JOSEException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
@WebServlet("/Connexion")
public class ConnexionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (SuiviConnexionService.estUtilisateurConnecte()) {
			response.sendRedirect(ROUTES.ACCUEIL);
		} else {
			try {
				String connexionToken = CsrfService.genererToken();
				response.addCookie(CsrfService.genererCookieCSRF(connexionToken, ROUTES.CONNEXION));
				request.setAttribute(CsrfService.CSRF_TOKEN, connexionToken);
				request.setAttribute("page", PAGES.VISITEUR + PAGES.CONNEXION);
				RequestDispatcher dispatcher = request.getRequestDispatcher(PAGES.APP);
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				Log.error(e.getMessage(), e);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (SuiviConnexionService.estUtilisateurConnecte()) {
			response.sendRedirect(ROUTES.FORBIDDEN_ERR);
		} else {
			try {
				// 1 Vérification du Token CSRF
				String csrfTokenFromRequest = request.getParameter(CsrfService.CSRF_TOKEN);
				Cookie crsfCookkie = CookieService.recupererCookie(request, CsrfService.CSRF_TOKEN);
				if (!CsrfService.validerCSRF(csrfTokenFromRequest, crsfCookkie)) throw new EchecAuthentificationException(EchecAuthentificationException.TOKEN_INVALIDE);
				// 2 Récupération des identifiants
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				if (!ConnexionService.validerFormulaire(username, password)) throw new EchecAuthentificationException(EchecAuthentificationException.ENTREE_INVALIDE);
				// 3 Vérification du compte
				Compte compte = Cache.CompteExist(username);
				if (!ConnexionService.validerCompte(compte, password)) {
					throw new EchecAuthentificationException(EchecAuthentificationException.AUTHENTIFICATION_REFUSEE);
				} else {
					// 4 Création de session sécurisée
					SessionService.creerSessionSecurisee(request, response, compte);
					// 5Redirection
					response.sendRedirect(ConnexionService.redirigerVersDashboard(compte.getRole()));
				}
			} catch (EchecAuthentificationException e) {
				response.sendRedirect(ROUTES.CONNEXION);
			} catch (JOSEException e) {
				response.sendRedirect(ROUTES.INTERNAL_ERR);
            }
        }
	}
}