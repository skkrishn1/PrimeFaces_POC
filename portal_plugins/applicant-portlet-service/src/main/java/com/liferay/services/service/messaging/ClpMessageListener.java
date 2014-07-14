package com.liferay.services.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.liferay.services.service.ApplicantLocalServiceUtil;
import com.liferay.services.service.ApplicantServiceUtil;
import com.liferay.services.service.ClpSerializer;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            ApplicantLocalServiceUtil.clearService();

            ApplicantServiceUtil.clearService();
        }
    }
}
