<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- Include Bootstrap Datepicker -->
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" />
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" />

<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>

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
	<c:set var="readonly" value =""/>
	<c:if test="${!userSession.admin}">
		<c:set var="readonly" value ="readonly='true'"/>
	</c:if>
	<div class="container">
		<div class="row">
		<!-- modification col-md-4 en col-md-12 -->
			<div class="col-xs-12 col-sm-12 col-md-12 well well-sm">	
				<form:form modelAttribute="mission" action="updateMission.do" class="formulaire">
					<div class="row">
		                <div class="col-xs-6 col-md-6">
		                    <input class="form-control" path="person.person.missions.client" placeholder="<spring:message code="person.person.missions.client"/>" type="text" required autofocus value="${mission.person.missions.client}"  ${readonly} />
		                </div>
		                <div class="col-xs-6 col-md-6">
		                    <input class="form-control" path="person.person.missions.entitedMission" placeholder="<spring:message code="person.person.missions.entitedMission"/>" type="text" required value="${mission.person.missions.entitedMission}" ${readonly}/>
		                </div>
		                <div class="col-xs-6 col-md-6">
		                    <input class="form-control" path="person.person.missions.activite" placeholder="<spring:message code="person.person.missions.activite"/>" type="text" required value="${mission.person.missions.activite}" ${readonly}/>
		                </div>
		            </div>
		            
		            <form id="eventForm" method="post" class="form-horizontal">					
					    <div class="form-group">
					            <div class="input-group input-append date" >
					                <input type="text" class="form-control" id="datePicker" name="date" required value="${mission.person.missions.dateDemarrage}" ${readonly}/>
					                <span class="input-group-addon"> </span>
					            </div>
					    </div>
					</form>
			<div class="col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title"><spring:message code='misc.choose.action'/></h3>
						</div>

						<div class="table table-hover" id="dev-table">
							<form:textarea path="person.person.missions.commentaire" rows="5" cols="77"></form:textarea>
						</div> 	
					</div>
			</div>
			<form:hidden   path="person.id" />
 				<input type="submit" title="update mission" class="submitButton"/> 	         	
		    </form:form>
		</div>
	</div>
</div>			
</div>
				
	

<script type="text/javascript">
$(document).ready(function() {
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
        $('datePicker')
        	.datepicker({
            		format: 'dd-mm-yyyy',
            		autoclose: true
            		
        		})
        		.on('changeDate', function(e) {
            		// Revalidate the date field
            		$('#eventForm').formValidation('revalidateField', 'date');
        		});
        });

    $('#eventForm').formValidation({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                validators: {
                    notEmpty: {
                        message: 'The name is required'
                    }
                }
            },
            date: {
                validators: {
                    notEmpty: {
                        message: 'The date is required'
                    },
                    date: {
                        format: 'DD-MM-YYYY',
                        autoclose: true,
                        message: 'The date is not a valid'
                    }
                }
            }
        }
    });
</script>