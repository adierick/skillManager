<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

		<fieldset class="ellipse03">
			<legend> <spring:message code='item.choose.action'/></legend>
			
			<div>
				<img src="<c:url value='/img/main/main_admin_item.png' />" style="float:left; padding: 10px;" />
				<form:form modelAttribute="item" action="update.do" class="formulaire">
					<div>
						<label class="large"><spring:message code='item.code'/> </label><form:input path="code"/><br/>
						<label class="large"><spring:message code='item.trs_label_key'/> </label><form:input path="trs_label_key"/><br/>
					</div>
					<form:hidden path="id"/>
					<form:select path="category">
						<form:option value="" label="---"/>
						<form:options items="${listCategory}" itemLabel="trs_label_key"/>
					</form:select>
					<div>
						<input type="button" title="<spring:message code='item.edit.back'/>" onclick="listeItems('<%=request.getContextPath()%>', '${userSession.id}');" class="backButton" />
						<input type="submit" title="${type}" class="submitButton"/>
					</div>
				</form:form>
			</div>
		</fieldset>
