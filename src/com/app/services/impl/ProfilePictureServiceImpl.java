package com.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IProfilePictureDao;
import com.app.model.ProfilePicture;
import com.app.services.IProfilePictureService;
@Service
public class ProfilePictureServiceImpl implements IProfilePictureService {
	
	@Autowired
	private IProfilePictureDao dao;
	
	@Override
	public int saveProfilePicture(ProfilePicture pictureObj) {
		return dao.saveProfilePicture(pictureObj);
		
	}
	@Override
	public void updateProfilePicture(ProfilePicture pictureObj) {
		dao.updateProfilePicture(pictureObj);
	}
	@Override
	public ProfilePicture getProfileImageObjById(int profileIamgeId) {
		return dao.getProfileImageObjById(profileIamgeId);
	}
	@Override
	public List<Object[]> getProfileIdAndProfileName() {
		return dao.getProfileIdAndProfileName();
	}
	@Override
	public void deleteUploadProfileImageById(int profileIamgeId) {
		dao.deleteUploadProfileImageById(profileIamgeId);
	}
	

}
