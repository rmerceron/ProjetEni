package main.java.fr.eni.projet.bll;

import main.java.fr.eni.projet.dal.*;

public class EnchereManager {
	
	private EnchereDAO enchereDAO;

	public EnchereManager() {
		this.enchereDAO = DAOFactory.getEnchereDAO();
	}

}
