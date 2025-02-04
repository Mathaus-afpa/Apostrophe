package apostrophe.java.javaee.visiteur;
import apostrophe.java.utilitaires.Log;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/Connexion")
public class ConnexionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			request.setAttribute("page", "/WEB-INF/Vues/Visiteur/connexion.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("app.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			Log.error(e.getMessage(), e);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}