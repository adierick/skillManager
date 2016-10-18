
	<!-- Modal -->
	<div id="myModalFormation" class="modal fade" role="dialog">
		<div class="modal-dialog">
	
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">
						<spring:message code='formation.choose.action' />
					</h4>
				</div>
				<div class="modal-body">
	
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="formation.entitled" /></label>
						<div class="col-sm-4">
							<input class="form-control" name="formation.entitled"
								placeholder="<spring:message code="formation.entitled"/>"
								type="text" required autofocus
								value="${formation.formation.entitled}" ${readonly} />
						</div>
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="formation.date" /></label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="datePickerformation"
								name="formation.date" required
								placeholder="<spring:message code="formation.date"/>"
								value="<fmt:formatDate  value="${formation.formation.date}"  pattern="dd-MM-yyyy" />"
								${readonly} 
								/>
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