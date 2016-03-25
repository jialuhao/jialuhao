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

public abstract class BasePersonImage  implements Serializable {

	public static String REF = "PersonImage";
	public static String PROP_PERSON_IMAGE = "PersonImage";
	public static String PROP_DR = "Dr";
	public static String PROP_ID = "Id";
	public static String PROP_VERSION = "Version";


	// constructors
	public BasePersonImage () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePersonImage (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private byte[] personImage;
	private java.lang.Short version;
	private java.lang.String dr;

	// collections
	private java.util.Set<model.PersonResume> personResumes;



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




	/**
	 * Return the value associated with the column: person_image
	 */
	public byte[] getPersonImage () {
		return personImage;
	}

	/**
	 * Set the value related to the column: person_image
	 * @param personImage the person_image value
	 */
	public void setPersonImage (byte[] personImage) {
		this.personImage = personImage;
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
	 * Return the value associated with the column: PersonResumes
	 */
	public java.util.Set<model.PersonResume> getPersonResumes () {
		return personResumes;
	}

	/**
	 * Set the value related to the column: PersonResumes
	 * @param personResumes the PersonResumes value
	 */
	public void setPersonResumes (java.util.Set<model.PersonResume> personResumes) {
		this.personResumes = personResumes;
	}

	public void addToPersonResumes (model.PersonResume personResume) {
		if (null == getPersonResumes()) setPersonResumes(new java.util.TreeSet<model.PersonResume>());
		getPersonResumes().add(personResume);
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