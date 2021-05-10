package fr.eni.projet.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
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
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/Inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int creditIntitial = 100; 
	private String path = "/WEB-INF/jsp/creationCompte.jsp";
       
    public InscriptionServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(path);
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurManager userMana = new UtilisateurManager();
		Utilisateur mailExist = userMana.recupUtilisateurMail(request.getParameter("email"));
		Utilisateur pseudoExist = userMana.recupUtilisateurPseudo(request.getParameter("pseudo"));
		
		if(pseudoExist.getNoUser() == 0 && mailExist.getNoUser() == 0) {
			Utilisateur newUser = new Utilisateur(request.getParameter("pseudo"),request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("email"), request.getParameter("telephone"), request.getParameter("rue"), request.getParameter("code_postal"), request.getParameter("ville"), request.getParameter("mdp"), creditIntitial, false);
			newUser = userMana.ajouterUtilisateur(newUser);
			try {
				newUser = userMana.seConnecter(newUser.getPseudo(), newUser.getMdp());
				HttpSession session = request.getSession(true);
				session.setAttribute("user", (Utilisateur) userMana.recupUtilisateur(newUser.getNoUser()));
				response.sendRedirect(request.getContextPath() + "/");
				
			} catch (BusinessException e) {
				request.setAttribute("errorMessage", "impossible de se connecter");
				request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
			}
		} else {
			//Message d'erreur données deja existante
			doGet(request, response);
		}
		
	}

}
