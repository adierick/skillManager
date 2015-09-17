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
		
		<div class="container">
		    <div class="row">
		        <div class="col-sm-6 col-md-offset-4">
		            <div class="account-wall" style="text-align: center">
		            	<img class="media-object dp img-circle" src="<%=request.getContextPath()%>/img/person-avatar1.png" 
		            		style="width: 100px;height:100px;">
		                <form:form modelAttribute="login" action="login.do" cssClass="form-signin" >
		                	<input type="text" class="form-control" name="login" value="" placeholder="<spring:message code="login.user"/>" required autofocus> 
			                <input type="password" class="form-control" name="password" placeholder="<spring:message code="login.password"/>" required>
			                <button class="btn btn-lg btn-primary btn-block " type="submit"><spring:message code="login.valid"/></button>
		                </form:form>  
		            </div>
		        </div>
		    </div>
		</div>
		<div id="foot-login"></div>
	</div>
</body>
</html>
