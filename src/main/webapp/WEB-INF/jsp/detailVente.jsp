<jsp:include page="/WEB-INF/fragments/upHead.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head>
<title>Détail vente</title>
<jsp:include page="/WEB-INF/fragments/head.jsp" />
</head>
<body>
	<%@include file="/WEB-INF/fragments/navbar.jsp" %>
	
	<div class="titrePage">
		<br><h2>Détail vente</h2><hr>
	</div>
	<c:choose>
		<c:when test="${errorMessage!=null}">
			<div class="alert alert-danger text-center" role="alert">${errorMessage }</div>
		</c:when>
		<c:otherwise>
		<c:if test="${errorMessageEnchere!=null}">
				<div class="alert alert-danger text-center" role="alert">${errorMessageEnchere }</div>
		</c:if>
		<div class="container">
			<div class="form-group">
				<h3>${enchere.getArticle().getNom()}</h3>
				<p>
		            <span id="description">
		            	<b>Description :</b> ${enchere.getArticle().getDescription()}
		            </span><br>
		            <span id="categorie">
		            	<b>Catégorie :</b> ${enchere.getArticle().getLaCategorie().getLibelle()}
		            </span><br>
		            <span id="meilleurOffre">
		            	<b>Meilleure offre :</b> ${enchere.getMontant()} pts par ${enchere.getDernierEncherisseur().getPrenom()} ${enchere.getDernierEncherisseur().getNom()}
		            </span><br>
		            <span id="miseAPrix">
		            	<b>Mise à prix :</b> ${enchere.getArticle().getPrixVente()}
		            </span><br> 
		            <span id="finEnchere">
		            	<b>Fin de l'enchère :</b> ${enchere.getArticle().getDateFin()}
		            </span><br>
		            <span id="retrait">
		            	<b>Retrait :</b> ${enchere.getUser().getRue()}, ${enchere.getUser().getVille()} ${enchere.getUser().getCode_postal()}
		            </span><br>
		            <span id="vendeur">
		            	<b>Vendeur :</b> ${enchere.getUser().getPrenom()} ${enchere.getUser().getNom()}
		            </span><br>
				</p>
			</div>
			<c:if test="${sessionScope.user!=null}">
				<form method="POST">
					<div class="container">
						<div class="row">
							<div class="form-outline mb-4">
								<input required type="number" name="enchere" id="enchere"
									class="form-control" min="${enchere.getMontant()}"
									max="1548485485484848484"
									value="${enchere.getMontant()}" />
							</div>
							<div class="col-4">
								<button type="submit" class="btn btn-block btn-dark">Enchérir</button>
							</div>
						</div>
					</div>
					<input hidden name="idEnchere" value="${enchere.getNoEnchere()}"/>
					<input hidden name="user" value="${sessionScope.user.getNoUser()}"/>
				</form>
			</c:if>
		</div>
		</c:otherwise>
	</c:choose>
</body>
<footer>
	<jsp:include page="/WEB-INF/fragments/foot.jsp" />
</footer>
</html>