<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

		<fieldset class="ellipse02">
			<legend> <spring:message code='index.personnal.skill'/></legend>
			
			<div>
				<img src="<c:url value='/img/main/main_perso_skills.png' />" style="float:left; padding: 10px;" />
				<div>
					<table>
						<c:forEach var="skill" items="${skillsList}" varStatus="status">
						<tr>
							<td>
								<spring:message code='${skill.item.trs_label_key}'/>
							</td>
							<td>
								<img src="<c:url value='/img/skills/reset.png' />"  
									title="<spring:message code='personnal.skill.reset'/>"
									onmouseover="setImageOver(this);" onmouseout="setImageOut(this);"
									onclick="setSkillLevel('<%=request.getContextPath() %>', '0', '${userSession.matricule}', '${skill.id}', '${skill.item.id}')" 
									style="cursor: pointer;" />
							</td>
							<td>
							<c:forEach var="lvl" begin="1" end="5">
								<c:choose>
									<c:when test="${skill.level>=lvl}"> 
										<img id="id_skill_${skill.id}_${skill.item.id}_${lvl}" src="<c:url value='/img/skills/active1.png' />" 
											style="cursor: pointer;"
											onmouseover="refreshSkillStars('id_skill_${skill.id}_${skill.item.id}_', ${lvl});" 
											onmouseout="refreshSkillStarsOut('id_skill_${skill.id}_${skill.item.id}_', ${skill.level});"
											onclick="setSkillLevel('<%=request.getContextPath() %>', '${lvl}', '${userSession.matricule}', '${skill.id}', '${skill.item.id}')" /> 
									</c:when>
									<c:otherwise>
										<img id="id_skill_${skill.id}_${skill.item.id}_${lvl}" src="<c:url value='/img/skills/active0.png' />" 
											style="cursor: pointer;"
											onmouseover="refreshSkillStars('id_skill_${skill.id}_${skill.item.id}_', ${lvl});" 
											onmouseout="refreshSkillStarsOut('id_skill_${skill.id}_${skill.item.id}_', ${skill.level});"
											onclick="setSkillLevel('<%=request.getContextPath() %>', '${lvl}', '${userSession.matricule}', '${skill.id}', '${skill.item.id}')" /> 
									</c:otherwise>
								</c:choose>
							</c:forEach>
							</td>
						</tr>
						</c:forEach>
					</table>
							
					<div>
						<input type="button" title="<spring:message code='main.back'/>" onclick="location.href='<%=request.getContextPath()%>/main/login/login.do'" class="backButton"/>

					</div>
				</div>
			</div>
			
		</fieldset>
