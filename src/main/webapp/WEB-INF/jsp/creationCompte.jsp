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
	<h2>Inscription a ENI-Enchere</h2>
	<hr>
		<form action="${pageContext.request.contextPath}/Inscription" method="post">
			<div class="form-group">
				<label for="pseudo">Pseudo</label>
				<input type="text" name="pseudo" class="form-control" required pattern="^[A-Za-z0-9]+$">
				<label for="email">Email</label>
				<input type="email" name="email" class="form-control" required>
				<label for="mdp">Mot de passe</label>
				<input type="password" name="mdp" class="form-control" required>
				<label for="nom">Nom</label>
				<input type="text" name="nom" class="form-control" required>
				<label for="prenom">Prenom</label>
				<input type="text" name="prenom" class="form-control" required>
				<label for="telephone">Telephone</label>
				<input type="text" name="telephone" class="form-control" required>
				<label for="rue">Rue</label>
				<input type="text" name="rue" class="form-control" required>
				<label for="code_postal">Code postal</label>
				<input type="text" name="code_postal" class="form-control" required>
				<label for="ville">Ville</label>
				<input type="text" name="ville" class="form-control" required>
				<br>
				<button type="submit" class="btn btn-primary">Inscription</button>
			</div>
		</form>
	</div>
</body>
<footer>
	<jsp:include page="/WEB-INF/fragments/foot.jsp" />
</footer>
</html>