<jsp:include page="/WEB-INF/fragments/upHead.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head>
<title>Nouvelle vente</title>
<jsp:include page="/WEB-INF/fragments/head.jsp" />
</head>
<body>
	<%@include file="/WEB-INF/fragments/navbar.jsp" %>
	
	<div class="titrePage">
		<br><h2>Nouvelle vente</h2><hr>
	</div>

	<form action="${pageContext.request.contextPath}/NouvelleVente" method="post">
		<div class="container">
			<div class="form-group">
			
				<label for="article">Article</label>
				<input type="text" name="article" class="form-control" required>
				
				<label for="description">Description</label>
				<textarea name="description" class="form-control" required> </textarea>
				
				<label for="categorie">Catégorie</label>
				<select class="custom-select" id="categorie" name="categorie">
					<option value ="" disabled selected>Choisir..</option>
					<c:forEach var="categorie" items="${listeCategorie}">
						<option value="${categorie.noCategorie}"> ${categorie.libelle} </option>
					</c:forEach>
				</select>
				
				<label for="miseaprix">Mise à prix</label>
				<input type="number" name="miseaprix" class="form-control" required>
				
				<label for="debutEnchere">Début de l'enchère</label>
				<input type="date" id="debutEnchere" name="debutEnchere" class="form-control" required>
				
				<label for="debutEnchere">Fin de l'enchère</label>
				<input type="date" id="finEnchere" name="finEnchere" class="form-control" required><br>
				
				<div class="card">
					<div class="card-body">
						<div class="form-group">
							<h5 class="card-title">Retrait</h5>
							<label for="rue">Rue</label>
							<input type="text" id="rue" name="rue" class="form-control" value="${user.rue}">
							<label for="rue">Code postal</label>
							<input type="text" id="cp" name="cp" class="form-control" value="${user.code_postal}">
							<label for="rue">Ville</label>
							<input type="text" id="ville" name="ville" class="form-control" value="${user.ville}">
						</div>
					</div>
				</div>
				
			</div>
			<button type="submit" class="btn btn-success">Enregistrer</button>
			<button type="reset" class="btn btn-danger">Annuler</button>
		</div>
	</form>
</body>
<footer>
	<jsp:include page="/WEB-INF/fragments/foot.jsp" />
</footer>
</html>