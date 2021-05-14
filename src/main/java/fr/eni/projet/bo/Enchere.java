package fr.eni.projet.bo;

import java.sql.Date;

public class Enchere {
	
	private int noEnchere;
	private Date dateEnchere;
	private int montant;
	private ArticleVendu article;
	private Utilisateur user;
	private Retrait retrait;
	private Utilisateur dernierEncherisseur;
	
	public Enchere() {

	}
	
	public Enchere(int noEnchere, Date dateEnchere, int montant, ArticleVendu article, Utilisateur user) {
		super();
		this.noEnchere = noEnchere;
		this.dateEnchere = dateEnchere;
		this.montant = montant;
		this.article = article;
		this.user = user;
	}

	public int getNoEnchere() {
		return noEnchere;
	}

	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}

	public Date getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(Date date) {
		this.dateEnchere = date;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public ArticleVendu getArticle() {
		return article;
	}

	public void setArticle(ArticleVendu article) {
		this.article = article;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
	public Retrait getRetrait() {
		return retrait;
	}

	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}

	public Utilisateur getDernierEncherisseur() {
		return dernierEncherisseur;
	}

	public void setDernierEncherisseur(Utilisateur dernierEncherisseur) {
		this.dernierEncherisseur = dernierEncherisseur;
	}

}
