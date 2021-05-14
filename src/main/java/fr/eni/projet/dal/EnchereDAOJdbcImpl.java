package fr.eni.projet.dal;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projet.bo.Categorie;
import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Enchere;
import fr.eni.projet.bo.Retrait;
import fr.eni.projet.bo.Utilisateur;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	
	private static final String INSERT_ENCHERE = "INSERT INTO ENCHERES (date_enchere, montant_enchere, no_article, no_utilisateur) " +
					"VALUES (?,?,?,?);";
		
	private static final String SELECT_ENCHERE = "SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur FROM encheres;";
	
	private static final String FIND_BY_ID = "SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur FROM encheres WHERE no_enchere = ? ";
	
	private static final String UPDATE_ENCHERE = "UPDATE ENCHERES SET date_enchere = ?, montant_enchere = ?, no_article = ?, no_utilisateur = ? " + 
					"WHERE no_enchere = ?;";
	
	private static final String DELETE_ENCHERE = "DELETE FROM ENCHERES WHERE no_article = ?;";
	
	private final String INNER_JOIN = "SELECT a.no_article, a.nom_article, a.description, a.date_debut_encheres, a.date_fin_encheres, a.prix_initial, a.prix_vente, c.no_categorie, c.libelle, e.no_enchere, e.date_enchere, e.montant_enchere, r.no_article, r.rue as retraitRue, r.code_postal as retraitCP, r.ville as retraitVille, u.no_utilisateur, u.pseudo,u.prenom, u.nom, u.email, u.telephone, u.rue, u.code_postal, u.ville, u.credit,u2.no_utilisateur as no_utilisateurEN, u2.pseudo as pseudoEN,u2.prenom as prenomEN, u2.nom as nomEN, u2.email as emailEN, u2.telephone as telephoneEN, u2.rue as rueEN, u2.code_postal as code_postalEN, u2.ville as villeEN, u2.credit as creditEN\n"
			+ "FROM ARTICLES_VENDUS a \n" 
			+ "INNER JOIN ENCHERES e ON a.no_article = e.no_article \n"
			+ "INNER JOIN RETRAITS r ON r.no_article = a.no_article \n"
			+ "INNER JOIN CATEGORIES c ON c.no_categorie = a.no_categorie \n"
			+ "INNER JOIN UTILISATEURS u ON u.no_utilisateur = a.no_utilisateur \n"
			+ "LEFT JOIN UTILISATEURS u2 ON u2.no_utilisateur = e.no_utilisateur where no_enchere=?";
	
	private final String ENCHERIR = "UPDATE ENCHERES set montant_enchere = ?, date_enchere =? WHERE no_enchere = ?";
	
	
	@Override
	public List<Enchere> selectEncheres() {
		return null;
	}

	@Override
	public Enchere selectEnchere(int idEnchere) throws DALException {
		Enchere enchere = new Enchere();

		try (Connection connection = ConnectionProvider.getConnection()) {

			PreparedStatement ps = connection.prepareStatement(FIND_BY_ID);
			ps.setInt(1, idEnchere);

			ResultSet rs = ps.executeQuery();

			enchere.setNoEnchere(rs.getInt("no_enchere"));
			enchere.setDateEnchere(rs.getDate("date_enchere"));
			enchere.setMontant(rs.getInt("montant_enchere"));
			enchere.getArticle().setNoArticle(rs.getInt("no_article"));
			enchere.getUser().setNoUser(rs.getInt("no_utilisateur"));

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e);
		}
		return enchere;
	}

	@Override
	public void insertEnchere(Enchere enchere) {
		
	}

	@Override
	public void updateEnchere(Enchere enchere) {
		
	}

	@Override
	public void deleteEnchere(int idEnchere) {
		
	}

	@Override
	public Enchere getEnchereInnerJoin(Integer id_enchere) throws DALException {

		Enchere enchere = new Enchere();
		ArticleVendu article = new ArticleVendu();
		Retrait retrait = new Retrait();
		Utilisateur utilisateur = new Utilisateur();
		Utilisateur encherisseur = new Utilisateur();

		try (Connection connection = ConnectionProvider.getConnection()) {

			PreparedStatement ps = connection.prepareStatement(INNER_JOIN);
			ps.setInt(1, id_enchere);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				enchere.setNoEnchere(rs.getInt("no_enchere"));
				article.setNoArticle(rs.getInt("no_article"));
				article.setNom(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setLaCategorie(
						new Categorie(Integer.parseInt(rs.getString("no_categorie")), rs.getString("libelle")));
				article.setDateDebut(rs.getDate("date_debut_encheres"));
				article.setDateFin(rs.getDate("date_fin_encheres"));

				retrait.setNoArticle(rs.getInt("no_article"));
				retrait.setRue(rs.getString("retraitRue"));
				retrait.setCodePostal(rs.getString("retraitCP"));
				retrait.setVille(rs.getString("retraitVille"));

				utilisateur.setNoUser(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCode_postal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));

				encherisseur.setNoUser(rs.getInt("no_utilisateurEN"));
				encherisseur.setPseudo(rs.getString("pseudoEN"));
				encherisseur.setPrenom(rs.getString("prenomEN"));
				encherisseur.setEmail(rs.getString("emailEN"));
				encherisseur.setTelephone(rs.getString("telephoneEN"));
				encherisseur.setNom(rs.getString("nomEN"));
				encherisseur.setRue(rs.getString("rueEN"));
				encherisseur.setCode_postal(rs.getString("code_postalEN"));
				encherisseur.setVille(rs.getString("villeEN"));

				enchere.setNoEnchere(rs.getInt("no_enchere"));
				enchere.setDateEnchere(rs.getDate("date_enchere"));
				enchere.setMontant(rs.getInt("montant_enchere"));
				enchere.setArticle(article);
				enchere.setUser(utilisateur);
				enchere.setDernierEncherisseur(encherisseur);
				enchere.setRetrait(retrait);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e);
		}

		return enchere;
	}

	@Override
	public void encherir(Integer idEnchere, Integer prix, Integer last) throws DALException {

		try (Connection connection = ConnectionProvider.getConnection()) {

			PreparedStatement ps = connection.prepareStatement(ENCHERIR);

			ps.setInt(1, prix);
			ps.setInt(2, last);
			ps.setInt(3, idEnchere);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e);
		}
	}

}
