<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

		<fieldset class="ellipse01">
			<legend> <spring:message code="personnal.data"/></legend>
			
			<div>
				<img src="<c:url value='/img/main/main_perso_data.png' />" style="float:left; padding: 10px;" />
				
				<form:form modelAttribute="picture" action="loadPicture.do" class="formulaire" enctype="multipart/form-data">>
					<div>
					<label class="large"><spring:message code="person.picture"/>
					<form:input path="file" type="file"/>
					</label><form:errors path="file" cssClass="error"/><br/>
					<input type="submit" value="Envoyer"><br/>
					</div>
					<img src="data:image/jpeg;base64,${Img}" alt="avatar">
				</form:form>
				
			</div>
			
		</fieldset>