package fr.eni.projet.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bo.BusinessException;
import fr.eni.projet.bo.Utilisateur;

/**
 * Servlet implementation class CompteServlet
 */
@WebServlet(urlPatterns = {"/displayProfil", "/editProfil","/deleteProfil"})
public class CompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String displayPath = "/WEB-INF/jsp/profil.jsp";
	private String editPath = "/WEB-INF/jsp/modifierProfil.jsp";
       
    
    public CompteServlet() {
        super();
    }
    
    public void init() throws ServletException {
		
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getRequestURI().contains("deleteProfil")){
			UtilisateurManager userMana = new UtilisateurManager();
			userMana.supprimerUtilisateur(Integer.parseInt(request.getParameter("userId")));
			HttpSession session = request.getSession(true);
			session.removeAttribute("user");
			response.sendRedirect(request.getContextPath() + "/");
			
		} else {
			RequestDispatcher rd;
			if(request.getRequestURI().contains("editProfil")) {
				rd = request.getRequestDispatcher(editPath);
			} else {
				rd = request.getRequestDispatcher(displayPath);
			}
			
	    	ServletContext sc = getServletContext();
			HttpSession session = request.getSession(true);
			Utilisateur sessionUser = (Utilisateur) session.getAttribute("user");
			sc.setAttribute("user", sessionUser);
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurManager userMana = new UtilisateurManager();
		Utilisateur mailExist = userMana.recupUtilisateurMail(request.getParameter("email"));
		Utilisateur pseudoExist = userMana.recupUtilisateurPseudo(request.getParameter("pseudo"));
		int idUser = Integer.parseInt(request.getParameter("id"));
		Utilisateur oldUser = userMana.recupUtilisateur(idUser);
		
		if((pseudoExist.getNoUser() == 0 || pseudoExist.getNoUser() == idUser) && (mailExist.getNoUser() == 0|| mailExist.getNoUser() == idUser)) {
			System.out.println("j'y arrive");
			Utilisateur newUser = new Utilisateur(oldUser.getNoUser(), request.getParameter("pseudo"),request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("email"), request.getParameter("telephone"), request.getParameter("rue"), request.getParameter("code_postal"), request.getParameter("ville"), request.getParameter("mdp"), oldUser.getCredit(), oldUser.isAdmin());
			System.out.println(newUser.toString());
			newUser = userMana.modifierUtilisateur(newUser);
			System.out.println(newUser.toString());
			try {
				newUser = userMana.seConnecter(newUser.getPseudo(), newUser.getMdp());
				HttpSession session = request.getSession(true);
				session.removeAttribute("user");
				session.setAttribute("user", (Utilisateur) userMana.recupUtilisateur(newUser.getNoUser()));
				response.sendRedirect(request.getContextPath() + "/");
				
			} catch (BusinessException e) {
				request.setAttribute("errorMessage", "impossible de se connecter");
				request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
			}
		}
	}
	
	
	
}
