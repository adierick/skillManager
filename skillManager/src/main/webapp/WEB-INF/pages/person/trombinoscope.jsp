<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

		<fieldset class="ellipse01">
			<legend> <spring:message code="person.trombinoscope"/></legend>
				<div>
<!-- 					<table> -->
						
					
					<div class="[ container text-center ]">
						<div class="[ row ]">
							<div class="[ col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3 ]" role="tabpanel">
								<div class="[ col-xs-4 col-sm-12 ]">
							    	<!-- Nav tabs -->
							        <ul class="[ nav nav-justified ]" id="nav-tabs" role="tablist">
							        	<c:set var="i" value ="${0}"/>
										<c:forEach var="personPicture" items="${personsPicturesList}" varStatus="status">
											<c:set var="i" value="${i+1}"/>
							            	<li role="presentation" class="">
							                	<a href="#${personPicture.person.matricule}" aria-controls="${personPicture.person.matricule}" role="tab" data-toggle="tab">
							                    	<img class="img-circle" src="data:image/jpeg;base64,${personPicture.encoded}" />
							                        <span class="quote"><i class="fa fa-quote-left"></i></span>
												</a>
											</li>
											<c:if test="${i>4}">
												<br/>
												<c:set var="i" value ="${0}"/>
											</c:if>
										</c:forEach>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
		</fieldset>
								<div class="[ col-xs-8 col-sm-12 ]">
							     	<!-- Tab panes -->
							        <div class="tab-content" id="tabs-collapse">    
							        	<c:forEach var="personPicture" items="${personsPicturesList}" varStatus="status">       
								        	<div role="tabpanel" class="tab-pane fade in" id="${personPicture.person.matricule}">
								            	<div class="tab-inner">                    
								                	<p class="lead"><c:out value="${personPicture.person.firstname}"/> <c:out value="${personPicture.person.lastname}"/></p>
								                    <hr>
								                    <p>
								                    	<strong class="text-uppercase">
								                    		<spring:message code="person.bu"/>: ${personPicture.person.bu.label}, 
								                        	<spring:message code="person.email"/>: ${personPicture.person.email}, 
								                        	<spring:message code="person.matricule"/>: ${personPicture.person.matricule}
														</strong>
													</p>
													<p>
								                    	<em class="text-capitalize"> 
															<c:if test="${userSession.admin}">
																<a href="editionPersonAsAdmin.do?matricule=${personPicture.person.matricule}">
															</c:if> 
															<spring:message code="personnal.data"/>
															<c:if test="${userSession.admin}">
																</a>
															</c:if>
														</em> 
													</p>     
												</div>
											</div>
										</c:forEach>
									</div>
								</div>