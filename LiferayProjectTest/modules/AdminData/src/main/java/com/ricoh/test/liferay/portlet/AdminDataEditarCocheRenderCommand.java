package com.ricoh.test.liferay.portlet;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.ricoh.test.liferay.constants.AdminDataPortletKeys;
import com.ricoh.test.liferay.constants.Constants;
import com.ricoh.test.liferay.entities.Coche;
import com.ricoh.test.liferay.web.WebServiceUtil;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + AdminDataPortletKeys.ADMINDATA,
			"mvc.command.name=" + Constants.RENDER_EDITAR_COCHE
		},
		service = MVCRenderCommand.class
)
public class AdminDataEditarCocheRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		Integer idCoche = ParamUtil.getInteger(renderRequest, "idCoche");
		
		Coche cochetoUpdate = WebServiceUtil.jsonToCoche(
							  WebServiceUtil.stringObjectDataToJsonObject(
							  WebServiceUtil.getCarById(idCoche)));
		
		_log.info("User selected the object 'Coche' with ID " + idCoche + " to edit (" + cochetoUpdate.toString() + ")");
		
		renderRequest.setAttribute("cochetoUpdate", cochetoUpdate);
		
		_log.info("Redirect to '" + Constants.EDITAR_COCHE + "'.");
		
		return Constants.EDITAR_COCHE;
	}
	
	private static final Log _log = LogFactoryUtil.getLog(AdminDataEditarCocheRenderCommand.class);
}
