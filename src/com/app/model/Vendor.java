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
@Table(name="Vendor_TAB")
public class Vendor {
	@Id
	@GeneratedValue(generator="ven",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="ven",sequenceName="ven_seq")
	@Column(name="v_id")
	private int venId;
	@Column(name="v_first_name")
	private String venFirstName;
	@Column(name="v_last_name")
	private String venLastName;
	@Column(name="v_email")
	private String venEmail;
	@Column(name="v_sec_email")
	private String venSecEmail;
	@Column(name="v_App_No")
	private String venAppNo;
	@Column(name="v_Joining_Date")
	private String venJoinDate;
	@Column(name="v_Prof_Id")
	private String venProfId;
	@Column(name="v_mobile")
	private String venMobile;
	@Column(name="v_dob")
	private String venDob;
	@Column(name="v_gender")
	private String venGender;
	@Column(name="v_pwd")
	private String venPwd;
	@ManyToOne
	@JoinColumn(name="locFk")
	public Location loc;
	@ManyToOne
	@JoinColumn(name="AddressFkId")
	public Address addr;
	@ManyToOne
	@JoinColumn(name="ProfilePictureFkId")
	public ProfilePicture proImage;
	public Vendor() {
		super();
	}
	public Vendor(int venId) {
		super();
		this.venId = venId;
	}
	public Vendor(int venId, String venFirstName) {
		super();
		this.venId = venId;
		this.venFirstName = venFirstName;
	}
	
	public Vendor(int venId, String venFirstName, String venLastName) {
		super();
		this.venId = venId;
		this.venFirstName = venFirstName;
		this.venLastName = venLastName;
	}
	public Vendor(int venId, String venFirstName, String venLastName, String venEmail) {
		super();
		this.venId = venId;
		this.venFirstName = venFirstName;
		this.venLastName = venLastName;
		this.venEmail = venEmail;
	}
	public Vendor(int venId, String venFirstName, String venLastName, String venEmail, String venSecEmail) {
		super();
		this.venId = venId;
		this.venFirstName = venFirstName;
		this.venLastName = venLastName;
		this.venEmail = venEmail;
		this.venSecEmail = venSecEmail;
	}
	public Vendor(int venId, String venFirstName, String venLastName, String venEmail, String venSecEmail,
			String venAppNo) {
		super();
		this.venId = venId;
		this.venFirstName = venFirstName;
		this.venLastName = venLastName;
		this.venEmail = venEmail;
		this.venSecEmail = venSecEmail;
		this.venAppNo = venAppNo;
	}
	public Vendor(int venId, String venFirstName, String venLastName, String venEmail, String venSecEmail,
			String venAppNo, String venJoinDate) {
		super();
		this.venId = venId;
		this.venFirstName = venFirstName;
		this.venLastName = venLastName;
		this.venEmail = venEmail;
		this.venSecEmail = venSecEmail;
		this.venAppNo = venAppNo;
		this.venJoinDate = venJoinDate;
	}
	public Vendor(int venId, String venFirstName, String venLastName, String venEmail, String venSecEmail,
			String venAppNo, String venJoinDate, String venProfId) {
		super();
		this.venId = venId;
		this.venFirstName = venFirstName;
		this.venLastName = venLastName;
		this.venEmail = venEmail;
		this.venSecEmail = venSecEmail;
		this.venAppNo = venAppNo;
		this.venJoinDate = venJoinDate;
		this.venProfId = venProfId;
	}
	public Vendor(int venId, String venFirstName, String venLastName, String venEmail, String venSecEmail,
			String venAppNo, String venJoinDate, String venProfId, String venMobile) {
		super();
		this.venId = venId;
		this.venFirstName = venFirstName;
		this.venLastName = venLastName;
		this.venEmail = venEmail;
		this.venSecEmail = venSecEmail;
		this.venAppNo = venAppNo;
		this.venJoinDate = venJoinDate;
		this.venProfId = venProfId;
		this.venMobile = venMobile;
	}
	public Vendor(int venId, String venFirstName, String venLastName, String venEmail, String venSecEmail,
			String venAppNo, String venJoinDate, String venProfId, String venMobile, String venDob) {
		super();
		this.venId = venId;
		this.venFirstName = venFirstName;
		this.venLastName = venLastName;
		this.venEmail = venEmail;
		this.venSecEmail = venSecEmail;
		this.venAppNo = venAppNo;
		this.venJoinDate = venJoinDate;
		this.venProfId = venProfId;
		this.venMobile = venMobile;
		this.venDob = venDob;
	}
	public Vendor(int venId, String venFirstName, String venLastName, String venEmail, String venSecEmail,
			String venAppNo, String venJoinDate, String venProfId, String venMobile, String venDob, String venGender) {
		super();
		this.venId = venId;
		this.venFirstName = venFirstName;
		this.venLastName = venLastName;
		this.venEmail = venEmail;
		this.venSecEmail = venSecEmail;
		this.venAppNo = venAppNo;
		this.venJoinDate = venJoinDate;
		this.venProfId = venProfId;
		this.venMobile = venMobile;
		this.venDob = venDob;
		this.venGender = venGender;
	}
	public Vendor(int venId, String venFirstName, String venLastName, String venEmail, String venSecEmail,
			String venAppNo, String venJoinDate, String venProfId, String venMobile, String venDob, String venGender,
			String venPwd) {
		super();
		this.venId = venId;
		this.venFirstName = venFirstName;
		this.venLastName = venLastName;
		this.venEmail = venEmail;
		this.venSecEmail = venSecEmail;
		this.venAppNo = venAppNo;
		this.venJoinDate = venJoinDate;
		this.venProfId = venProfId;
		this.venMobile = venMobile;
		this.venDob = venDob;
		this.venGender = venGender;
		this.venPwd = venPwd;
	}
	public Vendor(int venId, String venFirstName, String venLastName, String venEmail, String venSecEmail,
			String venAppNo, String venJoinDate, String venProfId, String venMobile, String venDob, String venGender,
			String venPwd, Location loc) {
		super();
		this.venId = venId;
		this.venFirstName = venFirstName;
		this.venLastName = venLastName;
		this.venEmail = venEmail;
		this.venSecEmail = venSecEmail;
		this.venAppNo = venAppNo;
		this.venJoinDate = venJoinDate;
		this.venProfId = venProfId;
		this.venMobile = venMobile;
		this.venDob = venDob;
		this.venGender = venGender;
		this.venPwd = venPwd;
		this.loc = loc;
	}
	public Vendor(int venId, String venFirstName, String venLastName, String venEmail, String venSecEmail,
			String venAppNo, String venJoinDate, String venProfId, String venMobile, String venDob, String venGender,
			String venPwd, Location loc, Address addr) {
		super();
		this.venId = venId;
		this.venFirstName = venFirstName;
		this.venLastName = venLastName;
		this.venEmail = venEmail;
		this.venSecEmail = venSecEmail;
		this.venAppNo = venAppNo;
		this.venJoinDate = venJoinDate;
		this.venProfId = venProfId;
		this.venMobile = venMobile;
		this.venDob = venDob;
		this.venGender = venGender;
		this.venPwd = venPwd;
		this.loc = loc;
		this.addr = addr;
	}
	public Vendor(int venId, String venFirstName, String venLastName, String venEmail, String venSecEmail,
			String venAppNo, String venJoinDate, String venProfId, String venMobile, String venDob, String venGender,
			String venPwd, Location loc, Address addr, ProfilePicture proImage) {
		super();
		this.venId = venId;
		this.venFirstName = venFirstName;
		this.venLastName = venLastName;
		this.venEmail = venEmail;
		this.venSecEmail = venSecEmail;
		this.venAppNo = venAppNo;
		this.venJoinDate = venJoinDate;
		this.venProfId = venProfId;
		this.venMobile = venMobile;
		this.venDob = venDob;
		this.venGender = venGender;
		this.venPwd = venPwd;
		this.loc = loc;
		this.addr = addr;
		this.proImage = proImage;
	}
	@Override
	public String toString() {
		return "Vendor [venId=" + venId + ", venFirstName=" + venFirstName + ", venLastName=" + venLastName
				+ ", venEmail=" + venEmail + ", venSecEmail=" + venSecEmail + ", venAppNo=" + venAppNo
				+ ", venJoinDate=" + venJoinDate + ", venProfId=" + venProfId + ", venMobile=" + venMobile + ", venDob="
				+ venDob + ", venGender=" + venGender + ", venPwd=" + venPwd + ", loc=" + loc + ", addr=" + addr
				+ ", proImage=" + proImage + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result + ((loc == null) ? 0 : loc.hashCode());
		result = prime * result + ((proImage == null) ? 0 : proImage.hashCode());
		result = prime * result + ((venAppNo == null) ? 0 : venAppNo.hashCode());
		result = prime * result + ((venDob == null) ? 0 : venDob.hashCode());
		result = prime * result + ((venEmail == null) ? 0 : venEmail.hashCode());
		result = prime * result + ((venFirstName == null) ? 0 : venFirstName.hashCode());
		result = prime * result + ((venGender == null) ? 0 : venGender.hashCode());
		result = prime * result + venId;
		result = prime * result + ((venJoinDate == null) ? 0 : venJoinDate.hashCode());
		result = prime * result + ((venLastName == null) ? 0 : venLastName.hashCode());
		result = prime * result + ((venMobile == null) ? 0 : venMobile.hashCode());
		result = prime * result + ((venProfId == null) ? 0 : venProfId.hashCode());
		result = prime * result + ((venPwd == null) ? 0 : venPwd.hashCode());
		result = prime * result + ((venSecEmail == null) ? 0 : venSecEmail.hashCode());
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
		Vendor other = (Vendor) obj;
		if (addr == null) {
			if (other.addr != null)
				return false;
		} else if (!addr.equals(other.addr))
			return false;
		if (loc == null) {
			if (other.loc != null)
				return false;
		} else if (!loc.equals(other.loc))
			return false;
		if (proImage == null) {
			if (other.proImage != null)
				return false;
		} else if (!proImage.equals(other.proImage))
			return false;
		if (venAppNo == null) {
			if (other.venAppNo != null)
				return false;
		} else if (!venAppNo.equals(other.venAppNo))
			return false;
		if (venDob == null) {
			if (other.venDob != null)
				return false;
		} else if (!venDob.equals(other.venDob))
			return false;
		if (venEmail == null) {
			if (other.venEmail != null)
				return false;
		} else if (!venEmail.equals(other.venEmail))
			return false;
		if (venFirstName == null) {
			if (other.venFirstName != null)
				return false;
		} else if (!venFirstName.equals(other.venFirstName))
			return false;
		if (venGender == null) {
			if (other.venGender != null)
				return false;
		} else if (!venGender.equals(other.venGender))
			return false;
		if (venId != other.venId)
			return false;
		if (venJoinDate == null) {
			if (other.venJoinDate != null)
				return false;
		} else if (!venJoinDate.equals(other.venJoinDate))
			return false;
		if (venLastName == null) {
			if (other.venLastName != null)
				return false;
		} else if (!venLastName.equals(other.venLastName))
			return false;
		if (venMobile == null) {
			if (other.venMobile != null)
				return false;
		} else if (!venMobile.equals(other.venMobile))
			return false;
		if (venProfId == null) {
			if (other.venProfId != null)
				return false;
		} else if (!venProfId.equals(other.venProfId))
			return false;
		if (venPwd == null) {
			if (other.venPwd != null)
				return false;
		} else if (!venPwd.equals(other.venPwd))
			return false;
		if (venSecEmail == null) {
			if (other.venSecEmail != null)
				return false;
		} else if (!venSecEmail.equals(other.venSecEmail))
			return false;
		return true;
	}
	public int getVenId() {
		return venId;
	}
	public void setVenId(int venId) {
		this.venId = venId;
	}
	public String getVenFirstName() {
		return venFirstName;
	}
	public void setVenFirstName(String venFirstName) {
		this.venFirstName = venFirstName;
	}
	public String getVenLastName() {
		return venLastName;
	}
	public void setVenLastName(String venLastName) {
		this.venLastName = venLastName;
	}
	public String getVenEmail() {
		return venEmail;
	}
	public void setVenEmail(String venEmail) {
		this.venEmail = venEmail;
	}
	public String getVenSecEmail() {
		return venSecEmail;
	}
	public void setVenSecEmail(String venSecEmail) {
		this.venSecEmail = venSecEmail;
	}
	public String getVenAppNo() {
		return venAppNo;
	}
	public void setVenAppNo(String venAppNo) {
		this.venAppNo = venAppNo;
	}
	public String getVenJoinDate() {
		return venJoinDate;
	}
	public void setVenJoinDate(String venJoinDate) {
		this.venJoinDate = venJoinDate;
	}
	public String getVenProfId() {
		return venProfId;
	}
	public void setVenProfId(String venProfId) {
		this.venProfId = venProfId;
	}
	public String getVenMobile() {
		return venMobile;
	}
	public void setVenMobile(String venMobile) {
		this.venMobile = venMobile;
	}
	public String getVenDob() {
		return venDob;
	}
	public void setVenDob(String venDob) {
		this.venDob = venDob;
	}
	public String getVenGender() {
		return venGender;
	}
	public void setVenGender(String venGender) {
		this.venGender = venGender;
	}
	public String getVenPwd() {
		return venPwd;
	}
	public void setVenPwd(String venPwd) {
		this.venPwd = venPwd;
	}
	public Location getLoc() {
		return loc;
	}
	public void setLoc(Location loc) {
		this.loc = loc;
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
