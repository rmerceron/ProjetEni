package fr.eni.projet.bll;

import java.util.List;

import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.UtilisateurDAO;

public class UtilisateurManager {
	
	private UtilisateurDAO utilisateurDAO;
	
	
	/**
	 * Constructor
	 */
	public UtilisateurManager() 
	{
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	/**
	 * @return Une liste de tous les utilisateurs
	 */
	public List<Utilisateur> recupAllUtilisateurs() 
	{
		return utilisateurDAO.selectUtilisateurs();
	}
	
	/**
	 * @param idUser
	 * @return Un utilisateur en fonction de son ID
	 */
	public Utilisateur recupUtilisateur(int idUser) 
	{
		return utilisateurDAO.selectUtilisateur(idUser);
	}
	
	/**
	 * @param pseudoUser
	 * @return Un utilisateur en fonction de son pseudo
	 */
	public Utilisateur recupUtilisateurPseudo(String pseudoUser) 
	{
		return utilisateurDAO.selectByPseudo(pseudoUser);
	}
	
	/**
	 * @param mailUser
	 * @return Un utilisateur en fonction de son mail
	 */
	public Utilisateur recupUtilisateurMail(String mailUser) 
	{
		return utilisateurDAO.selectByMail(mailUser);
	}
	
	/**
	 * Ajoute un utilisateur � la bdd
	 * @param user
	 */
	public void ajouterUtilisateur(Utilisateur user) 
	{
		utilisateurDAO.insertUtilisateur(user);
	}
	
	/**
	 * Modifie un utilisateur de la bdd
	 * @param user
	 */
	public void modifierUtilisateur(Utilisateur user) 
	{
		utilisateurDAO.updateUtilisateur(user);
	}
	
	/**
	 * Supprime un utilisateur de la bdd
	 * @param idUser
	 */
	public void supprimerUtilisateur(int idUser) 
	{
		utilisateurDAO.deleteUtilisateur(idUser);
	}

}
