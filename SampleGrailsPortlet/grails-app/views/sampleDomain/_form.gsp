<%@ page import="com.apple.tests.SampleDomain" %>



<div class="fieldcontain ${hasErrors(bean: sampleDomainInstance, field: 'desc', 'error')} ">
	<label for="desc">
		<g:message code="sampleDomain.desc.label" default="Desc" />
		
	</label>
	<g:textField name="desc" value="${sampleDomainInstance?.desc}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: sampleDomainInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="sampleDomain.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${sampleDomainInstance?.name}"/>
</div>

