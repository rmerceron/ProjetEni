package main.java.fr.eni.projet.bo;

import java.time.LocalDate;

public class Enchere {
	
	private int noEnchere;
	private LocalDate dateEnchere;
	private int montant;
	private ArticleVendu article;
	private Utilisateur user;
	
	public Enchere() {

	}
	
	public Enchere(int noEnchere, LocalDate dateEnchere, int montant, ArticleVendu article, Utilisateur user) {
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

	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
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
	
		

}
