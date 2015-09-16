<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

			<div class="col-lg-6 col-sm-6" style="width: 100% !important">
			    <div class="card hovercard">
			        <div class="card-background">
						<c:choose>
							<c:when test="${person.person.matricule != null}">
								<img src="data:image/jpeg;base64,${Img}" alt="avatar" width="150px" class="card-bkimg">
							</c:when>
							<c:when test="${person.person.matricule != null && picture.file == null}">
								<img src="<c:url value='/img/person-avatar1.png'/>" alt="default-avatar" width="150px" class="card-bkimg">
							</c:when>
							<c:otherwise>
								<img src="<c:url value='/img/person-avatar1.png'/>" alt="default-avatar" width="150px" class="card-bkimg">
							</c:otherwise>
						</c:choose>
			        </div>
			        <div class="useravatar">
						<c:choose>
							<c:when test="${person.person.matricule != null}">
								<img src="data:image/jpeg;base64,${Img}" alt="avatar" width="150px" class="card-bkimg">
							</c:when>
							<c:when test="${person.person.matricule != null && picture.file == null}">
								<img src="<c:url value='/img/person-avatar1.png'/>" alt="default-avatar" width="150px" class="card-bkimg">
							</c:when>
							<c:otherwise>
								<img src="<c:url value='/img/person-avatar1.png'/>" alt="default-avatar" width="150px" class="card-bkimg">
							</c:otherwise>
						</c:choose>
			        </div>
			        <div class="card-info"> <span class="card-title">${person.person.lastname} ${person.person.firstname}</span>
			        </div>
			    </div>
			    <div class="btn-pref btn-group btn-group-justified btn-group-lg" role="group" aria-label="...">
			        <div class="btn-group" role="group">
			            <button type="button" id="following" class="btn btn-primary" href="#tab1" data-toggle="tab"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>
			                <div class="hidden-xs"><spring:message code="personnal.data"/></div>
			            </button>
			        </div>
			        <div class="btn-group" role="group">
			            <button type="button" id="stars" class="btn btn-default" href="#tab2" data-toggle="tab"><span class="glyphicon glyphicon-star " aria-hidden="true"></span>
			                <div class="hidden-xs"><spring:message code="skill.data"/></div>
			            </button>
			        </div>
			        <div class="btn-group" role="group">
			            <button type="button" id="favorites" class="btn btn-default" href="#tab3" data-toggle="tab"><span class="glyphicon glyphicon-heart " aria-hidden="true"></span>
			                <div class="hidden-xs">Following</div>
			            </button>
			        </div>
			    </div>
			<fieldset class="ellipse01">
				<div class="well">
			      <div class="tab-content">
			        <div class="tab-pane fade in active" id="tab1">
			        <c:if test="${userSession.admin}">
			       		 <%@include file="../person/editionPerson.jsp" %>
					</c:if>
					<c:if test="${userSession.admin!=true}">
			        	<%@include file="../person/editionPersonCollab.jsp" %>
			        </c:if>
			        </div>
			        <div class="tab-pane fade in" id="tab2">
			         	<%@include file="../skill/listeSkills.jsp" %>
			        </div>
			        <div class="tab-pane fade in" id="tab3">
			          <h3>This is tab 3</h3>
			        </div>
			      </div>
			    </div>
			    
			</div>
		</fieldset>

<script type="text/javascript">
$(document).ready(function() {
	$(".btn-pref .btn").click(function () {
	    $(".btn-pref .btn").removeClass("btn-primary").addClass("btn-default");
	    // $(".tab").addClass("active"); // instead of this do the below 
	    $(this).removeClass("btn-default").addClass("btn-primary");   
	});
	});
</script>