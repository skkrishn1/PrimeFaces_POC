package com.liferay.services.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ApplicantService}.
 * </p>
 *
 * @author    Suresh Kumar
 * @see       ApplicantService
 * @generated
 */
public class ApplicantServiceWrapper implements ApplicantService,
    ServiceWrapper<ApplicantService> {
    private ApplicantService _applicantService;

    public ApplicantServiceWrapper(ApplicantService applicantService) {
        _applicantService = applicantService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _applicantService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _applicantService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _applicantService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public ApplicantService getWrappedApplicantService() {
        return _applicantService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedApplicantService(ApplicantService applicantService) {
        _applicantService = applicantService;
    }

    public ApplicantService getWrappedService() {
        return _applicantService;
    }

    public void setWrappedService(ApplicantService applicantService) {
        _applicantService = applicantService;
    }
}
