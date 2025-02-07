package apostrophe.java.javaee.visiteur;
import apostrophe.java.Cache;
import apostrophe.java.compte.Compte;
import apostrophe.java.javaee.connexion.ConnexionService;
import apostrophe.java.javaee.connexion.CsrfService;
import apostrophe.java.javaee.PAGES;
import apostrophe.java.javaee.ROUTES;
import apostrophe.java.javaee.exceptions.EchecAuthentificationException;
import apostrophe.java.utilitaires.Log;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
@WebServlet("/Connexion")
public class ConnexionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String connexionToken = CsrfService.genererToken();
			response.addCookie(CsrfService.genererCookie(connexionToken, ROUTES.CONNEXION));
			request.setAttribute(ConnexionService.CSRF_TOKEN, connexionToken);
			request.setAttribute("page", PAGES.VISITEUR + PAGES.CONNEXION);
			RequestDispatcher dispatcher = request.getRequestDispatcher(PAGES.APP);
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			Log.error(e.getMessage(), e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 1 Vérification du Token CSRF
			String csrfTokenFromRequest = request.getParameter(ConnexionService.CSRF_TOKEN);
			if (!ConnexionService.ValiderToken(csrfTokenFromRequest, request.getCookies())) throw new EchecAuthentificationException(EchecAuthentificationException.TOKEN_INVALIDE);
			// 2 Récupération des identifiants
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if (!ConnexionService.ValiderFormulaire(username, password)) throw new EchecAuthentificationException(EchecAuthentificationException.ENTREE_INVALIDE);
			// 3 Vérification du compte
			Compte compte = Cache.CompteExist(username);
			if (!ConnexionService.ValiderCompte(compte, password)) {
				throw new EchecAuthentificationException(EchecAuthentificationException.AUTHENTIFICATION_REFUSEE);
			} else {
				// 4 Création de session sécurisée
				ConnexionService.CreerSessionSecurisee(request, compte.getLogin());
				// 5 Génération du JWT
				String jwt = ConnexionService.CreerJWT(compte.getLogin());
				response.setHeader("Authorization", "Bearer " + jwt);
				// 6 Redirection
				System.out.println("Role: " + compte.getRole() + " " + compte.getLogin());
				response.sendRedirect(ConnexionService.Redirection(compte.getRole()));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}