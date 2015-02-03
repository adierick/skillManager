<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<fieldset class="ellipse03">
	<legend>
		<spring:message code='category.choose.action' />
	</legend>

	<div>
		<img src="<c:url value='/img/main/main_admin_category.png' />" style="float: left; padding: 10px;" />
		<form:form modelAttribute="category" action="update.do" class="formulaire">
		<div>
			<form:hidden path="id" />		
			<label class="large"><spring:message code='category.code' /></label><form:input path="code" readonly="true"/><br />
			<label class="large"><spring:message code='category.trs_label_key' /> </label><form:input path="trs_label_key" readonly="true" /><br />
			<span class="col-md-6"><label class="large"><spring:message code='category.skills' /></label></span>
			<div class="col-md-6">
 				<form:select class="bootstrap-duallistbox-container" multiple="multiple" path="items" id="itemsDualListBox">
					<c:forEach items="${allItemsList}" var="item">
						<option value="${item.id}" 
						<c:if test="${item.category.id == category.id}">selected="selected"</c:if>
						>${item.code}</option>
					</c:forEach>
				</form:select>							
 			</div>				
		</div>			
		
		<div>
			<input type="button"
				title="<spring:message code='category.edit.back'/>"
				onclick="listeCategories('<%=request.getContextPath()%>', '${userSession.id}');"
				class="backButton" /> <input type="submit" title="${type}"
				class="submitButton" />
		</div>
		</form:form>
	</div>
</fieldset>
