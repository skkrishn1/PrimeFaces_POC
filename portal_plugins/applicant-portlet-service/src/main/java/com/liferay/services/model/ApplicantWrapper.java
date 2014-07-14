package com.liferay.services.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Applicant}.
 * </p>
 *
 * @author    Suresh Kumar
 * @see       Applicant
 * @generated
 */
public class ApplicantWrapper implements Applicant, ModelWrapper<Applicant> {
    private Applicant _applicant;

    public ApplicantWrapper(Applicant applicant) {
        _applicant = applicant;
    }

    public Class<?> getModelClass() {
        return Applicant.class;
    }

    public String getModelClassName() {
        return Applicant.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("applicantId", getApplicantId());
        attributes.put("firstName", getFirstName());
        attributes.put("middleName", getMiddleName());
        attributes.put("lastName", getLastName());
        attributes.put("qualifications", getQualifications());
        attributes.put("addressLine1", getAddressLine1());
        attributes.put("addressLine2", getAddressLine2());
        attributes.put("city", getCity());
        attributes.put("street", getStreet());
        attributes.put("postCode", getPostCode());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long applicantId = (Long) attributes.get("applicantId");

        if (applicantId != null) {
            setApplicantId(applicantId);
        }

        String firstName = (String) attributes.get("firstName");

        if (firstName != null) {
            setFirstName(firstName);
        }

        String middleName = (String) attributes.get("middleName");

        if (middleName != null) {
            setMiddleName(middleName);
        }

        String lastName = (String) attributes.get("lastName");

        if (lastName != null) {
            setLastName(lastName);
        }

        String qualifications = (String) attributes.get("qualifications");

        if (qualifications != null) {
            setQualifications(qualifications);
        }

        String addressLine1 = (String) attributes.get("addressLine1");

        if (addressLine1 != null) {
            setAddressLine1(addressLine1);
        }

        String addressLine2 = (String) attributes.get("addressLine2");

        if (addressLine2 != null) {
            setAddressLine2(addressLine2);
        }

        String city = (String) attributes.get("city");

        if (city != null) {
            setCity(city);
        }

        String street = (String) attributes.get("street");

        if (street != null) {
            setStreet(street);
        }

        String postCode = (String) attributes.get("postCode");

        if (postCode != null) {
            setPostCode(postCode);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }
    }

    /**
    * Returns the primary key of this applicant.
    *
    * @return the primary key of this applicant
    */
    public long getPrimaryKey() {
        return _applicant.getPrimaryKey();
    }

    /**
    * Sets the primary key of this applicant.
    *
    * @param primaryKey the primary key of this applicant
    */
    public void setPrimaryKey(long primaryKey) {
        _applicant.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the applicant ID of this applicant.
    *
    * @return the applicant ID of this applicant
    */
    public long getApplicantId() {
        return _applicant.getApplicantId();
    }

    /**
    * Sets the applicant ID of this applicant.
    *
    * @param applicantId the applicant ID of this applicant
    */
    public void setApplicantId(long applicantId) {
        _applicant.setApplicantId(applicantId);
    }

    /**
    * Returns the first name of this applicant.
    *
    * @return the first name of this applicant
    */
    public java.lang.String getFirstName() {
        return _applicant.getFirstName();
    }

    /**
    * Sets the first name of this applicant.
    *
    * @param firstName the first name of this applicant
    */
    public void setFirstName(java.lang.String firstName) {
        _applicant.setFirstName(firstName);
    }

    /**
    * Returns the middle name of this applicant.
    *
    * @return the middle name of this applicant
    */
    public java.lang.String getMiddleName() {
        return _applicant.getMiddleName();
    }

    /**
    * Sets the middle name of this applicant.
    *
    * @param middleName the middle name of this applicant
    */
    public void setMiddleName(java.lang.String middleName) {
        _applicant.setMiddleName(middleName);
    }

    /**
    * Returns the last name of this applicant.
    *
    * @return the last name of this applicant
    */
    public java.lang.String getLastName() {
        return _applicant.getLastName();
    }

    /**
    * Sets the last name of this applicant.
    *
    * @param lastName the last name of this applicant
    */
    public void setLastName(java.lang.String lastName) {
        _applicant.setLastName(lastName);
    }

    /**
    * Returns the qualifications of this applicant.
    *
    * @return the qualifications of this applicant
    */
    public java.lang.String getQualifications() {
        return _applicant.getQualifications();
    }

    /**
    * Sets the qualifications of this applicant.
    *
    * @param qualifications the qualifications of this applicant
    */
    public void setQualifications(java.lang.String qualifications) {
        _applicant.setQualifications(qualifications);
    }

    /**
    * Returns the address line1 of this applicant.
    *
    * @return the address line1 of this applicant
    */
    public java.lang.String getAddressLine1() {
        return _applicant.getAddressLine1();
    }

    /**
    * Sets the address line1 of this applicant.
    *
    * @param addressLine1 the address line1 of this applicant
    */
    public void setAddressLine1(java.lang.String addressLine1) {
        _applicant.setAddressLine1(addressLine1);
    }

    /**
    * Returns the address line2 of this applicant.
    *
    * @return the address line2 of this applicant
    */
    public java.lang.String getAddressLine2() {
        return _applicant.getAddressLine2();
    }

    /**
    * Sets the address line2 of this applicant.
    *
    * @param addressLine2 the address line2 of this applicant
    */
    public void setAddressLine2(java.lang.String addressLine2) {
        _applicant.setAddressLine2(addressLine2);
    }

    /**
    * Returns the city of this applicant.
    *
    * @return the city of this applicant
    */
    public java.lang.String getCity() {
        return _applicant.getCity();
    }

    /**
    * Sets the city of this applicant.
    *
    * @param city the city of this applicant
    */
    public void setCity(java.lang.String city) {
        _applicant.setCity(city);
    }

    /**
    * Returns the street of this applicant.
    *
    * @return the street of this applicant
    */
    public java.lang.String getStreet() {
        return _applicant.getStreet();
    }

    /**
    * Sets the street of this applicant.
    *
    * @param street the street of this applicant
    */
    public void setStreet(java.lang.String street) {
        _applicant.setStreet(street);
    }

    /**
    * Returns the post code of this applicant.
    *
    * @return the post code of this applicant
    */
    public java.lang.String getPostCode() {
        return _applicant.getPostCode();
    }

    /**
    * Sets the post code of this applicant.
    *
    * @param postCode the post code of this applicant
    */
    public void setPostCode(java.lang.String postCode) {
        _applicant.setPostCode(postCode);
    }

    /**
    * Returns the create date of this applicant.
    *
    * @return the create date of this applicant
    */
    public java.util.Date getCreateDate() {
        return _applicant.getCreateDate();
    }

    /**
    * Sets the create date of this applicant.
    *
    * @param createDate the create date of this applicant
    */
    public void setCreateDate(java.util.Date createDate) {
        _applicant.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this applicant.
    *
    * @return the modified date of this applicant
    */
    public java.util.Date getModifiedDate() {
        return _applicant.getModifiedDate();
    }

    /**
    * Sets the modified date of this applicant.
    *
    * @param modifiedDate the modified date of this applicant
    */
    public void setModifiedDate(java.util.Date modifiedDate) {
        _applicant.setModifiedDate(modifiedDate);
    }

    public boolean isNew() {
        return _applicant.isNew();
    }

    public void setNew(boolean n) {
        _applicant.setNew(n);
    }

    public boolean isCachedModel() {
        return _applicant.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _applicant.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _applicant.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _applicant.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _applicant.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _applicant.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _applicant.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ApplicantWrapper((Applicant) _applicant.clone());
    }

    public int compareTo(Applicant applicant) {
        return _applicant.compareTo(applicant);
    }

    @Override
    public int hashCode() {
        return _applicant.hashCode();
    }

    public com.liferay.portal.model.CacheModel<Applicant> toCacheModel() {
        return _applicant.toCacheModel();
    }

    public Applicant toEscapedModel() {
        return new ApplicantWrapper(_applicant.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _applicant.toString();
    }

    public java.lang.String toXmlString() {
        return _applicant.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _applicant.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Applicant getWrappedApplicant() {
        return _applicant;
    }

    public Applicant getWrappedModel() {
        return _applicant;
    }

    public void resetOriginalValues() {
        _applicant.resetOriginalValues();
    }
}
