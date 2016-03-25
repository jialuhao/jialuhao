package model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the comp_bespeak table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="comp_bespeak"
 */

public abstract class BaseCompBespeak  implements Serializable {

	public static String REF = "CompBespeak";
	public static String PROP_MAIL_POST = "MailPost";
	public static String PROP_TELEPHONE = "Telephone";
	public static String PROP_DR = "Dr";
	public static String PROP_PASSWORD = "Password";
	public static String PROP_LINKMAN = "Linkman";
	public static String PROP_ID = "Id";
	public static String PROP_COMP_ADDR = "CompAddr";
	public static String PROP_COMP_NAME = "CompName";
	public static String PROP_USER_ID = "UserId";
	public static String PROP_VERSION = "Version";
	public static String PROP_COMP_STATUS = "CompStatus";
	public static String PROP_MAIL = "Mail";


	// constructors
	public BaseCompBespeak () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCompBespeak (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCompBespeak (
		java.lang.Integer id,
		java.lang.String userId,
		java.lang.String password,
		java.lang.String compName,
		java.lang.String compAddr,
		java.lang.String telephone,
		java.lang.String linkman,
		java.lang.String mail,
		java.lang.String compnum,
		java.lang.String comparea,
		java.lang.String cardnum) {

		this.setId(id);
		this.setUserId(userId);
		this.setPassword(password);
		this.setCompName(compName);
		this.setCompAddr(compAddr);
		this.setTelephone(telephone);
		this.setLinkman(linkman);
		this.setMail(mail);
		this.setCardnum(cardnum);
		this.setCompnum(compnum);
		this.setComparea(comparea);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String userId;   
	private java.lang.String password;
	private java.lang.String compName;
	private java.lang.String compAddr;
	private java.lang.String mailPost;
	private java.lang.String telephone;
	private java.lang.String linkman;
	private java.lang.String mail;
	private java.lang.String compStatus;
	private java.lang.Short version;
	private java.lang.String dr;
	private java.lang.String compnum;
	private java.lang.String comparea;
	private java.lang.String cardnum;
	private java.lang.String fkcompanyimage;
	private java.lang.Integer pv;
	private java.lang.String companyplace;
	private java.lang.String opinion;


	public java.lang.String getOpinion() {
		return opinion;
	}

	public void setOpinion(java.lang.String opinion) {
		this.opinion = opinion;
	}

	public java.lang.String getCompanyplace() {
		return companyplace;
	}

	public void setCompanyplace(java.lang.String companyplace) {
		this.companyplace = companyplace;
	}



	// collections
	private java.util.Set<model.CompInfo> compInfos;



	public java.lang.String getFkcompanyimage() {
		return fkcompanyimage;
	}

	public void setFkcompanyimage(java.lang.String fkcompanyimage) {
		this.fkcompanyimage = fkcompanyimage;
	}

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="id"
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
	 * Return the value associated with the column: user_id
	 */
	public java.lang.String getUserId () {
		return userId;
	}

	/**
	 * Set the value related to the column: user_id
	 * @param userId the user_id value
	 */
	public void setUserId (java.lang.String userId) {
		this.userId = userId;
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
	 * Return the value associated with the column: comp_name
	 */
	public java.lang.String getCompName () {
		return compName;
	}

	/**
	 * Set the value related to the column: comp_name
	 * @param compName the comp_name value
	 */
	public void setCompName (java.lang.String compName) {
		this.compName = compName;
	}



	/**
	 * Return the value associated with the column: comp_addr
	 */
	public java.lang.String getCompAddr () {
		return compAddr;
	}

	/**
	 * Set the value related to the column: comp_addr
	 * @param compAddr the comp_addr value
	 */
	public void setCompAddr (java.lang.String compAddr) {
		this.compAddr = compAddr;
	}



	/**
	 * Return the value associated with the column: mail_post
	 */
	public java.lang.String getMailPost () {
		return mailPost;
	}

	/**
	 * Set the value related to the column: mail_post
	 * @param mailPost the mail_post value
	 */
	public void setMailPost (java.lang.String mailPost) {
		this.mailPost = mailPost;
	}



	/**
	 * Return the value associated with the column: telephone
	 */
	public java.lang.String getTelephone () {
		return telephone;
	}

	/**
	 * Set the value related to the column: telephone
	 * @param telephone the telephone value
	 */
	public void setTelephone (java.lang.String telephone) {
		this.telephone = telephone;
	}



	/**
	 * Return the value associated with the column: linkman
	 */
	public java.lang.String getLinkman () {
		return linkman;
	}

	/**
	 * Set the value related to the column: linkman
	 * @param linkman the linkman value
	 */
	public void setLinkman (java.lang.String linkman) {
		this.linkman = linkman;
	}



	/**
	 * Return the value associated with the column: mail
	 */
	public java.lang.String getMail () {
		return mail;
	}

	/**
	 * Set the value related to the column: mail
	 * @param mail the mail value
	 */
	public void setMail (java.lang.String mail) {
		this.mail = mail;
	}



	/**
	 * Return the value associated with the column: comp_status
	 */
	public java.lang.String getCompStatus () {
		return compStatus;
	}

	/**
	 * Set the value related to the column: comp_status
	 * @param compStatus the comp_status value
	 */
	public void setCompStatus (java.lang.String compStatus) {
		this.compStatus = compStatus;
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
	public java.lang.Integer getPv() {
		return pv;
	}

	public void setPv(java.lang.Integer pv) {
		this.pv = pv;
	}


	public java.lang.String getCompnum() {
		return compnum;
	}

	public void setCompnum(java.lang.String compnum) {
		this.compnum = compnum;
	}

	public java.lang.String getComparea() {
		return comparea;
	}

	public void setComparea(java.lang.String comparea) {
		this.comparea = comparea;
	}

	public java.lang.String getCardnum() {
		return cardnum;
	}

	public void setCardnum(java.lang.String cardnum) {
		this.cardnum = cardnum;
	}

	/**
	 * Return the value associated with the column: CompInfos
	 */
	public java.util.Set<model.CompInfo> getCompInfos () {
		return compInfos;
	}

	/**
	 * Set the value related to the column: CompInfos
	 * @param compInfos the CompInfos value
	 */
	public void setCompInfos (java.util.Set<model.CompInfo> compInfos) {
		this.compInfos = compInfos;
	}

	public void addToCompInfos (model.CompInfo compInfo) {
		if (null == getCompInfos()) setCompInfos(new java.util.TreeSet<model.CompInfo>());
		getCompInfos().add(compInfo);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof model.CompBespeak)) return false;
		else {
			model.CompBespeak compBespeak = (model.CompBespeak) obj;
			if (null == this.getId() || null == compBespeak.getId()) return false;
			else return (this.getId().equals(compBespeak.getId()));
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