package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.Utilisateur;

public interface UtilisateurDAO {

	/**
	 * @return Une liste de tous les utilisateurs
	 */
	public List<Utilisateur> selectUtilisateurs();
	
	/**
	 * @param idUser
	 * @return Un utilisateur en fonction de son id
	 */
	public Utilisateur selectUtilisateur(int idUser);
	
	/**
	 * @param pseudoUser
	 * @return Un utilisateur en fonction de son pseudo
	 */
	public Utilisateur selectByPseudo(String pseudoUser);
	
	/**
	 * @param mailUser
	 * @return Un utilisateur en fonction de son mail
	 */
	public Utilisateur selectByMail(String mailUser);
	
	/**
	 * Permet d'ajouter un utilisateur � la bdd
	 * @param user
	 */
	public Utilisateur insertUtilisateur(Utilisateur user);
	
	/**
	 * Permet de mettre un jour un utilisateur de la bdd
	 * @param user
	 */
	public Utilisateur updateUtilisateur(Utilisateur user);
	
	/**
	 * Permet de supprimer un utilisateur de la bdd
	 * @param idUser
	 */
	public void deleteUtilisateur(int idUser);
	
	/**
	 * @param var1
	 * @param var2
	 * @return
	 * @throws DALException
	 */
	Utilisateur seConnecter(String pseudo, String password) throws DALException;
}
