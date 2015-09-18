<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

		<fieldset class="ellipse01">
			<legend></legend>
			<div>
				<div class="col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title"><spring:message code='personnal.choose.action'/></h3>
						</div>
						<table class="table table-hover" id="dev-table">
							<thead>
								<tr>
									<th>
										<form:form modelAttribute="person" action="create.do">
											<div>
												<input type="submit" title="<spring:message code='personnal.add'/>" class="addButton"/>
											</div>
										</form:form>
									</th>
									<th><spring:message code='person.firstname'/></th>
									<th><spring:message code='person.lastname'/></th>
									<th><spring:message code='person.matricule'/></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="person" items="${personsList}" varStatus="status">
								<tr>
									<td>
										<a href="editionPersonAsAdmin.do?matricule=${person.matricule}"><span class="glyphicon glyphicon-edit"></span> </a>
									</td>
									<td>
										<c:out value="${person.firstname}"></c:out>
									</td>
									<td>
										<c:out value="${person.lastname}"></c:out>
									</td>
									<td>
										<c:out value="${person.matricule}"></c:out>
									</td>
									<td>
										<form:form modelAttribute="person" action="delete.do?matricule=${person.matricule}" id="deleteForm" name="deleteForm">
											<span class="glyphicon glyphicon-remove" onclick="$(deleteForm).submit()" style="cursor:pointer"></span>
										</form:form>
									</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			
		</fieldset>
