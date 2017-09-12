package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IProfilePictureDao;
import com.app.model.ProfilePicture;
@Repository
public class ProfilePictureDaoImpl  implements IProfilePictureDao{
	
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveProfilePicture(ProfilePicture pictureObj) {
		 return (int) ht.save(pictureObj);
		
	}
	@Override
	public void updateProfilePicture(ProfilePicture pictureObj) {
		ht.update(pictureObj);	
	}
	@Override
	public List<Object[]> getProfileIdAndProfileName() {
		String hql="select profileIamgeId,profileImageName from com.app.model.ProfilePicture"; 
		@SuppressWarnings("unchecked")
		List<Object[]> find = (List<Object[]>)ht.find(hql);
		return find;
	}
	@Override
	public ProfilePicture getProfileImageObjById(int profileIamgeId) {
		return ht.get(ProfilePicture.class, profileIamgeId);
	}
	
	@Override
	public void deleteUploadProfileImageById(int profileIamgeId) {
		ht.delete(new ProfilePicture(profileIamgeId));
	}
}
