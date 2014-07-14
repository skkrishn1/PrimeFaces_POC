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
	
	/** The address. */
	private Address address;
	
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
	 * Gets the address.
	 *
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(Address address) {
		this.address = address;
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


}
