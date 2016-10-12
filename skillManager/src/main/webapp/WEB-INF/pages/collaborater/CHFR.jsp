<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div>
	<c:set var="readonly" value="" />
	<c:if test="${!userSession.admin}">
		<c:set var="readonly" value="readonly='true'" />
	</c:if>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 well well-sm">
				<form:form modelAttribute="person" action="update.do" class="formulaire">
					<%-- ------------ --%> 
					<%-- COMPETENCES COMPORTEMENTALES --%> 
					<%-- ------------ --%>  
					<div class ="md-col-6">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">
									<spring:message code='behaviour.choose.action'/>
								</h3>
							</div>
							<table class="table table-hover" id="dev-table">
								<thead>
									<th><span  class="addButton"></span></th>
									<th><spring:message code='behaviour.strong_points'/></th>
									<th><spring:message code='behaviour.areas_improvement'/></th>
								</thead>
								<tbody>
								<c:forEach var="behaviour" items="${person.person.behaviour}" varStatus="status">
									<tr>
										<td><a href=""><span class="glyphicon glyphicon-edit"></span> </a></td>
										<td>${behaviour.strong_points}</td>
										<td>${behaviour.areas_improvement}</td>
									</tr>	
								</c:forEach>
								</tbody>
							</table>
						</div>
					</div>	
					
					<!------------------->
					<!--HISTORIQUE MANAGERIALE-->
					<!------------------->
					<div class="md-col-6">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">
									<spring:message code='history_MGT.choose.action'/>
								</h3>
								</div>
								<table>
									<thead>
									<th><spring:message code='personality_type'></spring:message></th>
									<th></th>
									</thead>
								</table>	
								<table class="table table-hover">
									<thead>
										<th><spring:message code='history_MGT.smil'/></th>
										<th><spring:message code='histoy_MGT.maturity_employee'/></th>
										<th><spring:message code='history_MGT.management_style'/></th>
										<th><spring:message code='history_MGT.management_apply'/></th>
									</thead>
									<tbody>
<%-- 								<c:forEach var="historyMGT" items="${person.person.historyMGT}" varStatus="status"> --%>
<!-- 									<tr> -->
<!-- 										<td><a href=""><span class="glyphicon glyphicon-edit"></span> </a></td> -->
<%-- 										<td>${historyMGT.smil}</td> --%>
<%-- 										<td>${historyMGT.maturity_employee}</td> --%>
<%-- 										<td>${historyMGT.management_style}</td> --%>
<%-- 										<td>${historyMGT.management_apply}</td> --%>
<!-- 									</tr>	 -->
<%-- 								</c:forEach> --%>
								</tbody>
								</table>
						</div>
					</div>
						<!---------------->
						<!-- FORMATIONS -->
						<!---------------->
					<div class="md-col-6">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">
									<spring:message code='formation.choose.action'/>
								</h3>
							</div>	
								<table class="table table-hover" id="dev-table">
									<thead>
									<th><spring:message code='formation.entitled'></spring:message></th>
									<th><spring:message code='formation.date'></spring:message></th>
									</thead>
									<tbody>
<%-- 								<c:forEach var="formation" items="${person.person.formation}" varStatus="status"> --%>
<!-- 									<tr> -->
<!-- 										<td><a href=""><span class="glyphicon glyphicon-edit"></span> </a></td> -->
<%-- 										<td>${formation.entitled}</td> --%>
<%-- 										<td>${formation.date}</td> --%>
<!-- 									</tr>	 -->
<%-- 								</c:forEach> --%>
								</tbody>
								</table>
						</div>					
					</div>	
					<!--------------------->
					<!------REMARQUES------>
					<!--------------------->
					<div class="col-md-6">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">
									<spring:message code='remarks.choose.action' />
								</h3>
							</div>

							<div class="table table-hover" id="dev-table">
								<textarea rows="5" cols="77"></textarea> 
							</div>
						</div>
					</div>
				</form:form>
			</div>	
		</div>
	</div>
</div>	
				
<!-- <a href="#" class="btn btn-warning btn-lg" role="button"> -->
<!-- 	<span class="glyphicon glyphicon-alert"></span> <br/> -->
<!-- 	UNDER CONSTRUCTION -->
<!-- </a> -->
