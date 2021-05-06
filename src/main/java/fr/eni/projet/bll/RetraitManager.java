package fr.eni.projet.bll;

import java.util.List;

import fr.eni.projet.bo.Retrait;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.RetraitDAO;

public class RetraitManager {

	private RetraitDAO retraitDAO;
	
	
	/**
	 * Constructor
	 */
	public RetraitManager() 
	{
		this.retraitDAO = DAOFactory.getRetraitDAO();
	}
	
	/**
	 * @return Une liste de tous les retrait de la bdd
	 */
	public List<Retrait> recupAllRetraits() 
	{
		return retraitDAO.selectRetraits();
	}

	/**
	 * @param idRetrait
	 * @return un retrait en fonction de son id
	 */
	public Retrait recupRetrait(int idRetrait) 
	{
		return retraitDAO.selectRetrait(idRetrait);
	}

	/**
	 * Ajoute un retrait
	 * @param retrait
	 */
	public void ajouterRetrait(Retrait retrait) 
	{
		retraitDAO.insertRetrait(retrait);
	}

	/**
	 * Modifie un retrait
	 * @param retrait
	 */
	public void modifierRetrait(Retrait retrait) 
	{
		retraitDAO.updateRetrait(retrait);
	}

	/**
	 * Supprime un retrait
	 * @param idRetrait
	 */
	public void supprimerRetrait(int idRetrait) 
	{
		retraitDAO.deleteRetrait(idRetrait);
	}
}
