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
		
				<div class="container">
				    <div class="row">
				        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm">
				           <form:form modelAttribute="category" action="update.do" class="formulaire">
					            <input class="form-control" name="code" placeholder="<spring:message code='category.code'/>" type="text" required value="${category.code}" />
					            <input class="form-control" name="trs_label_key" placeholder="<spring:message code='category.trs_label_key'/>" type="text" required value="${category.trs_label_key}" />
								<label for=""><spring:message code="category.skills"/></label>
					            <div class="row">
					                <div class="col-xs-4 col-md-4">
										<select class="form-control" size="10">					
											<c:forEach items="${itemListCategory}" var="item">
												<option value="${item.id}">${item.code}</option>
											</c:forEach>
										</select>
					                </div>
					            </div>
					            <br />
					            <br />
					            <form:hidden path="id"/>
					            <button class="btn btn-lg btn-primary btn-block" type="submit">${type}</button>
				            </form:form>
				        </div>
					</div>
				</div>
	</div>
</fieldset>
