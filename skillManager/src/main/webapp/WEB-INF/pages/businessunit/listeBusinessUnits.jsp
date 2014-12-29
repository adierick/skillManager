<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

		<fieldset class="ellipse04">
			<legend> <spring:message code='bu.choose.action'/></legend>
			
			<div >
				<img src="<c:url value='/img/main/main_admin_bu.png' />" style="float:left; padding: 10px;" />
				<div>
					<table>
						<c:forEach var="businessunit" items="${businessunitsList}" varStatus="status">
						<tr>
							<td>
							<a href="editionBusinessUnit.do?id=${businessunit.id }">
								<c:out value="${businessunit}"></c:out>
							</a>
							</td>
							<td>
								<form method="post" action="delete.do">
									<input type="hidden" name="id" value="${businessunit.id}" /> 
									<input type="submit" title="Delete" class="deleteButton"/>
								</form>
							</td>
						</tr>
						</c:forEach>
					</table>
			
					<form:form modelAttribute="businessunit" action="create.do">
						<div>
							<input type="button" title="<spring:message code='main.back'/>" onclick="location.href='<%=request.getContextPath()%>/main/login/login.do'" class="backButton"/>
							<input type="submit" title="<spring:message code='businessunit.add'/>" class="addButton"/>
						</div>
					</form:form>
				</div>
			</div>
	<br />
<c:out value="${message }"></c:out>

		</fieldset>
