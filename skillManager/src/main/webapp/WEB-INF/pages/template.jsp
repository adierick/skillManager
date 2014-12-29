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
<body class="body">
    <header>
        <jsp:include page="header.jsp"/>
    </header>
    <div id="main-page">
		<div class="validDiv">
			<label>${msgSaved}</label>
		</div>
		<div class="errorDiv">
			<label>${msgError}</label>
		</div>
    	<jsp:include page="${partial}"/>
    </div>
    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</body>
</html>