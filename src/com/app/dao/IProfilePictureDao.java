package com.app.dao;

import java.util.List;

import com.app.model.ProfilePicture;
public interface IProfilePictureDao {

	public int saveProfilePicture(ProfilePicture pictureObj);
	public void updateProfilePicture(ProfilePicture pictureObj);
	public List<Object[]> getProfileIdAndProfileName();
	public ProfilePicture getProfileImageObjById(int profileIamgeId);
	public void deleteUploadProfileImageById(int profileIamgeId );
}
