package com.liferay.services.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.services.service.http.ApplicantServiceSoap}.
 *
 * @author    Suresh Kumar
 * @see       com.liferay.services.service.http.ApplicantServiceSoap
 * @generated
 */
public class ApplicantSoap implements Serializable {
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

    public ApplicantSoap() {
    }

    public static ApplicantSoap toSoapModel(Applicant model) {
        ApplicantSoap soapModel = new ApplicantSoap();

        soapModel.setApplicantId(model.getApplicantId());
        soapModel.setFirstName(model.getFirstName());
        soapModel.setMiddleName(model.getMiddleName());
        soapModel.setLastName(model.getLastName());
        soapModel.setQualifications(model.getQualifications());
        soapModel.setAddressLine1(model.getAddressLine1());
        soapModel.setAddressLine2(model.getAddressLine2());
        soapModel.setCity(model.getCity());
        soapModel.setStreet(model.getStreet());
        soapModel.setPostCode(model.getPostCode());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());

        return soapModel;
    }

    public static ApplicantSoap[] toSoapModels(Applicant[] models) {
        ApplicantSoap[] soapModels = new ApplicantSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ApplicantSoap[][] toSoapModels(Applicant[][] models) {
        ApplicantSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ApplicantSoap[models.length][models[0].length];
        } else {
            soapModels = new ApplicantSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ApplicantSoap[] toSoapModels(List<Applicant> models) {
        List<ApplicantSoap> soapModels = new ArrayList<ApplicantSoap>(models.size());

        for (Applicant model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ApplicantSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _applicantId;
    }

    public void setPrimaryKey(long pk) {
        setApplicantId(pk);
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
}
