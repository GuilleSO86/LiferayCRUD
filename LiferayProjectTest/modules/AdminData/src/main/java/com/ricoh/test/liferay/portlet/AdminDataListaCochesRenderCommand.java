package com.ricoh.test.liferay.portlet;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.ricoh.test.liferay.constants.AdminDataPortletKeys;
import com.ricoh.test.liferay.constants.Constants;
import com.ricoh.test.liferay.entities.Coche;
import com.ricoh.test.liferay.web.WebServiceUtil;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + AdminDataPortletKeys.ADMINDATA,
			"mvc.command.name=/"
		},
		service = MVCRenderCommand.class
)
public class AdminDataListaCochesRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		_log.info("'render' process car list stored in data base to send it to '" + Constants.VISTA_COCHE + "'");
		
		List<Coche> coches = new ArrayList<Coche>();
		Coche coche = null;
		String listaCoches = WebServiceUtil.getCars();
		
		JSONArray jsonArrayCoches = WebServiceUtil.stringArrayObjectsDataToJsonArrayObject(listaCoches);
		
		for (int i = 0; i < jsonArrayCoches.length(); i++) {
			
			JSONObject jsonCoche = WebServiceUtil.stringObjectDataToJsonObject(jsonArrayCoches.get(i).toString());
			
			coche = WebServiceUtil.jsonToCoche(jsonCoche);
			
			coches.add(coche);
		}
		
		_log.info("'render' returns car list from WS: " + coches.toString());
		
		renderRequest.setAttribute("listaCoches", coches);		
		
		return null;
	}
	
	private static final Log _log = LogFactoryUtil.getLog(AdminDataListaCochesRenderCommand.class);
}
