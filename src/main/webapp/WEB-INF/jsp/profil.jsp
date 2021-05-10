<jsp:include page="/WEB-INF/fragments/upHead.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head>
	<title>Mon Compte</title>
	<jsp:include page="/WEB-INF/fragments/head.jsp" />
</head>

<body>
	<%@include file="/WEB-INF/fragments/navbar.jsp" %>
	
	<div class="container">
		<h2>Mon profil</h2>
		<hr>
		<div class="form-group">
			<p>
	            <span id="pseudo">
	              Pseudo : ${user.pseudo}
	            </span><br>
	            <span id="email">
	              E-mail : ${user.email}
	            </span><br>
	            <span id="prenom">
	              Prénom : ${user.prenom}
	            </span><br>
	            <span id="nom">
	              Nom : ${user.nom}
	            </span><br> 
	            <span id="telephone">
	              Telephone : ${user.telephone}
	            </span><br>
	            <span id="rue">
	              Rue : ${user.rue}
	            </span><br>
	            <span id="code_postal">
	              Code postal : ${user.code_postal}
	            </span><br>
	            <span id="ville">
	              Ville : ${user.ville}
	            </span><br>
			</p>
			<a href="${pageContext.request.contextPath}/editProfil" class="btn btn-primary">Modifier le profil</a>
		</div>
	</div>

</body>

<footer>
	<jsp:include page="/WEB-INF/fragments/foot.jsp" />
</footer>
</html>