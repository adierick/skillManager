<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<fieldset class="ellipse01">
	<legend>
		<spring:message code="personnal.cv" />
	</legend>

	<div>
		<form:form modelAttribute="templateData"
			class="formulaire">
			<div id="accordion">
				<c:choose>
					<c:when test="${not empty templateData.expPros}">
						
						<c:forEach var="listValue" items="${templateData.expPros}"
										varStatus="status">
											
							<h3>Experience ${status.index+1}</h3>
							<div>
								<label class="large"><spring:message code="template.client.nom" />
								</label>
								<form:input class="ui-corner-all" id="client0" path="expPros[${status.index}].client"/>
								<label class="large"><spring:message code="template.client.lieu" />
								</label>
								<form:input class="ui-corner-all" id="lieu0" path="expPros[${status.index}].lieu"/>
								<label class="large"><spring:message code="template.client.activite" />
								</label>
								<form:input class="ui-corner-all" id="activite0" path="expPros[${status.index}].activite"/>
								<label class="large"><spring:message code="template.collab.fonction" />
								</label>
								<form:input class="ui-corner-all" id="fonction0" path="expPros[${status.index}].fonction"/>
								<label class="large"><spring:message code="template.client.debut" />
								</label>
								<form:input class="ui-corner-all datepicker" id="debut0" path="expPros[${status.index}].debut"/>
								<label class="large"><spring:message code="template.client.fin" />
								</label>
								<form:input class="ui-corner-all datepicker" id="fin0" path="expPros[${status.index}].fin"/>
								
								<br><br><label style="padding: 8px 0px 5px 30px;" class="large"><spring:message code="template.mission.resume" />
								</label><br>
								<form:textarea class="ui-corner-all" path="expPros[${status.index}].resume" id="resume0" style="margin-left: 17px;width: 350px;height: 75px;"></form:textarea>
								<br><label style="text-align: center;padding: 8px;" class="large"><spring:message code="template.mission.details" />
								</label>
								<c:choose>
									<c:when test="${not empty listValue.details}">
									<div id="details${status.index}" data-exp="${status.index}" data-det="${fn:length(listValue.details)}">
										<c:forEach var="detValue" items="${listValue.details}"
										varStatus="detStatus">
											<div>
												<span style="float:left;clear:left;" class="ui-icon ui-icon-triangle-1-e"></span>
												<span><form:input style="float:left;" class="ui-corner-all" path="expPros[${status.index}].details[${detStatus.index}]" size="60"/></span>
												<c:choose>
													<c:when test="${detStatus.index != 0}"><span style="float:left;cursor:pointer;" class="ui-icon ui-icon-trash removeDet"></span></c:when>
												</c:choose>
												
											</div>
											<br>
										</c:forEach>
										</div>
									</c:when>
									<c:otherwise>
										<div id="details0" data-exp="0" data-det="1">
											<span style="float:left;" class="ui-icon ui-icon-triangle-1-e"></span>
											<span><form:input class="ui-corner-all" path="expPros[${status.index}].details[0]" size="60"/></span><br>
										</div>
									</c:otherwise>
								</c:choose>
								<form:button style="cursor:pointer;float:right;" type="button" class="ui-state-hover" id="addDetailExp">ajouter un detail</form:button>
								<br><br><label class="large"><spring:message code="template.mission.techno" />
								</label>
								<form:input class="ui-corner-all" size="60" id="techno0" path="expPros[${status.index}].techno" placeholder="java, sql, jquery"/>
							</div>
						</c:forEach>
							
					</c:when>
					<c:otherwise>
						<h3>Experience 1</h3>
						<div>
							<label class="large"><spring:message code="template.client.nom" />
							</label>
							<form:input class="ui-corner-all" id="client0" path="expPros[0].client"/>
							<label class="large"><spring:message code="template.client.lieu" />
							</label>
							<form:input class="ui-corner-all" id="lieu0" path="expPros[0].lieu"/>
							<label class="large"><spring:message code="template.client.activite" />
							</label>
							<form:input class="ui-corner-all" id="activite0" path="expPros[0].activite"/>
							<label class="large"><spring:message code="template.collab.fonction" />
							</label>
							<form:input class="ui-corner-all" id="fonction0" path="expPros[0].fonction"/>
							<label class="large"><spring:message code="template.client.debut" />
							</label>
							<form:input class="ui-corner-all datepicker" id="debut0" path="expPros[0].debut"/>
							<label class="large"><spring:message code="template.client.fin" />
							</label>
							<form:input class="ui-corner-all datepicker" id="fin0" path="expPros[0].fin"/>
							
							<br><br><label style="padding: 8px 0px 5px 30px;" class="large"><spring:message code="template.mission.resume" />
							</label><br>
							<form:textarea class="ui-corner-all" path="expPros[0].resume" id="resume0" style="margin-left: 17px;width: 350px;height: 75px;"></form:textarea>
							<br><label style="text-align: center;padding: 8px;" class="large"><spring:message code="template.mission.details" />
							</label>
							<div id="details0" data-exp="0" data-det="1">
								<span style="float:left;" class="ui-icon ui-icon-triangle-1-e"></span>
								<span><form:input class="ui-corner-all" path="expPros[0].details[0]" size="60"/></span><br>
							</div>
							<form:button style="cursor:pointer;float:right;" type="button" class="ui-state-hover" id="addDetailExp">ajouter un detail</form:button>
							<br><br><label class="large"><spring:message code="template.mission.techno" />
							</label>
							<form:input class="ui-corner-all" size="60" id="techno0" path="expPros[0].techno" placeholder="java, sql, jquery"/>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<div style="text-align:center;">
				<c:choose>
					<c:when test="${not empty templateData.expPros}">
						<form:button style="cursor:pointer;" type="button" data-cpt="${fn:length(templateData.expSignLbl)}" class="ui-state-hover" id="addExpPro">ajouter une exp pro</form:button>
					</c:when>
					<c:otherwise>
						<form:button style="cursor:pointer;" type="button" data-cpt="1" class="ui-state-hover" id="addExpPro">ajouter une exp pro</form:button>
					</c:otherwise>
				</c:choose>
				<br>
				<form:button type="button" class="step" value="step1.do" style="margin:10px;">
					<spring:message code="person.previousstep" />
				</form:button>
				<form:button type="button" class="step" value="generatePdf.do" style="margin:10px;">
					<spring:message code="personnal.cv.generate" />
				</form:button>
			</div>
		</form:form>
	</div>
</fieldset>
<script type="text/javascript" >
$(function() {
    $( "#accordion" ).accordion({
    	fillSpace: true,
    	heightStyle: "content",
    	clearStyle: true
    	});
    $( ".datepicker" ).datepicker({ dateFormat: "dd/mm/yy" });
  });
 
 
$('body').on('focus',".datepicker", function(){
    $(this).datepicker();
});

$(function() {
    $( "#templateData" ).on("click",".step",function(){
    	$("#templateData").attr("action",$(this).attr('value'));
    	$("#templateData").submit();
    });
  });

$(document)
.ready(
		function() {
			var expProFieldCount = 1;
			
			$(".formulaire").on("click","#addExpPro",function(){
				addField('accordion',expProFieldCount);
				$("#accordion").accordion( "refresh" );
				$("#accordion").accordion( "option", "active",expProFieldCount);
				expProFieldCount++;
			});
			
			$("#accordion").on("click","#addDetailExp",function(){
				var numId = $(this).prev('div').attr('data-exp');
				console.log(numId);
				var divId = $(this).prev('div').attr('id');
				console.log(divId);
				var cptDet = $(this).prev('div').attr('data-det');
				console.log(cptDet);
				addDetail(divId,numId,cptDet);
				cptDet++;
				$(this).prev('div').attr('data-det',cptDet);
				$("#accordion").accordion( "refresh" );
			});
			
			$("#accordion").on("click",".removeDet",function(e) {
			    $(this).parent().next("br").remove();
			    $(this).parent().remove();
			    $("#accordion").accordion( "refresh" );
			});
			
	});


function addField(divId,cpt){
	Fields = $("#"+divId);
	$(Fields)
		.append('<h3>Experience '+(cpt+1)+'</h3>'+
				'<div>'+
				'<label class="large"><spring:message code="template.client.nom" />'+
				'</label> '+
				'<input class="ui-corner-all" id="client'+cpt+'" name="expPros['+cpt+'].client"/> '+
				'<label class="large"><spring:message code="template.client.lieu" />'+
				'</label> '+
				'<input class="ui-corner-all" id="lieu'+cpt+'" name="expPros['+cpt+'].lieu" /> '+
				'<label class="large"><spring:message code="template.client.activite" />'+
				'</label> '+
				'<input class="ui-corner-all" id="activite'+cpt+'" name="expPros['+cpt+'].activite" /> '+
				'<label class="large"><spring:message code="template.collab.fonction" />'+
				'</label> '+
				'<input class="ui-corner-all" id="fonction'+cpt+'"  name="expPros['+cpt+'].fonction" /> '+
				'<label class="large"><spring:message code="template.client.debut" />'+
				'</label> '+
				'<input class="ui-corner-all datepicker" id="debut'+cpt+'" name="expPros['+cpt+'].debut" /> '+
				'<label class="large"><spring:message code="template.client.fin" />'+
				'</label> '+
				'<input class="ui-corner-all datepicker" id="fin'+cpt+'" name="expPros['+cpt+'].fin" /> '+
				
				'<br><br><label style="padding: 8px 0px 5px 30px;" class="large"><spring:message code="template.mission.resume" />'+
				'</label><br>'+
				'<textarea class="ui-corner-all" name="expPros['+cpt+'].resume" id="resume'+cpt+'" style="margin-left: 17px;width: 350px;height: 75px;"></textarea>'+
				'<br><label style="text-align: center;padding: 8px;" class="large"><spring:message code="template.mission.details" />'+
				'</label>'+
				'<div id="details'+cpt+'" data-exp="'+cpt+'" data-det="1">'+
					'<span style="float:left;" class="ui-icon ui-icon-triangle-1-e"></span>'+
					'<span><input class="ui-corner-all" name="expPros['+cpt+'].details[0]" size="60"/></span><br>'+
				'</div>'+
				'<button style="cursor:pointer;float:right;" type="button" class="ui-state-hover" id="addDetailExp">ajouter un detail</button>'+
				'<br><br><label class="large"><spring:message code="template.mission.techno" /></label>'+
				'<input class="ui-corner-all" size="60" id="techno'+cpt+'" name="expPros['+cpt+'].techno" placeholder="java, sql, jquery"/>'+
			'</div>');
	return false;
}

function addDetail(divId,numId,cptDet){
	Fields = $("#"+divId);
	
	$(Fields)
		.append('<div><span style="float:left;clear:left;" class="ui-icon ui-icon-triangle-1-e"></span><span style="float:left;"><input class="ui-corner-all" name="expPros['+numId+'].details['+cptDet+']" size="60"/></span><span style="float:left;cursor:pointer;" class="ui-icon ui-icon-trash removeDet"></span></div><br>');
	return false;
}

$('.removeExp').click(function(e) {
    $(this).parent('div').prev('h3').andSelf().remove();
});


  
</script>

