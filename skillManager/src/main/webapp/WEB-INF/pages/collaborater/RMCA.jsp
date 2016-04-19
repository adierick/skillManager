<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Include Bootstrap Datepicker -->
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" />
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" />

<script
	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>

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
			<!-- modification col-md-4 en col-md-12 -->
			<div class="col-xs-12 col-sm-12 col-md-12 well well-sm">
				<form:form modelAttribute="person" action="update.do"
					class="formulaire">
					<div class="row">
						<div class="col-xs-6 col-md-6">
							<input class="form-control" name="person.firstname"
								placeholder="<spring:message code="person.firstname"/>"
								type="text" required autofocus
								value="${person.person.firstname}" ${readonly} />
						</div>
						<div class="col-xs-6 col-md-6">
							<input class="form-control" name="person.lastname"
								placeholder="<spring:message code="person.lastname"/>"
								type="text" required value="${person.person.lastname}"
								${readonly} />
						</div>
					</div>

					<%-- 		            <form id="eventForm" method="post" class="form-horizontal">					 --%>
					<div class="form-group">
						<div class="input-group input-append date">
							<input type="text" class="form-control" id="datePicker"
								name="date" required value="${person.person.birth_date}"
								${readonly} /> <span class="input-group-addon"> </span>
							<!-- 					                    <span class="glyphicon glyphicon-calendar"> 
					                    </span>-->

						</div>
					</div>
					<%-- 					</form> --%>

					<%--  		            <input class="form-control"  name="person.person.birth_date" placeholder="<spring:message code="person.person.birth_date"/>" type="text" required value="${person.person.birth_date}" ${readonly}/>  --%>
					<input class="form-control" name="person.tel"
						placeholder="<spring:message code="person.person.tel"/>"
						type="text" required value="${person.person.tel}" ${readonly} />
					<input class="form-control" name="person.hobby"
						placeholder="<spring:message code="person.hobby"/>" type="text"
						required value="${person.person.hobby}" ${readonly} />
					<%-- 					<form id="eventForm2" method="post" class="form-horizontal">  --%>
					<div class="form-group">
						<div class="input-group input-append date">
							<input type="text" class="form-control" id="datePicker2"
								name="date" required value="${person.person.date_activity_pro}"
								${readonly} /> <span class="input-group-addon"></span>
							<!-- 									                    <span class="glyphicon glyphicon-calendar"> 
<!-- 									                </span>  -->
						</div>
					</div>
					<%-- 				 	</form>					 --%>

					<%-- 					<form id="eventForm3" method="post" class="form-horizontal"> --%>
					<div class="form-group">
						<div class="input-group input-append date">
							<input type="text" class="form-control" id="datePicker3"
								name="date" required value="${person.person.date_entry_sii}"
								${readonly} /> <span class="input-group-addon"></span>
							<!-- 					                    <span class="glyphicon glyphicon-calendar"> </span>-->


						</div>
					</div>
					<%-- 					</form> --%>

					<%--  		         	<input class="form-control" name="person.person.date_entry_sii" placeholder="<spring:message code="person.date_entry_sii"/>" type="date" required value="${person.person.date_entry_sii}" ${readonly}/>  --%>
					<input class="form-control" name="person.position_coeff"
						placeholder="<spring:message code="person.person.position_coeff"/>"
						type="text" required value="${person.person.position_coeff}"
						${readonly} />
					<input class="form-control" name="person.position.code"
						placeholder="<spring:message code="person.person.position.code"/>"
						type="text" required value="${person.person.position.code}"
						${readonly} />

					<%-- 					<textarea class="form-control" path="person.person.misc.misc_description" placeholder="<spring:message code="misc.description"/>" type="text" required value="${person.person.misc.misc_description}" ${readonly}></textarea> --%>

					<input class="form-control" name="person.manager_.lastname"
						placeholder="<spring:message code="person.person.manager_.lastname"/>"
						type="text" required
						value="${person.person.manager_.firstname} ${person.person.manager_.lastname }"
						${readonly} />

					<div></div>
					<!-- 				</div> -->
					<label for=""><spring:message code="person.bu" /></label>
					<div class="row">
						<div class="col-xs-4 col-md-4">
							<form:select path="person.bu" cssClass="form-control">
								<form:option value="" label="---" />
								<form:options items="${listBu}" itemLabel="label" />
							</form:select>
						</div>
					</div>

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
										<th></th>

										<th><spring:message code='remuneration.brut' /></th>
										<th><spring:message code='remuneration.fixe' /></th>
										<th><spring:message code='remuneration.variable' /></th>
										<th><spring:message code='remuneration.commentaire' />
									</tr>
								</thead>

								<tbody>
									<!-- person.person.remuneration à la place de listeRemunerations-->
									<c:forEach var="remuneration" items="${listeRemunerations}"
										varStatus="status">
										<tr>
											<td><a href=""><span
													class="glyphicon glyphicon-edit"></span> </a> <%-- 	 <a href="#" onclick="editionCHFR('<%=request.getContextPath()%>', '${userSession.id}')"  ><spring:message code='index.admin.collab'/></a>  --%>
											</td>
											<!-- 											remuneration.brut a la place de person.remuneration.brut -->
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
										<%-- 						 	<c:forEach var="mission" items="${listeMissions}" varStatus="status"> --%>
										<tr>
											<td><a
												onclick="location.href='<%=request.getContextPath()%>/main/collaborater/editionMission.do'"><span
													class="glyphicon glyphicon-edit"></span> </a></td>
											<td>${person.person.missions.client}</td>
											<td>${person.person.missions.entitedMission}</td>
											<td>${person.person.missions.activite}</td>
											<td>${person.person.missions.dateDemarrage}</td>
											<td>${person.person.missions.commentaire}</td>
										</tr>
										<%-- 		       					</c:forEach> --%>
									</tbody>
								</table>
							</div>
						</div>
					</div>
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

										<tr>
											<td><a
												href="editionCollaboraterAsManager.do?matricule=${career.poste}"><span
													class="glyphicon glyphicon-edit"></span> </a></td>
											<td>${person.person.career.poste}</td>
											<td>${person.person.career.coefficient}</td>
											<td>${person.person.career.date}</td>

										</tr>
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
					<input type="submit" title="update person" class="submitButton" />
				</form:form>
			</div>
		</div>
	</div>
</div>



<script type="text/javascript">
	$(document).ready(
			function() {
				/*  $('#datePicker', '#datePicker2', '#datePicker3')
				      .datepicker({
				          format: 'dd-mm-yyyy',
				          autoclose: true
				      })
				      .on('changeDate', function(e) {
				          // Revalidate the date field
				          $('#eventForm', '#eventForm2', '#eventForm3').formValidation('revalidateField', 'date');
				      });
				 */
				$("input[id*='datePicker']").each(
						function(key, element) {
							$(element).datepicker({
								format : 'dd-mm-yyyy',
								autoclose : true

							}).on(
									'changeDate',
									function(e) {
										// Revalidate the date field
										$('#eventForm', '#eventForm2',
												'#eventForm3').formValidation(
												'revalidateField', 'date');
									});
						});

				$('#eventForm', '#eventForm2', '#eventForm3').formValidation({
					framework : 'bootstrap',
					icon : {
						valid : 'glyphicon glyphicon-ok',
						invalid : 'glyphicon glyphicon-remove',
						validating : 'glyphicon glyphicon-refresh'
					},
					fields : {
						name : {
							validators : {
								notEmpty : {
									message : 'The name is required'
								}
							}
						},
						date : {
							validators : {
								notEmpty : {
									message : 'The date is required'
								},
								date : {
									format : 'DD-MM-YYYY',
									autoclose : true,
									message : 'The date is not a valid'
								}
							}
						}
					}
				});
			});
</script>