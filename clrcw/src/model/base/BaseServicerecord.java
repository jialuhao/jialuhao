package model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the areacode table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="areacode"
 */

public abstract class BaseServicerecord  implements Serializable {



	// constructors
	public BaseServicerecord () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseServicerecord (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String name;
	private java.lang.String job;
	private java.lang.String levels;
	private java.lang.String phone;
	private java.lang.String people;
	private java.lang.String serviceid;


	public java.lang.String getPhone() {
		return phone;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
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




	

	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	
	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getJob() {
		return job;
	}

	public void setJob(java.lang.String job) {
		this.job = job;
	}

	public java.lang.String getLevels() {
		return levels;
	}

	public void setLevels(java.lang.String levels) {
		this.levels = levels;
	}

	public java.lang.String getPeople() {
		return people;
	}

	public void setPeople(java.lang.String people) {
		this.people = people;
	}

	public java.lang.String getServiceid() {
		return serviceid;
	}

	public void setServiceid(java.lang.String serviceid) {
		this.serviceid = serviceid;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof model.Areacode)) return false;
		else {
			model.Areacode areacode = (model.Areacode) obj;
			if (null == this.getId() || null == areacode.getId()) return false;
			else return (this.getId().equals(areacode.getId()));
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
