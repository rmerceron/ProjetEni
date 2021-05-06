package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.Retrait;

public interface RetraitDAO {
	

	/**
	 * @return Une liste de tous les retraits
	 */
	public List<Retrait> selectRetraits();
	
	/**
	 * @param idRetrait
	 * @return Un retrait en fonction de son id
	 */
	public Retrait selectRetrait(int idRetrait);
	
	/**
	 *  Permet d'insérer un retrait
	 * @param retrait
	 */
	public void insertRetrait(Retrait retrait);
	
	/**
	 * Permet de modifier un retrait
	 * @param retrait
	 */
	public void updateRetrait(Retrait retrait);
	
	/**
	 * Permet de supprimer un retrait
	 * @param idRetrait
	 */
	public void deleteRetrait(int idRetrait);
	
}
