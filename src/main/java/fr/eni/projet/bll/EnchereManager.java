package fr.eni.projet.bll;

import fr.eni.projet.dal.EnchereDAO;
import fr.eni.projet.dal.*;

public class EnchereManager {
	
	private EnchereDAO enchereDAO;

	public EnchereManager() {
		this.enchereDAO = DAOFactory.getEnchereDAO();
	}

}
