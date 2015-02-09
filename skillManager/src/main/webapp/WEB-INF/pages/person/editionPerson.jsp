<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

		<fieldset class="ellipse01">
			<legend> <spring:message code="personnal.data"/></legend>
			
			<div>
				<img src="<c:url value='/img/main/main_perso_data.png' />" style="float:left; padding: 10px;" />
				
				<form:form modelAttribute="person" action="${type}AsAdmin.do" class="formulaire">
<%-- 				<form:form modelAttribute="person" action="${type}AsAdmin.do" class="formulaire" enctype="multipart/form-data"> --%>
					<div>
						<label class="large"><spring:message code="person.firstname"/> </label><form:input path="person.firstname"/><form:errors path="person.firstname" cssClass="error"/><br/>
						<label class="large"><spring:message code="person.lastname"/> </label><form:input path="person.lastname"/><form:errors path="person.lastname" cssClass="error"/><br/>
						<label class="large"><spring:message code="person.matricule"/> </label><form:input path="person.matricule"/><form:errors path="person.matricule" cssClass="error"/><br/>
						<label class="large"><spring:message code="person.email"/> </label><form:input path="person.email"/><form:errors path="person.email" cssClass="error"/><br/>
<%-- 						<label class="large"><spring:message code="person.picture"/> </label><form:input path="person.picture" type="file"/><form:errors path="person.picture" cssClass="error"/><br/> --%>
						<label class="large"><spring:message code="person.admin"/> </label><form:checkbox path="person.admin" /><br/>
						<label class="large"><spring:message code="person.login"/> </label><form:input path="person.login"/><form:errors path="person.login" cssClass="error"/><br/>
						<label class="large"><spring:message code="person.password"/> </label><form:password path="firstPassword"/><form:errors path="firstPassword" cssClass="error"/><br/>
						<label class="large"><spring:message code="person.password.confirm"/></label><form:password path="confirmPassword"/><form:errors path="confirmPassword" cssClass="error"/><br/>
						<label class="large"><spring:message code="person.bu"/> </label>
						<form:select path="person.bu">
							<form:option value="" label="---"/>
							<form:options items="${listBu}" itemLabel="label"/>
						</form:select>
					</div>
					<div>
						<input type="button" title="<spring:message code='person.edit.back'/>" onclick="listePersons('<%=request.getContextPath()%>', '${userSession.id}')" class="backButton" />		  
						
						<input type="submit" title="${type}" class="submitButton"/>
					</div>
				</form:form>
			</div>
		</fieldset>

