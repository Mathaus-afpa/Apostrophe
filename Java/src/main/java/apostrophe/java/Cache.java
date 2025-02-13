package apostrophe.java;
import apostrophe.java.auteur.Auteur;
import apostrophe.java.auteur.AuteurDAO;
import apostrophe.java.categorie.Categorie;
import apostrophe.java.categorie.CategorieDAO;
import apostrophe.java.client.Client;
import apostrophe.java.client.ClientDAO;
import apostrophe.java.compte.Compte;
import apostrophe.java.compte.CompteDAO;
import apostrophe.java.exceptions.ModelException;
import apostrophe.java.exceptions.NullDataException;
import apostrophe.java.libraire.Libraire;
import apostrophe.java.libraire.LibraireDAO;
import apostrophe.java.livre.Livre;
import apostrophe.java.livre.LivreDAO;
import apostrophe.java.services.DataDB;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
/**
 * [Cache] - class
 * @author Mathaus
 */
public class Cache {
	private Cache() {}
	//<editor-fold defaultstate="expanded" desc="CACHE MAPS">
	private static final TreeMap<Integer, Auteur> AUTEURS = new TreeMap<>();
	private static final TreeMap<Integer, Categorie> CATEGORIES = new TreeMap<>();
	private static final TreeMap<Integer, Client> CLIENTS = new TreeMap<>();
	private static final TreeMap<Integer, Compte> COMPTES = new TreeMap<>();
	private static final TreeMap<Integer, Libraire> LIBRAIRES = new TreeMap<>();
	private static final TreeMap<Integer, Livre> LIVRES = new TreeMap<>();
	private static boolean isLoaded = false;
	//</editor-fold>
	//<editor-fold defaultstate="expanded" desc="FONCTIONS CACHE">
	/**
	 * Ajoute un objet au cache.
	 * @param data
	 * @throws NullDataException
	 * @throws ModelException
	 */
	public static void ajouter(Object data) throws NullDataException, ModelException {
		switch (data) {
			case Auteur auteur -> AUTEURS.put(auteur.getId(), auteur);
			case Categorie categorie -> CATEGORIES.put(categorie.getId(), categorie);
			case Client client -> CLIENTS.put(client.getId(), client);
			case Compte compte -> COMPTES.put(compte.getId(), compte);
			case Libraire libraire -> LIBRAIRES.put(libraire.getId(), libraire);
			case Livre livre -> LIVRES.put(livre.getId(), livre);
			case null -> throw new NullDataException("Cache.ajouter", data.getClass().getName());
			default -> throw new ModelException("Cache.ajouter", data.getClass().getName());
		}
	}
	/**
	 * Retire un element du cache
	 * @param data
	 * @throws NullDataException
	 * @throws ModelException
	 */
	public static void retirer(Object data) throws NullDataException, ModelException {
		switch (data) {
			case Auteur auteur -> AUTEURS.remove(auteur.getId());
			case Categorie categorie -> CATEGORIES.remove(categorie.getId());
			case Client client -> CLIENTS.remove(client.getId());
			case Compte compte -> COMPTES.remove(compte.getId());
			case Libraire libraire -> LIBRAIRES.remove(libraire.getId());
			case Livre livre -> LIVRES.remove(livre.getId());
			case null -> throw new NullDataException("Cache.retirer", data.getClass().getName());
			default -> throw new ModelException("Cache.retirer", data.getClass().getName());
		}
	}
	//</editor-fold>
	//<editor-fold defaultstate="expanded" desc="LIRE DONNEE">
	//	AUTEURS
	public static List<Auteur> listerAuteurs() {
		return new ArrayList<>(AUTEURS.values());
	}
	public static Auteur getAuteur(int id) throws NullDataException {
		Auteur auteur = AUTEURS.get(id);
		if (auteur == null) throw new NullDataException("Cache.getAuteur");
		return auteur;
	}
	//	CATEGORIES
	public static List<Categorie> listerCategories() {
		return new ArrayList<>(CATEGORIES.values());
	}
	public static Categorie getCategorie(int id) throws NullDataException {
		Categorie categorie = CATEGORIES.get(id);
		if (categorie == null) throw new NullDataException("Cache.getCategorie");
		return categorie;
	}
	//	CLIENTS
	public static List<Client> listerClients() {
		return new ArrayList<>(CLIENTS.values());
	}
	public static Client getClient(int id) throws NullDataException {
		Client client = CLIENTS.get(id);
		if (client == null) throw new NullDataException("Cache.getClient");
		return client;
	}
	//	COMPTES
	public static List<Compte> listerComptes() {
		return new ArrayList<>(COMPTES.values());
	}
	public static Compte getCompte(int id) throws NullDataException {
		Compte compte = COMPTES.get(id);
		if (compte == null) throw new NullDataException("Cache.getCompte");
		return compte;
	}
	//	LIBRAIRES
	public static List<Libraire> listerLibraires() {
		return new ArrayList<>(LIBRAIRES.values());
	}
	public static Libraire getLibraire(int id) throws NullDataException {
		Libraire libraire = LIBRAIRES.get(id);
		if (libraire == null) throw new NullDataException("Cache.getLibraire");
		return libraire;
	}
	//	LIVRES
	public static List<Livre> listerLivres() {
		return new ArrayList<>(LIVRES.values());
	}
	public static List<Livre> listerLeTopLivresParQuantite() {
		// Trier les livres par quantité en ordre décroissant
		List<Livre> sortedLivres = listerLivres();
		sortedLivres.sort((l1, l2) -> Integer.compare(l2.getQuantite(), l1.getQuantite()));
		// Retourner les 3 premiers livres
		return sortedLivres.size() > 3 ? sortedLivres.subList(0, 3) : sortedLivres;
	}
	public static Livre getLivre(int id) throws NullDataException {
		Livre livre = LIVRES.get(id);
		if (livre == null) throw new NullDataException("Cache.getLivre");
		return livre;
	}
	//</editor-fold>
	//<editor-fold defaultstate="expanded" desc="EFFACEMENT DES CACHES">
	public static void clearAuteurs() {
		AUTEURS.clear();
	}
	public static void clearCategories() {
		CATEGORIES.clear();
	}
	public static void clearClients() {
		CLIENTS.clear();
	}
	public static void clearComptes() {
		COMPTES.clear();
	}
	public static void clearLibraires() {
		LIBRAIRES.clear();
	}
	public static void clearLivres() {
		LIVRES.clear();
	}
	//</editor-fold>
	//<editor-fold defaultstate="expanded" desc="INITIALISER LES CACHES">
	public static void initCache() {
		if (!isLoaded) {
			DataDB.setForcerRequete(true);
			AuteurDAO.rechercherTout();
			CategorieDAO.rechercherTout();
			ClientDAO.rechercherTout();
			CompteDAO.rechercherTout();
			LibraireDAO.rechercherTout();
			LivreDAO.rechercherTout();
			isLoaded = true;
			DataDB.setForcerRequete(false);
		}
	}
	//</editor-fold>
	public static Compte CompteExist(String name) {
		List<Compte> comptes = listerComptes();
		return comptes.stream()
				.filter(compte -> compte.getLogin().equals(name))
				.findFirst().orElse(null);
	}
}