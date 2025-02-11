package apostrophe.java.javaee.membre;
import apostrophe.java.javaee.ROUTES;
import apostrophe.java.javaee.services.SessionService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/Deconnexion")
public class DeconnexionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SessionService.nettoyerSession(request);
		response.sendRedirect(ROUTES.ACCUEIL);
	}
}