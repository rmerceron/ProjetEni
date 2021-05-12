package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Retrait;

public class RetraitDAOJdbcImpl implements RetraitDAO{

	private static final String INSERT_RETRAIT = "INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (?,?,?,?);";

	private static final String SELECT_RETRAIT = "SELECT no_article, rue, code_postal, ville FROM retraits;";

	private static final String UPDATE_RETRAIT = "UPDATE RETRAITS SET rue = ?, code_postal = ?, ville = ? WHERE no_article = ?;";

	private static final String DELETE_RETRAIT = "DELETE FROM ARTICLES_VENDUS WHERE no_enchere = ?;";

	
	@Override
	public List<Retrait> selectRetraits() 
	{
		return null;
	}

	@Override
	public Retrait selectRetrait(int idRetrait) 
	{
		return null;
	}

	@Override
	public void insertRetrait(Retrait retrait) 
	{
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			insertRetrait(cnx, retrait);
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void insertRetrait(Connection cnx, Retrait retrait) 
	{
		try 
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_RETRAIT);
			pstmt.setInt(1, retrait.getNoArticle());
			pstmt.setString(2, retrait.getRue());
			pstmt.setString(3, retrait.getCodePostal());
			pstmt.setString(4, retrait.getVille());
			
			pstmt.executeUpdate();

		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void updateRetrait(Retrait retrait) 
	{
		
	}

	@Override
	public void deleteRetrait(int idRetrait) 
	{
		
	}

}
