package com.liferay.user.registration.bean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.activation.MimetypesFileTypeMap;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UICommand;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.faces.annotation.BridgePreDestroy;

import org.primefaces.model.UploadedFile;

import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.faces.util.portal.WebKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.FileUtil;
import javax.xml.namespace.QName;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.store.DLStoreUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.services.model.Applicant;
import com.liferay.services.model.impl.ApplicantImpl;
import com.liferay.services.service.ApplicantLocalServiceUtil;
import com.liferay.user.registration.dto.User;


/**
 * @author Suresh.Kumar
 *
 */
@ManagedBean(name = "registrationBackingBean")
@RequestScoped
public class RegistrationBackingBean implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4812893367562762456L;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(RegistrationBackingBean.class);

	/** The registration model bean. */
	@ManagedProperty(name = "registrationModelBean", value = "#{registrationModelBean}")
	private RegistrationModelBean registrationModelBean;

	/** The file. */
	private UploadedFile file;

	/**
	 * Bridge pre destroy.
	 */
	@BridgePreDestroy
	public void bridgePreDestroy() {
		logger.trace("@BridgePreDestroy annotation worked -- should only be called if com.liferay.faces.bridge.preferPreDestroy "
				+ "init param is false in portlet.xml");
	}

	/**
	 * Submit.
	 * 
	 * @param event
	 *            the event
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void submit(ActionEvent event) throws IOException, SystemException,
			PortalException {

		/*QName qName = new QName("http://liferay.com/events","ipc.applicantEdited");
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		ActionResponse actionResponse = (ActionResponse) externalContext.getResponse();
		actionResponse.setEvent(qName, registrationModelBean.getUser());*/
		PortletRequest portletRequest = (PortletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long fileEntryId = processFileUpload(portletRequest, themeDisplay);
		if(fileEntryId !=0) {
		addApplicant(fileEntryId);
		} else {
			FacesMessage msg = new FacesMessage("There is an Error in adding Applicant");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			logger.info("Error in Adding Applicant");
		}
	}

	/**
	 * @param portletRequest
	 * @param themeDisplay
	 * @return long
	 * @throws IOException
	 * @throws PortalException
	 * @throws SystemException
	 */
	private long processFileUpload(PortletRequest portletRequest,
			ThemeDisplay themeDisplay) throws IOException, PortalException,
			SystemException {
		long companyId = themeDisplay.getCompanyId();
		long groupId = themeDisplay.getScopeGroupId();
		long repositoryId = themeDisplay.getScopeGroupId();
		long fileEntryId = 0l;
		if(file !=null) {
		String fileName = getFileName();
		InputStream fileStream = file.getInputstream();
		try {
			File fileIO = createTempFile(fileStream);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), portletRequest);
			createFileUploadDirectory(companyId, repositoryId);
			// Upload resume into Liferay Document Repository
			fileEntryId = uploadFile(themeDisplay, groupId, fileName, fileStream, fileIO, serviceContext);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		return fileEntryId;
	}

	/**
	 * @return String
	 */
	private String getFileName() {
		
		String fileName = file.getFileName();
		if (fileName.contains("\\")) {
			/*To Resolve FileNameException , IE9 issue with fileName , because of this document was not getting upload in to liferay document repository 
			i.e File Name comes along with absolute path , fucking this makes me frustrated. */
			fileName = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length());
		}
		return fileName;
	}

	private void addApplicant(long fileEntryId) {
		Date dateAdded = new Date();
		Applicant applicant = new ApplicantImpl();
		User user = registrationModelBean.getUser();
		try {
			
			applicant.setApplicantId(fileEntryId);
			applicant.setFirstName(user.getFirstName());
			applicant.setMiddleName(user.getLastName());
			applicant.setLastName(user.getLastName());
			applicant.setQualifications(user.getQualifications());
			applicant.setCreateDate(dateAdded);
			applicant.setModifiedDate(dateAdded);
			applicant = ApplicantLocalServiceUtil.addApplicant(applicant);

			if (applicant != null) {
				FacesMessage msg = new FacesMessage(
						"Applicant was Added Successfully", " with applicantId"
								+ fileEntryId);
				FacesContext.getCurrentInstance().addMessage(null, msg);
				logger.info("Applicant have been added successfylly");
			} else {
				FacesMessage msg = new FacesMessage(
						"There is an Erron in adding Applicant");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				logger.info("Error in Adding Applicant");
			}

		} catch (SystemException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * @param fileStream
	 * @return
	 */
	private File createTempFile(InputStream fileStream) {
		File fileIO = null;

		try {
			fileIO = FileUtil.createTempFile(fileStream);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		return fileIO;
	}

	/**
	 * @param companyId
	 * @param repositoryId
	 * @param dirName
	 */
	private void createFileUploadDirectory(long companyId, long repositoryId) {
		boolean dirExists = false;
		String dirName = "applicant_resumes";

		try {
			dirExists = DLStoreUtil.hasDirectory(companyId, repositoryId, dirName);
		} catch (PortalException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}

		if (!dirExists) {
			try {
				DLStoreUtil.addDirectory(companyId, repositoryId, dirName);
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param themeDisplay
	 * @param groupId
	 * @param fileName
	 * @param fileStream
	 * @param fileIO
	 */
	private long uploadFile(ThemeDisplay themeDisplay, long groupId,
			String fileName, InputStream fileStream, File fileIO,
			ServiceContext serviceContext) {
		long fileEntryId = 0l;
		try {

			Map<String, Fields> fieldsMap = new HashMap<String, Fields>();

			DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.addFileEntry(
					themeDisplay.getUserId(), groupId, groupId, groupId,
					fileName,
					new MimetypesFileTypeMap().getContentType(fileIO),
					fileName, fileName, "", 0L, fieldsMap, fileIO, fileStream,
					fileIO.length(), serviceContext);

			fileEntryId = dlFileEntry.getFileEntryId();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return fileEntryId;
	}

	/**
	 * Gets the registration model bean.
	 * 
	 * @return the registration model bean
	 */
	public RegistrationModelBean getRegistrationModelBean() {
		return registrationModelBean;
	}

	/**
	 * Sets the registration model bean.
	 * 
	 * @param registrationModelBean
	 *            the new registration model bean
	 */
	public void setRegistrationModelBean(
			RegistrationModelBean registrationModelBean) {
		this.registrationModelBean = registrationModelBean;
	}

	/**
	 * Gets the file.
	 * 
	 * @return the file
	 */
	public UploadedFile getFile() {

		return file;
	}

	/**
	 * Sets the file.
	 * 
	 * @param file
	 *            the new file
	 */
	public void setFile(UploadedFile file) {

		this.file = file;
	}

}
