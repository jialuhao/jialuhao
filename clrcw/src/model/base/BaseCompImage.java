package model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the person_image table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="person_image"
 */

public abstract class BaseCompImage  implements Serializable {

	public static String REF = "CompImage";
	public static String PROP_COMP_IMAGE = "CompImage";
	public static String PROP_DR = "Dr";
	public static String PROP_ID = "Id";
	public static String PROP_VERSION = "Version";


	// constructors
	public BaseCompImage () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCompImage (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private byte[] compImage;
	private java.lang.Short version;
	private java.lang.String dr;

	// collections
	private java.util.Set<model.CompBespeak> compbespeak;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="pk_image"
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




	



	public byte[] getCompImage() {
		return compImage;
	}

	public void setCompImage(byte[] compImage) {
		this.compImage = compImage;
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


	public java.util.Set<model.CompBespeak> getCompbespeak() {
		return compbespeak;
	}

	public void setCompbespeak(java.util.Set<model.CompBespeak> compbespeak) {
		this.compbespeak = compbespeak;
	}
	/**
	 * Return the value associated with the column: PersonResumes
	 */
	

	public void addToPersonResumes (model.CompBespeak compbespeak) {
		if (null == getCompbespeak()) setCompbespeak(new java.util.TreeSet<model.CompBespeak>());
		getCompbespeak().add(compbespeak);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof model.PersonImage)) return false;
		else {
			model.PersonImage personImage = (model.PersonImage) obj;
			if (null == this.getId() || null == personImage.getId()) return false;
			else return (this.getId().equals(personImage.getId()));
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