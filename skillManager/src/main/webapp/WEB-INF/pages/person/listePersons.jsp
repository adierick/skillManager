<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

		<fieldset class="ellipse01">
			<legend> <spring:message code='personnal.choose.action'/></legend>
			
			<div>
				<img src="<c:url value='/img/main/main_admin_person.png' />" style="float:left; padding: 10px;" />
				<div>
					<table>
						<c:forEach var="person" items="${personsList}" varStatus="status">
						<tr>
							<td>
								<c:choose>
									<c:when test="${person.bu != null}"> 
										<a href="editionPersonAsAdmin.do?matricule=${person.matricule}"> 
											<c:out value="${person}"></c:out>
										</a>
									</c:when>
									<c:otherwise>
										<label class="inactivePerson"><c:out value="${person}"></c:out></label>
									</c:otherwise>
								</c:choose>
							</td>
							<td>
								<form:form modelAttribute="person" action="delete.do?matricule=${person.matricule}">
									<input type="submit" value="<spring:message code='main.delete'/>" class="deleteButton"/>
								</form:form>
							</td>
						</tr>
						</c:forEach>
					</table>
							
					<form:form modelAttribute="person" action="create.do">
						<div>
							<input type="button" title="<spring:message code='main.back'/>" onclick="location.href='<%=request.getContextPath()%>/main/login/login.do'" class="backButton"/>
							<input type="submit" title="<spring:message code='personnal.add'/>" class="addButton"/>
						</div>
					</form:form>
				</div>
			</div>
			
		</fieldset>
