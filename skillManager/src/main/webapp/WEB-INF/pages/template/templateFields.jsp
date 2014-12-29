<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<fieldset class="ellipse01">
	<legend>
		<spring:message code="personnal.cv" />
	</legend>

	<div>
		<img src="<c:url value='/img/main/main_perso_cv.png' />"
			style="float: left; padding: 10px;" />
		<form:form modelAttribute="templateData" action="step1.do"
			class="formulaire">
			<div>
				<label class="large"><spring:message code="person.firstname" />
				</label>
				<form:input path="firstname" readonly="true"/>
				<br /> <label class="large"><spring:message
						code="person.lastname" /> </label>
				<form:input path="lastname" readonly="true"/>
				<br /> <label class="large"><spring:message
						code="person.age" /> </label>
				<form:input path="age" />
				<br /> <label class="large"><spring:message
						code="person.fct" /> </label>
				<form:input path="fctclb" />
				<br /> <label class="large"><spring:message
						code="person.yearexp" /> </label>
				<form:input path="expclb" />
				<br /> <label class="large"><spring:message
						code="person.dispo" /> </label>
				<form:input path="dispoclb" />
				<br /> <label class="large"><spring:message
						code="person.lastschool" /> </label>
				<form:input path="lastSchool" />
				<br/><br/>
			</div>
			<form:button style="margin:10px;">
				<spring:message code="person.nextstep" />
			</form:button>
		</form:form>
	</div>
</fieldset>