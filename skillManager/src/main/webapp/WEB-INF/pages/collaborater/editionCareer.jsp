
<form:form modelAttribute="career" action="updateCareer.do" class="formulaire">
	<!-- Modal -->
	<div id="myModalCareer" class="modal fade" role="dialog">
		<div class="modal-dialog">
	
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">
						<spring:message code='career.choose.action' />
					</h4>
				</div>
				<div class="modal-body">
	
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="career.poste" /></label>
						<div class="col-sm-4">
							<form:select path="career.poste" cssClass="form-control">
								<form:option value="" label="---" />
								<form:options items="${listPosition}" itemValue="code" />
							</form:select>
						</div>
	
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="career.coefficient" /></label>
						<div class="col-sm-4">
							<input class="form-control" name="career.coefficient"
								placeholder="<spring:message code="career.coefficient"/>"
								type="text" required autofocus value="${career.career.coefficient}"
								${readonly} />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput"><spring:message code="career.date" /></label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="datePickerCareer"
								name="career.date" required
								placeholder="<spring:message code="career.date"/>"
								value="<fmt:formatDate  value="${career.career.date}"  pattern="dd-MM-yyyy" />"
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
	<form:hidden path="career.idcareer" />
	<form:hidden path="personId" />
</form:form>