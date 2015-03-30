<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

		<fieldset class="ellipse01">
			<legend> <spring:message code="person.trombinoscope"/></legend>
				<div>
					<table cellspacing="30">
						
						<c:set var="i" value="${0}"/>
						<c:forEach var="personPicture" items="${personsPicturesList}" varStatus="status">	
								<c:if test="${i<=0}">
									<tr>
								</c:if>
									<td align="center">
										<c:choose>
											<c:when test="${userSession.admin}">
												<a href="editionPersonAsAdmin.do?matricule=${personPicture.person.matricule}"><img src="data:image/jpeg;base64,${personPicture.encoded}" title="Modifier le profil" alt="avatar" width="100px"></a>
											</c:when>
											<c:otherwise>
												<img src="data:image/jpeg;base64,${personPicture.encoded}" alt="avatar" width="100px">
											</c:otherwise>
										</c:choose>
										<br/>
										<c:out value="${personPicture.person.firstname}"/><br>
										<c:out value="${personPicture.person.lastname}"/><br>	
									</td>
								<c:set var="i" value="${i+1}"/>
								
								<c:if test="${i>3}">
									</tr>
									<c:set var="i" value="0"/>
								</c:if>
						
						</c:forEach>
						<c:if test="${i>0}">
							</tr>
						</c:if>
					</table>
					
				</div>
		</fieldset>
