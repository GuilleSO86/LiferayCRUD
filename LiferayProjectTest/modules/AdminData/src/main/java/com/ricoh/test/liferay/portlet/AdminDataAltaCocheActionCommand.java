package com.ricoh.test.liferay.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.ricoh.test.liferay.constants.AdminDataPortletKeys;
import com.ricoh.test.liferay.constants.Constants;
import com.ricoh.test.liferay.web.WebServiceUtil;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + AdminDataPortletKeys.ADMINDATA,
			"mvc.command.name=" + Constants.RENDER_ALTA_COCHE
		},
		service = MVCActionCommand.class
)
public class AdminDataAltaCocheActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		_log.info("'AltaCoche' form data process");
		
		JSONObject jsonNewCoche = JSONFactoryUtil.createJSONObject();
		JSONObject jsonMarca = JSONFactoryUtil.createJSONObject();
		
		// Default data
		jsonNewCoche.put("idCoche", "0");
		jsonMarca = WebServiceUtil.stringObjectDataToJsonObject(WebServiceUtil.getMarcaById(1));
		
		
		String modelo = ParamUtil.getString(actionRequest, "modelo");
		String cv = ParamUtil.getString(actionRequest, "cv");
		String precio = ParamUtil.getString(actionRequest, "precio");
		
		
		jsonNewCoche.put("modelo", modelo);
		jsonNewCoche.put("cv", cv);
		jsonNewCoche.put("precio", precio);
		jsonNewCoche.put("marca", jsonMarca);
		
		_log.info("Starting process to insert the following 'Coche' object: " + jsonNewCoche.toString());
		
		WebServiceUtil.insertCar(jsonNewCoche.toString());
		
		return true;
	}
	
	private static final Log _log = LogFactoryUtil.getLog(AdminDataAltaCocheActionCommand.class);
}
