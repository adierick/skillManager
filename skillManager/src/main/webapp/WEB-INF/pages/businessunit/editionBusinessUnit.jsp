<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

		<fieldset class="ellipse04">
			<legend> <spring:message code='bu.choose.action'/></legend>
			
			<div>
				<img src="<c:url value='/img/main/main_admin_bu.png' />" style="float:left; padding: 10px;" />
				<form:form modelAttribute="businessunit" action="update.do" class="formulaire">
					<div>
						<label class="large"><spring:message code='businessunit.label'/> </label><form:input path="label"/><br/>
					</div>
					<form:hidden path="id"/>
					<div>
						<input type="button" title="<spring:message code='bu.edit.back'/>" onclick="listeBusinessUnits('<%=request.getContextPath()%>', '${userSession.id}')" class="backButton" />
						<input type="submit" title="${type}" class="submitButton"/>
					</div>
				</form:form>
		<br />
		<style type="text/css">
table.tftable {
	font-size: 12px;
	color: #333333;
	width: 100%;
	border-width: 1px;
	border-color: #729ea5;
	border-collapse: collapse;
}

table.tftable th {
	font-size: 12px;
	background-color: #acc8cc;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #729ea5;
	text-align: left;
}

table.tftable tr {
	background-color: #ffffff;
}

table.tftable td {
	font-size: 12px;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #729ea5;
}
</style>

		<table id="tfhover" class="tftable" border="1">
			<caption>liste des personnes</caption>
			<c:forEach var="person" items="${listPersons}">
				<tr>
					<td><c:out value="${person}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</fieldset>
