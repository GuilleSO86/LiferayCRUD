<%@ include file="/init.jsp" %>
<%@page import="com.ricoh.test.liferay.constants.Constants"%>

<liferay-portlet:actionURL var="altaCoche" name="<%= Constants.RENDER_ALTA_COCHE %>">
	<liferay-portlet:param name="backURL" value="<%= currentURL %>" />
</liferay-portlet:actionURL>


<h1>Alta de nuevo coche</h1>

<liferay-ui:header title="admindata.altacoche" backURL="<%= backURL %>"></liferay-ui:header>

<aui:form action="${ altaCoche }">
	<aui:input name="modelo" label="Modelo:" type="text"></aui:input>
	
	<aui:input name="cv" label="CV:" type="text"></aui:input>
	
	<aui:input name="precio" label="Precio:" type="text"></aui:input>
	
	<aui:button-row>
		<aui:button type="submit" value="save"></aui:button>
		<aui:button type="cancel" value="cancel" href="<%= backURL %>"></aui:button>
	</aui:button-row>
</aui:form>