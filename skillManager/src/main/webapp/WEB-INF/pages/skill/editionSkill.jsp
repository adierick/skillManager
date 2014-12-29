<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

		<fieldset>
			<legend> <spring:message code="skill.data"/></legend>
			
			<div>
				<form:form modelAttribute="skill" action="update.do" class="formulaire">
					<div>
						<label class="large"><spring:message code="skill.person"/> </label>
						<%-- <form:select path="person">
							<form:option value="" label="---"/>
							<form:options items="${listPerson}" itemLabel="label"/>
						</form:select> --%>
						<label class="large"><spring:message code="skill.level"/> </label><form:input path="level"/><form:errors path="level" cssClass="error"/><br/>
						<label class="large"><spring:message code="skill.item"/> </label>
						<form:select path="item">
							<form:option value="" label="---"/>
							<form:options items="${listItem}" itemLabel="label"/>
						</form:select>
					</div>
					<form:hidden path="id"/>
					<div>
						<input type="button" title="<spring:message code='skill.edit.back'/>" onclick="listSkill('<%=request.getContextPath()%>', '${userSession.matricule}')" class="backButton" />
						<input type="submit" title="${type}" class="submitButton"/>
					</div>
				</form:form>
			</div>
		</fieldset>

