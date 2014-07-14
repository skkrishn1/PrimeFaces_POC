package com.liferay.applicants.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.services.model.Applicant;
import com.liferay.services.service.ApplicantLocalServiceUtil;
import com.liferay.user.registration.dto.User;


/**
 * @author  Suresh Kumar
 */
@ManagedBean(name = "applicantsViewModelBean")
@RequestScoped
public class ApplicantsViewModelBean implements Serializable {

 

	/**
	 * 
	 */
	private static final long serialVersionUID = -3073469379523232662L;

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(ApplicantsViewModelBean.class);

 	// Private Bean Properties
	private List<User> allApplicants =null;
	
	private User selectedUser;

	private String firstName;
	
	@PostConstruct
	public void postConstruct() {
		logger.trace("@PostConstruct annotation worked");
		
	}

	@PreDestroy
	public void preDestroy() {
		logger.trace("@PreDestroy annotation worked");
	}

	public List<User> getAllApplicants() {
		int count=0;
		try {
			count=ApplicantLocalServiceUtil.getApplicantsCount();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			List<Applicant> applicantsList = ApplicantLocalServiceUtil.getApplicants(0, count);
			
			allApplicants = new ArrayList<User>();
			for(Applicant applicant : applicantsList) {
				User user = new User();
				DLFileEntry dlFlieEntry = DLFileEntryLocalServiceUtil.fetchDLFileEntry(applicant.getApplicantId());
				user.setFileName(dlFlieEntry.getTitle());
				user.setApplicantId(applicant.getApplicantId());
				user.setFirstName(applicant.getFirstName());
				user.setLastName(applicant.getLastName());
				user.setMiddleName(applicant.getMiddleName());
				allApplicants.add(user);
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return allApplicants;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	 
}
