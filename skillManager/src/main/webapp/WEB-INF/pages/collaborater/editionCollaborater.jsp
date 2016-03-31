<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div>
	<img src="<c:url value='/img/main/main_perso_data.png' />" style="float:left; padding: 10px;" />

	<c:set var="readonly" value =""/>
	<c:if test="${!userSession.manager}">
		<c:set var="readonly" value ="readonly='true'"/>
	</c:if>
	
	
	<div class="container">
	    <div class="row">
	        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm">
	           <form:form modelAttribute="collaborater" action="${type}AsManager.do" class="formulaire">
		            <div class="row">
		                <div class="col-xs-6 col-md-6">
		                    <input class="form-control" name="collaborater.firstname" placeholder="<spring:message code="collab.firstname"/>" type="text" required autofocus value="${person.collaborater.firstname}"  ${readonly} />
		                </div>
		                <div class="col-xs-6 col-md-6">
		                    <input class="form-control" name="collaborater.lastname" placeholder="<spring:message code="collab.lastname"/>" type="text" required value="${person.collaborater.lastname}" ${readonly}/>
		                </div>
		            </div>
		            <input class="form-control" name="collaborater.birth_date" placeholder="<spring:message code="collaborater.matricule"/>" type="text" required value="${person.collaborater.matricule}" ${readonly}/>
		            <input class="form-control" name="collaborater.Tel" placeholder="<spring:message code="collab.Tel"/>" type="text"  required value="${person.collaborater.Tel}" ${readonly}/>
		            <input class="form-control" name="collaborater.hobby" placeholder="<spring:message code="collab.hobby"/>" type="text" required value="${person.collaborater.hobby}"/>
		            <input class="form-control" name="collaborater.date_entry_sii" placeholder="<spring:message code="collab.date_entry_sii"/>" type="text" required value="${collaborater.date_enty_sii}"/>
		            <input class="form-control" name="collaborater.position_coeff" placeholder="<spring:message code="collab.position_coeff"/>" type="text" required value="${collaboorater.position_coeff}"/>
		          
					<label for=""><spring:message code="person.bu"/></label>
		            <div class="row">
		                <div class="col-xs-4 col-md-4">
							<form:select path="person.bu" cssClass="form-control">
								<form:option value="" label="---"/>
								<form:options items="${listBu}" itemLabel="label"/>
							</form:select>
		                </div>
		            </div>
		            
		            <c:if test="${userSession.manager}">
			            <label class="radio-inline" >
			                <spring:message code="person.admin"/><form:checkbox path="person.admin"/>
			            </label>
			            <label class="radio-inline" id="CocheFicheCollab" onclick="afficher_cacher()">
			                <spring:message code="person.manager"/><form:checkbox path="person.manager"  />
			            </label>
		            </c:if>
		            <br />
		            <br />
		            <button class="btn btn-lg btn-primary btn-block" type="submit">${type}</button>
	            </form:form>
	        </div>
	    </div>
	</div>
<!-- 	<div class="pictureDiv"> -->
<!-- 		<br/> -->
<%-- 		<c:if test="${userSession.admin}"> --%>
<%-- 		<form:form id="uploadForm" name="uploadForm" modelAttribute="picture" action="loadPicture.do?selectedMatricule=${selectedMatricule}" class="formulaire formUpload" enctype="multipart/form-data"> --%>
<%-- 			<c:choose> --%>
<%-- 				<c:when test="${person.person.matricule != null}"> --%>
<%-- 					<form:input path="file" type="file" cssClass="glyphicon glyphicon-remove" title="Charger une photo" /><form:errors path="file" cssClass="error"/><br/> --%>
<!-- 					 <button class="btn btn-lg btn-primary btn-block" type="submit">Upload photo</button> -->
<%-- 				</c:when> --%>
<%-- 				<c:otherwise> --%>
<!-- 					<button class="btn btn-lg btn-primary btn-block" type="submit" disabled="disabled"  -->
<!-- 					title="Le profil doit d'abord être créé avant de pouvoir charger une photo">Upload photo</button> -->
<%-- 				</c:otherwise> --%>
<%-- 			</c:choose> --%>
<%-- 		</form:form> --%>
<%-- 		</c:if> --%>
<!-- 	</div> -->
</div>