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
							<h3 class="panel-title"><spring:message code='behaviour.choose.action'/></h3>
						</div>
						<table class="table table-hover" id="dev-table">
							<thead>
								<tr>
								<th></th>
								  
									<th><spring:message code='behaviour.strong_points'/></th>
							   		<th><spring:message code='behaviour.areas_improvement'/></th>
			 					<th></th>
								</tr>
							</thead>
							
						 	<tbody>
								<c:forEach var="behaviour" items="${listeBehaviours}" varStatus="status">
							 	<tr>
							 		<td>
										 <input class="form-control" name="behaviour.strong_points" placeholder="<spring:message code="behaviour.strong_points"/>" type="text" required value="${person.behaviour.strong_points}" ${readonly}/>
									</td>	
									<td>
										<input class="from-control" name="behaviour.areas_improvement" placeholder="<spring:message code="behaviour.areas_improvement"/>" type="text" required value="${person.behaviour.areas_improvement}" ${readonly}/>
									</td>
														
		       					</tr>
								</c:forEach>
							</tbody>						
						</table>
					</div>
				</div>
			</div>
</fieldset>
<br>
<fieldset class="ellipse01">
			<legend></legend>
			<div>
				<div class="col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title"><spring:message code='history_MGT.choose.action'/></h3>
						</div>
						<table class="table table-hover" id="dev-table">
							<thead>
								<tr>
								<th></th>
									<th><spring:message code='history_MGT.smil'/></th>
							   		<th><spring:message code='histoy_MGT.maturity_employee'/></th>
							   		<th><spring:message code='history_MGT.management_apply'/></th>
			 					<th></th>
								</tr>
							</thead>
							
						 	<tbody>
								<c:forEach var="history_MGT" items="${listeHistory_MGT}" varStatus="status">
							 	<tr>
							 		<td>
										 <input class="form-control" name="history_MGT.smil" placeholder="<spring:message code="history_MGT.smil"/>" type="text" required value="${person.history_MGT.smil}" ${readonly}/>
									</td>	
									<td>
										<input class="from-control" name="history_MGT.maturity_employee" placeholder="<spring:message code="history_MGT.maturity_employee"/>" type="text" required value="${person.history_MGT.maturity_employee}" ${readonly}/>
									</td>
									<td>
										<input class="from-control" name="history_MGT.management_apply" placeholder="<spring:message code="history_MGT.management_apply"/>" type="text" required value="${person.history_MGT.management_apply}" ${readonly}/>
									</td>
															
		       					</tr>
								</c:forEach>
							</tbody>						
						</table>
					</div>
				</div>
			</div>
</fieldset>
<br>
<fieldset class="ellipse01">
			<legend></legend>
			<div>
				<div class="col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title"><spring:message code='formation.choose.action'/></h3>
						</div>
						<table class="table table-hover" id="dev-table">
							<thead>
								<tr>
								<th></th>
								  
									<th><spring:message code='formation.entitled'/></th>
							   		<th><spring:message code='formation.date'/></th>   		
			 					<th></th>
								</tr>
							</thead>
							
						 	<tbody>
								<c:forEach var="formation" items="${listeFormations}" varStatus="status">
							 	<tr>
							 		<td>
										 <input class="form-control" name="formation.entitled" placeholder="<spring:message code="formation.entitled"/>" type="text" required value="${person.formation.entitled}" ${readonly}/>
									</td>	
									<td>
										<input class="from-control" name="formation.date" placeholder="<spring:message code="formation.date"/>" type="date" required value="${person.formation.date}" ${readonly}/>
									</td>
														
		       					</tr>
								</c:forEach>
							</tbody>						
						</table>
					</div>
				</div>
			</div>
</fieldset>
<br>
<fieldset class="ellipse01">
			<legend></legend>
			<div>
				<div class="col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title"><spring:message code='misc.choose.action'/></h3>
						</div>
						<c:forEach var="remarks" items="${listeRemarks}" varStatus="status">
						<from>
							<input class="from-control" name="remarks.remarks" placeholder="<spring:message code="remarks.remarks"/>" type="text" required value="${person.remarks.remarks}" ${readonly}/>
						</from>
						</c:forEach>	 	
					</div>
				</div>
			</div>
</fieldset>