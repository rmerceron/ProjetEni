package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.bo.Categorie;

public class CategorieDAOJdbcImpl implements CategorieDAO {

	// Permet de s�lectionner toutes les cat�gories de la bdd
	private static final String SELECT_ALL_CATEGORIES = "SELECT * FROM CATEGORIES";
	
	// Permet de r�cup�rer une cat�gorie en fonction de son ID
	private static final String SELECT_CATEGORIE_ID = "SELECT * FROM CATEGORIES WHERE no_categorie = ?";

	
	/**
	 * @return une liste de toutes les cat�gories 
	 */
	@Override
	public List<Categorie> selectAll() 
	{
		List<Categorie> listCategorie = new ArrayList<>();
		try(Connection cnx = ConnectionProvider.getConnection()) 
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_CATEGORIES);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) 
			{
				listCategorie.add(new Categorie(rs.getInt("no_categorie"), rs.getString("libelle")));
			}
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return listCategorie;
	}

	
	/**
	 * Permet de s�lectionner une cat�gorie en fonction de son ID
	 */
	@Override
	public Categorie selectById(int id) 
	{
		Categorie categorie = new Categorie();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_CATEGORIE_ID);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) 
			{
				categorie = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));
			}
			
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return categorie;
	}
	
	
}
