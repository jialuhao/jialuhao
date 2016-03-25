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

public abstract class BaseAreacode  implements Serializable {

	public static String REF = "Areacode";
	public static String PROP_AREACODE = "Areacode";
	public static String PROP_AREANAME = "Areaname";
	public static String PROP_DR = "Dr";
	public static String PROP_ID = "Id";


	// constructors
	public BaseAreacode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAreacode (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String areacode;
	private java.lang.String areaname;
	private java.lang.String dr;



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




	/**
	 * Return the value associated with the column: areacode
	 */
	public java.lang.String getAreacode () {
		return areacode;
	}

	/**
	 * Set the value related to the column: areacode
	 * @param areacode the areacode value
	 */
	public void setAreacode (java.lang.String areacode) {
		this.areacode = areacode;
	}



	/**
	 * Return the value associated with the column: areaname
	 */
	public java.lang.String getAreaname () {
		return areaname;
	}

	/**
	 * Set the value related to the column: areaname
	 * @param areaname the areaname value
	 */
	public void setAreaname (java.lang.String areaname) {
		this.areaname = areaname;
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