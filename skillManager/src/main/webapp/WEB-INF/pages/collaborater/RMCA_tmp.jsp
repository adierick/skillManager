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
							<h3 class="panel-title"><spring:message code='collab.personal.information'/></h3>
						</div>
						<table class="table table-hover" id="dev-table">
							<thead>
								<tr>
								  <!--  
									<th>
										<form:form modelAttribute="collaborater" action="create.do">
											<div>
												<input type="submit" title="<spring:message code='collab.add'/>" class="addButton"/>
											</div>
										</form:form>
									</th>
									-->
									<th><spring:message code='collab.firstname'/></th>
							   		<th>
			 							<input class="form-control" name="firstname" placeholder="<spring:message code="collab.firstname"/>" type="text" required value="${person.person.firstname}"/>
			 						</th>
			 					<tr>
			 						<th><spring:message code='collab.lastname'></spring:message>
			 						<th>
										<input class="form-control" name="lastname" placeholder="<spring:message code="collab.lastname"/>" type="text" required value="${person.person.lastname}"/>
									</th>
			 					</tr>
								  <!--  
									<th>
										<form:form modelAttribute="collaborater" action="create.do">
											<div>
												<input type="submit" title="<spring:message code='collab.add'/>" class="addButton"/>
											</div>
										</form:form>
									</th>
									-->
									
			 					<th><spring:message code='collab.birth_date'/></th>
							   		<th>
			 							<input class="form-control" name="birth_date" placeholder="<spring:message code="collab.birth_date"/>" type="date" required value="${person.person.birth_date}"/>
			 						</th>
			 					<tr>
			 						<th><spring:message code='collab.Tel'></spring:message>
			 						<th>
										<input class="form-control" name="tel" placeholder="<spring:message code="collab.Tel"/>" type="text" required value="${person.person.Tel}"/>
									</th>
			 					</tr>
			 					<tr>
			 						<th><spring:message code='collab.hobby'></spring:message>
			 						<th>
										<input class="form-control" name="hobby" placeholder="<spring:message code="collab.hobby"/>" type="text" required value="${person.person.hobby}"/>
									</th>
			 					</tr>
			 					<tr>
			 						<th><spring:message code='collab.date_entry_sii'></spring:message>
			 						<th>
										<input class="form-control" name="date_entry_sii" placeholder="<spring:message code="collab.date_entry_sii"/>" type="date" required value="${person.person.date_entry_sii}"/>
									</th>
			 					</tr>
			 					<tr>
			 						<th><spring:message code='collab.position_coeff'></spring:message>
			 						<th>
										<input class="form-control" name="position_coeff" placeholder="<spring:message code="collab.position_coeff"/>" type="text" required value="${person.person.position_coeff}"/>
									</th>
			 					</tr>
			 					<tr>
			 						<th><spring:message code='collab.position'></spring:message>
			 						<th>
										<input class="form-control" name="position" placeholder="<spring:message code="collab.position"/>" type="text" required value="${person.person.position.code}"/>
									</th>
			 					</tr>
			 					<tr>
			 						<th><spring:message code='collab.manager'></spring:message>
			 						<th>
										<input class="form-control" name="bu" placeholder="<spring:message code="collab.bu"/>" type="text" required value="${person.person.bu.label}"/>
									</th>
			 					</tr>
								</tr>
								
								
							</thead>
							
						 	 <%-- <tbody>
								<c:forEach var="collaborater" items="${listeCollaborateurs}" varStatus="status">
							 	<tr>
							 	<td></td>
							 		<td>
										<c:out value="${collaborater.firstname} ${collaborater.lastname}"></c:out>
									</td>
								<tr>	
									<td>
									<!-- parce que position est une objet dans la classe Person.java on met position.code comme ci-dessous -->
										<c:out value="${collaborater.position.code}"></c:out>
									</td>
								</tr>					
		       					</tr>
								</c:forEach>
							</tbody> --%>					
						</table>
					</div>
				</div>
			</div>
<!-- </fieldset>
<fieldset class="ellipse01">
			<legend></legend> -->
			<div>
				<div class="col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title"><spring:message code='remuneration.choose.action'/></h3>
						</div>
						<table class="table table-hover" id="dev-table">
							<%-- <tr>
			 					<th><spring:message code='remuneration.brut'></spring:message>
			 					<th>
									<input class="form-control" name="brut" placeholder="<spring:message code="remuneration.brut"/>" type="text" required value="${remuneration.brut}"/>
								</th>
			 				</tr>
			 				<tr>
			 					<th><spring:message code='remuneration.fixe'></spring:message>
			 					<th>
									<input class="form-control" name="fixe" placeholder="<spring:message code="remuneration.fixe"/>" type="text" required value="${remuneration.fixe}"/>
								</th>
			 				</tr>
			 				<tr>
			 					<th><spring:message code='remuneration.variable'></spring:message>
			 					<th>
									<input class="form-control" name="variable" placeholder="<spring:message code="remuneration.variable"/>" type="text" required value="${remuneration.variable}"/>
								</th>
			 				</tr>
			 				<tr>
			 					<th><spring:message code='remuneration.commentaire'></spring:message>
			 					<th>
									<div>
							 <textarea class="form-control" name="commentaire" placeholder="<spring:message code="remuneration.commentaire"/>" type="text" required value="${remuneration.commentaire}" ${readonly}></textarea> 	
						</div>
								</th>
			 				</tr> --%>
						
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
										 <input class="form-control" name="brut" placeholder="<spring:message code="remuneration.brut"/>" type="text" required value="${remuneration.brut}" ${readonly}/>
									</td>	
									<td>
										<input class="from-control" name="fixe" placeholder="<spring:message code="remuneration.fixe"/>" type="text" required value="${remuneration.fixe}" ${readonly}/>
									</td>
									<td>
										<input class="from-control" name="variable" placeholder="<spring:message code="remuneration.variable"/>" type="text" required value="${remuneration.variable}" ${readonly}/>
									</td>
									<td>
										<textarea class="form-control" name="commentaire" placeholder="<spring:message code="remuneration.commentaire"/>" type="text" required value="${remuneration.commentaire}" ${readonly}></textarea>
									</td>
														
		       					</tr>
								</c:forEach>
							</tbody>						
						</table>
					</div>
				</div>
			</div>
<!-- </fieldset>
<br>
<fieldset class="ellipse01">
			<legend></legend> -->
			<div>
				<div class="col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title"><spring:message code='mission.choose.action'/></h3>
						</div>
						<table class="table table-hover" id="dev-table">
						<tr>
			 					<th><spring:message code='mission.client'></spring:message>
			 					<th>
									<input class="form-control" name="client" placeholder="<spring:message code="mission.client"/>" type="text" required value="${mission.client}"/>
								</th>
			 			</tr>
			 			<tr>
			 					<th><spring:message code='mission.activite'></spring:message>
			 					<th>
									<input class="form-control" name="activite" placeholder="<spring:message code="mission.activite"/>" type="text" required value="${mission.activite}"/>
								</th>
			 			</tr>
			 			<tr>
			 					<th><spring:message code='mission.dateDemarrage'></spring:message>
			 					<th>
									<input class="form-control" name="dateDemarrage" placeholder="<spring:message code="mission.dateDemarrage"/>" type="date" required value="${mission.dateDemarrage}"/>
								</th>
			 			</tr>
			 			<tr>
			 					<th><spring:message code='mission.commentaire'></spring:message>
			 					<th>
									<textarea class="form-control" name="commentaire" placeholder="<spring:message code="mission.commentaire"/>" type="text" required value="${mission.commentaire}"></textarea>
								</th>
			 			</tr>
							<%-- <thead>
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
							</tbody> --%>						
						</table>
					</div>
				</div>
			</div>
<!-- </fieldset>
<br>
<fieldset class="ellipse01">
			<legend></legend> -->
			<div>
				<div class="col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title"><spring:message code='career.choose.action'/></h3>
						</div>
						<table class="table table-hover" id="dev-table">
							<tr>
			 					<th><spring:message code='career.poste'></spring:message>
			 					<th>
									<input class="form-control" name="poste" placeholder="<spring:message code="career.poste"/>" type="text" required value="${career.poste}"/>
								</th>
			 			</tr>
			 			<tr>
			 					<th><spring:message code='career.coefficient'></spring:message>
			 					<th>
									<input class="form-control" name="coefficient" placeholder="<spring:message code="career.coefficient"/>" type="text" required value="${career.coefficient}"/>
								</th>
			 			</tr>
			 			<tr>
			 					<th><spring:message code='career.date'></spring:message>
			 					<th>
									<input class="form-control" name="date" placeholder="<spring:message code="career.date"/>" type="date" required value="${career.date}"/>
								</th>
			 			</tr>
							
							<%-- <thead>
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
							</tbody> --%>						
						</table>
					</div>
				</div>
			</div>
<!-- </fieldset>
<br>
<fieldset class="ellipse01">
			<legend></legend> -->
			<div>
				<div class="col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title"><spring:message code='misc.choose.action'/></h3>
						</div>
						<tr>
			 					<th>
									<textarea class="form-control" name="misc" placeholder="<spring:message code="misc.description"/>" type="text" required value="${misc.description}"></textarea>
								</th>
			 				</tr>
						
						<%-- <c:forEach var="misc" items="${listeMisc}" varStatus="status">
						<from>
							<input class="from-control" name="misc.misc" placeholder="<spring:message code="misc.misc"/>" type="text" required value="${person.misc.misc}" ${readonly}/>
						</from>
						</c:forEach> --%>	 	
					</div>
				</div>
			</div>
</fieldset>