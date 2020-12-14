<%@ include file="/init.jsp" %>
<%@page import="com.ricoh.test.liferay.constants.Constants"%>
<%@page import="com.ricoh.test.liferay.entities.Coche"%>

<% Coche coche = (Coche) renderRequest.getAttribute("cochetoUpdate"); %>

<liferay-portlet:actionURL var="editarCoche" name="<%= Constants.RENDER_EDITAR_COCHE %>">
	<liferay-portlet:param name="backURL" value="<%= currentURL %>" />
</liferay-portlet:actionURL>


<h1>Edicion de Coche</h1>

<liferay-ui:header title="admindata.editacoche" backURL="<%= backURL %>"></liferay-ui:header>

<aui:form action="${ editarCoche }">
	<aui:input name="idCoche" type="hidden" value="<%= coche.getIdCoche() %>"></aui:input>
	
	<aui:input name="modelo" label="Modelo:" type="text" value="<%= coche.getModelo() %>"></aui:input>
	
	<aui:input name="cv" label="CV:" type="text" value="<%= coche.getCv() %>"></aui:input>
	
	<aui:input name="precio" label="Precio:" type="text" value="<%= coche.getPrecio() %>"></aui:input>
	
	<aui:button-row>
		<aui:button type="submit" value="save"></aui:button>
		<aui:button type="cancel" value="cancel" href="<%= backURL %>"></aui:button>
	</aui:button-row>
</aui:form>
