<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<img src="<c:url value='/img/main/main_admin_search.png' />" style="padding: 10px;" />
	
	<form:form id="searchForm" modelAttribute="searchCriteria" action="search.do" style="float: right; padding-right: 150px; padding-top: 50px;">
		<div><label class="large"><spring:message code="search.type"/></label> 
			<form:select path="type" >
				<form:options items="${searchTypes}"  itemLabel="label" itemValue="id"/>
			</form:select>
		</div>
		<div><label class="large"><spring:message code="search.criteria"/></label> <form:input path="criteria"/></div>
		<div>
			<form:hidden path="export"/>
			
			<input type="button" title="<spring:message code='main.back'/>" onclick="location.href='<%=request.getContextPath()%>/main/login/login.do'" class="backButton" />
			<input type="submit" title="<spring:message code='search.doSearch'/>" class="searchButton"/>
			<input type="submit" title="<spring:message code='search.export.excel'/>" class="excelButton" 
				onclick="document.getElementById('export').value=1; document.getElementById('searchForm').submit();" 
				/>
		</div>
	</form:form>
