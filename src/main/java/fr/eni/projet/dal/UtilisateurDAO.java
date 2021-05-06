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
	 * Permet d'ajouter un utilisateur à la bdd
	 * @param user
	 */
	public void insertUtilisateur(Utilisateur user);
	
	/**
	 * Permet de mettre un jour un utilisateur de la bdd
	 * @param user
	 */
	public void updateUtilisateur(Utilisateur user);
	
	/**
	 * Permet de supprimer un utilisateur de la bdd
	 * @param idUser
	 */
	public void deleteUtilisateur(int idUser);
}
