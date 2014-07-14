package com.liferay.services.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.services.model.Applicant;

/**
 * The persistence interface for the applicant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Suresh Kumar
 * @see ApplicantPersistenceImpl
 * @see ApplicantUtil
 * @generated
 */
public interface ApplicantPersistence extends BasePersistence<Applicant> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ApplicantUtil} to access the applicant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the applicant in the entity cache if it is enabled.
    *
    * @param applicant the applicant
    */
    public void cacheResult(com.liferay.services.model.Applicant applicant);

    /**
    * Caches the applicants in the entity cache if it is enabled.
    *
    * @param applicants the applicants
    */
    public void cacheResult(
        java.util.List<com.liferay.services.model.Applicant> applicants);

    /**
    * Creates a new applicant with the primary key. Does not add the applicant to the database.
    *
    * @param applicantId the primary key for the new applicant
    * @return the new applicant
    */
    public com.liferay.services.model.Applicant create(long applicantId);

    /**
    * Removes the applicant with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param applicantId the primary key of the applicant
    * @return the applicant that was removed
    * @throws com.liferay.services.NoSuchApplicantException if a applicant with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.services.model.Applicant remove(long applicantId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.services.NoSuchApplicantException;

    public com.liferay.services.model.Applicant updateImpl(
        com.liferay.services.model.Applicant applicant, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the applicant with the primary key or throws a {@link com.liferay.services.NoSuchApplicantException} if it could not be found.
    *
    * @param applicantId the primary key of the applicant
    * @return the applicant
    * @throws com.liferay.services.NoSuchApplicantException if a applicant with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.services.model.Applicant findByPrimaryKey(
        long applicantId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.services.NoSuchApplicantException;

    /**
    * Returns the applicant with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param applicantId the primary key of the applicant
    * @return the applicant, or <code>null</code> if a applicant with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.services.model.Applicant fetchByPrimaryKey(
        long applicantId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the applicants where firstName = &#63;.
    *
    * @param firstName the first name
    * @return the matching applicants
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.services.model.Applicant> findByname(
        java.lang.String firstName)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.services.model.Applicant> findByname(
        java.lang.String firstName, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.services.model.Applicant> findByname(
        java.lang.String firstName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first applicant in the ordered set where firstName = &#63;.
    *
    * @param firstName the first name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching applicant
    * @throws com.liferay.services.NoSuchApplicantException if a matching applicant could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.services.model.Applicant findByname_First(
        java.lang.String firstName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.services.NoSuchApplicantException;

    /**
    * Returns the first applicant in the ordered set where firstName = &#63;.
    *
    * @param firstName the first name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching applicant, or <code>null</code> if a matching applicant could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.services.model.Applicant fetchByname_First(
        java.lang.String firstName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last applicant in the ordered set where firstName = &#63;.
    *
    * @param firstName the first name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching applicant
    * @throws com.liferay.services.NoSuchApplicantException if a matching applicant could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.services.model.Applicant findByname_Last(
        java.lang.String firstName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.services.NoSuchApplicantException;

    /**
    * Returns the last applicant in the ordered set where firstName = &#63;.
    *
    * @param firstName the first name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching applicant, or <code>null</code> if a matching applicant could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.services.model.Applicant fetchByname_Last(
        java.lang.String firstName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.services.model.Applicant[] findByname_PrevAndNext(
        long applicantId, java.lang.String firstName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.services.NoSuchApplicantException;

    /**
    * Returns all the applicants.
    *
    * @return the applicants
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.services.model.Applicant> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.services.model.Applicant> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.services.model.Applicant> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the applicants where firstName = &#63; from the database.
    *
    * @param firstName the first name
    * @throws SystemException if a system exception occurred
    */
    public void removeByname(java.lang.String firstName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the applicants from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of applicants where firstName = &#63;.
    *
    * @param firstName the first name
    * @return the number of matching applicants
    * @throws SystemException if a system exception occurred
    */
    public int countByname(java.lang.String firstName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of applicants.
    *
    * @return the number of applicants
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
