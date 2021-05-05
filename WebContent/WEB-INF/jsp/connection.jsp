<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
	<jsp:include page="head.jsp">
		<jsp:param name="title" value="Connexion" />
	</jsp:include>
	<div class="container" style="max-width: 600px;">
		<form action="${pageContext.servletContext.contextPath}/connection"
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
					<a href="#!">Mot de passe oublié</a>
				</div>
			</div>
			<button type="submit" class="btn btn-primary btn-block">Se connecter</button>
		</form>
		<br> <a class="btn btn-dark btn-block" href ="${pageContext.servletContext.contextPath}/creationCompte">Créer un compte</a>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>