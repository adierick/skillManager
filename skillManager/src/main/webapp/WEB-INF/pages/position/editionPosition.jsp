<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

		<fieldset class="ellipse04">
			<legend> <spring:message code='position.choose.action'/></legend>
			
			<div>
				<img src="<c:url value='/img/main/main_admin_bu.png' />" style="float:left; padding: 10px;" />
				
				<div class="container">
				    <div class="row">
				        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm">
				           <form:form modelAttribute="position" action="update.do" class="formulaire">
					            <input class="form-control" name="code" placeholder="<spring:message code='position.label'/>" type="text" required value="${position.code}" />
					            <input class="form-control" name="trs_label_key"  placeholder="<spring:message code='position.trs_label_key'/>" type="text" required value="${position.trs_label_key}" />
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
