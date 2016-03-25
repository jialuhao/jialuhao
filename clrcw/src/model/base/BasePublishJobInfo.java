package model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the publish_job_info table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="publish_job_info"
 */

public abstract class BasePublishJobInfo  implements Serializable {

	public static String REF = "PublishJobInfo";
	public static String PROP_JOB_DESC = "JobDesc";
	public static String PROP_PK_COMP = "PkComp";
	public static String PROP_PUBLISH_TIME = "PublishTime";
	public static String PROP_CLOSE_TIME = "CloseTime";
	public static String PROP_VALIDTIME = "validtime";
	public static String PROP_COMP_LOGIN_ID = "CompLoginId";
	public static String PROP_WORK_YEAR = "WorkYear";
	public static String PROP_JOB = "Job";
	public static String PROP_JOB_AMOUNT = "JobAmount";
	public static String PROP_GRADING = "Grading";
	public static String PROP_STATUS = "Status";
	public static String PROP_EDUCATION = "Education";
	public static String PROP_AGE_LIMIT = "AgeLimit";
	public static String PROP_POST = "Post";
	public static String PROP_ENGAGE_SEX = "EngageSex";
	public static String PROP_DR = "Dr";
	public static String PROP_SALARY = "Salary";
	public static String PROP_PK_JOB = "Id";
	public static String PROP_Address="Address";


	// constructors
	public BasePublishJobInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePublishJobInfo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePublishJobInfo (
		java.lang.Integer id,
		model.BdEducate education,
		model.CompInfo pkComp,
		model.BdPost post,
		model.BdJob job,
		java.lang.String compLoginId,
		java.lang.String address) {

		this.setId(id);
		this.setEducation(education);
		this.setPkComp(pkComp);
		this.setPost(post);
		this.setJob(job);
		this.setCompLoginId(compLoginId);
		this.setAddress(address);
		
		initialize();
	}


	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	 short version;

	// fields
	private java.lang.String compLoginId;
	//private java.lang.String jobInfo;
	private java.lang.String jobAmount;
	private java.lang.String grading;
	private java.lang.String publishTime;
	private java.lang.String closeTime;
	private java.lang.String engageSex;
	private java.lang.String ageLimit;
	private java.lang.String workYear;
	private java.lang.String salary;
	private java.lang.String jobDesc;
	private java.lang.String status;
	private java.lang.String dr;
    private java.lang.String address;
    private java.lang.String workarea;
    private java.lang.String welfare;
    private java.lang.String validflag;
    private java.lang.String nature;
    private java.lang.String  opinion;
	

	public java.lang.String getOpinion() {
		return opinion;
	}

	public void setOpinion(java.lang.String opinion) {
		this.opinion = opinion;
	}

	public java.lang.String getAddress() {
		return address;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
	}



	// many to one
	private model.BdEducate education;
	private model.CompInfo pkComp;
	private model.BdPost post;
	private model.BdJob job;

	// collections
	private java.util.Set<model.CompResume> compResumes;
	private java.util.Set<model.PersonMailInfo> personMailInfos;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="pk_job"
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
	 * Return the value associated with the column: version
	 */
	public short getVersion () {
		return version;
	}

	/**
	 * Set the value related to the column: version
	 * @param version the version value
	 */
	public void setVersion (short version) {
		this.version = version;
	}




	/**
	 * Return the value associated with the column: comp_login_id
	 */
	public java.lang.String getCompLoginId () {
		return compLoginId;
	}

	/**
	 * Set the value related to the column: comp_login_id
	 * @param compLoginId the comp_login_id value
	 */
	public void setCompLoginId (java.lang.String compLoginId) {
		this.compLoginId = compLoginId;
	}

	/**
	 * Return the value associated with the column: job_amount
	 */
	public java.lang.String getJobAmount () {
		return jobAmount;
	}

	/**
	 * Set the value related to the column: job_amount
	 * @param jobAmount the job_amount value
	 */
	public void setJobAmount (java.lang.String jobAmount) {
		this.jobAmount = jobAmount;
	}



	/**
	 * Return the value associated with the column: grading
	 */
	public java.lang.String getGrading () {
		return grading;
	}

	/**
	 * Set the value related to the column: grading
	 * @param grading the grading value
	 */
	public void setGrading (java.lang.String grading) {
		this.grading = grading;
	}



	/**
	 * Return the value associated with the column: publish_time
	 */
	public java.lang.String getPublishTime () {
		return publishTime;
	}

	/**
	 * Set the value related to the column: publish_time
	 * @param publishTime the publish_time value
	 */
	public void setPublishTime (java.lang.String publishTime) {
		this.publishTime = publishTime;
	}



	/**
	 * Return the value associated with the column: close_time
	 */
	public java.lang.String getCloseTime () {
		return closeTime;
	}

	/**
	 * Set the value related to the column: close_time
	 * @param closeTime the close_time value
	 */
	public void setCloseTime (java.lang.String closeTime) {
		this.closeTime = closeTime;
	}



	/**
	 * Return the value associated with the column: engage_sex
	 */
	public java.lang.String getEngageSex () {
		return engageSex;
	}

	/**
	 * Set the value related to the column: engage_sex
	 * @param engageSex the engage_sex value
	 */
	public void setEngageSex (java.lang.String engageSex) {
		this.engageSex = engageSex;
	}



	/**
	 * Return the value associated with the column: age_limit
	 */
	public java.lang.String getAgeLimit () {
		return ageLimit;
	}

	/**
	 * Set the value related to the column: age_limit
	 * @param ageLimit the age_limit value
	 */
	public void setAgeLimit (java.lang.String ageLimit) {
		this.ageLimit = ageLimit;
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
	 * Return the value associated with the column: job_desc
	 */
	public java.lang.String getJobDesc () {
		return jobDesc;
	}

	/**
	 * Set the value related to the column: job_desc
	 * @param jobDesc the job_desc value
	 */
	public void setJobDesc (java.lang.String jobDesc) {
		this.jobDesc = jobDesc;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
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



	public java.lang.String getNature() {
		return nature;
	}

	public void setNature(java.lang.String nature) {
		this.nature = nature;
	}

	public java.lang.String getWorkarea() {
		return workarea;
	}

	public void setWorkarea(java.lang.String workarea) {
		this.workarea = workarea;
	}

	public java.lang.String getWelfare() {
		return welfare;
	}

	public void setWelfare(java.lang.String welfare) {
		this.welfare = welfare;
	}

	public java.lang.String getValidflag() {
		return validflag;
	}

	public void setValidflag(java.lang.String validflag) {
		this.validflag = validflag;
	}

	/**
	 * Return the value associated with the column: education_id
	 */
	public model.BdEducate getEducation () {
		return education;
	}

	/**
	 * Set the value related to the column: education_id
	 * @param education the education_id value
	 */
	public void setEducation (model.BdEducate education) {
		this.education = education;
	}



	/**
	 * Return the value associated with the column: pk_comp
	 */
	public model.CompInfo getPkComp () {
		return pkComp;
	}

	/**
	 * Set the value related to the column: pk_comp
	 * @param pkComp the pk_comp value
	 */
	public void setPkComp (model.CompInfo pkComp) {
		this.pkComp = pkComp;
	}



	/**
	 * Return the value associated with the column: post_id
	 */
	public model.BdPost getPost () {
		return post;
	}

	/**
	 * Set the value related to the column: post_id
	 * @param post the post_id value
	 */
	public void setPost (model.BdPost post) {
		this.post = post;
	}



	/**
	 * Return the value associated with the column: job_id
	 */
	public model.BdJob getJob () {
		return job;
	}

	/**
	 * Set the value related to the column: job_id
	 * @param job the job_id value
	 */
	public void setJob (model.BdJob job) {
		this.job = job;
	}



	/**
	 * Return the value associated with the column: CompResumes
	 */
	public java.util.Set<model.CompResume> getCompResumes () {
		return compResumes;
	}

	/**
	 * Set the value related to the column: CompResumes
	 * @param compResumes the CompResumes value
	 */
	public void setCompResumes (java.util.Set<model.CompResume> compResumes) {
		this.compResumes = compResumes;
	}

	public void addToCompResumes (model.CompResume compResume) {
		if (null == getCompResumes()) setCompResumes(new java.util.TreeSet<model.CompResume>());
		getCompResumes().add(compResume);
	}



	/**
	 * Return the value associated with the column: PersonMailInfos
	 */
	public java.util.Set<model.PersonMailInfo> getPersonMailInfos () {
		return personMailInfos;
	}

	/**
	 * Set the value related to the column: PersonMailInfos
	 * @param personMailInfos the PersonMailInfos value
	 */
	public void setPersonMailInfos (java.util.Set<model.PersonMailInfo> personMailInfos) {
		this.personMailInfos = personMailInfos;
	}

	public void addToPersonMailInfos (model.PersonMailInfo personMailInfo) {
		if (null == getPersonMailInfos()) setPersonMailInfos(new java.util.TreeSet<model.PersonMailInfo>());
		getPersonMailInfos().add(personMailInfo);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof model.PublishJobInfo)) return false;
		else {
			model.PublishJobInfo publishJobInfo = (model.PublishJobInfo) obj;
			if (null == this.getId() || null == publishJobInfo.getId()) return false;
			else return (this.getId().equals(publishJobInfo.getId()));
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