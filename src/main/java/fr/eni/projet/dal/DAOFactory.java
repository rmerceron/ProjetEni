package main.java.fr.eni.projet.dal;

public abstract class DAOFactory {
	
	public static EnchereDAO getEnchereDAO()
	{
		return new EnchereDAOImpl();
	}
	
	public static CategorieDAO getCategorieDAO() 
	{
		return new CategorieDAOJdbcImpl();
	}

}
