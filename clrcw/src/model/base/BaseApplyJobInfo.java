package model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the apply_job_info table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="apply_job_info"
 */

public abstract class BaseApplyJobInfo  implements Serializable {

	public static String REF = "ApplyJobInfo";
	
	public static String PROP_DR = "Dr";
	public static String PROP_POST_CODE = "PostCode";
	public static String PROP_PERSON_CODE = "PersonCode";
	public static String PROP_RESUME_CODE = "ResumeCode";
	public static String PROP_WORK_YEAR = "WorkYear";
	public static String PROP_SALARY = "Salary";
	public static String PROP_ID = "Id";
	public static String PROP_JOB_CODE = "JobCode";
	public static String PROP_VERSION = "Version";


	// constructors
	public BaseApplyJobInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseApplyJobInfo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseApplyJobInfo (
		java.lang.Integer id,
		model.PersonResume resumeCode,
		model.BdJob jobCode,
		model.BdTrade postCode,
		model.UserInfo personCode,
		java.lang.String createTime) {

		this.setId(id);
		this.setResumeCode(resumeCode);
		this.setJobCode(jobCode);
		this.setPostCode(postCode);
		this.setPersonCode(personCode);
		this.setCreateTime(createTime);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;
   
	// fields
	private java.lang.String workYear;
	private java.lang.String salary;
	
	private java.lang.Short version;
	private java.lang.String dr;




	// many to one
	private model.PersonResume resumeCode;
	private model.BdJob jobCode;
	private model.BdTrade postCode;
	private model.UserInfo personCode;
	
	private java.lang.String createTime;

    private java.lang.String refreshtime;
 
    private java.lang.String isNo;//判断有没有加入人才库的字段与数据库无关联
    
	public java.lang.String getIsNo() {
		return isNo;
	}

	public void setIsNo(java.lang.String isNo) {
		this.isNo = isNo;
	}

	public java.lang.String getRefreshtime() {
		return refreshtime;
	}

	public void setRefreshtime(java.lang.String refreshtime) {
		this.refreshtime = refreshtime;
	}

	public java.lang.String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.lang.String createTime) {
		this.createTime = createTime;
	}

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="pk_apply_job"
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
	 * Return the value associated with the column: work_year
	 */
	public java.lang.String getWorkYear () {
		return workYear;
	}

	/**
	 * Set the value related to the column: work_year
	 * @param workYear the work_year value
	 */
	public void setWorkYear (java.lang.String workYear) {
		this.workYear = workYear;
	}



	/**
	 * Return the value associated with the column: salary
	 */
	public java.lang.String getSalary () {
		return salary;
	}

	/**
	 * Set the value related to the column: salary
	 * @param salary the salary value
	 */
	public void setSalary (java.lang.String salary) {
		this.salary = salary;
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
	 * Return the value associated with the column: resume_code
	 */
	public model.PersonResume getResumeCode () {
		return resumeCode;
	}

	/**
	 * Set the value related to the column: resume_code
	 * @param resumeCode the resume_code value
	 */
	public void setResumeCode (model.PersonResume resumeCode) {
		this.resumeCode = resumeCode;
	}



	/**
	 * Return the value associated with the column: job_code
	 */
	public model.BdJob getJobCode () {
		return jobCode;
	}

	/**
	 * Set the value related to the column: job_code
	 * @param jobCode the job_code value
	 */
	public void setJobCode (model.BdJob jobCode) {
		this.jobCode = jobCode;
	}



	/**
	 * Return the value associated with the column: post_code
	 */
	public model.BdTrade getPostCode () {
		return postCode;
	}

	/**
	 * Set the value related to the column: post_code
	 * @param postCode the post_code value
	 */
	public void setPostCode (model.BdTrade postCode) {
		this.postCode = postCode;
	}



	/**
	 * Return the value associated with the column: person_code
	 */
	public model.UserInfo getPersonCode () {
		return personCode;
	}

	/**
	 * Set the value related to the column: person_code
	 * @param personCode the person_code value
	 */
	public void setPersonCode (model.UserInfo personCode) {
		this.personCode = personCode;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof model.ApplyJobInfo)) return false;
		else {
			model.ApplyJobInfo applyJobInfo = (model.ApplyJobInfo) obj;
			if (null == this.getId() || null == applyJobInfo.getId()) return false;
			else return (this.getId().equals(applyJobInfo.getId()));
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