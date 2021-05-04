package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.*;


public interface EnchereDAO {
	
	//Requetes Utilisateur
	
	public List<Utilisateur> selectUtilisateurs();
	
	public Utilisateur selectUtilisateur(int idUser);
	
	public void insertUtilisateur(Utilisateur user);
	
	public void updateUtilisateur(Utilisateur user);
	
	public void deleteUtilisateur(int idUser);
	
	//Requetes Enchere
	
	public List<Enchere> selectEncheres();
	
	public Enchere selectEnchere(int idEnchere);
	
	public void insertEnchere(Enchere enchere);
	
	public void updateEnchere(Enchere enchere);
	
	public void deleteEnchere(int idEnchere);
	
	//Requetes Retrait
	
	public List<Retrait> selectRetraits();
	
	public Retrait selectRetrait(int idRetrait);
	
	public void insertRetrait(Retrait retrait);
	
	public void updateRetrait(Retrait retrait);
	
	public void deleteRetrait(int idRetrait);
	
	//Requetes Article
	
	public List<ArticleVendu> selectArticleVendus();
	
	public ArticleVendu selectArticleVendu(int idArticleVendu);
	
	public void insertArticleVendu(ArticleVendu article);
	
	public void updateArticleVendu(ArticleVendu article);
	
	public void deleteArticleVendu(int idArticleVendu);
	
	//Requetes Catégorie
	
	public List<Categorie> selectCategories();
	
	public Categorie selectCategorie(int idCat);
	
	

}
