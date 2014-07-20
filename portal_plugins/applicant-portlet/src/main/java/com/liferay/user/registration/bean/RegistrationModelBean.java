package com.liferay.user.registration.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.user.registration.dto.User;

/**
 * This class is a JSF model managed-bean that contains applicant registration
 * details. First, the Portlet 2.0 EVENT_PHASE broadcasts the IPC events. At
 * that point, the bridge executes the RESTORE_VIEW phase of the JSF lifecycle
 * so that the ApplicantEventHandler.handleEvent(FacesContext, Event)
 * method can handle the "ipc.applicantUpdated" event as defined in the
 * WEB-INF/portlet.xml descriptor. Then, the Portlet 2.0 RENDER_PHASE will cause
 * the RENDER_RESPONSE phase of the JSF lifecycle to be executed. 
 * 
 * 
 * @author suresh kumar
 */

@SessionScoped
@ManagedBean(name = "registrationModelBean")
public class RegistrationModelBean implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3625673172315850000L;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(RegistrationModelBean.class);

	/** The user. */
	User user;
	
	

	/**
	 * Post construct.
	 */
	@PostConstruct
	public void postConstruct() {

		logger.trace("@PostConstruct method");
		user = new User();
	}

	/**
	 * Pre destroy.
	 */
	@PreDestroy
	public void preDestroy() {
		logger.trace("@PreDestroy method");
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 * 
	 * @param user
	 *            the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
