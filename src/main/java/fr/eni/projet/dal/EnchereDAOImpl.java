package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Enchere;
import fr.eni.projet.bo.Retrait;
import fr.eni.projet.bo.Utilisateur;

public class EnchereDAOImpl implements EnchereDAO {
	
	//Requete Insert
	
	private static final String INSERT_RETRAIT = "INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (?,?,?,?);";
	
	private static final String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, " +
					"date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES (?,?,?,?,?,?,?,?);";
	
	private static final String INSERT_ENCHERE = "INSERT INTO ENCHERES (date_enchere, montant_enchere, no_article, no_utilisateur) " +
					"VALUES (?,?,?,?);";
	
	//Requete Select
	
	private static final String SELECT_ARTICLE = "SELECT no_article, nom_article, description, date_debut_encheres, "+
					"date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM articles_vendus;";
	
	private static final String SELECT_ENCHERE = "SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur FROM encheres;";
	
	private static final String SELECT_RETRAIT = "SELECT no_article, rue, code_postal, ville FROM retraits;";
	
	//Requete Update
	
	private static final String UPDATE_ENCHERE = "UPDATE ENCHERES SET date_enchere = ?, montant_enchere = ?, no_article = ?, no_utilisateur = ? " + 
					"WHERE no_enchere = ?;";
	
	private static final String UPDATE_ARTICLE = "UPDATE ARTICLES_VENDUS SET nom_article = ?, description = ?, " +
					"date_debut_encheres = ?, date_fin_encheres = ?, prix_initial = ?, prix_vente = ?, " +
					"no_utilisateur = ?, no_categorie = ? WHERE no_article = ?;";
	
	private static final String UPDATE_RETRAIT = "UPDATE RETRAITS SET rue = ?, code_postal = ?, ville = ? WHERE no_article = ?;";
	
	//Requete Delete
	
	private static final String DELETE_USER = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?;";
	
	private static final String DELETE_ENCHERE = "DELETE FROM ENCHERES WHERE no_article = ?;";
	
	private static final String DELETE_ARTICLE = "DELETE FROM ARTICLES_VENDUS WHERE no_enchere = ?;";
	
	private static final String DELETE_RETRAIT = "DELETE FROM ARTICLES_VENDUS WHERE no_enchere = ?;";
	
	
	@Override
	public List<Enchere> selectEncheres() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enchere selectEnchere(int idEnchere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertEnchere(Enchere enchere) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEnchere(Enchere enchere) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEnchere(int idEnchere) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Retrait> selectRetraits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Retrait selectRetrait(int idRetrait) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertRetrait(Retrait retrait) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRetrait(Retrait retrait) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRetrait(int idRetrait) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ArticleVendu> selectArticleVendus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleVendu selectArticleVendu(int idArticleVendu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertArticleVendu(ArticleVendu article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateArticleVendu(ArticleVendu article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArticleVendu(int idArticleVendu) {
		// TODO Auto-generated method stub
		
	}

}
