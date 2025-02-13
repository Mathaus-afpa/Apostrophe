package apostrophe.java.livre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * [LivreRequetes] - class
 * @author Mathaus
 */
public class LivreRequetes {
	private LivreRequetes() {}
	//<editor-fold defaultstate="expanded" desc="Champs BDD">
	public final static String CHAMPS_ID = "liv_id";
	public final static String CHAMPS_TITRE = "liv_titre";
	public final static String CHAMPS_RESUME = "liv_resume";
	public final static String CHAMPS_IMAGE = "liv_image";
	public final static String CHAMPS_ISBN = "liv_isbn";
	public final static String CHAMPS_QUANTITE = "liv_quantite";
	public final static String CHAMPS_CATEGORIE = "cat_id";
	public final static String CHAMPS_AUTEUR = "aut_id";
	//</editor-fold>
	//<editor-fold defaultstate="expanded" desc="INSERT">
	public static final String INSERT  = ""; //todo:
	public static final PreparedStatement Insert(Connection connection, Livre livre) throws SQLException {
		PreparedStatement requetePreparee = connection.prepareStatement(LivreRequetes.INSERT);
		requetePreparee.setString(1, livre.getTitre());			//login
		//todo: client ?
		return requetePreparee;
	}
	//</editor-fold>
	//<editor-fold defaultstate="expanded" desc="SELECT ONE">
	public static final String SELECT_ONE  = ""; //todo:
	public static final PreparedStatement SelectById(Connection connection, int id) throws SQLException {
		PreparedStatement requetePreparee = connection.prepareStatement(LivreRequetes.SELECT_ONE);
		requetePreparee.setInt(1, id);
		return requetePreparee;
	}
	//</editor-fold>
	//<editor-fold defaultstate="expanded" desc="SELECT ALL">
	public static final String SELECT_ALL  =  "SELECT " + CHAMPS_ID + ", " + CHAMPS_TITRE + ", " + CHAMPS_RESUME + ", " + CHAMPS_IMAGE
			+ ", " + CHAMPS_ISBN + ", " + CHAMPS_QUANTITE + ", " + CHAMPS_CATEGORIE + ", " + CHAMPS_AUTEUR + " FROM LIVRE";
	//</editor-fold>
	//<editor-fold defaultstate="expanded" desc="UPDATE">
	public static final String UPDATE = ""; //todo:
	public static final PreparedStatement Update(Connection connection, Livre livre) throws SQLException {
		PreparedStatement requetePreparee = connection.prepareStatement(LivreRequetes.UPDATE);
		//todo :
		return requetePreparee;
	}
	//</editor-fold>
	//<editor-fold defaultstate="expanded" desc="DELETE">
	public static final String DELETE = "DELETE FROM USERS WHERE " + CHAMPS_ID + " = ?";
	public static final PreparedStatement Delete(Connection connection, int id) throws SQLException {
		PreparedStatement requetePreparee = connection.prepareStatement(LivreRequetes.DELETE);
		requetePreparee.setInt(1, id);
		return requetePreparee;
	}
	//</editor-fold>
}