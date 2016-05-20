
<form:form modelAttribute="remuneration" action="updateRemuneration.do" class="formulaire">
	<!-- Modal -->
	<div id="myModalRemuneration" class="modal fade" role="dialog">
		<div class="modal-dialog">
	
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">
						<spring:message code='remuneration.choose.action' />
					</h4>
				</div>
				<div class="modal-body">
	
										<th><spring:message code='remuneration.brut' /></th>
										<th><spring:message code='remuneration.fixe' /></th>
										<th><spring:message code='remuneration.variable' /></th>
										<th><spring:message code='remuneration.commentaire' />
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="remuneration.brut" /></label>
						<div class="col-sm-4">
							<input class="form-control" name="remuneration.brut"
								placeholder="<spring:message code="remuneration.brut"/>"
								type="text" required autofocus value="${remuneration.remuneration.brut}"
								${readonly} />
						</div>
	
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="remuneration.fixe" /></label>
						<div class="col-sm-4">
							<input class="form-control" name="remuneration.fixe"
								placeholder="<spring:message code="remuneration.fixe"/>"
								type="text" required autofocus value="${remuneration.remuneration.fixe}"
								${readonly} />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="remuneration.variable" /></label>
						<div class="col-sm-4">
							<input class="form-control" name="remuneration.variable"
								placeholder="<spring:message code="remuneration.variable"/>"
								type="text" required autofocus value="${remuneration.remuneration.variable}"
								${readonly} />
						</div>
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="remuneration.commentaire" /></label>
						<div class="col-sm-4">
							<input class="form-control" name="remuneration.commentaire"
								placeholder="<spring:message code="remuneration.commentaire"/>"
								type="text" required autofocus value="${remuneration.remuneration.commentaire}"
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
	<form:hidden path="remuneration.idREMUNERATION" />
	<form:hidden path="personId" />
</form:form>