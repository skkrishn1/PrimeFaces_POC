package com.liferay.user.registration.event;

import java.io.Serializable;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.portlet.Event;
import javax.portlet.faces.BridgeEventHandler;
import javax.portlet.faces.event.EventNavigationResult;

import com.liferay.faces.bridge.event.EventPayloadWrapper;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.user.registration.bean.RegistrationModelBean;
import com.liferay.user.registration.dto.User;


/**
 * @author  Suresh Kumar
 */
public class ApplicantEventHandler implements BridgeEventHandler {

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(ApplicantEventHandler.class);

	public EventNavigationResult handleEvent(FacesContext facesContext,
			Event event) {
		EventNavigationResult eventNavigationResult = null;
		String eventQName = event.getQName().toString();
		
		if (eventQName.equals("{http://liferay.com/events}ipc.applicantSelected")) {

		Serializable value = event.getValue();

		if (value instanceof EventPayloadWrapper) {
			value = ((EventPayloadWrapper) value).getWrapped();
		}

		User user = (User) value;
		RegistrationModelBean registrationModelBean = getRegistrationModelBean(facesContext);
		registrationModelBean.setUser(user);

		String fromAction = null;
		String outcome = "ipc.applicantSelected";
		eventNavigationResult = new EventNavigationResult(fromAction, outcome);
		logger.info(
				"Received event ipc.userEntry for applicantId=[{0}] firstName=[{1}] lastName=[{2}]",
				new Object[] { user.getApplicantId(), user.getFirstName(),
						user.getLastName() });
		}
		return eventNavigationResult;
	}

	/**
	 * @param facesContext
	 * @return
	 */
	protected RegistrationModelBean getRegistrationModelBean(FacesContext facesContext) {
		String elExpression = "#{registrationModelBean}";
		ELContext elContext = facesContext.getELContext();
		ValueExpression valueExpression = facesContext.getApplication().getExpressionFactory().createValueExpression(
				elContext, elExpression, RegistrationModelBean.class);

		return (RegistrationModelBean) valueExpression.getValue(elContext);
	}
}
