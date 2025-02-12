package apostrophe.java.javaee;
public class PAGES {
	private PAGES() {}
	//<editor-fold defaultstate="expanded" desc="Prefix">
	public static final String GESTION = "/WEB-INF/Vues/Gestion";
	public static final String VISITEUR = "/WEB-INF/Vues/Visiteur";
	public static final String MEMBRE = "/WEB-INF/Vues/Membre";
	public static final String MODULE = "/WEB-INF/Modules";
	//</editor-fold>
	//<editor-fold defaultstate="expanded" desc="Pages Visiteurs">
	public static final String ACCUEIL = "/accueil.jsp";
	public static final String CGU = "/cgu.jsp";
	public static final String CONNEXION = "/connexion.jsp";
	public static final String INSCRIPTION = "/inscription.jsp";
	public static final String RECUPERATION = "/recuperation.jsp";
	public static final String DETAILS_LIVRE = "/Livres/livre.jsp";
	//</editor-fold>
	//<editor-fold defaultstate="expanded" desc="Pages Membres">
	public static final String EMPRUNT = "/emprunter.jsp";
	public static final String CLIENT = "/client.jsp";
	//</editor-fold>
	//<editor-fold defaultstate="expanded" desc="Pages Gestions">
	public static final String ADMINISTRATEUR = "/administrateur.jsp";
	public static final String LIBRAIRE = "/libraire.jsp";
	//</editor-fold>
	public static final String APP = "/app.jsp";
	public static final String TABLEAU = "/tableau.jsp";
}