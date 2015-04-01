<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

		<fieldset class="ellipse01">
			<legend> <spring:message code="person.trombinoscope"/></legend>
				<div>
					<table>
						
						<c:set var="i" value ="${0}"/>
						<c:forEach var="personPicture" items="${personsPicturesList}" varStatus="status">
							<c:set var="i" value="${i+1}"/>
								<c:if test="${i<1}">
									<tr>
								</c:if>
									<td align="center" height="200px" width="200px">
										<c:if test="${userSession.admin}">
											<a href="editionPersonAsAdmin.do?matricule=${personPicture.person.matricule}">
										</c:if> 
										<br/>
										<c:out value="${personPicture.person.firstname}"/><br>
										<c:out value="${personPicture.person.lastname}"/><br>
										<img src="data:image/jpeg;base64,${personPicture.encoded}" alt="avatar" width="100px">
										<c:if test="${userSession.admin}">
											</a>
										</c:if>
									</td>
								<c:if test="${i>4}">
									<c:set var="i" value="${0}"/>
									</tr>
								</c:if>
						</c:forEach>
						<c:if test="${i>0}">
							</tr>
						</c:if>
					</table>
					
				</div>
		</fieldset>