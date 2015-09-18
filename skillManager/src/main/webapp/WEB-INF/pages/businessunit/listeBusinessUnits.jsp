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
							<h3 class="panel-title"><spring:message code='businessunit.choose.action'/></h3>
						</div>
						<table class="table table-hover" id="dev-table">
							<thead>
								<tr>
									<th>
										<form:form modelAttribute="businessunit" action="create.do">
											<div>
												<input type="submit" title="<spring:message code='businessunit.add'/>" class="addButton"/>
											</div>
										</form:form>
									</th>
									<th><spring:message code='businessunit.label'/></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="businessunit" items="${businessunitsList}" varStatus="status">
								<tr>
									<td>
										<a href="editionBusinessUnit.do?id=${businessunit.id }"><span class="glyphicon glyphicon-edit"></span> </a>
									</td>
									<td>
										<c:out value="${businessunit}"></c:out>
									</td>
									<td>
										<form method="post" action="delete.do" id="deleteForm" name="deleteForm">
											<input type="hidden" name="id" value="${businessunit.id}" /> 
											<span class="glyphicon glyphicon-remove" onclick="$(deleteForm).submit()" style="cursor:pointer"></span>
										</form>
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
