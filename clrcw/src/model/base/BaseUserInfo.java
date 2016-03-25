package model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the user_info table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="user_info"
 */

public abstract class BaseUserInfo  implements Serializable {

	public static String REF = "UserInfo";
	public static String PROP_DR = "Dr";
	public static String PROP_LOGIN_ID = "LoginId";
	public static String PROP_PASSWORD = "Password";
	public static String PROP_ID = "Id";
	public static String PROP_VERSION = "Version";
	public static String PROP_MAIL_ADDR = "MailAddr";


	// constructors
	public BaseUserInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUserInfo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String loginId;
	private java.lang.String password;
	private java.lang.String mailAddr;
	private java.lang.Short version;
	private java.lang.String dr;
	private java.lang.String area;
//jialuhaoadd
	private java.lang.String truename;
	private java.lang.String phone;
	public java.lang.String getPhone() {
		return phone;
	}

	public java.lang.String getTruename() {
		return truename;
	}

	public void setTruename(java.lang.String truename) {
		this.truename = truename;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}



	// collections
	private java.util.Set<model.PersonResume> personResumes;
	private java.util.Set<model.ApplyJobInfo> applyJobInfos;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="pk_person"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: login_id
	 */
	public java.lang.String getLoginId () {
		return loginId;
	}

	/**
	 * Set the value related to the column: login_id
	 * @param loginId the login_id value
	 */
	public void setLoginId (java.lang.String loginId) {
		this.loginId = loginId;
	}



	/**
	 * Return the value associated with the column: password
	 */
	public java.lang.String getPassword () {
		return password;
	}

	/**
	 * Set the value related to the column: password
	 * @param password the password value
	 */
	public void setPassword (java.lang.String password) {
		this.password = password;
	}



	/**
	 * Return the value associated with the column: mail_addr
	 */
	public java.lang.String getMailAddr () {
		return mailAddr;
	}

	/**
	 * Set the value related to the column: mail_addr
	 * @param mailAddr the mail_addr value
	 */
	public void setMailAddr (java.lang.String mailAddr) {
		this.mailAddr = mailAddr;
	}



	/**
	 * Return the value associated with the column: version
	 */
	public java.lang.Short getVersion () {
		return version;
	}

	/**
	 * Set the value related to the column: version
	 * @param version the version value
	 */
	public void setVersion (java.lang.Short version) {
		this.version = version;
	}



	/**
	 * Return the value associated with the column: dr
	 */
	public java.lang.String getDr () {
		return dr;
	}

	/**
	 * Set the value related to the column: dr
	 * @param dr the dr value
	 */
	public void setDr (java.lang.String dr) {
		this.dr = dr;
	}



	public java.lang.String getArea() {
		return area;
	}

	public void setArea(java.lang.String area) {
		this.area = area;
	}

	/**
	 * Return the value associated with the column: PersonResumes
	 */
	public java.util.Set<model.PersonResume> getPersonResumes () {
		return personResumes;
	}

	/**
	 * Set the value related to the column: PersonResumes
	 * @param personResumes the PersonResumes value
	 */
	public void setPersonResumes (java.util.Set<model.PersonResume> personResumes) {
		this.personResumes = personResumes;
	}

	public void addToPersonResumes (model.PersonResume personResume) {
		if (null == getPersonResumes()) setPersonResumes(new java.util.TreeSet<model.PersonResume>());
		getPersonResumes().add(personResume);
	}



	/**
	 * Return the value associated with the column: ApplyJobInfos
	 */
	public java.util.Set<model.ApplyJobInfo> getApplyJobInfos () {
		return applyJobInfos;
	}

	/**
	 * Set the value related to the column: ApplyJobInfos
	 * @param applyJobInfos the ApplyJobInfos value
	 */
	public void setApplyJobInfos (java.util.Set<model.ApplyJobInfo> applyJobInfos) {
		this.applyJobInfos = applyJobInfos;
	}

	public void addToApplyJobInfos (model.ApplyJobInfo applyJobInfo) {
		if (null == getApplyJobInfos()) setApplyJobInfos(new java.util.TreeSet<model.ApplyJobInfo>());
		getApplyJobInfos().add(applyJobInfo);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof model.UserInfo)) return false;
		else {
			model.UserInfo userInfo = (model.UserInfo) obj;
			if (null == this.getId() || null == userInfo.getId()) return false;
			else return (this.getId().equals(userInfo.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}