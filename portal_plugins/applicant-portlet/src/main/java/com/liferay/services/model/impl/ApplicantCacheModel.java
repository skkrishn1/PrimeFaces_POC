package com.liferay.services.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.services.model.Applicant;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Applicant in entity cache.
 *
 * @author Suresh Kumar
 * @see Applicant
 * @generated
 */
public class ApplicantCacheModel implements CacheModel<Applicant>, Serializable {
    public long applicantId;
    public String firstName;
    public String middleName;
    public String lastName;
    public String qualifications;
    public String addressLine1;
    public String addressLine2;
    public String city;
    public String street;
    public String postCode;
    public long createDate;
    public long modifiedDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(25);

        sb.append("{applicantId=");
        sb.append(applicantId);
        sb.append(", firstName=");
        sb.append(firstName);
        sb.append(", middleName=");
        sb.append(middleName);
        sb.append(", lastName=");
        sb.append(lastName);
        sb.append(", qualifications=");
        sb.append(qualifications);
        sb.append(", addressLine1=");
        sb.append(addressLine1);
        sb.append(", addressLine2=");
        sb.append(addressLine2);
        sb.append(", city=");
        sb.append(city);
        sb.append(", street=");
        sb.append(street);
        sb.append(", postCode=");
        sb.append(postCode);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append("}");

        return sb.toString();
    }

    public Applicant toEntityModel() {
        ApplicantImpl applicantImpl = new ApplicantImpl();

        applicantImpl.setApplicantId(applicantId);

        if (firstName == null) {
            applicantImpl.setFirstName(StringPool.BLANK);
        } else {
            applicantImpl.setFirstName(firstName);
        }

        if (middleName == null) {
            applicantImpl.setMiddleName(StringPool.BLANK);
        } else {
            applicantImpl.setMiddleName(middleName);
        }

        if (lastName == null) {
            applicantImpl.setLastName(StringPool.BLANK);
        } else {
            applicantImpl.setLastName(lastName);
        }

        if (qualifications == null) {
            applicantImpl.setQualifications(StringPool.BLANK);
        } else {
            applicantImpl.setQualifications(qualifications);
        }

        if (addressLine1 == null) {
            applicantImpl.setAddressLine1(StringPool.BLANK);
        } else {
            applicantImpl.setAddressLine1(addressLine1);
        }

        if (addressLine2 == null) {
            applicantImpl.setAddressLine2(StringPool.BLANK);
        } else {
            applicantImpl.setAddressLine2(addressLine2);
        }

        if (city == null) {
            applicantImpl.setCity(StringPool.BLANK);
        } else {
            applicantImpl.setCity(city);
        }

        if (street == null) {
            applicantImpl.setStreet(StringPool.BLANK);
        } else {
            applicantImpl.setStreet(street);
        }

        if (postCode == null) {
            applicantImpl.setPostCode(StringPool.BLANK);
        } else {
            applicantImpl.setPostCode(postCode);
        }

        if (createDate == Long.MIN_VALUE) {
            applicantImpl.setCreateDate(null);
        } else {
            applicantImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            applicantImpl.setModifiedDate(null);
        } else {
            applicantImpl.setModifiedDate(new Date(modifiedDate));
        }

        applicantImpl.resetOriginalValues();

        return applicantImpl;
    }
}
