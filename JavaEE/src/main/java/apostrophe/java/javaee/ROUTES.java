package apostrophe.java.javaee;
public class ROUTES {
	private ROUTES() {}
	//<editor-fold defaultstate="expanded" desc="#VISITEURS SERVLETS">
		//<editor-fold defaultstate="expanded" desc="AccueilServlet">
		public static String EMPTY = "/";
		public static String ACCUEIL = "/Accueil";
		//</editor-fold>
		//<editor-fold defaultstate="expanded" desc="CguServlet">
		public static String CGU = "/CGU";
		//</editor-fold>
		//<editor-fold defaultstate="expanded" desc="ConnexionServlet">
		public static String CONNEXION = "/Connexion";
		//</editor-fold>
		//<editor-fold defaultstate="expanded" desc="EmprunterServlet">
		public static String EMPRUNTER = "/Emprunter?livre=";
		//</editor-fold>
		//<editor-fold defaultstate="expanded" desc="InscriptionServlet">
		public static String INSCRIPTION = "/Inscription";
		//</editor-fold>
		//<editor-fold defaultstate="expanded" desc="RecuperationServlet">
		public static String RECUPERATION = "/Recuperation";
		//</editor-fold>
		//<editor-fold defaultstate="expanded" desc="Servlet">
		public static String LIVRES = "/Livres";
		//</editor-fold>
		//<editor-fold defaultstate="expanded" desc="Servlet">
		public static String LIVRE = "/Livre?id=";
		//</editor-fold>
	//</editor-fold>
	//<editor-fold defaultstate="expanded" desc="#MEMBRES SERVLETS">
		//<editor-fold defaultstate="expanded" desc="Servlet">
		public static String CLIENT = "/Client";
		//</editor-fold>
		//<editor-fold defaultstate="expanded" desc="ConnexionServlet">
		public static String DECONNEXION = "/Deconnexion";
		//</editor-fold>
	//</editor-fold>
	//<editor-fold defaultstate="expanded" desc="#GESTIONS SERVLETS">
		//<editor-fold defaultstate="expanded" desc="Servlet">
		public static String LIBRAIRE = "/Libraire";
		//</editor-fold>
		//<editor-fold defaultstate="expanded" desc="Servlet">
		public static String ADMINISTRATEUR = "/Administrateur";
		//</editor-fold>
	//</editor-fold>
	//<editor-fold defaultstate="expanded" desc="#ERREURS SERVLETS">
		//<editor-fold defaultstate="expanded" desc="Servlet">
		public static String UNAUTHORIZED = "/Unauthorized";		//401
		//</editor-fold>
		//<editor-fold defaultstate="expanded" desc="Servlet">
		public static String FORBIDDEN_ERR = "/Forbidden";			//403
		//</editor-fold>
		//<editor-fold defaultstate="expanded" desc="Servlet">
		public static String NOTFOUND_ERR = "/NotFound";			//404
		//</editor-fold>
		//<editor-fold defaultstate="expanded" desc="Servlet">
		public static String NOTALLOWED_ERR = "/MethodNotAllowed";	//405
		//</editor-fold>
		//<editor-fold defaultstate="expanded" desc="Servlet">
		public static String INTERNAL_ERR = "/InternalServerError";	//500
		//</editor-fold>
	//</editor-fold>
	//<editor-fold defaultstate="expanded" desc="Servlet">

	//</editor-fold>
}