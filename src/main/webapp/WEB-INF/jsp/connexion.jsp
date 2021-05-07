<jsp:include page="/WEB-INF/fragments/upHead.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head>
<title>Connexion</title>
<jsp:include page="/WEB-INF/fragments/head.jsp"/>
</head>
<body>
	<%@include file="/WEB-INF/fragments/navbar.jsp" %>
	
	<div class="titrePage">
		<br><h2>Connexion</h2><hr>
	</div>
	<div class="container" style="max-width: 600px;">
		<form action="${pageContext.servletContext.contextPath}/connexion"
			method="post">
			<div class="form-outline mb-4">
				<input required type="text" name="identifiant" id="identifiant" class="form-control" value="${ identifiant }" /> <label
					class="form-label" for="identifiant">Identifiant</label>
			</div>
			<div class="form-outline mb-4">
				<input required type="password" name="password" id="password"
					class="form-control" /> <label class="form-label"
					for="password">Mot de passe</label>
			</div>
			<div class="row mb-4">
				<div class="col d-flex justify-content-center">
					<div class="form-check">
						<input class="form-check-input" type="checkbox" name="rememberMe"
							id="rememberMe"/> <label class="form-check-label"
							for="rememberMe">Se souvenir de moi</label>
					</div>
				</div>

				<div class="col">
					<!-- Simple link -->
					<a href="#!">Mot de passe oubli�</a>
				</div>
			</div>
			<button type="submit" class="btn btn-primary btn-block">Se connecter</button>
		</form>
		<br> <a class="btn btn-dark btn-block" href ="${pageContext.servletContext.contextPath}/creationCompte">Cr�er un compte</a>
	</div>
</body>
<footer>
	<jsp:include page="/WEB-INF/fragments/foot.jsp"/>
</footer>
</html>