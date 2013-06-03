
<%@ page import="com.apple.tests.SampleDomain" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'sampleDomain.label', default: 'SampleDomain')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-sampleDomain" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-sampleDomain" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list sampleDomain">
			
				<g:if test="${sampleDomainInstance?.desc}">
				<li class="fieldcontain">
					<span id="desc-label" class="property-label"><g:message code="sampleDomain.desc.label" default="Desc" /></span>
					
						<span class="property-value" aria-labelledby="desc-label"><g:fieldValue bean="${sampleDomainInstance}" field="desc"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sampleDomainInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="sampleDomain.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${sampleDomainInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${sampleDomainInstance?.id}" />
					<g:link class="edit" action="edit" id="${sampleDomainInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
