<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<fieldset class="ellipse02" style="height:790px !important;">
	<legend>
		<spring:message code='search.doSearch' />
	</legend>

	<jsp:include page="searchForm.jsp"/>
			<div >
				<div class="col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title"><spring:message code='search.doSearch' /></h3>
						</div>
						<table class="table table-hover" id="dev-table">
							<thead >
								<tr>
									<th>
										<spring:message code='search.result.bu.label'/>
									</th>
									<th>
										<spring:message code='search.result.person.lastname'/>
									</th>
									<th>
										<spring:message code='search.result.person.firstname'/>									
									</th>
									<th>
										<spring:message code='search.result.item.code'/>									
									</th>
									<th>
										<spring:message code='search.result.item.label'/>
									</th>
									<th>
										<spring:message code='search.result.skill.level'/>
									</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="result" items="${searchResult}" varStatus="status">
								<tr>
									<td>${result.buLabel}</td>
									<td>${result.lastName}</td>
									<td>${result.firstName}</td>
									<td>${result.itemCode}</td>
									<td>${result.itemLabel}</td>
									<td>
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
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
</fieldset>