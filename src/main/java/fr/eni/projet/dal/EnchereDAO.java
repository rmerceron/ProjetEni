package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.*;


public interface EnchereDAO {
	
	
	/**
	 * @return Une liste de tous les encheres
	 */
	public List<Enchere> selectEncheres();
	
	/**
	 * @param idEnchere
	 * @return Un enchere en fonction de son id
	 */
	public Enchere selectEnchere(int idEnchere);
	
	/**
	 * Ajoute une enchere
	 * @param enchere
	 */
	public void insertEnchere(Enchere enchere);
	
	/**
	 * Mofidie une enchere
	 * @param enchere
	 */
	public void updateEnchere(Enchere enchere);
	
	/**
	 * Supprimer une enchere
	 * @param idEnchere
	 */
	public void deleteEnchere(int idEnchere);
	
	
}
