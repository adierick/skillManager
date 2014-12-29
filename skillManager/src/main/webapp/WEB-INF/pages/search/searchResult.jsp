<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<fieldset class="ellipse02">
	<legend>
		<spring:message code='search.doSearch' />
	</legend>

	<jsp:include page="searchForm.jsp"/>
	
	<div class="search">
		<table>
			<tr class="thead">
				<th class="searchBu sortable" onclick="sortSearchTable('<%=request.getContextPath()%>', 1);"
					title="<spring:message code='search.result.bu.sort'/>">
					<spring:message code='search.result.bu.label'/>
				</th>
				<th class="searchPerson sortable" onclick="sortSearchTable('<%=request.getContextPath()%>', 2);"
					title="<spring:message code='search.result.person.lastname.sort'/>">
					<spring:message code='search.result.person.lastname'/>
				</th>
				<th class="searchPerson sortable" onclick="sortSearchTable('<%=request.getContextPath()%>', 3);"
					title="<spring:message code='search.result.person.firstname.sort'/>">
					<spring:message code='search.result.person.firstname'/>
				</th>
				<th class="searchItemCode sortable" onclick="sortSearchTable('<%=request.getContextPath()%>', 4);"
					title="<spring:message code='search.result.item.code.sort'/>">
					<spring:message code='search.result.item.code'/>
				</th>
				<th class="searchItem sortable" onclick="sortSearchTable('<%=request.getContextPath()%>', 5);"
					title="<spring:message code='search.result.item.label.sort'/>">
					<spring:message code='search.result.item.label'/>
				</th>
				<th class="searchLevel sortable" onclick="sortSearchTable('<%=request.getContextPath()%>', 6);"
					title="<spring:message code='search.result.skill.level.sort'/>">
					<spring:message code='search.result.skill.level'/>
				</th>
			</tr>
			<%
			String cssActive = "searchActive";
			String cssInActive = "searchInActive";
			int i=0;
			%>
			<c:forEach var="result" items="${searchResult}" varStatus="status">
				<tr class="<%= (i%2==0)?cssActive:cssInActive%>">
					<td class="searchBu">${result.buLabel}</td>
					<td class="searchPerson">${result.lastName}</td>
					<td class="searchPerson">${result.firstName}</td>
					<td class="searchItemCode">${result.itemCode}</td>
					<td class="searchItem">${result.itemLabel}</td>
					<td class="searchLevel">
					<c:forEach var="lvl" begin="1" end="5">
						<c:choose>
							<c:when test="${result.level>=lvl}"> 
								<img src="<c:url value='/img/skills/active1.png' />" /> 
							</c:when>
							<c:otherwise>
								<img src="<c:url value='/img/skills/active0.png' />" /> 
							</c:otherwise>
						</c:choose>
					</c:forEach>
					</td>
				</tr>
			<%i++; %>
			</c:forEach>
		</table>
	</div>
</fieldset>