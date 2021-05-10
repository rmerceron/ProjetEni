<jsp:include page="/WEB-INF/fragments/upHead.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head>
<title>Creation de votre compte</title>
<jsp:include page="/WEB-INF/fragments/head.jsp" />
</head>
<body>
	<%@include file="/WEB-INF/fragments/navbar.jsp" %>
	
	<div class="container">
		<h2>Modifier son profil</h2>
		<hr>
		<form action="${pageContext.request.contextPath}/editProfil" method="post">
			<div class="form-group">
				<input type="hidden" name="id" value="${user.noUser}">
				<label for="pseudo">Pseudo</label>
				<input type="text" name="pseudo" class="form-control" required pattern="^[A-Za-z0-9]+$" value="${user.pseudo}">
				<label for="email">Email</label>
				<input type="email" name="email" class="form-control" required value="${user.email}">
				<label for="mdp">Mot de passe</label>
				<input type="text" name="mdp" class="form-control" required value="${user.mdp}">
				<label for="nom">Nom</label>
				<input type="text" name="nom" class="form-control" required value="${user.nom}">
				<label for="prenom">Prenom</label>
				<input type="text" name="prenom" class="form-control" required value="${user.prenom}">
				<label for="telephone">Telephone</label>
				<input type="text" name="telephone" class="form-control" required value="${user.telephone}">
				<label for="rue">Rue</label>
				<input type="text" name="rue" class="form-control" required value="${user.rue}">
				<label for="code_postal">Code postal</label>
				<input type="text" name="code_postal" class="form-control" required value="${user.code_postal}">
				<label for="ville">Ville</label>
				<input type="text" name="ville" class="form-control" required value="${user.ville}">
				<br>
				<button type="submit" class="btn btn-primary">Modifier</button>
				
			</div>
		</form>
		<a href="${pageContext.request.contextPath}/deleteProfil?userId=${user.noUser}" class="btn btn-danger">Supprimer mon compte</a>
	</div>

</body>
<footer>
	<jsp:include page="/WEB-INF/fragments/foot.jsp" />
</footer>
</html>