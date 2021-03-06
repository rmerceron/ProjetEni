package fr.eni.projet.dal;

import java.sql.Connection;
import java.util.List;

import fr.eni.projet.bo.ArticleVendu;

public interface ArticleDAO {
	

	/**
	 * @return Une liste de tous les articles
	 */
	public List<ArticleVendu> selectArticleVendus();
	
	/**
	 * 
	 * @param idArticleVendu
	 * @return Un utilsiateur en fonction de son ID
	 */
	public ArticleVendu selectArticleVendu(int idArticleVendu);
	
	/**
	 * Permet d'ajouter un article ? la bdd
	 * @param article
	 */
	public void insertArticleVendu(ArticleVendu article);
	
	/**
	 * Permet de mettre ? jour un article de la bdd
	 * @param article
	 */
	public void updateArticleVendu(ArticleVendu article);
	
	/**
	 * Permet de supprimer un article de la bdd
	 * @param idArticleVendu
	 */
	public void deleteArticleVendu(int idArticleVendu);
	
	/**
	 * Insert un article avec un retrait
	 * @param cnx
	 * @param article
	 */
	public void insertArticle(Connection cnx, ArticleVendu article);
	
	/**
	 * @return une liste en fonction de la categorie et du nom
	 */
	public List<ArticleVendu> selectArticleVenduByCategorieEtNomArticle(String nomArticle, int noCategorie);

	/**
	 * @param noCategorie
	 * @return une liste en fonction de la cat?gorie
	 */
	public List<ArticleVendu> selectArticleVenduByCategorie(int noCategorie);
}
