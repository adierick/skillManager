<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en" ng-app>
<head>
	<title><spring:message code="skillmanager.title"/></title>
	<link rel="icon" type="image/png" href="<c:url value='/img/icon.png' />" />	
	<link href="<c:url value='/css/main.css' />" rel="stylesheet"  type="text/css" />
	<link href="<c:url value='/css/custom-theme/jquery-ui-1.10.4.custom.css' />" rel="stylesheet"  type="text/css" />
	<link href="<c:url value='/css/semi-bootstrap.css' />" rel="stylesheet"  type="text/css" />
	<link href="<c:url value='/css/bootstrap-duallistbox.css' />" rel="stylesheet"  type="text/css" />	
		
	<script src="<c:url value='/js/utils.js' />"></script>
	<script src="<c:url value='/js/jquery-1.10.2.js' />"></script>
	<script src="<c:url value='/js/jquery-ui-1.10.4.js' />"></script>	
	<script src="<c:url value='/js/config-jquery.js' />"></script>
 	<script src="<c:url value='/js/bootstrap/bootstrap.js' />"></script>
	<script src="<c:url value='/js/jquery.bootstrap-duallistbox.min.js' />"></script>
	<script src="<c:url value='/js/load.js' />"></script>		
	
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body class="body">
    <header>
        <jsp:include page="header.jsp"/>
    </header>
    <div id="main-page">
		<div class="validDiv">
			<label class="labelMsg">${msgSaved}</label>
		</div>
		<div class="errorDiv">
			<label class="labelMsg">${msgError}</label>
		</div>
    	<jsp:include page="${partial}"/>
    </div>
    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</body>
</html>