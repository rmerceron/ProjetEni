package fr.eni.projet.dal;

public abstract class DAOFactory {
	
	public static EnchereDAO getEnchereDAO()
	{
		return new EnchereDAOImpl();
	}

}