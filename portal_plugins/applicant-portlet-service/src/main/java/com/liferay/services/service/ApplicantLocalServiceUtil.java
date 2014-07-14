package com.liferay.services.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the applicant local service. This utility wraps {@link com.liferay.services.service.impl.ApplicantLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Suresh Kumar
 * @see ApplicantLocalService
 * @see com.liferay.services.service.base.ApplicantLocalServiceBaseImpl
 * @see com.liferay.services.service.impl.ApplicantLocalServiceImpl
 * @generated
 */
public class ApplicantLocalServiceUtil {
    private static ApplicantLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.liferay.services.service.impl.ApplicantLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the applicant to the database. Also notifies the appropriate model listeners.
    *
    * @param applicant the applicant
    * @return the applicant that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.services.model.Applicant addApplicant(
        com.liferay.services.model.Applicant applicant)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addApplicant(applicant);
    }

    /**
    * Creates a new applicant with the primary key. Does not add the applicant to the database.
    *
    * @param applicantId the primary key for the new applicant
    * @return the new applicant
    */
    public static com.liferay.services.model.Applicant createApplicant(
        long applicantId) {
        return getService().createApplicant(applicantId);
    }

    /**
    * Deletes the applicant with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param applicantId the primary key of the applicant
    * @return the applicant that was removed
    * @throws PortalException if a applicant with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.services.model.Applicant deleteApplicant(
        long applicantId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteApplicant(applicantId);
    }

    /**
    * Deletes the applicant from the database. Also notifies the appropriate model listeners.
    *
    * @param applicant the applicant
    * @return the applicant that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.services.model.Applicant deleteApplicant(
        com.liferay.services.model.Applicant applicant)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteApplicant(applicant);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    public static com.liferay.services.model.Applicant fetchApplicant(
        long applicantId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchApplicant(applicantId);
    }

    /**
    * Returns the applicant with the primary key.
    *
    * @param applicantId the primary key of the applicant
    * @return the applicant
    * @throws PortalException if a applicant with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.services.model.Applicant getApplicant(
        long applicantId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getApplicant(applicantId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the applicants.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of applicants
    * @param end the upper bound of the range of applicants (not inclusive)
    * @return the range of applicants
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.services.model.Applicant> getApplicants(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getApplicants(start, end);
    }

    /**
    * Returns the number of applicants.
    *
    * @return the number of applicants
    * @throws SystemException if a system exception occurred
    */
    public static int getApplicantsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getApplicantsCount();
    }

    /**
    * Updates the applicant in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param applicant the applicant
    * @return the applicant that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.services.model.Applicant updateApplicant(
        com.liferay.services.model.Applicant applicant)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateApplicant(applicant);
    }

    /**
    * Updates the applicant in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param applicant the applicant
    * @param merge whether to merge the applicant with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the applicant that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.services.model.Applicant updateApplicant(
        com.liferay.services.model.Applicant applicant, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateApplicant(applicant, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static void clearService() {
        _service = null;
    }

    public static ApplicantLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ApplicantLocalService.class.getName());

            if (invokableLocalService instanceof ApplicantLocalService) {
                _service = (ApplicantLocalService) invokableLocalService;
            } else {
                _service = new ApplicantLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ApplicantLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(ApplicantLocalService service) {
    }
}
