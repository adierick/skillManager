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
								<c:if test="${i>4}">
									<tr>
								</c:if>
								
									<td align="center">
										<br/>
										<c:out value="${personPicture.person.firstname}"/><br>
										<c:out value="${personPicture.person.lastname}"/><br>
										<img src="data:image/jpeg;base64,${personPicture.encoded}" alt="avatar" width="100px">
									</td>
								
								<c:if test="${i>4}">
									<c:set var="i" value="${0}"/>
									</tr>
								</c:if>
						
						</c:forEach>
					</table>
					
				</div>
		</fieldset>