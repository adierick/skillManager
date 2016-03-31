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
							<h3 class="panel-title"><spring:message code='remuneration.choose.action'/></h3>
						</div>
						<table class="table table-hover" id="dev-table">
							<thead>
								<tr>
								<th></th>
								  
									<th><spring:message code='remuneration.brut'/></th>
							   		<th><spring:message code='remuneration.fixe'/></th>
							   		<th><spring:message code='remuneration.variable'/></th>
							   		<th><spring:message code='remuneration.commentaire'/>
			 					<th></th>
								</tr>
							</thead>
							
						 	<tbody>
								<c:forEach var="remuneration" items="${listeRemunerations}" varStatus="status">
							 	<tr>
							 		<td>
										 <input class="form-control" name="remuneration.brut" placeholder="<spring:message code="collab.brut"/>" type="text" required value="${person.remuneration.brut}" ${readonly}/>
									</td>	
									<td>
										<input class="from-control" name="remuneration.fixe" placeholder="<spring:message code="collab.fixe"/>" type=text" required value="${person.remuneration.fixe}" ${readonly}/>
									</td>
									<td>
										<input class="from-control" name="remuneration.variable" placeholder="<spring:message code="collab.variable"/>" type=text" required value="${person.remuneration.variable}" ${readonly}/>
									</td>
									<td>
										<input class="from-control" name="remuneration.commentaire" placeholder="<spring:message code="collab.commentaire"/>" type=text" required value="${person.remuneration.fixe}" ${readonly}/>
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
							<h3 class="panel-title"><spring:message code='mission.choose.action'/></h3>
						</div>
						<table class="table table-hover" id="dev-table">
							<thead>
								<tr>
								<th></th>
								  
									<th><spring:message code='mission.client'/></th>
							   		<th><spring:message code='mission.activite'/></th>
							   		<th><spring:message code='mission.dateDemarrage'/></th>
							   		<th><spring:message code='mission.commentaire'/>
			 					<th></th>
								</tr>
							</thead>
							
						 	<tbody>
								<c:forEach var="mission" items="${listeMissions}" varStatus="status">
							 	<tr>
							 		<td>
										 <input class="form-control" name="mission.client" placeholder="<spring:message code="mission.client"/>" type="text" required value="${person.mission.brut}" ${readonly}/>
									</td>	
									<td>
										<input class="from-control" name="mission.activite" placeholder="<spring:message code="mission.activite"/>" type=text" required value="${person.mission.fixe}" ${readonly}/>
									</td>
									<td>
										<input class="from-control" name="mission.dateDemarrage" placeholder="<spring:message code="mission.dateDemarrage"/>" type=text" required value="${person.mission.variable}" ${readonly}/>
									</td>
									<td>
										<input class="from-control" name="mission.commentaire" placeholder="<spring:message code="mission.commentaire"/>" type=text" required value="${person.mission.fixe}" ${readonly}/>
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
							<h3 class="panel-title"><spring:message code='career.choose.action'/></h3>
						</div>
						<table class="table table-hover" id="dev-table">
							<thead>
								<tr>
								<th></th>
								  
									<th><spring:message code='career.poste'/></th>
							   		<th><spring:message code='career.coefficient'/></th>
							   		<th><spring:message code='career.date'/></th>
			 					<th></th>
								</tr>
							</thead>
							
						 	<tbody>
								<c:forEach var="career" items="${listeCareers}" varStatus="status">
							 	<tr>
							 		<td>
										 <input class="form-control" name="career.poste" placeholder="<spring:message code="career.poste"/>" type="text" required value="${person.career.brut}" ${readonly}/>
									</td>	
									<td>
										<input class="from-control" name="career.coefficient" placeholder="<spring:message code="career.coefficient"/>" type=text" required value="${person.career.fixe}" ${readonly}/>
									</td>
									<td>
										<input class="from-control" name="career.date" placeholder="<spring:message code="career.date"/>" type=text" required value="${person.career.variable}" ${readonly}/>
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
						<c:forEach var="misc" items="${listeMisc}" varStatus="status">
						<from>
							<input class="from-control" name="misc.misc" placeholder="<spring:message code="misc.misc"/>" type="text" required value="${person.misc.misc}" ${readonly}/>
						</from>
						</c:forEach>	 	
					</div>
				</div>
			</div>
</fieldset>