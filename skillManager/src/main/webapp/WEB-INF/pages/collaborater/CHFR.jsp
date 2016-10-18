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
									<th>
										<div>
											<input type="button"
												title="<spring:message code='behaviour.add'/>"
												class="addButton" data-toggle="modal" data-target="#myModalBehaviour" />
										</div>
									</th>
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
									<spring:message code='history_MGT.choose.action' />
								</h3>
							</div>
							<table class="table table-hover">
								<table class="table table-hover">
									<thead>
										<th>
											<div>
												<input type="button"
													title="<spring:message code='history_MGT.add'/>"
													class="addButton" data-toggle="modal"
													data-target="#myModalHistoryMGT" />
											</div>
										</th>

										<th><label class="col-sm-2 control-label" for="textinput"><spring:message
													code="history_MGT.personality_type" /></label></th>
										<th><c:forEach var="historyMGT"
												items="${person.person.historyMGT}" varStatus="status">
												<input class="form-control"
													placeholder="<spring:message code="history_MGT.personality_type"/>"
													type="text" autofocus
													value="${historyMGT.personality_type}" ${readonly} />
											</c:forEach></th>
									</thead>
								</table>
								<table class="table table-hover">
									<thead>
										<th></th>
										<th><spring:message code='history_MGT.smil' /></th>
										<th><spring:message code='histoy_MGT.maturity_employee' /></th>
										<th><spring:message code='history_MGT.management_style' /></th>
										<th><spring:message code='history_MGT.management_apply' /></th>
									</thead>
									<tbody>
										<c:forEach var="historyMGT"
											items="${person.person.historyMGT}" varStatus="status">
											<tr>
												<td><a href=""><span
														class="glyphicon glyphicon-edit"></span> </a></td>
												<td>${historyMGT.smil}</td>
												<td>${historyMGT.maturity_employee}</td>
												<td>
													<form:select path="person.historyMGT" cssClass="form-control">
														<form:option value="historyMGT.management_style" label="---" />
														<form:options items="${listManagement}"/>
													</form:select> 
												<td>
													<form:select path="person.historyMGT"
														cssClass="form-control">
														<form:option value="history.management_apply" label="---" />
														<form:options items="${listManagement}"/>
													</form:select>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
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
									<th>
										<div>
											<input type="button"
												title="<spring:message code='formation.add'/>"
												class="addButton" data-toggle="modal" data-target="#myModalFormation" />
										</div>
									</th>
									<th><spring:message code='formation.entitled'></spring:message></th>
									<th><spring:message code='formation.date'></spring:message></th>
									</thead>
									<tbody>
								<c:forEach var="formation" items="${person.person.formation}" varStatus="status">
									<tr>
										<td><a href=""><span class="glyphicon glyphicon-edit"></span> </a></td>
										<td>${formation.entitled}</td>
										<td><fmt:formatDate  value="${formation.date}"  pattern="dd-MM-yyyy" /></td>
									</tr>	
								</c:forEach>
								</tbody>
								</table>
						</div>					
					</div>	
									
					<!--------------------->
					<!------REMARQUES------>
					<!--------------------->
					<div>
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">
									<spring:message code='remarks.choose.action' />
								</h3>
							</div>

							<div class="table table-hover" id="dev-table">
								<form:textarea path="person.remarks.remarks" style="width: 591px; height: 89px;"></form:textarea> 
							</div>
						</div>
					</div>
					<form:hidden path="person.firstname" />
					<button class="btn btn-lg btn-success btn-block" type="submit">${type}</button>
				</form:form>
			</div>	
		</div>
	</div>
</div>	

<!-- MODAL POPUPS -->
<%@include file="./editionBehaviour.jsp" %>
<%@include file="./editionHistoryMGT.jsp" %>
<%@include file="./editionFormation.jsp" %>