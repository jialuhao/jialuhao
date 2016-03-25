package model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the comp_info table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="comp_info"
 */

public abstract class BaseCompService  implements Serializable {




	// constructors
	public BaseCompService () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCompService (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	
	private java.lang.String pkjob;
	private java.lang.String name;
	private java.lang.String number;
	private java.lang.String phone;
	private java.lang.String losewhy;
	private java.lang.String house;
	private java.lang.String workname;
	private java.lang.String remark;
	private java.lang.String otherwhy;
	public java.lang.String getHouse() {
		return house;
	}

	public java.lang.String getOtherwhy() {
		return otherwhy;
	}

	public void setOtherwhy(java.lang.String otherwhy) {
		this.otherwhy = otherwhy;
	}

	public void setHouse(java.lang.String house) {
		this.house = house;
	}

	public java.lang.String getWorkname() {
		return workname;
	}

	public void setWorkname(java.lang.String workname) {
		this.workname = workname;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="pk_comp"
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

	public java.lang.String getPkjob() {
		return pkjob;
	}

	public void setPkjob(java.lang.String pkjob) {
		this.pkjob = pkjob;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getNumber() {
		return number;
	}

	public void setNumber(java.lang.String number) {
		this.number = number;
	}

	public java.lang.String getPhone() {
		return phone;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	public java.lang.String getLosewhy() {
		return losewhy;
	}

	public void setLosewhy(java.lang.String losewhy) {
		this.losewhy = losewhy;
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