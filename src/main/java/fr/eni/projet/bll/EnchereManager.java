package fr.eni.projet.bll;

import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import fr.eni.projet.dal.DALException;
import fr.eni.projet.bo.BusinessException;
import fr.eni.projet.bo.Enchere;
import fr.eni.projet.dal.*;

public class EnchereManager {
	
	private EnchereDAO enchereDAO;
	

	public EnchereManager() 
	{
		this.enchereDAO = DAOFactory.getEnchereDAO();
	}
	
	public List<Enchere> recupAllEncheres() 
	{
		return enchereDAO.selectEncheres();
	}

	public Enchere recupEnchere(int idEnchere) throws DALException 
	{
		Enchere enchere = new Enchere();
		try {
			enchere = enchereDAO.selectEnchere(idEnchere);
		} catch (DALException e) {
			e.printStackTrace();
		}
		return enchere;
	}

	public void ajouterEnchere(Enchere enchere) 
	{
		enchereDAO.insertEnchere(enchere);
	}

	public void modifierEnchere(Enchere enchere) 
	{
		enchereDAO.updateEnchere(enchere);
	}

	public void supprimerEnchere(int idEnchere) 
	{
		enchereDAO.deleteEnchere(idEnchere);
	}
	
	public Enchere getEnchereInnerJoin(Integer no_enchere) throws BusinessException {

		Enchere enchere = null;
		try {
			enchere = enchereDAO.getEnchereInnerJoin(no_enchere);
		} catch (DALException e) {
			e.printStackTrace();
		}
		return enchere;
	}

	public void encherir(String id, String enchere, int idUser) throws BusinessException {
		try {
			Integer intEnchere = Integer.parseInt(id);
			Integer intPrix = Integer.parseInt(enchere);
			Integer intIdUserDeb = idUser;
			Enchere e = enchereDAO.getEnchereInnerJoin(intEnchere);
			if (compareDate(e.getArticle().getDateFin().toString())) {
				Integer newPrix = intPrix;
				enchereDAO.encherir(intEnchere, newPrix, intIdUserDeb);
			} else {
				throw new BusinessException("l'enchere est terminée");
			}
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		
	}
	
	private Boolean compareDate(String date) throws BusinessException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
		Date dateActuelle = new Date(System.currentTimeMillis());
		Date dateChoisie = null;
		try {
			dateChoisie = formatter.parse(date + ",23:59:59");
		} catch (ParseException e) {
			throw new BusinessException();
		}
		if (dateChoisie.compareTo(dateActuelle) >= 0) {
			return true;
		}
		return false;
	}

}
