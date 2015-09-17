<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

		<fieldset class="ellipse03">
			<legend> <spring:message code='item.choose.action'/></legend>
			
			<div>
				<img src="<c:url value='/img/main/main_admin_item.png' />" style="float:left; padding: 10px;" />
				<div class="container">
				    <div class="row">
				        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm">
							<form:form modelAttribute="item" action="update.do" class="formulaire">
								<div>
									<label for=""><spring:message code='item.categorie'/></label>
						            <div class="row">
						                <div class="col-xs-4 col-md-4">
											<form:select path="category" cssClass="form-control">
												<form:option value="" label="---"/>
												<form:options items="${listCategory}" itemLabel="trs_label_key"/>
											</form:select>
						                </div>
						            </div>
									
																						
<%-- 									<c:choose> --%>
<%-- 										<c:when test="${type=='create'}">												 --%>
<%-- 											<form:select path="category"> --%>
<%-- 												<form:option value="" label="---"/> --%>
<%-- 												<form:options items="${listCategory}" itemLabel="trs_label_key"/> --%>
<%-- 											</form:select> --%>
<%-- 										</c:when> --%>
<%-- 										<c:otherwise> --%>
<%-- 											<form:hidden path="category"/><spring:message code='${item.category.trs_label_key}'/> --%>
<%-- 										</c:otherwise>						 --%>
<%-- 									</c:choose> --%>
<!-- 									<br/> -->
									<input class="form-control" name="code" placeholder="<spring:message code='item.code'/>" type="text" required value="${item.code}" />
									<input class="form-control" name="trs_label_key" placeholder="<spring:message code='item.trs_label_key'/>" type="text" required value="${item.trs_label_key}" />
								</div>
								<form:hidden path="id"/>
								<button class="btn btn-lg btn-primary btn-block" type="submit">${type}</button>
							</form:form>
				        </div>
					</div>
				</div>
			</div>
		</fieldset>
