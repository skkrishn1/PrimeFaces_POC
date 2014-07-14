/**
 * Copyright (c) 2000-2014 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.applicants.event;

import javax.faces.context.FacesContext;
import javax.portlet.Event;
import javax.portlet.faces.BridgeEventHandler;
import javax.portlet.faces.event.EventNavigationResult;

import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.services.model.Applicant;
import com.liferay.services.model.impl.ApplicantImpl;
import com.liferay.services.service.ApplicantLocalServiceUtil;
import com.liferay.user.registration.dto.User;


/**
 * @author  Suresh Kumar
 */
public class ApplicantEditedEventHandler implements BridgeEventHandler {

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(ApplicantEditedEventHandler.class);

	public EventNavigationResult handleEvent(FacesContext facesContext, Event event) {
		EventNavigationResult eventNavigationResult = null;
		String eventQName = event.getQName().toString();

		if (eventQName.equals("{http://liferay.com/events}ipc.applicantEdited")) {
			User user = (User) event.getValue();
			Applicant applicant = new ApplicantImpl();
			applicant.setApplicantId(user.getApplicantId());
			applicant.setFirstName(user.getFirstName());
			applicant.setMiddleName(user.getMiddleName());
			applicant.setQualifications(user.getQualifications());
			try {
				ApplicantLocalServiceUtil.updateApplicant(applicant);
			} catch (SystemException e) {
				e.printStackTrace();
			}
			logger.debug("Received event ipc.applicantEdited for applicantId=[{0}] firstName=[{1}] lastName=[{2}]",
				new Object[] { applicant.getApplicantId(), applicant.getFirstName(), applicant.getLastName() });
		}

		return eventNavigationResult;
	}
}
