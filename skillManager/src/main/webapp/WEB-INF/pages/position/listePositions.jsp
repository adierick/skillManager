<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

		<fieldset class="ellipse04">
			<legend></legend>
			
			<div >
				<div class="col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title"><spring:message code='collab.position'/></h3>
						</div>
						<table class="table table-hover" id="dev-table">
							<thead>
								<tr>
									<th>
										<form:form modelAttribute="position" action="create.do">
											<div>
												<input type="submit" title="<spring:message code='position.add'/>" class="addButton"/>
											</div>
										</form:form>
									</th>
									<th><spring:message code='position.code'/></th>
									<th><spring:message code='position.trs_label_key'/></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="position" items="${positionList}" varStatus="status">
								<tr>
									<td>
										<a href="editionPosition.do?id=${position.id }"><span class="glyphicon glyphicon-edit"></span> </a>
									</td>
									<td>
										<c:out value="${position}"></c:out>
									</td>
									<td>
										<c:out value="${position.trs_label_key}"></c:out>
									</td>
									<td>
									
										<form:form modelAttribute="position" action="delete.do?id=${position.id}" id="deleteForm_${position.id}" name="deleteForm_${position.id}">
											<span class="glyphicon glyphicon-remove" onclick="$(deleteForm_${position.id}).submit()" style="cursor:pointer"></span>
										</form:form>
									</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
	<c:out value="${message }"></c:out>
	</fieldset>
