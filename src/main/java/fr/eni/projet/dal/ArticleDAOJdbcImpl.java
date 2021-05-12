package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.projet.bo.ArticleVendu;

public class ArticleDAOJdbcImpl implements ArticleDAO {
	
	private static final String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, " +
			"date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES (?,?,?,?,?,?,?,?);";

	private static final String SELECT_ARTICLE = "SELECT no_article, nom_article, description, date_debut_encheres, "+
			"date_fin_encheres, prix_initial, prix_vente FROM articles_vendus;";

	private static final String SELECT_ARTICLE_ID = "SELECT no_article, nom_article, description, date_debut_encheres, "+
			"date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM articles_vendus WHERE no_article = ?;";
	
	private static final String UPDATE_ARTICLE = "UPDATE ARTICLES_VENDUS SET nom_article = ?, description = ?, " +
			"date_debut_encheres = ?, date_fin_encheres = ?, prix_initial = ?, prix_vente = ?, " +
			"no_utilisateur = ?, no_categorie = ? WHERE no_article = ?;";
	
	private static final String DELETE_ARTICLE = "DELETE FROM ARTICLES_VENDUS WHERE no_enchere = ?;";


	@Override
	public List<ArticleVendu> selectArticleVendus() 
	{
		List<ArticleVendu> listeArticle = new ArrayList<ArticleVendu>();
		try(Connection cnx = ConnectionProvider.getConnection()) 
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ARTICLE);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) 
			{
				listeArticle.add(new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),rs.getString("description"), new Date(rs.getTimestamp("date_debut_encheres").getTime()), new Date(rs.getTimestamp("date_fin_encheres").getTime()), rs.getInt("prix_initial"), rs.getInt("prix_vente")));
			}
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return listeArticle;
	}

	@Override
	public ArticleVendu selectArticleVendu(int idArticleVendu) 
	{
		ArticleVendu article = new ArticleVendu();
		try(Connection cnx = ConnectionProvider.getConnection()) 
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ARTICLE);
			pstmt.setInt(1, idArticleVendu);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) 
			{
				article = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),rs.getString("description"), new Date(rs.getTimestamp("date_debut_encheres").getTime()), new Date(rs.getTimestamp("date_fin_encheres").getTime()), rs.getInt("prix_initial"), rs.getInt("prix_vente"));
			}
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return article;
	}

	@Override
	public void insertArticleVendu(ArticleVendu article) 
	{
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			insertArticle(cnx, article);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void insertArticle(Connection cnx, ArticleVendu article) 
	{
		try
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, article.getNom());
			pstmt.setString(2, article.getDescription());
			pstmt.setTimestamp(3, new Timestamp(article.getDateDebut().getTime()));
			pstmt.setTimestamp(4, new Timestamp(article.getDateFin().getTime()));
			pstmt.setInt(5, article.getPrixInitial());
			pstmt.setInt(6, article.getPrixVente());
			pstmt.setInt(7, article.getAcheteur().getNoUser());
			pstmt.setInt(8, article.getLaCategorie().getNoCategorie());
			
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if(rs.next())
			{
				article.setNoArticle(rs.getInt(1));
			}
				
			rs.close();
			pstmt.close();

		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void updateArticleVendu(ArticleVendu article)
	{
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_ARTICLE);
			pstmt.setString(1, article.getNom());
			pstmt.setString(2, article.getDescription());
			pstmt.setTimestamp(3, new Timestamp(article.getDateDebut().getTime()));
			pstmt.setTimestamp(4, new Timestamp(article.getDateFin().getTime()));
			pstmt.setInt(5, article.getPrixInitial());
			pstmt.setInt(6, article.getPrixVente());
			pstmt.setInt(7, article.getLaCategorie().getNoCategorie());
			pstmt.setInt(8, article.getAcheteur().getNoUser());
			
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			
			rs.close();
			pstmt.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void deleteArticleVendu(int idArticleVendu)
	{
		try(Connection cnx = ConnectionProvider.getConnection()) 
		{
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_ARTICLE);
			pstmt.setInt(1, idArticleVendu);
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

}
