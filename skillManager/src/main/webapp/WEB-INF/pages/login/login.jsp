<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
	<title><spring:message code="skillmanager.title"/></title>
	<link rel="icon" type="image/png" href="<c:url value='/img/icon.png' />" />
	<link href="<c:url value='/css/main.css' />" rel="stylesheet"  type="text/css" />
	<link href="<c:url value='/css/ui-lightness/jquery-ui-1.10.4.css' />" rel="stylesheet"  type="text/css" />
	<script src="<c:url value='/js/utils.js' />"></script>
	<script src="<c:url value='/js/jquery-1.10.2.js' />"></script>
	<script src="<c:url value='/js/jquery-ui-1.10.4.js' />"></script>
	<script src="<c:url value='/js/config-jquery.js' />"></script>
</head>
<body>
	<div class="login-zone">
	
		<div id="header-login">
			<div id="form_login_label">
				<div style="font-family: arial; font-size: 20px">
					<span style="font-family: Arial Black; font-size: 20px"><spring:message code="skillmanager.title"/></span> 
				</div>
			</div>
		</div>
		<div class="errorDiv">
			<label>${msgError}</label>
		</div>
		<form:form modelAttribute="login" action="login.do">
			<table align="center">
				<tr>
					<td align="right"><strong><spring:message code="login.user"/></strong></td>
					<td><form:input path="login"/> <form:errors path="login" cssClass="error"/></td>
				</tr>
				<tr>
					<td align="right"><strong><spring:message code="login.password"/></strong></td>
					<td><form:password path="password"/><form:errors path="password"  cssClass="error"/></td>
				</tr>
				<tr>
					<td colspan=2 align="right"><input type="submit" class="button" value="<spring:message code="login.valid"/>"/></td>
				</tr>
			</table>
		</form:form>
	
		<div id="foot-login"></div>
	</div>
</body>
</html>
