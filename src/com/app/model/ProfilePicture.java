package com.app.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PROFILE_IMAGE_TAB")
public class ProfilePicture {
	@Id
	@GeneratedValue(generator="profileimageup",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="profileimageup",sequenceName="profileimageup_seq")
	@Column(name="profile_image_id")
	private int profileIamgeId;
	@Column(name="profile_image_name")
	private String profileImageName;
	/** holds file data in byte[]
	 * format
	 */
	@Lob
	@Column(name="profileImagedata")
	private byte[] prifileImageData;
	public ProfilePicture() {
		super();
	}
	public ProfilePicture(int profileIamgeId) {
		super();
		this.profileIamgeId = profileIamgeId;
	}
	public ProfilePicture(int profileIamgeId, String profileImageName) {
		super();
		this.profileIamgeId = profileIamgeId;
		this.profileImageName = profileImageName;
	}
	public ProfilePicture(int profileIamgeId, String profileImageName, byte[] prifileImageData) {
		super();
		this.profileIamgeId = profileIamgeId;
		this.profileImageName = profileImageName;
		this.prifileImageData = prifileImageData;
	}
	@Override
	public String toString() {
		return "ProfilePicture [profileIamgeId=" + profileIamgeId + ", profileImageName=" + profileImageName
				+ ", prifileImageData=" + Arrays.toString(prifileImageData) + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(prifileImageData);
		result = prime * result + profileIamgeId;
		result = prime * result + ((profileImageName == null) ? 0 : profileImageName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfilePicture other = (ProfilePicture) obj;
		if (!Arrays.equals(prifileImageData, other.prifileImageData))
			return false;
		if (profileIamgeId != other.profileIamgeId)
			return false;
		if (profileImageName == null) {
			if (other.profileImageName != null)
				return false;
		} else if (!profileImageName.equals(other.profileImageName))
			return false;
		return true;
	}
	public int getProfileIamgeId() {
		return profileIamgeId;
	}
	public void setProfileIamgeId(int profileIamgeId) {
		this.profileIamgeId = profileIamgeId;
	}
	public String getProfileImageName() {
		return profileImageName;
	}
	public void setProfileImageName(String profileImageName) {
		this.profileImageName = profileImageName;
	}
	public byte[] getPrifileImageData() {
		return prifileImageData;
	}
	public void setPrifileImageData(byte[] prifileImageData) {
		this.prifileImageData = prifileImageData;
	}
}
