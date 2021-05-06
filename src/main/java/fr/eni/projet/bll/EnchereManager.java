package fr.eni.projet.bll;

import fr.eni.projet.dal.EnchereDAO;

import java.util.List;

import fr.eni.projet.bo.Enchere;
import fr.eni.projet.dal.*;

public class EnchereManager {
	
	private EnchereDAO enchereDAO;
	

	public EnchereManager() 
	{
		this.enchereDAO = DAOFactory.getEnchereDAO();
	}
	
	public List<Enchere> recupAllEncheres() 
	{
		return enchereDAO.selectEncheres();
	}

	public Enchere recupEnchere(int idEnchere) 
	{
		return enchereDAO.selectEnchere(idEnchere);
	}

	public void ajouterEnchere(Enchere enchere) 
	{
		enchereDAO.insertEnchere(enchere);
	}

	public void modifierEnchere(Enchere enchere) 
	{
		enchereDAO.updateEnchere(enchere);
	}

	public void supprimerEnchere(int idEnchere) 
	{
		enchereDAO.deleteEnchere(idEnchere);
	}

}
