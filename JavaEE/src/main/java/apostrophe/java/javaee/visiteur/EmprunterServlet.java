package apostrophe.java.javaee.visiteur;
import apostrophe.java.javaee.ROUTES;
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
		// Récupérer la session existante (false pour ne pas créer une nouvelle session si elle n'existe pas)
		HttpSession session = request.getSession(false);
		// Vérifier si la session existe et si l'utilisateur est bien authentifié
		if (session == null || session.getAttribute("username") == null) {
			response.sendRedirect(ROUTES.CONNEXION);  // Rediriger vers la page de login si pas authentifié
			return;
		}
	}
}