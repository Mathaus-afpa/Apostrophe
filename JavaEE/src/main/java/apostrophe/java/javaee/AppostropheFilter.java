package apostrophe.java.javaee;
import apostrophe.java.javaee.connexion.ConnexionService;
import apostrophe.java.javaee.connexion.SuiviConnexion;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * [AppostropheFIlter] - class
 * @author Mathaus
 */
@WebFilter("/*")
public class AppostropheFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String uri = httpRequest.getRequestURI();
		String pathWithoutFile = uri.substring(0, uri.lastIndexOf('/'));
		if ("".equals(pathWithoutFile) || "/Images/Livres".equals(pathWithoutFile)) {
			chain.doFilter(request, response);
		} else {
			ConnexionService.processSession(httpRequest, httpResponse, chain);
		}
		SuiviConnexion.nettoyer();
	}
}