package fr.eni.projet.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.bll.ArticleManager;
import fr.eni.projet.bll.CategorieManager;
import fr.eni.projet.bo.ArticleVendu;


@WebServlet("/AccueilServlet")
public class AccueilServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String path = "/WEB-INF/jsp/accueil.jsp";

  
    public AccueilServlet() {
    	
    }
    
    
    @Override
	public void init() throws ServletException 
    {

	}

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(path);
		
    	ServletContext sc = getServletContext();
    	HttpSession session = request.getSession();
    	CategorieManager categorieManager = new CategorieManager();
    	ArticleManager articleManager = new ArticleManager();
    	sc.setAttribute("listeArticleVendu", articleManager.recupAllArticleVendus());
    	sc.setAttribute("listeCategorie", categorieManager.recupAllCategorie());
    	
    	if(session.getAttribute("user") != null)
    	{
    		sc.setAttribute("listeArticleVendus", articleManager.recupAllArticleVendus());
    	}
    	
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		ArticleManager articleManager = new ArticleManager();
		RequestDispatcher rd = request.getRequestDispatcher(path);
		
		int categorie = Integer.parseInt(request.getParameter("categorieSelect"));
		String recherche = request.getParameter("recherche");
		List<ArticleVendu> listeArticle = new ArrayList<>();
		
		if(!request.getParameter("categorieSelect").equals(""))
		{
			if(!recherche.equals(""))
			{
				listeArticle = articleManager.recupArticleByCateAndNom(recherche, categorie);
			} 
			else 
			{
				listeArticle = articleManager.recupArticleByCate(categorie);
			}
		}
		
		request.setAttribute("listeArticleVendus", listeArticle);
		
		rd.forward(request, response);
	}
	

}
