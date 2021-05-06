package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.ArticleVendu;

public class ArticleDAOJdbcImpl implements ArticleDAO {
	
	private static final String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, " +
			"date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES (?,?,?,?,?,?,?,?);";

	private static final String SELECT_ARTICLE = "SELECT no_article, nom_article, description, date_debut_encheres, "+
			"date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM articles_vendus;";

	private static final String UPDATE_ARTICLE = "UPDATE ARTICLES_VENDUS SET nom_article = ?, description = ?, " +
			"date_debut_encheres = ?, date_fin_encheres = ?, prix_initial = ?, prix_vente = ?, " +
			"no_utilisateur = ?, no_categorie = ? WHERE no_article = ?;";
	
	private static final String DELETE_ARTICLE = "DELETE FROM ARTICLES_VENDUS WHERE no_enchere = ?;";


	@Override
	public List<ArticleVendu> selectArticleVendus() 
	{
		return null;
	}

	@Override
	public ArticleVendu selectArticleVendu(int idArticleVendu) 
	{
		return null;
	}

	@Override
	public void insertArticleVendu(ArticleVendu article) 
	{
		
	}

	@Override
	public void updateArticleVendu(ArticleVendu article)
	{
		
	}

	@Override
	public void deleteArticleVendu(int idArticleVendu)
	{
		
	}

}
