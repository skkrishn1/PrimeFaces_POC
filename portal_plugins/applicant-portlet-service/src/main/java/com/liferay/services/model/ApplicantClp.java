package com.liferay.services.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.services.service.ApplicantLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ApplicantClp extends BaseModelImpl<Applicant> implements Applicant {
    private long _applicantId;
    private String _firstName;
    private String _middleName;
    private String _lastName;
    private String _qualifications;
    private String _addressLine1;
    private String _addressLine2;
    private String _city;
    private String _street;
    private String _postCode;
    private Date _createDate;
    private Date _modifiedDate;
    private BaseModel<?> _applicantRemoteModel;

    public ApplicantClp() {
    }

    public Class<?> getModelClass() {
        return Applicant.class;
    }

    public String getModelClassName() {
        return Applicant.class.getName();
    }

    public long getPrimaryKey() {
        return _applicantId;
    }

    public void setPrimaryKey(long primaryKey) {
        setApplicantId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_applicantId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
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

    @Override
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

    public long getApplicantId() {
        return _applicantId;
    }

    public void setApplicantId(long applicantId) {
        _applicantId = applicantId;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    public String getMiddleName() {
        return _middleName;
    }

    public void setMiddleName(String middleName) {
        _middleName = middleName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    public String getQualifications() {
        return _qualifications;
    }

    public void setQualifications(String qualifications) {
        _qualifications = qualifications;
    }

    public String getAddressLine1() {
        return _addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        _addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return _addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        _addressLine2 = addressLine2;
    }

    public String getCity() {
        return _city;
    }

    public void setCity(String city) {
        _city = city;
    }

    public String getStreet() {
        return _street;
    }

    public void setStreet(String street) {
        _street = street;
    }

    public String getPostCode() {
        return _postCode;
    }

    public void setPostCode(String postCode) {
        _postCode = postCode;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public BaseModel<?> getApplicantRemoteModel() {
        return _applicantRemoteModel;
    }

    public void setApplicantRemoteModel(BaseModel<?> applicantRemoteModel) {
        _applicantRemoteModel = applicantRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            ApplicantLocalServiceUtil.addApplicant(this);
        } else {
            ApplicantLocalServiceUtil.updateApplicant(this);
        }
    }

    @Override
    public Applicant toEscapedModel() {
        return (Applicant) Proxy.newProxyInstance(Applicant.class.getClassLoader(),
            new Class[] { Applicant.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ApplicantClp clone = new ApplicantClp();

        clone.setApplicantId(getApplicantId());
        clone.setFirstName(getFirstName());
        clone.setMiddleName(getMiddleName());
        clone.setLastName(getLastName());
        clone.setQualifications(getQualifications());
        clone.setAddressLine1(getAddressLine1());
        clone.setAddressLine2(getAddressLine2());
        clone.setCity(getCity());
        clone.setStreet(getStreet());
        clone.setPostCode(getPostCode());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());

        return clone;
    }

    public int compareTo(Applicant applicant) {
        int value = 0;

        value = getFirstName().compareTo(applicant.getFirstName());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        ApplicantClp applicant = null;

        try {
            applicant = (ApplicantClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = applicant.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(25);

        sb.append("{applicantId=");
        sb.append(getApplicantId());
        sb.append(", firstName=");
        sb.append(getFirstName());
        sb.append(", middleName=");
        sb.append(getMiddleName());
        sb.append(", lastName=");
        sb.append(getLastName());
        sb.append(", qualifications=");
        sb.append(getQualifications());
        sb.append(", addressLine1=");
        sb.append(getAddressLine1());
        sb.append(", addressLine2=");
        sb.append(getAddressLine2());
        sb.append(", city=");
        sb.append(getCity());
        sb.append(", street=");
        sb.append(getStreet());
        sb.append(", postCode=");
        sb.append(getPostCode());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(40);

        sb.append("<model><model-name>");
        sb.append("com.liferay.services.model.Applicant");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>applicantId</column-name><column-value><![CDATA[");
        sb.append(getApplicantId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>firstName</column-name><column-value><![CDATA[");
        sb.append(getFirstName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>middleName</column-name><column-value><![CDATA[");
        sb.append(getMiddleName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lastName</column-name><column-value><![CDATA[");
        sb.append(getLastName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>qualifications</column-name><column-value><![CDATA[");
        sb.append(getQualifications());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>addressLine1</column-name><column-value><![CDATA[");
        sb.append(getAddressLine1());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>addressLine2</column-name><column-value><![CDATA[");
        sb.append(getAddressLine2());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>city</column-name><column-value><![CDATA[");
        sb.append(getCity());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>street</column-name><column-value><![CDATA[");
        sb.append(getStreet());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>postCode</column-name><column-value><![CDATA[");
        sb.append(getPostCode());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
