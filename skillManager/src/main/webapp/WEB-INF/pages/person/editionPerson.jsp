<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

		<fieldset class="ellipse01">
			<legend> <spring:message code="personnal.data"/></legend>
				<div>
					<img src="<c:url value='/img/main/main_perso_data.png' />" style="float:left; padding: 10px;" />
					
					<div>
					<form:form modelAttribute="person" action="${type}AsAdmin.do" class="formulaire">
	<%-- 				<form:form modelAttribute="person" action="${type}AsAdmin.do" class="formulaire" enctype="multipart/form-data"> --%>
						<div>
							<label class="large"><spring:message code="person.firstname"/> </label><form:input path="person.firstname" cssClass="personInput"/><form:errors path="person.firstname" cssClass="error"/><br/>
							<label class="large"><spring:message code="person.lastname"/> </label><form:input path="person.lastname" cssClass="personInput"/><form:errors path="person.lastname" cssClass="error"/><br/>
							<label class="large"><spring:message code="person.matricule"/> </label><form:input path="person.matricule" cssClass="personInput"/><form:errors path="person.matricule" cssClass="error"/><br/>
							<label class="large"><spring:message code="person.email"/> </label><form:input path="person.email" cssClass="personInput"/><form:errors path="person.email" cssClass="error"/><br/>
	<%-- 						<label class="large"><spring:message code="person.picture"/> </label><form:input path="person.picture" type="file"/><form:errors path="person.picture" cssClass="error"/><br/> --%>
							<label class="large"><spring:message code="person.admin"/> </label><form:checkbox path="person.admin" /><br/>
							<label class="large"><spring:message code="person.login"/> </label><form:input path="person.login" cssClass="personInput"/><form:errors path="person.login" cssClass="error"/><br/>
							<label class="large"><spring:message code="person.password"/> </label><form:password path="firstPassword" cssClass="personInput"/><form:errors path="firstPassword" cssClass="error"/><br/>
							<label class="large"><spring:message code="person.password.confirm"/></label><form:password path="confirmPassword" cssClass="personInput"/><form:errors path="confirmPassword" cssClass="error"/><br/>
							<label class="large"><spring:message code="person.bu"/> </label>
							<form:select path="person.bu">
								<form:option value="" label="---"/>
								<form:options items="${listBu}" itemLabel="label"/>
							</form:select>
							<br/>
					
						</div>
						<br/>
						<div>
							<input type="button" title="<spring:message code='person.edit.back'/>" onclick="listePersons('<%=request.getContextPath()%>', '${userSession.id}')" class="backButton" />		  
							
							<input type="submit" title="${type}" class="submitButton"/>
						</div>
					</form:form>
					
					</div>
					<br/>
					<div class="pictureDiv">
						<c:choose>
							<c:when test="${person.person.matricule != null}">
								<img src="data:image/jpeg;base64,${Img}" alt="avatar" width="150px">
							</c:when>
							<c:when test="${person.person.matricule != null && picture.file == null}">
								<img src="<c:url value='/img/person-avatar1.png'/>" alt="default-avatar" width="150px">
							</c:when>
							<c:otherwise>
								<img src="<c:url value='/img/person-avatar1.png'/>" alt="default-avatar" width="150px">
							</c:otherwise>
						</c:choose>
						
						<br/>
						<c:if test="${userSession.admin}">
						<form:form modelAttribute="picture" action="loadPicture.do?selectedMatricule=${selectedMatricule}" class="formulaire formUpload" enctype="multipart/form-data">
							<c:choose>
								<c:when test="${person.person.matricule != null}">
									<form:input path="file" type="file" cssClass="inputFile" title="Charger une photo" /><form:errors path="file" cssClass="error"/><br/>
									<input type="submit" value="Envoyer" class="pictureSubmit"><br/>
								</c:when>
								<c:otherwise>
									<input type="submit" value="Envoyer" class="pictureSubmit" disabled="disabled" title="Le profil doit d'abord être créé avant de pouvoir charger une photo"><br/>
								</c:otherwise>
							</c:choose>
						</form:form>
						</c:if>
					</div>
			</div>
		</fieldset>

