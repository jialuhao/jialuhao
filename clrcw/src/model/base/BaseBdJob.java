package model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bd_job table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bd_job"
 */

public abstract class BaseBdJob  implements Serializable {

	public static String REF = "BdJob";
	public static String PROP_DR = "Dr";
	public static String PROP_JOB_NAME = "JobName";
	public static String PROP_ID = "Id";
	public static String PROP_VERSION = "Version";
	public static String ADDRESS="address";


	public static String getADDRESS() {
		return ADDRESS;
	}

	public static void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	// constructors
	public BaseBdJob () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdJob (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBdJob (
		java.lang.Integer id,
		java.lang.String jobName,
		java.lang.Short version) {

		this.setId(id);
		this.setJobName(jobName);
		this.setVersion(version);
		initialize();
	}

	public BaseBdJob (
			java.lang.Integer id,
			java.lang.String jobName,
			java.lang.Short version,
			java.lang.String address) {

			this.setId(id);
			this.setJobName(jobName);
			this.setVersion(version);
			this.setAddress(address);
			initialize();
		}
	
	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String jobName;
	private java.lang.Short version;
	private java.lang.String dr;
    private java.lang.String address;
	public java.lang.String getAddress() {
		return address;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
	}



	// collections
	private java.util.Set<model.PublishJobInfo> publishJobInfos;
	private java.util.Set<model.ApplyJobInfo> applyJobInfos;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="job_id"
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
	 * Return the value associated with the column: job_name
	 */
	public java.lang.String getJobName () {
		return jobName;
	}

	/**
	 * Set the value related to the column: job_name
	 * @param jobName the job_name value
	 */
	public void setJobName (java.lang.String jobName) {
		this.jobName = jobName;
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
	 * Return the value associated with the column: PublishJobInfos
	 */
	public java.util.Set<model.PublishJobInfo> getPublishJobInfos () {
		return publishJobInfos;
	}

	/**
	 * Set the value related to the column: PublishJobInfos
	 * @param publishJobInfos the PublishJobInfos value
	 */
	public void setPublishJobInfos (java.util.Set<model.PublishJobInfo> publishJobInfos) {
		this.publishJobInfos = publishJobInfos;
	}

	public void addToPublishJobInfos (model.PublishJobInfo publishJobInfo) {
		if (null == getPublishJobInfos()) setPublishJobInfos(new java.util.TreeSet<model.PublishJobInfo>());
		getPublishJobInfos().add(publishJobInfo);
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
		if (!(obj instanceof model.BdJob)) return false;
		else {
			model.BdJob bdJob = (model.BdJob) obj;
			if (null == this.getId() || null == bdJob.getId()) return false;
			else return (this.getId().equals(bdJob.getId()));
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