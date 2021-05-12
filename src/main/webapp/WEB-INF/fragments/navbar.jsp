<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
	<a class="navbar-brand" href="${pageContext.request.contextPath}/AccueilServlet">ENI-Encheres</a>
	<div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
		<ul class="navbar-nav ml-auto">
			<c:choose>
				<c:when test="${sessionScope.user==null}">
					<li class="nav-item">
						<a class="nav-link" href="${pageContext.request.contextPath}/connexion">Connexion</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="${pageContext.request.contextPath}/Inscription">Inscription</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="nav-item">
						<a class="nav-link" href="${pageContext.request.contextPath}/enchere">Enchères</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="${pageContext.request.contextPath}/NouvelleVente">Vendre un article</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="${pageContext.request.contextPath}/displayProfil">Mon profil</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="${pageContext.request.contextPath}/deconnexion">Déconnexion</a>
					</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</nav>
