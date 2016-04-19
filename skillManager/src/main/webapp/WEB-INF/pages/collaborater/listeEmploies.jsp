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
							<h3 class="panel-title"><spring:message code='collab.choose.action'/></h3>
						</div>
						<table class="table table-hover" id="dev-table">
							<thead>
								<tr>
								<th></th>
								  <!--  
									<th>
										<form:form modelAttribute="collaborater" action="create.do">
											<div>
												<input type="submit" title="<spring:message code='collab.add'/>" class="addButton"/>
											</div>
										</form:form>
									</th>
									-->
									<th><spring:message code='collab.firstname.lastname'/></th>
							   		<th><spring:message code='collab.position'/></th>
			 					<th></th>
								</tr>
							</thead>
							
						 	<tbody>
								<c:forEach var="collaborater" items="${listeCollaborateurs}" varStatus="status">
							 	<tr>
							 		<td>
									 	<a href="editionCollaboraterAsManager.do?matricule=${collaborater.matricule}"><span class="glyphicon glyphicon-edit"></span> </a>
								<%-- 	 <a href="#" onclick="editionCHFR('<%=request.getContextPath()%>', '${userSession.id}')"  ><spring:message code='index.admin.collab'/></a>  --%>
									</td>
							 		<td>
										<c:out value="${collaborater.firstname} ${collaborater.lastname}"></c:out>
									</td>	
									<td>
									<!-- parce que position est une objet dans la classe Person.java on met position.code comme ci-dessous -->
										<c:out value="${collaborater.position.code}"></c:out>
									</td>
														
		       					</tr>
								</c:forEach>
							</tbody>						
						</table>
					</div>
				</div>
			</div>
</fieldset>