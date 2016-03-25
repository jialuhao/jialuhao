package model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bd_post table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bd_post"
 */

public abstract class BaseBdPost  implements Serializable {

	public static String REF = "BdPost";
	public static String PROP_POST_NAME = "PostName";
	public static String PROP_DR = "Dr";
	public static String PROP_POST_ID_ROOT = "PostIdRoot";
	public static String PROP_ID = "Id";


	// constructors
	public BaseBdPost () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdPost (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBdPost (
		java.lang.Integer id,
		model.BdPostRoot postIdRoot,
		java.lang.String postName) {

		this.setId(id);
		this.setPostIdRoot(postIdRoot);
		this.setPostName(postName);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	 short version;

	// fields
	private java.lang.String postName;
	private java.lang.String dr;

	// many to one
	private model.BdPostRoot postIdRoot;

	// collections
	private java.util.Set<model.PublishJobInfo> publishJobInfos;
//	private java.util.Set<model.ApplyJobInfo> applyJobInfos;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="post_id"
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
	 * Return the value associated with the column: post_name
	 */
	public java.lang.String getPostName () {
		return postName;
	}

	/**
	 * Set the value related to the column: post_name
	 * @param postName the post_name value
	 */
	public void setPostName (java.lang.String postName) {
		this.postName = postName;
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
	 * Return the value associated with the column: post_id_root
	 */
	public model.BdPostRoot getPostIdRoot () {
		return postIdRoot;
	}

	/**
	 * Set the value related to the column: post_id_root
	 * @param postIdRoot the post_id_root value
	 */
	public void setPostIdRoot (model.BdPostRoot postIdRoot) {
		this.postIdRoot = postIdRoot;
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
//	public java.util.Set<model.ApplyJobInfo> getApplyJobInfos () {
//		return applyJobInfos;
//	}

	/**
	 * Set the value related to the column: ApplyJobInfos
	 * @param applyJobInfos the ApplyJobInfos value
	 */
	/*
	public void setApplyJobInfos (java.util.Set<model.ApplyJobInfo> applyJobInfos) {
		this.applyJobInfos = applyJobInfos;
	}

	public void addToApplyJobInfos (model.ApplyJobInfo applyJobInfo) {
		if (null == getApplyJobInfos()) setApplyJobInfos(new java.util.TreeSet<model.ApplyJobInfo>());
		getApplyJobInfos().add(applyJobInfo);
	}
*/



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof model.BdPost)) return false;
		else {
			model.BdPost bdPost = (model.BdPost) obj;
			if (null == this.getId() || null == bdPost.getId()) return false;
			else return (this.getId().equals(bdPost.getId()));
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