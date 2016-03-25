package model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bd_compkind table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bd_compkind"
 */

public abstract class BaseBdCompkind  implements Serializable {

	public static String REF = "BdCompkind";
	public static String PROP_DR = "Dr";
	public static String PROP_ID = "Id";
	public static String PROP_VERSION = "Version";
	public static String PROP_COMP_TYPE_NAME = "CompTypeName";


	// constructors
	public BaseBdCompkind () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdCompkind (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBdCompkind (
		java.lang.Integer id,
		java.lang.String compTypeName) {

		this.setId(id);
		this.setCompTypeName(compTypeName);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String compTypeName;
	private java.lang.Short version;
	private java.lang.String dr;

	// collections
	private java.util.Set<model.CompInfo> compInfos;



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
	 * Return the value associated with the column: comp_type_name
	 */
	public java.lang.String getCompTypeName () {
		return compTypeName;
	}

	/**
	 * Set the value related to the column: comp_type_name
	 * @param compTypeName the comp_type_name value
	 */
	public void setCompTypeName (java.lang.String compTypeName) {
		this.compTypeName = compTypeName;
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
		if (!(obj instanceof model.BdCompkind)) return false;
		else {
			model.BdCompkind bdCompkind = (model.BdCompkind) obj;
			if (null == this.getId() || null == bdCompkind.getId()) return false;
			else return (this.getId().equals(bdCompkind.getId()));
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