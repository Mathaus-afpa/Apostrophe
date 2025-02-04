package apostrophe.java.javaee.visiteur;
import apostrophe.java.Cache;
import apostrophe.java.javaee.PAGES;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import apostrophe.java.utilitaires.Log;
import java.io.IOException;
@WebServlet("/Accueil")
public class AccueilServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) {
		Log.info("Initialisation des données .......");
		Cache.initCache();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			request.setAttribute("page", PAGES.VISITEUR + PAGES.ACCUEIL);
			request.setAttribute("livres", Cache.getTop3LivresByQuantite());
			RequestDispatcher dispatcher = request.getRequestDispatcher(PAGES.APP);
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			Log.error(e.getMessage(), e);
		}
	}
}