package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USERS_TAB")
public class User {
	@Id
	@GeneratedValue(generator="user",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="user",sequenceName="user_seq")
	@Column(name="u_id")
	private int userId;
	@Column(name="u_first_name")
	private String userFirstName;
	@Column(name="u_last_name")
	private String userLastName;
	@Column(name="u_mail")
	private String userEmail;
	@Column(name="u_sec_mail")
	private String userSecEmail;
	@Column(name="u_mobile")
	private String mobileNum;
	@Column(name="Birthday")
	private String dob;
	@Column(name="Gender")
	private String userGender;
	@Column(name="u_pwd")
	private String userPwd;
	@ManyToOne
	@JoinColumn(name="AddressFkId")
	public Address addr;
	@ManyToOne
	@JoinColumn(name="ProfilePictureFkId")
	public ProfilePicture proImage;
	public User() {
		super();
	}
	public User(int userId) {
		super();
		this.userId = userId;
	}
	public User(int userId, String userFirstName) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
	}
	public User(int userId, String userFirstName, String userLastName) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
	}
	public User(int userId, String userFirstName, String userLastName, String userEmail) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
	}
	public User(int userId, String userFirstName, String userLastName, String userEmail, String userSecEmail) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userSecEmail = userSecEmail;
	}
	public User(int userId, String userFirstName, String userLastName, String userEmail, String userSecEmail,
			String mobileNum) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userSecEmail = userSecEmail;
		this.mobileNum = mobileNum;
	}
	public User(int userId, String userFirstName, String userLastName, String userEmail, String userSecEmail,
			String mobileNum, String dob) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userSecEmail = userSecEmail;
		this.mobileNum = mobileNum;
		this.dob = dob;
	}
	public User(int userId, String userFirstName, String userLastName, String userEmail, String userSecEmail,
			String mobileNum, String dob, String userGender) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userSecEmail = userSecEmail;
		this.mobileNum = mobileNum;
		this.dob = dob;
		this.userGender = userGender;
	}
	public User(int userId, String userFirstName, String userLastName, String userEmail, String userSecEmail,
			String mobileNum, String dob, String userGender, String userPwd) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userSecEmail = userSecEmail;
		this.mobileNum = mobileNum;
		this.dob = dob;
		this.userGender = userGender;
		this.userPwd = userPwd;
	}
	public User(int userId, String userFirstName, String userLastName, String userEmail, String userSecEmail,
			String mobileNum, String dob, String userGender, String userPwd, Address addr) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userSecEmail = userSecEmail;
		this.mobileNum = mobileNum;
		this.dob = dob;
		this.userGender = userGender;
		this.userPwd = userPwd;
		this.addr = addr;
	}
	public User(int userId, String userFirstName, String userLastName, String userEmail, String userSecEmail,
			String mobileNum, String dob, String userGender, String userPwd, Address addr, ProfilePicture proImage) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userSecEmail = userSecEmail;
		this.mobileNum = mobileNum;
		this.dob = dob;
		this.userGender = userGender;
		this.userPwd = userPwd;
		this.addr = addr;
		this.proImage = proImage;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userEmail=" + userEmail + ", userSecEmail=" + userSecEmail + ", mobileNum=" + mobileNum + ", dob="
				+ dob + ", userGender=" + userGender + ", userPwd=" + userPwd + ", addr=" + addr + ", proImage="
				+ proImage + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((mobileNum == null) ? 0 : mobileNum.hashCode());
		result = prime * result + ((proImage == null) ? 0 : proImage.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userFirstName == null) ? 0 : userFirstName.hashCode());
		result = prime * result + ((userGender == null) ? 0 : userGender.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userLastName == null) ? 0 : userLastName.hashCode());
		result = prime * result + ((userPwd == null) ? 0 : userPwd.hashCode());
		result = prime * result + ((userSecEmail == null) ? 0 : userSecEmail.hashCode());
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
		User other = (User) obj;
		if (addr == null) {
			if (other.addr != null)
				return false;
		} else if (!addr.equals(other.addr))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (mobileNum == null) {
			if (other.mobileNum != null)
				return false;
		} else if (!mobileNum.equals(other.mobileNum))
			return false;
		if (proImage == null) {
			if (other.proImage != null)
				return false;
		} else if (!proImage.equals(other.proImage))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userFirstName == null) {
			if (other.userFirstName != null)
				return false;
		} else if (!userFirstName.equals(other.userFirstName))
			return false;
		if (userGender == null) {
			if (other.userGender != null)
				return false;
		} else if (!userGender.equals(other.userGender))
			return false;
		if (userId != other.userId)
			return false;
		if (userLastName == null) {
			if (other.userLastName != null)
				return false;
		} else if (!userLastName.equals(other.userLastName))
			return false;
		if (userPwd == null) {
			if (other.userPwd != null)
				return false;
		} else if (!userPwd.equals(other.userPwd))
			return false;
		if (userSecEmail == null) {
			if (other.userSecEmail != null)
				return false;
		} else if (!userSecEmail.equals(other.userSecEmail))
			return false;
		return true;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserSecEmail() {
		return userSecEmail;
	}
	public void setUserSecEmail(String userSecEmail) {
		this.userSecEmail = userSecEmail;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public ProfilePicture getProImage() {
		return proImage;
	}
	public void setProImage(ProfilePicture proImage) {
		this.proImage = proImage;
	}
	
}