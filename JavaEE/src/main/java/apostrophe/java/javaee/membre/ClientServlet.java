package apostrophe.java.javaee.membre;
import apostrophe.java.compte.Compte;
import apostrophe.java.javaee.PAGES;
import apostrophe.java.javaee.ROUTES;
import apostrophe.java.javaee.services.SessionService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/Client")
public class ClientServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Compte compteUtilisateur = SessionService.recuperationCompte(request);
		if (compteUtilisateur != null) {
			String role = compteUtilisateur.getRole();
			if (role.equals("client")) {
				request.setAttribute("page", PAGES.MEMBRE + PAGES.CLIENT);
				RequestDispatcher dispatcher = request.getRequestDispatcher(PAGES.APP);
				dispatcher.forward(request, response);
			} else if (role.equals("administrateur") || role.equals("libraire")) {
				response.sendRedirect(ROUTES.ACCUEIL);
			} else response.sendRedirect(ROUTES.UNAUTHORIZED);
		} else {
			SessionService.nettoyerSession(request);
			response.sendRedirect(ROUTES.CONNEXION);
		}
	}
}