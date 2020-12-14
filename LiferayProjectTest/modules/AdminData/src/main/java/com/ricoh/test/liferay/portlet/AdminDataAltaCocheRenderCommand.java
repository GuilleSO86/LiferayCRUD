package com.ricoh.test.liferay.portlet;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.ricoh.test.liferay.constants.AdminDataPortletKeys;
import com.ricoh.test.liferay.constants.Constants;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + AdminDataPortletKeys.ADMINDATA,
			"mvc.command.name=" + Constants.RENDER_ALTA_COCHE
		},
		service = MVCRenderCommand.class
)
public class AdminDataAltaCocheRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		_log.info("Redirect to '" + Constants.ALTA_COCHE + "'");
		
		return Constants.ALTA_COCHE;
	}
	
	private static final Log _log = LogFactoryUtil.getLog(AdminDataAltaCocheRenderCommand.class);
}
