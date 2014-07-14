package com.liferay.applicants.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UICommand;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.portlet.ActionResponse;
import javax.xml.namespace.QName;

import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.user.registration.dto.User;

/**
 * @author Suresh.Kumar
 *
 */
@ManagedBean(name = "applicantsViewBackingBean")
@RequestScoped
public class ApplicantsViewBackingBean implements Serializable{

 
	private static final long serialVersionUID = -8268031740048603673L;
	// Logger
	private static final Logger logger = LoggerFactory.getLogger(ApplicantsViewBackingBean.class);
	
	@PostConstruct
	public void postConstruct() {
		logger.trace("@PostConstruct annotation worked");
	}

	@PreDestroy
	public void preDestroy() {
		logger.trace("@PreDestroy annotation worked");
	}

	public void selectionListener(ActionEvent actionEvent) {

		UICommand uiCommand = (UICommand) actionEvent.getComponent();
		User user = (User) uiCommand.getValue();
		QName qName = new QName("http://liferay.com/events", "ipc.applicantSelected");
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		ActionResponse actionResponse = (ActionResponse) externalContext.getResponse();
		Serializable eventPayload = user;		 
		actionResponse.setEvent(qName, eventPayload);
	}

}
