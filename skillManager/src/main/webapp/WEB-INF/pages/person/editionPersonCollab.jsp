<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

		<fieldset class="ellipse01">
			<legend> <spring:message code="personnal.data"/></legend>
			
			<div>
				<img src="<c:url value='/img/main/main_perso_data.png' />" style="float:left; padding: 10px;" />
				<form:form modelAttribute="person" action="update.do" class="formulaire">
					<div>
						<label class="large"><spring:message code="person.firstname"/> </label><form:input  path="person.firstname" readonly="true"/> <br/>
						<label class="large"><spring:message code="person.lastname"/> </label><form:input   path="person.lastname" readonly="true"/><br/>
						<label class="large"><spring:message code="person.matricule"/> </label><form:input  path="person.matricule" readonly="true"/><br/>
						<label class="large"><spring:message code="person.login"/> </label><form:input  path="person.login" readonly="true"/><br/>
						<label class="large"><spring:message code="person.password"/> </label><form:password path="firstPassword"/><form:errors path="firstPassword" cssClass="error"/><br/>
						<label class="large"><spring:message code="person.password.confirm"/></label><form:password path="confirmPassword"/><form:errors path="confirmPassword" cssClass="error"/><br/>
						<label class="large"><spring:message code="person.bu"/> </label>
						<form:select path="person.bu" disabled="true">
							<form:option value="" label="---"/>
							<form:options items="${listBu}" itemLabel="label"/>
						</form:select>
						
					</div>
					<form:hidden path="person.bu"/>
					
					<div>
						<input type="button" title="<spring:message code='main.back'/>" onclick="location.href='<%=request.getContextPath()%>/main/login/login.do'" class="backButton" />
						
						<input type="submit" title="${type}" class="submitButton"/>
					</div>
				</form:form>
			</div>
		</fieldset>

