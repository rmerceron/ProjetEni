package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.bo.*;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	
	private static final String INSERT_USER = "insert into utilisateurs(pseudo, nom, prenom, email, telephone, rue, " +
			"code_postal, ville, mot_de_passe, credit, administrateur) values(?,?,?,?,?,?,?,?,?,?,?);";
	
	private static final String SELECT_USER = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, "+
			"ville, mot_de_passe, credit, administrateur FROM utilisateurs;";
	
	private static final String SELECT_CONNEXION = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, "+
			"ville, mot_de_passe, credit, administrateur FROM utilisateurs WHERE (pseudo = ? OR email = ?) AND mot_de_passe = ?";
	
	private static final String SELECT_USER_ID = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, "+
			"ville, mot_de_passe, credit, administrateur FROM utilisateurs WHERE no_utilisateur = ?;";
	
	private static final String SELECT_USER_PSEUDO = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, "+
			"ville, mot_de_passe, credit, administrateur FROM utilisateurs WHERE pseudo = ?;";
	
	private static final String SELECT_USER_MAIL = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, "+
			"ville, mot_de_passe, credit, administrateur FROM utilisateurs WHERE email = ?;";
	
	private static final String UPDATE_USER = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, " +
			"code_postal = ?, ville = ?, mot_de_passe = ?, credit = ?, administrateur = ? WHERE no_utilisateur = ?;";
	
	private static final String DELETE_USER = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?;";

	@Override
	public List<Utilisateur> selectUtilisateurs() {
		
		List<Utilisateur> listeUsers = new ArrayList<Utilisateur>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_USER);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) 
			{
				listeUsers.add(new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeUsers;
	}

	@Override
	public Utilisateur selectUtilisateur(int idUser) {
		Utilisateur utilisateur = new Utilisateur();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_USER_ID);
			pstmt.setInt(1, idUser);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) 
			{
				utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
			}
			
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return utilisateur;
	}

	@Override
	public Utilisateur insertUtilisateur(Utilisateur user) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			try {
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, user.getPseudo());
				pstmt.setString(2, user.getNom());
				pstmt.setString(3, user.getPrenom());
				pstmt.setString(4, user.getEmail());
				pstmt.setString(5, user.getTelephone());
				pstmt.setString(6, user.getRue());
				pstmt.setString(7, user.getCode_postal());
				pstmt.setString(8, user.getVille());
				pstmt.setString(9, user.getMdp());
				pstmt.setInt(10, user.getCredit());
				pstmt.setBoolean(11, user.isAdmin());
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					user.setNoUser(rs.getInt(1));
				}
				rs.close();
				pstmt.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Utilisateur updateUtilisateur(Utilisateur user) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			try {
				PreparedStatement pstmt = cnx.prepareStatement(UPDATE_USER);
				pstmt.setString(1, user.getPseudo());
				pstmt.setString(2, user.getNom());
				pstmt.setString(3, user.getPrenom());
				pstmt.setString(4, user.getEmail());
				pstmt.setString(5, user.getTelephone());
				pstmt.setString(6, user.getRue());
				pstmt.setString(7, user.getCode_postal());
				pstmt.setString(8, user.getVille());
				pstmt.setString(9, user.getMdp());
				pstmt.setInt(10, user.getCredit());
				pstmt.setBoolean(11, user.isAdmin());
				pstmt.setInt(12, user.getNoUser());
				pstmt.executeUpdate();

				pstmt.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void deleteUtilisateur(int idUser) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			try {
				PreparedStatement pstmt = cnx.prepareStatement(DELETE_USER);
				pstmt.setInt(1, idUser);
				
				pstmt.executeUpdate();

				pstmt.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Utilisateur selectByPseudo(String pseudoUser) {
		Utilisateur utilisateur = new Utilisateur();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_USER_PSEUDO);
			pstmt.setString(1, pseudoUser);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) 
			{
				utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("pseudo"), rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
			}
			
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return utilisateur;
	}

	@Override
	public Utilisateur selectByMail(String mailUser) {
		Utilisateur utilisateur = new Utilisateur();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_USER_MAIL);
			pstmt.setString(1, mailUser);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) 
			{
				utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("pseudo"), rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
			}
			
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return utilisateur;
	}

	@Override
	public Utilisateur seConnecter(String login, String password) throws DALException {
		Utilisateur user = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement selectConnexion = cnx.prepareStatement(SELECT_CONNEXION);
			selectConnexion.setString(1, login);
			selectConnexion.setString(2, login);
			selectConnexion.setString(3, password);
			ResultSet rs = selectConnexion.executeQuery();
			if(rs.next()) 
			{
				user = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
