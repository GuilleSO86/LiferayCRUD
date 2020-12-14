package com.ricoh.test.liferay.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

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
			"mvc.command.name=" + Constants.RENDER_ELIMINAR_COCHE
		},
		service = MVCActionCommand.class
)
public class AdminDataEliminarCocheActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		String idCoche = ParamUtil.getString(actionRequest, "idCoche");
		
		_log.info("Deleting 'Coche' object with ID " + idCoche);
				
		WebServiceUtil.deleteCar(Integer.valueOf(idCoche));
		
		return true;
	}
	
	private static final Log _log = LogFactoryUtil.getLog(AdminDataEliminarCocheActionCommand.class);
}
