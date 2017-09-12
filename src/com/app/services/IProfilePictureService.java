package com.app.services;

import java.util.List;

import com.app.model.ProfilePicture;

public interface IProfilePictureService {
	public int saveProfilePicture(ProfilePicture pictureObj);
	public void updateProfilePicture(ProfilePicture pictureObj);
	public List<Object[]> getProfileIdAndProfileName();
	public ProfilePicture getProfileImageObjById(int profileIamgeId);
	public void deleteUploadProfileImageById(int profileIamgeId );
}
