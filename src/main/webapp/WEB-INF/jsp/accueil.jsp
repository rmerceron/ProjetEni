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
		<br><h2>Liste des ench�res</h2><hr>
	</div>
	
	<div class="from-group">
		<div class="col-sm-2">
			<form name="filtre" action="AccueilServlet" method="POST">
				<h6>Filtres :</h6>
				<div class="form-group">
					<input id="search-focus" type="search" class="form-control" placeholder="Rechercher un article" />
		 		</div>
				<h6>Cat�gorie</h6>
				<div class="form-group">
					<select class="custom-select" id="categorieSelect">
						<option value = "" disabled selected>Choisir une cat�gorie...</option>
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
		<c:forEach var="article" items="${listeArticleVendu}">
			<div class="card d-inline-flex justify-content-evenly">
				<div class="card-body">
					<div>${article.nom}</div>
					<div>${article.prixInitial}</div>
					<div>${article.dateFinEncheresFmt}</div>
					<div>${article.acheteur.pseudo}</div>
				</div>
			</div>
		</c:forEach>
	</div>
	
</body>

</html>