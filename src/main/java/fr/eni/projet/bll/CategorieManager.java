package fr.eni.projet.bll;

import java.util.List;

import fr.eni.projet.bo.Categorie;
import fr.eni.projet.dal.CategorieDAO;
import fr.eni.projet.dal.DAOFactory;

public class CategorieManager {

	private CategorieDAO categorieDAO;
	
	
	public CategorieManager() 
	{
		this.categorieDAO = DAOFactory.getCategorieDAO();
	}
	
	
	/**
	 * @return une liste de toute les categories
	 */
	public List<Categorie> recupAllCategorie() 
	{
		return categorieDAO.selectAll();
	}
	
	/**
	 * @param id = no_categorie
	 * @return Une categorie
	 */
	public Categorie recupCategorieById(int id) 
	{
		return categorieDAO.selectById(id);
	}
}
