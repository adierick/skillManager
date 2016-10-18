<div id="myModalHistoryMGT" class="modal fade" role="dialog">
		<div class="modal-dialog">
	
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">
						<spring:message code='history_MGT.choose.action' />
					</h4>
				</div>
				<div class="modal-body">
	
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="history_MGT.personality_type" /></label>
						<div class="col-sm-4">
							<input class="form-control" name="history_MGT.personality_type"
								placeholder="<spring:message code="history_MGT.personality_type"/>"
								type="text" required autofocus value="${history_MGT.history_MGT.personality_type}"
								${readonly} />
						</div>
	
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="history_MGT.smil" /></label>
						<div class="col-sm-4">
							<input class="form-control" name="history_MGT.smil"
								placeholder="<spring:message code="history_MGT.smil"/>"
								type="text" required autofocus value="${history_MGT.history_MGT.smil}"
								${readonly} />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="history_MGT.maturity_employee" /></label>
						<div class="col-sm-4">
							<input class="form-control" name="history_MGT.maturity_employee"
								placeholder="<spring:message code="history_MGT.maturity_employee"/>"
								type="text" required autofocus value="${history_MGT.history_MGT.maturity_employee}"
								${readonly} />
						</div>
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="history_MGT.management_style" /></label>
						<div class="col-sm-4">
							<input class="form-control" name="history_MGT.management_style"
								placeholder="<spring:message code="history_MGT.management_style"/>"
								type="text" required autofocus value="${history_MGT.history_MGT.management_style}"
								${readonly} />
						</div>
						
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="history_MGT.management_apply" /></label>
						<div class="col-sm-4">
							<input class="form-control" name="history_MGT.management_apply"
								placeholder="<spring:message code="history_MGT.management_apply"/>"
								type="text" autofocus value="${history_MGT.history_MGT.management_apply}"
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