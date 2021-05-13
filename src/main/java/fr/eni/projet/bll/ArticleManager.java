package fr.eni.projet.bll;

import java.sql.Connection;
import java.util.List;

import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Retrait;
import fr.eni.projet.dal.ArticleDAO;
import fr.eni.projet.dal.ConnectionProvider;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.RetraitDAO;

public class ArticleManager {

	private ArticleDAO articleDAO;
	
	
	public ArticleManager() 
	{
		this.articleDAO = DAOFactory.getArticleDAO();
	}
	
	
	/**
	 * @return Une liste de tous les articles de la bdd
	 */
	public List<ArticleVendu> recupAllArticleVendus() 
	{
		return articleDAO.selectArticleVendus();
	}
	
	/**
	 * @param nomArticle
	 * @param numCategorie
	 * @return une liste en fonction du nom de l'article ainsi que du numéro de la catégorie
	 */
	public List<ArticleVendu> recupArticleByCateAndNom(String nomArticle, int numCategorie)
	{
		return articleDAO.selectArticleVenduByCategorieEtNomArticle(nomArticle, numCategorie);
	}
	
	public List<ArticleVendu> recupArticleByCate(int numCategorie)
	{
		return articleDAO.selectArticleVenduByCategorie(numCategorie);
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
	
	/**
	 * Ajoute un article depuis la jsp NouvelleVente
	 * @param article
	 * @param retrait
	 */
	public void ajouterArticle(ArticleVendu article, Retrait retrait) 
	{
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			cnx.setAutoCommit(false);
			articleDAO.insertArticle(cnx, article);
			System.out.println(article.getNoArticle());
			retrait.setNoArticle(article.getNoArticle());
			
			RetraitDAO retraitDAO;
			retraitDAO = DAOFactory.getRetraitDAO();
			retraitDAO.insertRetrait(cnx, retrait);
			cnx.commit();
			
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}
