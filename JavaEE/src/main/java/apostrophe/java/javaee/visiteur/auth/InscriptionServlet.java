package apostrophe.java.javaee.visiteur.auth;
import apostrophe.java.javaee.PAGES;
import apostrophe.java.javaee.ROUTES;
import apostrophe.java.javaee.services.SuiviConnexionService;
import apostrophe.java.utilitaires.Log;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/Inscription")
public class InscriptionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (SuiviConnexionService.estUtilisateurConnecte()) {
			response.sendRedirect(ROUTES.ACCUEIL);
		} else {
			try {
				request.setAttribute("page", PAGES.VISITEUR + PAGES.INSCRIPTION);
				RequestDispatcher dispatcher = request.getRequestDispatcher(PAGES.APP);
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				Log.error(e.getMessage(), e);
			}
		}
	}
}