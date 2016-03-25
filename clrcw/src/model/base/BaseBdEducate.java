package model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bd_educate table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bd_educate"
 */

public abstract class BaseBdEducate  implements Serializable {

	public static String REF = "BdEducate";
	public static String PROP_DR = "Dr";
	public static String PROP_ID = "Id";
	public static String PROP_EDUCATE_NAME = "EducateName";
	public static String PROP_VERSION = "Version";


	// constructors
	public BaseBdEducate () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdEducate (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBdEducate (
		java.lang.Integer id,
		java.lang.String educateName) {

		this.setId(id);
		this.setEducateName(educateName);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String educateName;
	private java.lang.Short version;
	private java.lang.String dr;

	// collections
	private java.util.Set<model.PersonResume> personResumes;
	private java.util.Set<model.PublishJobInfo> publishJobInfos;



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
	 * Return the value associated with the column: educate_name
	 */
	public java.lang.String getEducateName () {
		return educateName.trim();
	}

	/**
	 * Set the value related to the column: educate_name
	 * @param educateName the educate_name value
	 */
	public void setEducateName (java.lang.String educateName) {
		this.educateName = educateName;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof model.BdEducate)) return false;
		else {
			model.BdEducate bdEducate = (model.BdEducate) obj;
			if (null == this.getId() || null == bdEducate.getId()) return false;
			else return (this.getId().equals(bdEducate.getId()));
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