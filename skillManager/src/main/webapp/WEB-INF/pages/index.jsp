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
						<img src="<c:url value='/img/main/main_perso_data.png' />"  
						title="<spring:message code='index.personnal.data'/>"
						onmouseover="setImageOver(this);" onmouseout="setImageOut(this);"
						onclick="editionPerson('<%=request.getContextPath()%>', '${userSession.matricule}')" 
						style="cursor: pointer; float:left; padding: 10px;" />
						
						<img src="<c:url value='/img/main/main_perso_skills.png' />"  
						title="<spring:message code='index.personnal.skill'/>"
						onmouseover="setImageOver(this);" onmouseout="setImageOut(this);"
						onclick="listSkill('<%=request.getContextPath()%>', '${userSession.matricule}')" 
						style="cursor: pointer; float:left; padding: 10px;" />
						
						<img src="<c:url value='/img/main/main_perso_cv.png' />"  
						title="<spring:message code='index.personnal.cv'/>"
						onmouseover="setImageOver(this);" onmouseout="setImageOut(this);"
						onclick="generateCv('<%=request.getContextPath()%>')" 
						style="cursor: pointer; float:left; padding-top: 10px;" />
						
						<img src="<c:url value='/img/main/main_trombi.png' />"  
						title="<spring:message code='index.trombinoscope'/>"
						onmouseover="setImageOver(this);" onmouseout="setImageOut(this);"
						onclick="showTrombinoscope('<%=request.getContextPath()%>')" 
						style="cursor: pointer; float:left; padding: 10px;" />
						
						<!-- Admin part -->
						<c:if test="${userSession.admin}">
							<img src="<c:url value='/img/main/main_admin_person.png' />"  
							title="<spring:message code='index.admin.person'/>"
							onmouseover="setImageOver(this);" onmouseout="setImageOut(this);"
							onclick="listePersons('<%=request.getContextPath()%>', '${userSession.id}')" 
							style="cursor: pointer; float:left; padding: 10px;" />
							
							<img src="<c:url value='/img/main/main_admin_bu.png' />"  
							title="<spring:message code='index.admin.bu'/>"
							onmouseover="setImageOver(this);" onmouseout="setImageOut(this);"
							onclick="listeBusinessUnits('<%=request.getContextPath()%>', '${userSession.id}')" 
							style="cursor: pointer; float:left; padding: 10px;" />
							
							<img src="<c:url value='/img/main/main_admin_item.png' />"  
							title="<spring:message code='index.admin.item'/>"
							onmouseover="setImageOver(this);" onmouseout="setImageOut(this);"
							onclick="listeItems('<%=request.getContextPath()%>', '${userSession.id}')" 
							style="cursor: pointer; float:left; padding: 10px;" />

							<img src="<c:url value='/img/main/main_admin_category.png' />"  
							title="<spring:message code='index.admin.category'/>"
							onmouseover="setImageOver(this);" onmouseout="setImageOut(this);"
							onclick="listeCategories('<%=request.getContextPath()%>', '${userSession.id}')" 
							style="cursor: pointer; float:left; padding: 10px;" />
							
							<img src="<c:url value='/img/main/main_admin_search.png' />"  
							title="<spring:message code='index.admin.search'/>"
							onmouseover="setImageOver(this);" onmouseout="setImageOut(this);"
							onclick="search('<%=request.getContextPath()%>')" 
							style="cursor: pointer; float:left; padding: 10px;" />
						</c:if>
				</div>
			</div>
	</div>
</div>
