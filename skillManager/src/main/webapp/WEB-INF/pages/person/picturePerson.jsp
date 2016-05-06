<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div>
	<img src="<c:url value='/img/main/main_perso_data.png' />" style="float:left; padding: 10px;" />

	<div class="container">
	    <div class="row">
	        <div class="col-xs-12 col-sm-12 col-md-12 well well-sm">
				<c:if test="${userSession.admin}">
				<form:form id="uploadForm" name="uploadForm" modelAttribute="picture" action="loadPicture.do?selectedMatricule=${selectedMatricule}" class="formulaire formUpload" enctype="multipart/form-data">
					<c:choose>
						<c:when test="${person.person.matricule != null}">
							<form:input path="file" type="file" cssClass="form-control" title="Charger une photo" /><form:errors path="file" cssClass="error"/><br/>
							 <button class="btn btn-success btn-lg" type="submit">Upload photo</button>
						</c:when>
						<c:otherwise>
							<button class="btn btn-success btn-lg" type="submit" disabled="disabled" 
							title="Le profil doit d'abord être créé avant de pouvoir charger une photo">Upload photo</button>
						</c:otherwise>
					</c:choose>
				</form:form>
				</c:if>
	        </div>
	    </div>
	</div>
</div>