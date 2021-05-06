package fr.eni.projet.dal;

public abstract class DAOFactory {
	
	public static EnchereDAO getEnchereDAO()
	{
		return new EnchereDAOJdbcImpl();
	}
	
	public static CategorieDAO getCategorieDAO() 
	{
		return new CategorieDAOJdbcImpl();
	}
	
	public static UtilisateurDAO getUtilisateurDAO() 
	{
		return new UtilisateurDAOJdbcImpl();
	}
	
	public static RetraitDAO getRetraitDAO() 
	{
		return new RetraitDAOJdbcImpl();
	}
	
	public static ArticleDAO getArticleDAO() 
	{
		return new ArticleDAOJdbcImpl();
	}

}
