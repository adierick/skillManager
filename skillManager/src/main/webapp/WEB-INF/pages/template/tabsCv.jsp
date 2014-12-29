<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link href="//cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css" />

<script src="//cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<fieldset class="ellipse01">
	<legend>
		<spring:message code="personnal.cv" />
	</legend>

	<div>
		<form:form modelAttribute="templateData" class="formulaire">
			<div id="tabs">
				<ul>
					<li><a href="#tabs-1">Experiences significatives</a></li>
					<li><a href="#tabs-2">Compétences techniques</a></li>
					<li><a href="#tabs-3">Compétences métier</a></li>
					<li><a href="#tabs-4">Formations</a></li>
				</ul>
				<div id="tabs-1">
					<table id="expFields" class="display">
						<caption>Experiences significatives</caption>
						<thead>
							<tr>
								<th>Client</th>
								<th>Mission</th>
								<th></th>
							</tr>
						</thead>
						<tbody>

							<c:choose>
								<c:when test="${not empty templateData.expSignLbl}">
									<c:forEach var="listValue" items="${templateData.expSignLbl}"
										varStatus="status">
										<tr>
											<td><form:input path="expSignLbl[${status.index}]"
													class="ui-corner-all" /></td>
											<td><form:textarea path="expSign[${status.index}]"
													class="ui-corner-all" style="width: 350px;height: 55px;" /></td>
											<c:choose>
												<c:when test="${status.index == 0}">
													<td></td>
												</c:when>
												<c:otherwise>
													<td><span
														style="float: left; cursor: pointer; zoom: 2;"
														class="ui-icon ui-icon-trash remove"
														alt="dropItem/exp/${status.index}"></span></td>
												</c:otherwise>
											</c:choose>
										</tr>
									</c:forEach>
									<button style="cursor: pointer; float: right;"
										data-count="${fn:length(templateData.expSignLbl)}" data-list="expSign" data-field="expFields"
										type="button" class="ui-state-hover addField" >ajouter
										une exp</button>
								</c:when>
								<c:otherwise>
									<tr>
										<td><form:input path="expSignLbl[0]"
												class="ui-corner-all" /></td>
										<td><form:textarea path="expSign[0]"
												class="ui-corner-all" style="width: 350px;height: 55px;" /></td>
										<td></td>
									</tr>
									<button style="cursor: pointer; float: right;" data-count="1"
										data-list="expSign" data-field="expFields" type="button" class="ui-state-hover addField" >ajouter
										une exp</button>
								</c:otherwise>
							</c:choose>


						</tbody>
					</table>



				</div>

				<div id="tabs-2">
					<table id="cptFields" class="display">
						<caption>Compétences techniques</caption>
						<thead>
							<tr>
								<th>Type</th>
								<th>Technologies</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${not empty templateData.cptTechLbl}">
									<c:forEach var="listValue" items="${templateData.cptTechLbl}"
										varStatus="status">
										<tr>
											<td><form:input path="cptTechLbl[${status.index}]"
													class="ui-corner-all" /></td>
											<td><form:textarea path="cptTech[${status.index}]"
													class="ui-corner-all" style="width: 350px;height: 55px;" /></td>
											<c:choose>
												<c:when test="${status.index == 0}">
													<td></td>
												</c:when>
												<c:otherwise>
													<td><span
														style="float: left; cursor: pointer; zoom: 2;"
														class="ui-icon ui-icon-trash remove"
														alt="dropItem/tec/${status.index}"></span></td>
												</c:otherwise>
											</c:choose>
										</tr>
									</c:forEach>
									<button style="cursor: pointer; float: right;"
										data-count="${fn:length(templateData.cptTechLbl)}" data-list="cptTech" data-field="cptFields"
										type="button" class="ui-state-hover addField" >ajouter un type de cptc tech</button>
								</c:when>
								<c:otherwise>
									<tr>
										<td><form:input path="cptTechLbl[0]" class="ui-corner-all" /></td>
										<td><form:textarea path="cptTech[0]" class="ui-corner-all"
												style="width: 350px;height: 55px;" /></td>
										<td></td>
									</tr>
									<button style="cursor: pointer; float: right;" data-count="1" data-list="cptTech" data-field="cptFields"
										type="button" class="ui-state-hover addField">ajouter un type de cptc tech</button>
								</c:otherwise>
							</c:choose>
							
						</tbody>
					</table>
				</div>

				<div id="tabs-3">
					<table id="mtrFields" class="display">
						<caption>Compétences métier</caption>
						<thead>
							<tr>
								<th>Métier</th>
								<th>Spécificités</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${not empty templateData.cptMtrLbl}">
									<c:forEach var="listValue" items="${templateData.cptMtrLbl}"
										varStatus="status">
										<tr>
											<td><form:input path="cptMtrLbl[${status.index}]"
													class="ui-corner-all" /></td>
											<td><form:textarea path="cptMtr[${status.index}]"
													class="ui-corner-all" style="width: 350px;height: 55px;" /></td>
											<c:choose>
												<c:when test="${status.index == 0}">
													<td></td>
												</c:when>
												<c:otherwise>
													<td><span
														style="float: left; cursor: pointer; zoom: 2;"
														class="ui-icon ui-icon-trash remove"
														alt="dropItem/mtr/${status.index}"></span></td>
												</c:otherwise>
											</c:choose>
										</tr>
									</c:forEach>
									<button style="cursor: pointer; float: right;"
										data-count="${fn:length(templateData.cptMtrLbl)}" data-list="cptMtr" data-field="mtrFields"
										type="button" class="ui-state-hover addField" >ajouter un type de cptc métier</button>
								</c:when>
								<c:otherwise>
									<tr>
										<td><form:input path="cptMtrLbl[0]" class="ui-corner-all" /></td>
										<td><form:textarea path="cptMtr[0]" class="ui-corner-all"
												style="width: 350px;height: 55px;" /></td>
										<td></td>
									</tr>
									<button style="cursor: pointer; float: right;" data-count="1" data-list="cptMtr" data-field="mtrFields"
										type="button" class="ui-state-hover addField" >ajouter un type de cptc métier</button>
								</c:otherwise>
							</c:choose>
						
						</tbody>
					</table>
					
				</div>

				<div id="tabs-4">
					<table id="fmtFields" class="display">
						<caption>Formations</caption>
						<thead>
							<tr>
								<th>Etablissement</th>
								<th>Années - intitulé formation</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${not empty templateData.fmtLbl}">
									<c:forEach var="listValue" items="${templateData.fmtLbl}"
										varStatus="status">
										<tr>
											<td><form:input path="fmtLbl[${status.index}]"
													class="ui-corner-all" /></td>
											<td><form:textarea path="fmt[${status.index}]"
													class="ui-corner-all" style="width: 350px;height: 55px;" /></td>
											<c:choose>
												<c:when test="${status.index == 0}">
													<td></td>
												</c:when>
												<c:otherwise>
													<td><span
														style="float: left; cursor: pointer; zoom: 2;"
														class="ui-icon ui-icon-trash remove"
														alt="dropItem/fmt/${status.index}"></span></td>
												</c:otherwise>
											</c:choose>
										</tr>
									</c:forEach>
									<button style="cursor: pointer; float: right;"
										data-count="${fn:length(templateData.fmtLbl)}" data-list="fmt" data-field="fmtFields"
										type="button" class="ui-state-hover addField" >ajouter un type de cptc métier</button>
								</c:when>
								<c:otherwise>
									<tr>
										<td><form:input path="fmtLbl[0]" class="ui-corner-all" /></td>
										<td><form:textarea path="fmt[0]" class="ui-corner-all"
												style="width: 350px;height: 55px;" /></td>
										<td></td>
									</tr>
									<button style="cursor: pointer; float: right;" data-count="1"
										type="button" class="ui-state-hover addField">ajouter une formation</button>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>
			</div>
			<form:button type="button" class="step" value="populate.do"
				style="margin:10px;">
				<spring:message code="person.previousstep" />
			</form:button>
			<form:button type="button" class="nextTab" value="step2.do"
				style="margin:10px;">
				<spring:message code="person.nextstep" />
			</form:button>
		</form:form>
	</div>
</fieldset>

<script>
	$(function() {
		$("#templateData").on("click", ".step", function() {
			$("#templateData").attr("action", $(this).attr('value'));
			$("#templateData").submit();
		});
		
		$('#templateData').on("click", ".nextTab", function(){
			var maxIndex = $(".ui-tabs-panel").size() -1;
			var current = $("#tabs").tabs("option", "active");
			if(current === maxIndex){
				$(this).removeClass('nextTab').addClass('step').click();
			}else{
				current++;
				$( "#tabs").tabs( "option", "active", current );
				$('.step').removeClass('step').addClass('prevTab');
			}
			
		});
		
		$('#templateData').on("click", ".prevTab", function(){
			var current = $("#tabs").tabs("option", "active");
			if(current === 0){
				$(this).removeClass('prevTab').addClass('step').click();
			}else{
				current--;
				$( "#tabs").tabs( "option", "active", current );
				$('.step').removeClass('step').addClass('nextTab');
			}
			
		});
		
	});

	$(document).ready(function() {
		$('table.display').dataTable({
			"paging" : false,
			"ordering" : false,
			"info" : false,
			"searching" : false
		});
		$('#tabs').tabs();

		$(".addField").click(function() {
			var fieldCount = $(this).attr('data-count');
			var fields = $(this).attr('data-field');
			var list = $(this).attr('data-list');
			addField(fields, list, fieldCount);
			fieldCount++;
			$(this).attr('data-count',fieldCount);
		});

		$("#tabs").on("click", ".remove", function(e) {
			if($(this).attr('alt') != undefined){
				$.ajax({
	                url: $(this).attr('alt')
	            });	
			}	
			
			var table = $(this).parents('table').DataTable();
			table.row($(this).parents('tr')).remove().draw();
		});
	});

	function addField(divId, nameList, cpt) {
		Fields = $("#" + divId).DataTable();
		Fields.row
				.add(
						[
								'<input id="'+nameList+'Lbl'+cpt+'" name="'+nameList+'Lbl['+cpt+']" type="text" value="" class="ui-corner-all"/>',
								'<textarea id="'+nameList+cpt+'" name="'+nameList+'['+cpt+']" style="width: 350px;height: 55px;" class="ui-corner-all"></textarea>',
								'<span style="float:left;cursor:pointer;zoom:2;" class="ui-icon ui-icon-trash remove">' ])
				.draw();

		return false;
	}
</script>