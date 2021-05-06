package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Enchere;
import fr.eni.projet.bo.Retrait;
import fr.eni.projet.bo.Utilisateur;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	
	private static final String INSERT_ENCHERE = "INSERT INTO ENCHERES (date_enchere, montant_enchere, no_article, no_utilisateur) " +
					"VALUES (?,?,?,?);";
		
	private static final String SELECT_ENCHERE = "SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur FROM encheres;";
	
	private static final String UPDATE_ENCHERE = "UPDATE ENCHERES SET date_enchere = ?, montant_enchere = ?, no_article = ?, no_utilisateur = ? " + 
					"WHERE no_enchere = ?;";
	
	private static final String DELETE_ENCHERE = "DELETE FROM ENCHERES WHERE no_article = ?;";
	
	
	@Override
	public List<Enchere> selectEncheres() {
		return null;
	}

	@Override
	public Enchere selectEnchere(int idEnchere) {
		return null;
	}

	@Override
	public void insertEnchere(Enchere enchere) {
		
	}

	@Override
	public void updateEnchere(Enchere enchere) {
		
	}

	@Override
	public void deleteEnchere(int idEnchere) {
		
	}

}
