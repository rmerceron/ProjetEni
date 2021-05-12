<jsp:include page="/WEB-INF/fragments/upHead.jsp"></jsp:include>

<!DOCTYPE html> 
<html>

<head>
	<title>Accueil</title>
	<jsp:include page="/WEB-INF/fragments/head.jsp"></jsp:include>
</head>

<body>
	<%@include file="/WEB-INF/fragments/navbar.jsp" %>
	
	<div class="titrePage">
		<br><h2>Liste des enchères</h2><hr>
	</div>
	
	<div class="from-group">
		<div class="col-sm-2">
			<form name="filtre" action="AccueilServlet" method="POST">
				<h6>Filtres :</h6>
				<div class="form-group">
					<input id="search-focus" type="search" class="form-control" placeholder="Rechercher un article" />
		 		</div>
				<h6>Catégorie</h6>
				<div class="form-group">
					<select class="custom-select" id="categorieSelect" name="categorieSelect">
						<option value = "" disabled selected>Tous</option>
						<c:forEach var="categorie" items="${listeCategorie}">
							<option value="${categorie.noCategorie}"> ${categorie.libelle} </option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<button class="btn btn-outline-primary btn" type="submit">Rechercher</button>
				</div>
			</form>
		</div>
	</div><hr>
	
	<div>
		<c:if test="${user.noUser != null}">
			<c:forEach var="article" items="${listeArticleVendu}">
				<div class="card d-inline-flex justify-content-evenly">
					<div class="card-body">
						<div>Article : ${article.nom}</div>
						<div>Prix Initial : ${article.prixInitial}</div>
						<div>Fin d'enchere : ${article.dateFinEncheresFmt}</div>
						<div>${article.acheteur.pseudo}</div>
						<c:forEach var="categorie" items="${categorieSelect}">
							<div>${categorie}</div>
						</c:forEach>
					</div>
				</div>
			</c:forEach>
		</c:if>
		<c:if test="${user.noUser == null }">
		
		</c:if>
	</div>
	
</body>

</html>