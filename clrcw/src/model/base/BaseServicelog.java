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

public abstract class BaseServicelog  implements Serializable {



	public java.lang.String getSeasonal() {
		return seasonal;
	}

	public void setSeasonal(java.lang.String seasonal) {
		this.seasonal = seasonal;
	}



	public java.lang.String getNumber() {
		return number;
	}

	public void setNumber(java.lang.String number) {
		this.number = number;
	}

	// constructors
	public BaseServicelog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseServicelog (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String jobid;
	private java.lang.String losewhy;
	private java.lang.String opinion;
	private java.lang.String createtime;	
	private java.lang.String writetime;
	private java.lang.String writeare;
	private java.lang.String writepeople;
	private java.lang.String serviceneed;
	private java.lang.String seasonal;
	private java.lang.String number;
	
	private java.lang.String otherwhy;


	public java.lang.String getOtherwhy() {
		return otherwhy;
	}

	public void setOtherwhy(java.lang.String otherwhy) {
		this.otherwhy = otherwhy;
	}


	public java.lang.String getWritetime() {
		return writetime;
	}

	public void setWritetime(java.lang.String writetime) {
		this.writetime = writetime;
	}

	public java.lang.String getWriteare() {
		return writeare;
	}

	public void setWriteare(java.lang.String writeare) {
		this.writeare = writeare;
	}

	public java.lang.String getWritepeople() {
		return writepeople;
	}

	public void setWritepeople(java.lang.String writepeople) {
		this.writepeople = writepeople;
	}

	public java.lang.String getServiceneed() {
		return serviceneed;
	}

	public void setServiceneed(java.lang.String serviceneed) {
		this.serviceneed = serviceneed;
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




	public java.lang.String getJobid() {
		return jobid;
	}

	public void setJobid(java.lang.String jobid) {
		this.jobid = jobid;
	}

	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	public java.lang.String getLosewhy() {
		return losewhy;
	}

	public void setLosewhy(java.lang.String losewhy) {
		this.losewhy = losewhy;
	}



	public java.lang.String getOpinion() {
		return opinion;
	}

	public void setOpinion(java.lang.String opinion) {
		this.opinion = opinion;
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