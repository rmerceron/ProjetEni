package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	
	// Requ�te qui permet d'ins�rer un utilisateur
	private static final String INSERT_USER = "insert into utilisateur(pseudo, nom, prenom, email, telephone, rue, " +
			"code_postal, ville, mot_de_passe, credit, administrateur) values(?,?,?,?,?,?,?,?,?,?,?);";
	
	// Requ�te qui permet de s�lectionner un utilisateur
	private static final String SELECT_USER = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, "+
			"ville, mot_de_passe, credit, administrateur FROM utilisateurs;";

	// Requ�te qui permet de mettre � jour un utilisateur
	private static final String UPDATE_USER = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, " +
			"code_postal = ?, ville = ?, mot_de_passe = ?, credit = ?, administrateur = ? WHERE no_utilisateur = ?;";

	// Requ�te qui permet de supprimer un utilisateur
	private static final String DELETE_USER = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?;";

	
	@Override
	public List<Utilisateur> selectUtilisateurs() {
		return null;
	}

	@Override
	public Utilisateur selectUtilisateur(int idUser) {
		return null;
	}

	@Override
	public void insertUtilisateur(Utilisateur user) {
		
	}

	@Override
	public void updateUtilisateur(Utilisateur user) {
		
	}

	@Override
	public void deleteUtilisateur(int idUser) {
		
	}

}
