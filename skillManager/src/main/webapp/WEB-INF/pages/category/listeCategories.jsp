<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

		<fieldset class="ellipse03">
			<legend> <spring:message code='category.choose.action'/></legend>
			
			<div >
				<img src="<c:url value='/img/main/main_admin_category.png' />" style="float:left; padding: 10px;" />
				<div>
					<table>
						<c:forEach var="category" items="${categoriesList}" varStatus="status">
						<tr>
							<td>
							<a href="editionCategory.do?id=${category.id }">
								<spring:message code='${category.trs_label_key}'/> (<c:out value="${category.code}"></c:out>)
							</a>
							</td>
							<td>
								<form method="post" action="delete.do">
									<input type="hidden" name="id" value="${category.id}" /> 
									<input type="submit" title="Delete" class="deleteButton"/>
								</form>
							</td>
						</tr>
						</c:forEach>
					</table>
			
					<form:form modelAttribute="category" action="create.do">
						<div>
							<input type="button" title="<spring:message code='main.back'/>" onclick="location.href='<%=request.getContextPath()%>/main/login/login.do'" class="backButton"/>
							<input type="submit" title="<spring:message code='category.add'/>" class="addButton"/>
						</div>
					</form:form>
				</div>
			</div>
		</fieldset>
