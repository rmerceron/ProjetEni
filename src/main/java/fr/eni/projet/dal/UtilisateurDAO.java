package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.Utilisateur;

public interface UtilisateurDAO {
	
	//Requetes Utilisateur
	
	public List<Utilisateur> selectUtilisateurs();
	
	public Utilisateur selectById(int idUser);
	
	public Utilisateur insertUtilisateur(Utilisateur user);
	
	public void updateUtilisateur(Utilisateur user);
	
	public void deleteUtilisateur(int idUser);

}
