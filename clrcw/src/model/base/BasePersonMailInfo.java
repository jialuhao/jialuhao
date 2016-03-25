package model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the person_mail_info table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="person_mail_info"
 */

public abstract class BasePersonMailInfo  implements Serializable {

	public static String REF = "PersonMailInfo";
	public static String PROP_COMP_JOB = "CompJob";
	public static String PROP_DR = "Dr";
	public static String PROP_USER_LOGIN_ID = "UserLoginId";
	public static String PROP_ID = "Id";
	public static String PROP_VERSION = "Version";
	public static String PROP_DATETIME = "Datetime";


	// constructors
	public BasePersonMailInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePersonMailInfo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePersonMailInfo (
		java.lang.Integer id,
		model.PublishJobInfo compJob) {

		this.setId(id);
		this.setCompJob(compJob);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String userLoginId;
	private java.lang.Short version;
	private java.lang.String dr;
	private java.lang.String datetime;

	// many to one
	private model.PublishJobInfo compJob;



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
	 * Return the value associated with the column: user_login_id
	 */
	public java.lang.String getUserLoginId () {
		return userLoginId;
	}

	/**
	 * Set the value related to the column: user_login_id
	 * @param userLoginId the user_login_id value
	 */
	public void setUserLoginId (java.lang.String userLoginId) {
		this.userLoginId = userLoginId;
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



	/**
	 * Return the value associated with the column: datetime
	 */
	public java.lang.String getDatetime () {
		return datetime;
	}

	/**
	 * Set the value related to the column: datetime
	 * @param datetime the datetime value
	 */
	public void setDatetime (java.lang.String datetime) {
		this.datetime = datetime;
	}



	/**
	 * Return the value associated with the column: comp_job_id
	 */
	public model.PublishJobInfo getCompJob () {
		return compJob;
	}

	/**
	 * Set the value related to the column: comp_job_id
	 * @param compJob the comp_job_id value
	 */
	public void setCompJob (model.PublishJobInfo compJob) {
		this.compJob = compJob;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof model.PersonMailInfo)) return false;
		else {
			model.PersonMailInfo personMailInfo = (model.PersonMailInfo) obj;
			if (null == this.getId() || null == personMailInfo.getId()) return false;
			else return (this.getId().equals(personMailInfo.getId()));
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