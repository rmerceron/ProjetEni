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
			<h6>Filtres :</h6>
			<div class="form-group">
				<input id="search-focus" type="search" class="form-control" placeholder="Rechercher un article" />
	 		</div>
		
			<h6>Catégorie</h6>
			<select class="custom-select" id="categorieSelect">
				<option value = "" disabled selected>Choisir une catégorie...</option>
				<c:forEach var="categorie" items="${listeCategorie}">
					<option value="${categorie.noCategorie}"> ${categorie.libelle} </option>
				</c:forEach>
			</select>
		</div>
	</div>
	
	
</body>

</html>