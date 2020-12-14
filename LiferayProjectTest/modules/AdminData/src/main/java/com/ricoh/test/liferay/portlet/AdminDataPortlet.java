package com.ricoh.test.liferay.portlet;

import com.ricoh.test.liferay.constants.AdminDataPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Guillermo Sanes Orrego
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Ricoh",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AdminData",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AdminDataPortletKeys.ADMINDATA,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AdminDataPortlet extends MVCPortlet {
}