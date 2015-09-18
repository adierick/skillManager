<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

		<fieldset class="ellipse03">
			<legend></legend>
			
			<div >
				<div class="col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title"><spring:message code='category.choose.action'/></h3>
						</div>
						<table class="table table-hover" id="dev-table">
							<thead>
								<tr>
									<th>
										<form:form modelAttribute="category" action="create.do">
											<div>
												<input type="submit" title="<spring:message code='category.add'/>" class="addButton"/>
											</div>
										</form:form>
									</th>
									<th><spring:message code='category.trs_label_key'/></th>
									<th><spring:message code='category.code'/></th>
									<th><spring:message code='category.skills'/></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="category" items="${categoriesList}" varStatus="status">
								<tr>
									<td>
										<a href="editionCategory.do?id=${category.id }"><span class="glyphicon glyphicon-edit"></span> </a>
									</td>
									<td>
										<spring:message code='${category.trs_label_key}'/> 
									</td>
									<td>
										<c:out value="${category.code}"></c:out>
									</td>
									<td>
										<a href="editionCategorySkills.do?id=${category.id}" class="addmodifButton"><span class="glyphicon glyphicon-list-alt"></span></a>				
									</td>
									<td>
										<form method="post" action="delete.do" id="deleteForm" name="deleteForm">
											<input type="hidden" name="id" value="${category.id}" /> 
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
		</fieldset>
