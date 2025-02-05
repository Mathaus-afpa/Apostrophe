package apostrophe.java.javaee.visiteur;
import apostrophe.java.javaee.PAGES;
import apostrophe.java.utilitaires.Log;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/Recuperation")
public class MotDePassePerduServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			request.setAttribute("page", PAGES.VISITEUR + PAGES.MDP);
			RequestDispatcher dispatcher = request.getRequestDispatcher(PAGES.APP);
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			Log.error(e.getMessage(), e);
		}
	}
}