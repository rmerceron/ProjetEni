package fr.eni.projet.bll;

import java.util.List;

import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.dal.ArticleDAO;

public class ArticleManager {

	private ArticleDAO articleDAO;
	
	/**
	 * @return Une liste de tous les articles de la bdd
	 */
	public List<ArticleVendu> recupAllArticleVendus() 
	{
		return articleDAO.selectArticleVendus();
	}

	/**
	 * @param idArticleVendu
	 * @return Un article de la bdd
	 */
	public ArticleVendu recupArticleVendu(int idArticleVendu) 
	{
		return articleDAO.selectArticleVendu(idArticleVendu);
	}

	/**
	 * Ajoute un article à la bdd
	 * @param article
	 */
	public void ajouterArticleVendu(ArticleVendu article) 
	{
		articleDAO.insertArticleVendu(article);
	}

	/**
	 * Modifie un article de la bdd
	 * @param article
	 */
	public void modifierArticleVendu(ArticleVendu article)
	{
		articleDAO.updateArticleVendu(article);
	}

	/**
	 * Supprime un article de la bdd
	 * @param idArticleVendu
	 */
	public void supprimerArticleVendu(int idArticleVendu)
	{
		articleDAO.deleteArticleVendu(idArticleVendu);
	}

}
