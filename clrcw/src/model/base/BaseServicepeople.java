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

public abstract class BaseServicepeople  implements Serializable {


	// constructors
	public BaseServicepeople () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseServicepeople (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String serviceid;
	private java.lang.String phone;
	private java.lang.String sname;
	private java.lang.String job;

	private java.lang.String register;
	private java.lang.String jobname;
	private java.lang.String remark;

	public java.lang.String getRegister() {
		return register;
	}

	public void setRegister(java.lang.String register) {
		this.register = register;
	}

	public java.lang.String getJobname() {
		return jobname;
	}

	public void setJobname(java.lang.String jobname) {
		this.jobname = jobname;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public java.lang.String getDisnumber() {
		return disnumber;
	}

	public void setDisnumber(java.lang.String disnumber) {
		this.disnumber = disnumber;
	}



	private java.lang.String createtime;
	private java.lang.String disnumber;



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




	




	public java.lang.String getServiceid() {
		return serviceid;
	}

	public void setServiceid(java.lang.String serviceid) {
		this.serviceid = serviceid;
	}



	

	

	

	public java.lang.String getPhone() {
		return phone;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	public java.lang.String getSname() {
		return sname;
	}

	public void setSname(java.lang.String sname) {
		this.sname = sname;
	}

	public java.lang.String getJob() {
		return job;
	}

	public void setJob(java.lang.String job) {
		this.job = job;
	}


	public java.lang.String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(java.lang.String createtime) {
		this.createtime = createtime;
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