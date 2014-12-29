<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

		<fieldset class="ellipse03">
			<legend> <spring:message code='item.choose.action'/></legend>
			
			<div >
				<img src="<c:url value='/img/main/main_admin_item.png' />" style="float:left; padding: 10px;" />
				<div>
					<table>
						<c:forEach var="item" items="${itemsList}" varStatus="status">
						<tr>
							<td>
							<a href="editionItem.do?id=${item.id }">
								<spring:message code='${item.trs_label_key}'/> (<c:out value="${item.code}"></c:out>)
							</a>
							</td>
							<td>
								<form method="post" action="delete.do">
									<input type="hidden" name="id" value="${item.id}" /> 
									<input type="submit" title="Delete" class="deleteButton"/>
								</form>
							</td>
						</tr>
						</c:forEach>
					</table>
			
					<form:form modelAttribute="item" action="create.do">
						<div>
							<input type="button" title="<spring:message code='main.back'/>" onclick="location.href='<%=request.getContextPath()%>/main/login/login.do'" class="backButton"/>
							<input type="submit" title="<spring:message code='item.add'/>" class="addButton"/>
						</div>
					</form:form>
				</div>
			</div>
		</fieldset>
