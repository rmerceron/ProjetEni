package fr.eni.projet.ihm;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.bll.ArticleManager;
import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Categorie;
import fr.eni.projet.bo.Retrait;
import fr.eni.projet.bo.Utilisateur;


@WebServlet("/NouvelleVente")
public class NouvelleVente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String path = "/WEB-INF/jsp/nouvelleVente.jsp";
       
  
    public NouvelleVente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		SimpleDateFormat dateEnchere = new SimpleDateFormat("yyyy-MM-dd");
		Date dateDebutEncheres;
		Date dateFinEncheres;
		
		try 
		{
			dateDebutEncheres = dateEnchere.parse(request.getParameter("debutEnchere"));
			dateFinEncheres = dateEnchere.parse(request.getParameter("finEnchere"));
			ArticleVendu article = new ArticleVendu( (String) request.getParameter("article"), 
													 (String) request.getParameter("description"), 
													 new Categorie(Integer.parseInt(request.getParameter("categorie")), ""), 
													 dateDebutEncheres, 
													 dateFinEncheres);
													 article.setAcheteur((Utilisateur)session.getAttribute("user"));
													 article.setPrixInitial(Integer.parseInt(request.getParameter("miseaprix")));
													 
			Retrait retrait = new Retrait( (String) request.getParameter("rue"),
										   (String) request.getParameter("cp"),
										   (String) request.getParameter("ville"));
													 
			ArticleManager articleManager = new ArticleManager();
			articleManager.ajouterArticle(article, retrait);
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		
		
	}

}
