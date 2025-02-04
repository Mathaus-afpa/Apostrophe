package apostrophe.java.javaee.visiteur.livre;
import apostrophe.java.Cache;
import apostrophe.java.javaee.PAGES;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/Livres")
public class LivresServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			request.setAttribute("livres", Cache.listerLivres());
			request.setAttribute("page", PAGES.MODULE + PAGES.LISTE_LIVRES + "?module=LIVRES");
			RequestDispatcher dispatcher = request.getRequestDispatcher(PAGES.APP);
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			//todo: log
		}
	}
}