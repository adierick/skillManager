<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<fieldset class="ellipse03">
	<legend>
		<spring:message code='category.choose.action' />
	</legend>

	<div>
				<div class="container">
<!-- 				    <div class="row"> -->
<!-- 				        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm"> -->
				           <form:form modelAttribute="category" action="update.do" class="formulaire">
					            <input class="form-control" name="code" placeholder="<spring:message code='category.code'/>" type="text" required value="${category.code}" readonly="readonly" />
					            <input class="form-control" name="trs_label_key" placeholder="<spring:message code='category.trs_label_key'/>" type="text" required value="${category.trs_label_key}" readonly="readonly" />
								<label for=""><spring:message code="category.skills"/></label>
					            <div class="row">
					                <div class="col-xs-4 col-md-4" style="width: 100% !important">
						 				<form:select class="bootstrap-duallistbox-container" multiple="multiple" path="items" id="itemsDualListBox">
											<c:forEach items="${allItemsList}" var="item">
												<option value="${item.id}" <c:if test="${item.category.id == category.id}">selected="selected"</c:if>>
													${item.code}
												</option>
											</c:forEach>
										</form:select>
					                </div>
					            </div>
					            <br />
					            <br />
					            <form:hidden path="id"/>
					            <button class="btn btn-lg btn-primary btn-block" type="submit">${type}</button>
				            </form:form>
<!-- 				        </div> -->
<!-- 					</div> -->
				</div>
		</div>			
</fieldset>
