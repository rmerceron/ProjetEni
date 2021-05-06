package fr.eni.projet.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.bll.CategorieManager;


@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String path = "/WEB-INF/jsp/connexion.jsp";

  
    public ConnexionServlet() {
    	
    }
    
    
    @Override
	public void init() throws ServletException 
    {
    	ServletContext sc = getServletContext();
    	CategorieManager categorieManager = new CategorieManager();
    	sc.setAttribute("listeCategorie", categorieManager.recupAllCategorie());
	}

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(path);
		
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}