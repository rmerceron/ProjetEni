package fr.eni.projet.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.bo.BusinessException;
import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bo.Utilisateur;

@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager userManager;

	public ConnexionServlet() {
		super();
		userManager = new UtilisateurManager();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		  Cookie[] cookies = request.getCookies();
	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                if (cookie.getName().equals("id")) {
	                	
	                    request.setAttribute("identifiant", cookie.getValue());
	                }
	            }
	        }
		request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("identifiant");
		String password = request.getParameter("password");
		
		if (null != request.getParameter("seSouvenirDeMoi")) {
			
	        Cookie cookie = new Cookie("id", id);
	        cookie.setMaxAge(60 * 60 * 24 * 30);
	        response.addCookie(cookie);
		}
		
		try {
			Utilisateur user = userManager.seConnecter(id, password);
			HttpSession session = request.getSession(true);
			session.setAttribute("user", (Utilisateur) userManager.recupUtilisateur(user.getNoUser()));
			response.sendRedirect(request.getContextPath() + "/");
			
			
			
		} catch (BusinessException e) {
			request.setAttribute("errorMessage", "impossible de se connecter");
			request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
		}
		
	}
}
