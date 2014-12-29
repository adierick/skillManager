<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${userSession != null}">
		<div id="header" onclick="location.href='<%=request.getContextPath()%>/main/login/login.do'">
			<h1></h1>
			<h2>
				<span id="title">SKILL MANAGER</span>
			</h2>
			<div id="logged">
				
					<span class="user">
						<img id="logged" src="<c:url value='/img/user.gif' />" />${userSession.login}
						<a id="logout" href="<%=request.getContextPath()%>/main/logout" ></a> 
					</span>
				<br />
				<div id="logo" onclick="location.href='<%=request.getContextPath()%>/main/login/login.do'"></div>
			</div>
		</div>
</c:if>