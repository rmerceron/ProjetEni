package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.*;


public interface EnchereDAO {
	
	
	public List<Enchere> selectEncheres();
	
	/**
	 * @param idEnchere
	 * @return Un enchere en fonction de son id
	 * @throws DALException 
	 */
	public Enchere selectEnchere(int idEnchere) throws DALException;
	
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
	
	/**
	 * 
	 * @param id_enchere
	 * @throws DALException 
	 */
	public Enchere getEnchereInnerJoin(Integer id_enchere) throws DALException;
	
	public void encherir(Integer idEnchere, Integer prix, Integer last) throws DALException;
}
