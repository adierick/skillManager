<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<style type="text/css">
/**
 * Override feedback icon position
 * See http://formvalidation.io/examples/adjusting-feedback-icon-position/
 */
#eventForm .form-control-feedback {
	top: 0;
	right: -15px;
}

#eventForm2 .form-control-feedback {
	top: 0;
	right: -15px;
}

#eventForm3 .form-control-feedback {
	top: 0;
	right: -15px;
}
</style>

<div>
	<c:set var="readonly" value="" />
	<c:if test="${!userSession.admin}">
		<c:set var="readonly" value="readonly='true'" />
	</c:if>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 well well-sm">
				<form:form modelAttribute="person" action="update.do" class="formulaire">


					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="person.firstname" /></label>
						<div class="col-sm-4">
							<input class="form-control" name="person.firstname"
								placeholder="<spring:message code="person.firstname"/>"
								type="text" required autofocus
								value="${person.person.firstname}" ${readonly} />
						</div>
						
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="person.date.sii" /></label>
						<div class="col-sm-4">
								<input type="text" class="form-control" id="datePicker3"
									name="person.date_entry_sii" required value="${person.person.date_entry_sii}"
									${readonly} /> 
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="person.lastname" /></label>
						<div class="col-sm-4">
							<input class="form-control" name="person.lastname"
								placeholder="<spring:message code="person.lastname"/>"
								type="text" required value="${person.person.lastname}"
								${readonly} />
						</div>
						
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="person.position.coeff" /></label>
						<div class="col-sm-4">
							<input class="form-control" name="person.position_coeff"
								placeholder="<spring:message code="person.position_coeff"/>"
								type="text" required value="${person.person.position_coeff}"
								${readonly} />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="person.date.birth" /></label>
						<div class="col-sm-4">
								<input type="text" class="form-control" id="datePicker"
									name="person.birth_date" required value="${person.person.birth_date}"
									${readonly} /> 
						</div>
						
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="person.position.code" /></label>
						<div class="col-sm-4">
							<form:select path="person.position" cssClass="form-control">
								<form:option value="" label="---" />
								<form:options items="${listPosition}" itemValue="id" />
							</form:select>
						</div>
					</div>
					
					
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="person.phone" /></label>
						<div class="col-sm-4">
							<input class="form-control" name="person.tel"
								placeholder="<spring:message code="person.person.tel"/>"
								type="text" required value="${person.person.tel}" ${readonly} />
						</div>
						
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="person.manager.name" /></label>
						<div class="col-sm-4">
							<form:select path="person.manager_" cssClass="form-control">
								<form:option value="" label="---" />
								<form:options items="${listManager}" itemValue="id" />
							</form:select>
						</div>
					</div>	
					
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="person.hobby" /></label>
						<div class="col-sm-4">
							<input class="form-control" name="person.hobby"
								placeholder="<spring:message code="person.hobby"/>" type="text"
								required value="${person.person.hobby}" ${readonly} />
						</div>
						
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="person.bu" /></label>
						<div class="col-sm-4">
							<form:select path="person.bu" cssClass="form-control">
								<form:option value="" label="---" />
								<form:options items="${listBu}" itemLabel="label" />
							</form:select>
						</div>
					</div>	
					
					
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="person.date.activity" /></label>
						<div class="col-sm-4">
								<input type="text" class="form-control" id="datePicker2"
									name="person.date_activity_pro" required value="${person.person.date_activity_pro}"
									${readonly} /> 
						</div>
					</div>		
					

					<%-- ------------ --%> 
					<%-- REMUNERATION --%> 
					<%-- ------------ --%>  
					<div class="col-md-6">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">
									<spring:message code='remuneration.choose.action' />
								</h3>
							</div>
							<table class="table table-hover" id="dev-table">
								<thead>
									<tr>
										<th><span  class="addButton"></span></th>
										<th><spring:message code='remuneration.brut' /></th>
										<th><spring:message code='remuneration.fixe' /></th>
										<th><spring:message code='remuneration.variable' /></th>
										<th><spring:message code='remuneration.commentaire' />
									</tr>
								</thead>
								<tbody>
									<c:forEach var="remuneration" items="${person.person.remuneration}" varStatus="status">
										<tr>
											<td><a href=""><span class="glyphicon glyphicon-edit"></span> </a> 
		<%-- 	 <a href="#" onclick="editionCHFR('<%=request.getContextPath()%>', '${userSession.id}')"  ><spring:message code='index.admin.collab'/></a>  --%>
											</td>
											<td>${remuneration.brut}</td>
											<td>${remuneration.fixe}</td>
											<td>${remuneration.variable}</td>
											<td>${remuneration.commentaire}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					
					<%-- ------------ --%> 
					<%--    MISSION   --%> 
					<%-- ------------ --%>  
					<div>
						<div class="col-md-6">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 class="panel-title">
										<spring:message code='mission.choose.action' />
									</h3>
								</div>
								<table class="table table-hover" id="dev-table">
									<tr>
										<th></th>

										<th><spring:message code='mission.client' /></th>
										<th><spring:message code='missionentitedMission' /></th>
										<th><spring:message code='mission.activite' /></th>
										<th><spring:message code='mission.dateDemarrage' /></th>
										<th><spring:message code='mission.commentaire' />
									</tr>
									</thead>

									<tbody>
									<c:forEach var="mission" items="${person.person.missions}" varStatus="status">
										<tr>
											<td><a href=""><span class="glyphicon glyphicon-edit"></span> </a> 
		<%-- 	 <a href="#" onclick="editionCHFR('<%=request.getContextPath()%>', '${userSession.id}')"  ><spring:message code='index.admin.collab'/></a>  --%>
											</td>
											<td>${mission.client}</td>
											<td>${mission.entitedMission}</td>
											<td>${mission.activite}</td>
											<td>${mission.dateDemarrage}</td>
											<td>${mission.commentaire}</td>
										</tr>
									</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					
					
					
					
					<%-- ------------ --%> 
					<%--    CAREER    --%> 
					<%-- ------------ --%>  
					<div>
						<div class="col-md-6">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 class="panel-title">
										<spring:message code='career.choose.action' />
									</h3>
								</div>
								<table class="table table-hover" id="dev-table">
									<thead>
										<tr>
											<th></th>
											<th><spring:message code='career.poste' /></th>
											<th><spring:message code='career.coefficient' /></th>
											<th><spring:message code='career.date' /></th>
										</tr>
									</thead>

									<tbody>
									<c:forEach var="career" items="${person.person.career}" varStatus="status">
										<tr>
											<td><a href=""><span class="glyphicon glyphicon-edit"></span> </a> 
		<%-- 	 <a href="#" onclick="editionCHFR('<%=request.getContextPath()%>', '${userSession.id}')"  ><spring:message code='index.admin.collab'/></a>  --%>
											</td>
											<td>${career.poste}</td>
											<td>${career.coefficient}</td>
											<td>${career.date}</td>
										</tr>
									</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					
					<div class="col-md-6">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">
									<spring:message code='misc.choose.action' />
								</h3>
							</div>

							<div class="table table-hover" id="dev-table">
								<form:textarea path="person.misc.misc_description" rows="5"
									cols="77"></form:textarea>

								<%-- 		<textarea class="form-control" path="person.person.misc.misc_description" placeholder="<spring:message code="misc.description"/>" type="text" required value="${person.person.misc.misc_description}"></textarea> --%>
							</div>


						</div>
					</div>
					<form:hidden path="person.id" />
					<button class="btn btn-lg btn-primary btn-block" type="submit">${type}</button>
				</form:form>
			</div>
		</div>
	</div>
</div>

