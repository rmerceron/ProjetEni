package fr.eni.projet.dal;

import java.util.List;

import fr.eni.projet.bo.Retrait;

public class RetraitDAOJdbcImpl implements RetraitDAO{

	private static final String INSERT_RETRAIT = "INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (?,?,?,?);";

	private static final String SELECT_RETRAIT = "SELECT no_article, rue, code_postal, ville FROM retraits;";

	private static final String UPDATE_RETRAIT = "UPDATE RETRAITS SET rue = ?, code_postal = ?, ville = ? WHERE no_article = ?;";

	private static final String DELETE_RETRAIT = "DELETE FROM ARTICLES_VENDUS WHERE no_enchere = ?;";

	
	@Override
	public List<Retrait> selectRetraits() {
		return null;
	}

	@Override
	public Retrait selectRetrait(int idRetrait) {
		return null;
	}

	@Override
	public void insertRetrait(Retrait retrait) {
		
	}

	@Override
	public void updateRetrait(Retrait retrait) {
		
	}

	@Override
	public void deleteRetrait(int idRetrait) {
		
	}

}
