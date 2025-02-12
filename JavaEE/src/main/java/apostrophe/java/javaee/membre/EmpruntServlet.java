package apostrophe.java.javaee.membre;
import apostrophe.java.Cache;
import apostrophe.java.compte.Compte;
import apostrophe.java.exceptions.NullDataException;
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
@WebServlet("/Emprunter")
public class EmpruntServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Compte compteUtilisateur = SessionService.recuperationCompte(request);
		if (compteUtilisateur != null) {
			String role = compteUtilisateur.getRole();
			if (role.equals("client")) {
				String id = request.getParameter("livre");
                try {
                    request.setAttribute("livre", Cache.getLivre(Integer.parseInt(id)));
					request.setAttribute("page", PAGES.MEMBRE + PAGES.EMPRUNT);
					RequestDispatcher dispatcher = request.getRequestDispatcher(PAGES.APP);
					dispatcher.forward(request, response);
                } catch (NullDataException e) {
					response.sendRedirect(ROUTES.NOTFOUND_ERR);
                }
			} else if (role.equals("administrateur") || role.equals("libraire")) {
				response.sendRedirect(ROUTES.ACCUEIL);
			} else response.sendRedirect(ROUTES.UNAUTHORIZED);
		} else {
			SessionService.nettoyerSession(request);
			response.sendRedirect(ROUTES.CONNEXION);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Compte compteUtilisateur = SessionService.recuperationCompte(request);
		if (compteUtilisateur != null) {
			String role = compteUtilisateur.getRole();
			if (role.equals("client")) {
				String id = request.getParameter("livre");
				System.out.println("id: " + id);
			} else if (role.equals("administrateur") || role.equals("libraire")) {
				response.sendRedirect(ROUTES.ACCUEIL);
			} else response.sendRedirect(ROUTES.UNAUTHORIZED);
		} else {
			SessionService.nettoyerSession(request);
			response.sendRedirect(ROUTES.CONNEXION);
		}
	}
}