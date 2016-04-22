<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div id="main-page">
    <div id="welcome">
		<div></div>
		<br/>
		<span class="welcome blockquote" style="border: none; background-color: transparent;">
			<spring:message code="index.welcome"/> ${userSession.firstname} ${userSession.lastname} 
		</span>
		
			<div>
				<div class="" style="font-size: 12px;margin-top: 20px;">
					<div class="container">
					    <div class="row">
					        <div class="col-md-6">
					            <div class="panel panel-primary">
					                <div class="panel-heading">
					                    <h3 class="panel-title">
					                        <span class="glyphicon glyphicon-bookmark"></span> Quick Shortcuts</h3>
					                </div>
					                <div class="panel-body">
					                    <div class="row">
					                        <div class="col-xs-6 col-md-6">
						                          <a href="#" class="btn btn-success btn-lg" role="button" onclick="editionPerson('<%=request.getContextPath()%>', '${userSession.matricule}')" >
							                          	<span class="glyphicon glyphicon-user"></span> 
							                          	<br/><spring:message code='index.personnal.data.light'/>
						                          </a>

						                          <a href="#" class="btn btn-info btn-lg" role="button" onclick="generateCv('<%=request.getContextPath()%>')" >
							                          	<span class="glyphicon glyphicon-file"></span> 
							                          	<br/><spring:message code='index.personnal.cv.light'/>
						                          </a>
					                        </div>
					                        <div class="col-xs-6 col-md-6">
						                          <a href="#" class="btn btn-primary btn-lg" role="button" onclick="showTrombinoscope('<%=request.getContextPath()%>')" >
						                          		<span class="glyphicon glyphicon-picture"></span> 
						                          		<br/><spring:message code='index.trombinoscope.light'/>
						                          </a>
									            <c:if test="${userSession.manager}">
						                          <a href="#" class="btn btn-warning btn-lg" role="button" 
						                          		 onclick="listeEmploies('<%=request.getContextPath()%>', '${userSession.id}')"  >
						                          		<span class="glyphicon glyphicon-list-alt"></span> 
						                          		<br/><spring:message code='index.admin.emploies.light'/>
						                          </a>
									            </c:if>
					                        </div>
					                    </div>
					                    <a href="<%=request.getContextPath()%>/main/logout"" class="btn btn-danger btn-lg btn-block" role="button"><span class="glyphicon glyphicon-off"></span> </a>
					                </div>
					            </div>
					        </div>
					    </div>
					</div>
				
				
				
<%-- 						<img src="<c:url value='/img/main/main_perso_data.png' />"   --%>
<%-- 						title="<spring:message code='index.personnal.data'/>" --%>
<!-- 						onmouseover="setImageOver(this);" onmouseout="setImageOut(this);" -->
<%-- 						onclick="editionPerson('<%=request.getContextPath()%>', '${userSession.matricule}')"  --%>
<!-- 						style="cursor: pointer; float:left; padding: 10px;" /> -->
						
<%-- 						<img src="<c:url value='/img/main/main_perso_cv.png' />"   --%>
<%-- 						title="<spring:message code='index.personnal.cv'/>" --%>
<!-- 						onmouseover="setImageOver(this);" onmouseout="setImageOut(this);" -->
<%-- 						onclick="generateCv('<%=request.getContextPath()%>')"  --%>
<!-- 						style="cursor: pointer; float:left; padding-top: 10px;" /> -->
						
<%-- 						<img src="<c:url value='/img/main/main_trombi.png' />"   --%>
<%-- 						title="<spring:message code='index.trombinoscope'/>" --%>
<!-- 						onmouseover="setImageOver(this);" onmouseout="setImageOut(this);" -->
<%-- 						onclick="showTrombinoscope('<%=request.getContextPath()%>')"  --%>
<!-- 						style="cursor: pointer; float:left; padding: 10px;" /> -->
				</div>
			</div>
	</div>
</div>
