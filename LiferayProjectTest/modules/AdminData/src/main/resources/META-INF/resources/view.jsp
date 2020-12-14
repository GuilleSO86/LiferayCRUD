<%@page import="com.ricoh.test.liferay.constants.Constants"%>
<%@ include file="/init.jsp" %>
<%@page import="com.ricoh.test.liferay.entities.Coche"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<% List<Coche> listaCoches = (List<Coche>) renderRequest.getAttribute("listaCoches"); %>

<liferay-portlet:renderURL var="altaCocheURL" windowState="<%= LiferayWindowState.MAXIMIZED.toString() %>">
	<liferay-portlet:param name="mvcRenderCommandName" value="<%= Constants.RENDER_ALTA_COCHE %>" />
	<liferay-portlet:param name="backURL" value="<%= currentURL %>" />
</liferay-portlet:renderURL>



<h1>LISTA DE COCHES</h1>

<aui:button value="Alta Nuevo Coche" href="${ altaCocheURL }" ></aui:button>

<table>
	<tr>
		<th>Modulo</th>
		<th>CV</th>
		<th>Precio</th>
		<th>Nombre</th>
		<th>Año fundación</th>
		<th>Nacionalidad</th>
		
		<th>Acciones</th>
	</tr>
	
	<% for (Coche coche : listaCoches) { %>
		<tr>
			<td><%= coche.getModelo() %></td>
			<td><%= coche.getCv() %></td>
			<td><%= coche.getPrecio() %></td>
			<td><%= coche.getMarca().getNombre() %></td>
			<td><%= coche.getMarca().getAniofundacion() %></td>
			<td><%= coche.getMarca().getNacionalidad() %></td>
			
			<td>
				<liferay-portlet:renderURL var="editarCocheURL">
					<liferay-portlet:param name="mvcRenderCommandName" value="<%= Constants.RENDER_EDITAR_COCHE %>" />
					<liferay-portlet:param name="backURL" value="<%= currentURL %>" />
					<liferay-portlet:param name="idCoche" value="<%= String.valueOf(coche.getIdCoche()) %>" />
				</liferay-portlet:renderURL>
				
				<liferay-portlet:actionURL var="eliminarCocheURL" name="<%= Constants.RENDER_ELIMINAR_COCHE %>">
					<liferay-portlet:param name="backURL" value="<%= currentURL %>" />
					<liferay-portlet:param name="idCoche" value="<%= String.valueOf(coche.getIdCoche()) %>" />
				</liferay-portlet:actionURL>
				
				
				<liferay-ui:icon-menu>
					<liferay-ui:icon url="${ editarCocheURL }" message="Edit"></liferay-ui:icon>
					<liferay-ui:icon url="${ eliminarCocheURL }" message="Delete"></liferay-ui:icon>
				</liferay-ui:icon-menu>
			</td>
		</tr>
	<% } %>
</table>