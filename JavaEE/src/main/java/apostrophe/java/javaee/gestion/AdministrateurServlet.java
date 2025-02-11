package apostrophe.java.javaee.gestion;
import apostrophe.java.Cache;
import apostrophe.java.compte.Compte;
import apostrophe.java.javaee.PAGES;
import apostrophe.java.javaee.ROUTES;
import apostrophe.java.javaee.services.SessionService;
import apostrophe.java.utilitaires.Log;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/Administrateur")
public class AdministrateurServlet  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Compte compteUtilisateur = SessionService.recuperationCompte(request);
		if (compteUtilisateur != null) {
			String role = compteUtilisateur.getRole();
			if (role.equals("administrateur") || role.equals("libraire")) {
				request.setAttribute("comptes", Cache.listerComptes());
				request.setAttribute("libraires", Cache.listerLibraires());
				request.setAttribute("page", PAGES.GESTION + PAGES.ADMINISTRATEUR);
				RequestDispatcher dispatcher = request.getRequestDispatcher(PAGES.APP);
				dispatcher.forward(request, response);
			} else response.sendRedirect(ROUTES.UNAUTHORIZED);
		} else {
			SessionService.nettoyerSession(request);
			response.sendRedirect(ROUTES.CONNEXION);
		}
	}
}