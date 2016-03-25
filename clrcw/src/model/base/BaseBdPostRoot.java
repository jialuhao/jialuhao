package model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bd_post_root table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bd_post_root"
 */

public abstract class BaseBdPostRoot  implements Serializable {

	public static String REF = "BdPostRoot";
	public static String PROP_POST_NAME = "PostName";
	public static String PROP_DR = "Dr";
	public static String PROP_ID = "Id";
	public static String PROP_VERSION = "Version";


	// constructors
	public BaseBdPostRoot () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdPostRoot (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBdPostRoot (
		java.lang.Integer id,
		java.lang.String postName) {

		this.setId(id);
		this.setPostName(postName);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String postName;
	private java.lang.Short version;
	private java.lang.String dr;

	// collections
	private java.util.Set<model.BdPost> bdPosts;



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
	 * Return the value associated with the column: BdPosts
	 */
	public java.util.Set<model.BdPost> getBdPosts () {
		return bdPosts;
	}

	/**
	 * Set the value related to the column: BdPosts
	 * @param bdPosts the BdPosts value
	 */
	public void setBdPosts (java.util.Set<model.BdPost> bdPosts) {
		this.bdPosts = bdPosts;
	}

	public void addToBdPosts (model.BdPost bdPost) {
		if (null == getBdPosts()) setBdPosts(new java.util.TreeSet<model.BdPost>());
		getBdPosts().add(bdPost);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof model.BdPostRoot)) return false;
		else {
			model.BdPostRoot bdPostRoot = (model.BdPostRoot) obj;
			if (null == this.getId() || null == bdPostRoot.getId()) return false;
			else return (this.getId().equals(bdPostRoot.getId()));
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