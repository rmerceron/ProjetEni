package fr.eni.projet.dal;

import fr.eni.projet.bo.Categorie;
import java.util.List;


public interface CategorieDAO {

	/**
	 * @return une liste de toutes les cat�gories
	 */
	public List<Categorie> selectAll();
	
	/**
	 * @param id = idUtilisateurs
	 * @return une categorie en fonction de son id
	 */
	public Categorie selectById(int id);
	
}
