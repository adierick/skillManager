<form:form modelAttribute="behaviour" action="updateBehaviour.do" class="formulaire">
	<!-- Modal -->
	<div id="myModalBehaviour" class="modal fade" role="dialog">
		<div class="modal-dialog">
	
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">
						<spring:message code='behaviour.choose.action' />
					</h4>
				</div>
				<div class="modal-body">
	
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="behaviour.strong_points" /></label>
						<div class="col-sm-4">
							<input class="form-control" name="behaviour.strong_points"
								placeholder="<spring:message code="behaviour.strong_points"/>"
								type="text" required autofocus value="${behaviour.behaviour.strong_points}"
								${readonly} />
						</div>
	
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="behaviour.areas_improvement" /></label>
						<div class="col-sm-4">
							<input class="form-control" name="behaviour.areas_improvement"
								placeholder="<spring:message code="behaviour.areas_improvement"/>"
								type="text" required autofocus value="${behaviour.behaviour.areas_improvement}"
								${readonly} />
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-success" >Save</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<form:hidden path="behaviour.idbehavioral_competence" />
	<form:hidden path="personId" />
</form:form>