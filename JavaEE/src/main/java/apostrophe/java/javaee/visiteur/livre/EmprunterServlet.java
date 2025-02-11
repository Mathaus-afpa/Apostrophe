package apostrophe.java.javaee.visiteur.livre;
import apostrophe.java.Cache;
import apostrophe.java.exceptions.NullDataException;
import apostrophe.java.javaee.PAGES;
import apostrophe.java.javaee.ROUTES;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/Emprunter")
public class EmprunterServlet  extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
		try {
			HttpSession session = request.getSession(false);
			if (session == null || session.getAttribute("utilisateur") == null) {
				response.sendRedirect(ROUTES.CONNEXION);  // Rediriger vers la page de login si pas authentifié
			} else {
				String id = request.getParameter("livre");
				request.setAttribute("livre", Cache.getLivre(Integer.parseInt(id)));
				request.setAttribute("page", PAGES.MEMBRE + PAGES.EMPRUNT);
				RequestDispatcher dispatcher = request.getRequestDispatcher(PAGES.APP);
				dispatcher.forward(request, response);
			}
		} catch (NullDataException e) {
			response.sendRedirect(ROUTES.NOTFOUND_ERR);
		}
	}
}