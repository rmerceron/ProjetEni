package fr.eni.projet.bo;

import java.util.Date;
import java.text.SimpleDateFormat;

public class ArticleVendu {
	
	private int noArticle;
	private String nom;
	private String description;
	private Date dateDebut;
	private Date dateFin;
	private int prixInitial;
	private int prixVente;
	private Categorie laCategorie;
	private Utilisateur acheteur;
	
	
	public ArticleVendu(int noArticle, String nom, String description, Date dateDebut, Date dateFin,
			int prixInitial, int prixVente, Categorie laCategorie, Utilisateur acheteur) {
		super();
		this.noArticle = noArticle;
		this.nom = nom;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.laCategorie = laCategorie;
		this.acheteur = acheteur;
	}
	
	public ArticleVendu(int noArticle, String nom, String description, Date dateDebut, Date dateFin, int prixInitial, int prixVente) {
		this.noArticle = noArticle;
		this.nom = nom;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
	}
	
	public ArticleVendu(String nom, String description, Categorie categorie, Date dateDebut, Date dateFin ) 
	{
		this.nom = nom;
		this.description = description;
		this.laCategorie = categorie;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public ArticleVendu() 
	{
		
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public Categorie getLaCategorie() {
		return laCategorie;
	}

	public void setLaCategorie(Categorie laCategorie) {
		this.laCategorie = laCategorie;
	}

	public Utilisateur getAcheteur() {
		return acheteur;
	}

	public void setAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}
	
	public String getDateFinEncheresFmt() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return simpleDateFormat.format(this.dateFin);
	}
	
	

}
