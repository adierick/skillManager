<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div>
	<div class="container">
	    <div class="row">
	        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm">
				<form:form id="searchForm" modelAttribute="searchCriteria" action="search.do" >
				<div class="container">
					<div class="row" style="margin-top: 5%">
				        <div class="col-md-5">
				            <div class="form-group">
				                <div class="icon-addon addon-lg">
									<form:select path="type" cssClass="form-control">
										<form:options items="${searchTypes}"  itemLabel="label" itemValue="id"/>
									</form:select>
				                </div>
				            </div>
			
				    		<div class="form-group">
				                <div class="icon-addon addon-lg">
				                    <input type="text" placeholder="<spring:message code="search.criteria"/>" class="form-control" id="criteria" name="criteria">
				                </div>
				            </div>
							<form:hidden path="export"/>
							<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
							<button type="submit"
								onclick="document.getElementById('export').value=1; document.getElementById('searchForm').submit();"  
								class="btn btn-primary"><span class="glyphicon glyphicon-floppy-save" aria-hidden="true"></span></button>
							</div>		
						</div>
					</div>
				</form:form>
	        
	        </div>
		</div>
	</div>
</div>