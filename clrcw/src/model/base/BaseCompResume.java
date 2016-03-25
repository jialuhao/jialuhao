package model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the comp_resume table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="comp_resume"
 */

public abstract class BaseCompResume  implements Serializable {

	public static String REF = "CompResume";
	public static String PROP_STATUS = "Status";
	public static String PROP_COMP_POST = "CompPost";
	public static String PROP_DR = "Dr";
	public static String PROP_COMP_LOGIN_ID = "CompLoginId";
	public static String PROP_PK_RESUME = "PkResume";
	public static String PROP_FILE = "File";
	public static String PROP_ID = "Id";
	public static String PROP_VERSION = "Version";
	public static String PROP_CREATETIME = "createtime";

	// constructors
	public BaseCompResume () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCompResume (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCompResume (
		java.lang.Integer id,
		model.PersonResume pkResume,
		java.lang.String compLoginId) {

		this.setId(id);
		this.setPkResume(pkResume);
		this.setCompLoginId(compLoginId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Boolean reg;
	public java.lang.Boolean getReg() {
		return reg;
	}

	public void setReg(java.lang.Boolean reg) {
		this.reg = reg;
	}



	private java.lang.String compLoginId;
	private java.lang.String file;
	private java.lang.String status;
	private java.lang.Short version;
	private java.lang.String dr;
	private java.lang.String createtime;
	// many to one
	private model.PublishJobInfo compPost;
	private model.PersonResume pkResume;
	



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="pk_comp_resume"
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
	 * Return the value associated with the column: isFile
	 */
	public java.lang.String isFile () {
		return file;
	}

	/**
	 * Set the value related to the column: isFile
	 * @param file the isFile value
	 */
	public void setFile (java.lang.String file) {
		this.file = file;
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



	public java.lang.String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(java.lang.String createtime) {
		this.createtime = createtime;
	}

	/**
	 * Return the value associated with the column: comp_post_id
	 */
	public model.PublishJobInfo getCompPost () {
		return compPost;
	}

	/**
	 * Set the value related to the column: comp_post_id
	 * @param compPost the comp_post_id value
	 */
	public void setCompPost (model.PublishJobInfo compPost) {
		this.compPost = compPost;
	}



	/**
	 * Return the value associated with the column: pk_resume
	 */
	public model.PersonResume getPkResume () {
		return pkResume;
	}

	/**
	 * Set the value related to the column: pk_resume
	 * @param pkResume the pk_resume value
	 */
	public void setPkResume (model.PersonResume pkResume) {
		this.pkResume = pkResume;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof model.CompResume)) return false;
		else {
			model.CompResume compResume = (model.CompResume) obj;
			if (null == this.getId() || null == compResume.getId()) return false;
			else return (this.getId().equals(compResume.getId()));
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