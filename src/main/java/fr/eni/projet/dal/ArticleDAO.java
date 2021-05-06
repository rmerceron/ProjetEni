package fr.eni.projet.dal;

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
	 * Permet d'ajouter un article à la bdd
	 * @param article
	 */
	public void insertArticleVendu(ArticleVendu article);
	
	/**
	 * Permet de mettre à jour un article de la bdd
	 * @param article
	 */
	public void updateArticleVendu(ArticleVendu article);
	
	/**
	 * Permet de supprimer un article de la bdd
	 * @param idArticleVendu
	 */
	public void deleteArticleVendu(int idArticleVendu);
}
