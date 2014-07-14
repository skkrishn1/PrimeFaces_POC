package com.liferay.services.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.services.model.Applicant;

import java.util.List;

/**
 * The persistence utility for the applicant service. This utility wraps {@link ApplicantPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Suresh Kumar
 * @see ApplicantPersistence
 * @see ApplicantPersistenceImpl
 * @generated
 */
public class ApplicantUtil {
    private static ApplicantPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Applicant applicant) {
        getPersistence().clearCache(applicant);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Applicant> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Applicant> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Applicant> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Applicant update(Applicant applicant, boolean merge)
        throws SystemException {
        return getPersistence().update(applicant, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Applicant update(Applicant applicant, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(applicant, merge, serviceContext);
    }

    /**
    * Caches the applicant in the entity cache if it is enabled.
    *
    * @param applicant the applicant
    */
    public static void cacheResult(
        com.liferay.services.model.Applicant applicant) {
        getPersistence().cacheResult(applicant);
    }

    /**
    * Caches the applicants in the entity cache if it is enabled.
    *
    * @param applicants the applicants
    */
    public static void cacheResult(
        java.util.List<com.liferay.services.model.Applicant> applicants) {
        getPersistence().cacheResult(applicants);
    }

    /**
    * Creates a new applicant with the primary key. Does not add the applicant to the database.
    *
    * @param applicantId the primary key for the new applicant
    * @return the new applicant
    */
    public static com.liferay.services.model.Applicant create(long applicantId) {
        return getPersistence().create(applicantId);
    }

    /**
    * Removes the applicant with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param applicantId the primary key of the applicant
    * @return the applicant that was removed
    * @throws com.liferay.services.NoSuchApplicantException if a applicant with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.services.model.Applicant remove(long applicantId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.services.NoSuchApplicantException {
        return getPersistence().remove(applicantId);
    }

    public static com.liferay.services.model.Applicant updateImpl(
        com.liferay.services.model.Applicant applicant, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(applicant, merge);
    }

    /**
    * Returns the applicant with the primary key or throws a {@link com.liferay.services.NoSuchApplicantException} if it could not be found.
    *
    * @param applicantId the primary key of the applicant
    * @return the applicant
    * @throws com.liferay.services.NoSuchApplicantException if a applicant with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.services.model.Applicant findByPrimaryKey(
        long applicantId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.services.NoSuchApplicantException {
        return getPersistence().findByPrimaryKey(applicantId);
    }

    /**
    * Returns the applicant with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param applicantId the primary key of the applicant
    * @return the applicant, or <code>null</code> if a applicant with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.services.model.Applicant fetchByPrimaryKey(
        long applicantId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(applicantId);
    }

    /**
    * Returns all the applicants where firstName = &#63;.
    *
    * @param firstName the first name
    * @return the matching applicants
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.services.model.Applicant> findByname(
        java.lang.String firstName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByname(firstName);
    }

    /**
    * Returns a range of all the applicants where firstName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param firstName the first name
    * @param start the lower bound of the range of applicants
    * @param end the upper bound of the range of applicants (not inclusive)
    * @return the range of matching applicants
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.services.model.Applicant> findByname(
        java.lang.String firstName, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByname(firstName, start, end);
    }

    /**
    * Returns an ordered range of all the applicants where firstName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param firstName the first name
    * @param start the lower bound of the range of applicants
    * @param end the upper bound of the range of applicants (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching applicants
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.services.model.Applicant> findByname(
        java.lang.String firstName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByname(firstName, start, end, orderByComparator);
    }

    /**
    * Returns the first applicant in the ordered set where firstName = &#63;.
    *
    * @param firstName the first name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching applicant
    * @throws com.liferay.services.NoSuchApplicantException if a matching applicant could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.services.model.Applicant findByname_First(
        java.lang.String firstName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.services.NoSuchApplicantException {
        return getPersistence().findByname_First(firstName, orderByComparator);
    }

    /**
    * Returns the first applicant in the ordered set where firstName = &#63;.
    *
    * @param firstName the first name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching applicant, or <code>null</code> if a matching applicant could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.services.model.Applicant fetchByname_First(
        java.lang.String firstName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByname_First(firstName, orderByComparator);
    }

    /**
    * Returns the last applicant in the ordered set where firstName = &#63;.
    *
    * @param firstName the first name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching applicant
    * @throws com.liferay.services.NoSuchApplicantException if a matching applicant could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.services.model.Applicant findByname_Last(
        java.lang.String firstName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.services.NoSuchApplicantException {
        return getPersistence().findByname_Last(firstName, orderByComparator);
    }

    /**
    * Returns the last applicant in the ordered set where firstName = &#63;.
    *
    * @param firstName the first name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching applicant, or <code>null</code> if a matching applicant could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.services.model.Applicant fetchByname_Last(
        java.lang.String firstName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByname_Last(firstName, orderByComparator);
    }

    /**
    * Returns the applicants before and after the current applicant in the ordered set where firstName = &#63;.
    *
    * @param applicantId the primary key of the current applicant
    * @param firstName the first name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next applicant
    * @throws com.liferay.services.NoSuchApplicantException if a applicant with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.services.model.Applicant[] findByname_PrevAndNext(
        long applicantId, java.lang.String firstName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.services.NoSuchApplicantException {
        return getPersistence()
                   .findByname_PrevAndNext(applicantId, firstName,
            orderByComparator);
    }

    /**
    * Returns all the applicants.
    *
    * @return the applicants
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.services.model.Applicant> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.liferay.services.model.Applicant> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the applicants.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of applicants
    * @param end the upper bound of the range of applicants (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of applicants
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.services.model.Applicant> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the applicants where firstName = &#63; from the database.
    *
    * @param firstName the first name
    * @throws SystemException if a system exception occurred
    */
    public static void removeByname(java.lang.String firstName)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByname(firstName);
    }

    /**
    * Removes all the applicants from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of applicants where firstName = &#63;.
    *
    * @param firstName the first name
    * @return the number of matching applicants
    * @throws SystemException if a system exception occurred
    */
    public static int countByname(java.lang.String firstName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByname(firstName);
    }

    /**
    * Returns the number of applicants.
    *
    * @return the number of applicants
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ApplicantPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ApplicantPersistence) PortletBeanLocatorUtil.locate(com.liferay.services.service.ClpSerializer.getServletContextName(),
                    ApplicantPersistence.class.getName());

            ReferenceRegistry.registerReference(ApplicantUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(ApplicantPersistence persistence) {
    }
}
