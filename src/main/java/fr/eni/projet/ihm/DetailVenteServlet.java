package fr.eni.projet.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.bll.EnchereManager;
import fr.eni.projet.bo.BusinessException;
import fr.eni.projet.bo.Enchere;

@WebServlet("/detailVente")
public class DetailVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EnchereManager enchereManager;

	public DetailVenteServlet() {
		enchereManager = new EnchereManager();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Enchere enchere = null;
		Integer idEnchere = null;

		try {
			idEnchere = Integer.parseInt(request.getParameter("id_enchere"));
			System.out.println(request.getParameter("error"));
			if (idEnchere <= 0 || idEnchere == null) {
				if (request.getParameter("error") != null) {
					throw new BusinessException(request.getParameter("error"));
				} else {
					throw new BusinessException("Enchere non disponible");
				}

			}
			enchere = enchereManager.getEnchereInnerJoin(idEnchere);

		} catch (BusinessException e) {
			System.out.println("test");
			request.setAttribute("errorMessage", e.getMessage());
		}
		request.setAttribute("enchere", enchere);

		request.getRequestDispatcher("/WEB-INF/jsp/detailVente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id_enchere");
		String enchere = request.getParameter("enchere");
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		int idUser = user.getNoUser();
		System.out.println(idUser);
		String error = "";
		try {
			enchereManager.encherir(id, enchere, idUser);
		} catch (BusinessException e) {
			request.setAttribute("errorMessageEnchere", e.getMessage());
			error = "&error=" + e.getMessage();
			System.out.println(error);
		}
		// request.setAttribute("idEnchere", id);
		// request.getRequestDispatcher(request.getContextPath() + "/detailVente?id_enchere=" + id).forward(request, response);

		response.sendRedirect(request.getContextPath() + "/detailVente?id_enchere=" + id + error);
	}

}