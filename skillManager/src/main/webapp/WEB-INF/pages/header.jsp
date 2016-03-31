<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${userSession != null}">
		<div id="header" onclick="location.href='<%=request.getContextPath()%>/main/login/login.do'">
			<h1></h1>
			<h2>
				<span id="title">SKILL MANAGER</span>
			</h2>
			<div id="logged">
				
					<span class="user">
						<img id="logged" src="<c:url value='/img/user.gif' />" />${userSession.login}
						<a id="logout" href="<%=request.getContextPath()%>/main/logout" ></a> 
					</span>
				<br />
				<div id="logo" onclick="location.href='<%=request.getContextPath()%>/main/login/login.do'"></div>
			</div>
		</div>
				
		<div class="container">
			<div class="row">
				<nav class="navbar navbar-default" role="navigation">
			  
				    <!-- Brand and toggle get grouped for better mobile display -->
				    <div class="navbar-header">
				      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				        <span class="sr-only">Toggle navigation</span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				      </button>
				      <a class="navbar-brand" href="#"  onclick="location.href='<%=request.getContextPath()%>/main/login/login.do'"><spring:message code='main.back'/></a>
				    </div>
				
				    <!-- Collect the nav links, forms, and other content for toggling -->
				    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				      <ul class="nav navbar-nav">
				        <li><a href="#" onclick="editionPerson('<%=request.getContextPath()%>', '${userSession.matricule}')"><spring:message code='index.personnal.data'/></a></li>
				        <li><a href="#" onclick="generateCv('<%=request.getContextPath()%>')" ><spring:message code='index.personnal.cv'/></a></li>
				        <li><a href="#" onclick="showTrombinoscope('<%=request.getContextPath()%>')"  ><spring:message code='index.trombinoscope'/></a></li>
				      </ul>
				      <c:if test="${userSession.admin}">
					      <ul class="nav navbar-nav navbar-right">
					        <li class="dropdown">
					          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Admin <b class="caret"></b></a>
					          <ul class="dropdown-menu">
					            <li><a href="#" onclick="listePersons('<%=request.getContextPath()%>', '${userSession.id}')" ><spring:message code='index.admin.person'/></a></li>
					            <li><a href="#" onclick="listeBusinessUnits('<%=request.getContextPath()%>', '${userSession.id}')" ><spring:message code='index.admin.bu'/></a></li>
					            <li><a href="#" onclick="listeItems('<%=request.getContextPath()%>', '${userSession.id}')" ><spring:message code='index.admin.item'/></a></li>
					            <li><a href="#" onclick="listeCategories('<%=request.getContextPath()%>', '${userSession.id}')"  ><spring:message code='index.admin.category'/></a></li> 
					            
					            <%-- Ajout menu Gestions Fiche collaborateurs --%>
					            <c:if test="${userSession.manager}">
					            <li><a href="#" onclick="listeEmploies('<%=request.getContextPath()%>', '${userSession.id}')"  ><spring:message code='index.admin.emploies'/></a></li>
					            </c:if>
					            <li class="divider"></li>
					            <li><a href="#" onclick="searchSkillManager('<%=request.getContextPath()%>')" ><spring:message code='index.admin.search'/></a></li>
					          </ul>
					        </li>
					      </ul>
				      </c:if>
				    </div><!-- /.navbar-collapse -->
			  
				</nav>
		
			</div>
		</div>
</c:if>

<script type="text/javascript">
$(function(){
    $(".dropdown").hover(            
            function() {
                $('.dropdown-menu', this).stop( true, true ).fadeIn("fast");
                $(this).toggleClass('open');
                $('b', this).toggleClass("caret caret-up");                
            },
            function() {
                $('.dropdown-menu', this).stop( true, true ).fadeOut("fast");
                $(this).toggleClass('open');
                $('b', this).toggleClass("caret caret-up");                
            });
    });
</script>