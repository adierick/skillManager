
<form:form modelAttribute="mission" action="updateMission.do" class="formulaire">
	<!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
	
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">
						<spring:message code='mission.choose.action' />
					</h4>
				</div>
				<div class="modal-body">
	
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="mission.client" /></label>
						<div class="col-sm-4">
							<input class="form-control" name="mission.client"
								placeholder="<spring:message code="mission.client"/>"
								type="text" required autofocus value="${mission.mission.client}"
								${readonly} />
						</div>
	
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="mission.entitedMission" /></label>
						<div class="col-sm-4">
							<input class="form-control" name="mission.entitedMission"
								placeholder="<spring:message code="mission.entitedMission"/>"
								type="text" required autofocus value="${mission.mission.entitedMission}"
								${readonly} />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="mission.activite" /></label>
						<div class="col-sm-4">
							<input class="form-control" name="mission.activite"
								placeholder="<spring:message code="mission.activite"/>"
								type="text" required autofocus value="${mission.mission.activite}"
								${readonly} />
						</div>
	
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="mission.dateDemarrage" /></label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="datePicker4"
								name="mission.dateDemarrage" required
								placeholder="<spring:message code="mission.dateDemarrage"/>"
								value="<fmt:formatDate  value="${mission.mission.dateDemarrage}"  pattern="dd-MM-yyyy" />"
								${readonly} 
								/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="mission.commentaire" /></label>
						<div class="col-sm-4">
							<input class="form-control" name="mission.commentaire"
								placeholder="<spring:message code="mission.commentaire"/>"
								type="text" autofocus value="${mission.mission.commentaire}"
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
	<form:hidden path="mission.idmission" />
	<form:hidden path="personId" />
</form:form>