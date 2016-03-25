package model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the person_resume_b table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="person_resume_b"
 */

public abstract class BasePersonResumeB  implements Serializable {

	public static String REF = "PersonResumeB";
	public static String PROP_JOB = "Job";
	public static String PROP_WORK_UNIT = "WorkUnit";
	public static String PROP_WORK_CONTENT = "WorkContent";
	public static String PROP_DR = "Dr";
	public static String PROP_RESUME = "Resume";
	public static String PROP_USER_LOGIN_ID = "UserLoginId";
	public static String PROP_ID = "Id";
	public static String PROP_END_TIME = "EndTime";
	public static String PROP_START_TIME = "StartTime";
	public static String PROP_VERSION = "Version";


	// constructors
	public BasePersonResumeB () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePersonResumeB (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePersonResumeB (
		java.lang.Integer id,
		model.PersonResume resume,
		java.lang.String userLoginId) {

		this.setId(id);
		this.setResume(resume);
		this.setUserLoginId(userLoginId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String userLoginId;
	private java.lang.String startTime;
	private java.lang.String endTime;
	private java.lang.String workUnit;
	private java.lang.String job;
	private java.lang.String workContent;
	private java.lang.Short version;
	private java.lang.String dr;

	// many to one
	private model.PersonResume resume;



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
	 * Return the value associated with the column: start_time
	 */
	public java.lang.String getStartTime () {
		return startTime;
	}

	/**
	 * Set the value related to the column: start_time
	 * @param startTime the start_time value
	 */
	public void setStartTime (java.lang.String startTime) {
		this.startTime = startTime;
	}



	/**
	 * Return the value associated with the column: end_time
	 */
	public java.lang.String getEndTime () {
		return endTime;
	}

	/**
	 * Set the value related to the column: end_time
	 * @param endTime the end_time value
	 */
	public void setEndTime (java.lang.String endTime) {
		this.endTime = endTime;
	}



	/**
	 * Return the value associated with the column: work_unit
	 */
	public java.lang.String getWorkUnit () {
		return workUnit;
	}

	/**
	 * Set the value related to the column: work_unit
	 * @param workUnit the work_unit value
	 */
	public void setWorkUnit (java.lang.String workUnit) {
		this.workUnit = workUnit;
	}



	/**
	 * Return the value associated with the column: job
	 */
	public java.lang.String getJob () {
		return job;
	}

	/**
	 * Set the value related to the column: job
	 * @param job the job value
	 */
	public void setJob (java.lang.String job) {
		this.job = job;
	}



	/**
	 * Return the value associated with the column: work_content
	 */
	public java.lang.String getWorkContent () {
		return workContent;
	}

	/**
	 * Set the value related to the column: work_content
	 * @param workContent the work_content value
	 */
	public void setWorkContent (java.lang.String workContent) {
		this.workContent = workContent;
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
	 * Return the value associated with the column: resume_id
	 */
	public model.PersonResume getResume () {
		return resume;
	}

	/**
	 * Set the value related to the column: resume_id
	 * @param resume the resume_id value
	 */
	public void setResume (model.PersonResume resume) {
		this.resume = resume;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof model.PersonResumeB)) return false;
		else {
			model.PersonResumeB personResumeB = (model.PersonResumeB) obj;
			if (null == this.getId() || null == personResumeB.getId()) return false;
			else return (this.getId().equals(personResumeB.getId()));
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