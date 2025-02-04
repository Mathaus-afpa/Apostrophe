package apostrophe.java.javaee.visiteur;
import apostrophe.java.Cache;
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("app.jsp");
		dispatcher.forward(request, response);
	}
}