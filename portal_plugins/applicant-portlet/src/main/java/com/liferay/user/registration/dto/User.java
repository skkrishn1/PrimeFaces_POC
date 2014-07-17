package com.liferay.user.registration.dto;

import java.io.Serializable;

/**
 * 
 *
 * @author Suresh Kumar
 */
public class User implements Serializable {

	// serialVersionUID
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4972283538344519853L;
	
	
	private long applicantId;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The middle name. */
	private String middleName;
	
	/** The qualifications. */
	private String qualifications;
	
	/** The address line1. */
	private String addressLine1;
	
	/** The address line2. */
	private String addressLine2;
	
	/** The city. */
	private String city;
	
	/** The street. */
	private String street;
	
	/** The post code. */
	private String postCode;

	
	private String fileName;

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the middle name.
	 *
	 * @return the middle name
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * Sets the middle name.
	 *
	 * @param middleName the new middle name
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * Gets the qualifications.
	 *
	 * @return the qualifications
	 */
	public String getQualifications() {
		return qualifications;
	}

	/**
	 * Sets the qualifications.
	 *
	 * @param qualifications the new qualifications
	 */
	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

	/**
	 * @return applicantId
	 */
	public long getApplicantId() {
		return applicantId;
	}

	/**
	 * @param applicantId
	 */
	public void setApplicantId(long applicantId) {
		this.applicantId = applicantId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}


}
