package model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the commoncode table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="commoncode"
 */

public abstract class BaseCommoncode  implements Serializable {

	public static String REF = "Commoncode";
	public static String PROP_FLAG = "Flag";
	public static String PROP_COMMONTYPE = "Commontype";
	public static String PROP_DR = "Dr";
	public static String PROP_ID = "Id";
	public static String PROP_COMMONVALUES = "Commonvalues";
	public static String PROP_CODE = "Code";


	// constructors
	public BaseCommoncode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCommoncode (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String commontype;
	private java.lang.String code;
	private java.lang.String commonvalues;
	private java.lang.String flag;
	private java.lang.String dr;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="ID"
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
	 * Return the value associated with the column: commontype
	 */
	public java.lang.String getCommontype () {
		return commontype;
	}

	/**
	 * Set the value related to the column: commontype
	 * @param commontype the commontype value
	 */
	public void setCommontype (java.lang.String commontype) {
		this.commontype = commontype;
	}



	/**
	 * Return the value associated with the column: code
	 */
	public java.lang.String getCode () {
		return code;
	}

	/**
	 * Set the value related to the column: code
	 * @param code the code value
	 */
	public void setCode (java.lang.String code) {
		this.code = code;
	}



	/**
	 * Return the value associated with the column: commonvalues
	 */
	public java.lang.String getCommonvalues () {
		return commonvalues;
	}

	/**
	 * Set the value related to the column: commonvalues
	 * @param commonvalues the commonvalues value
	 */
	public void setCommonvalues (java.lang.String commonvalues) {
		this.commonvalues = commonvalues;
	}



	/**
	 * Return the value associated with the column: flag
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: flag
	 * @param flag the flag value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
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
		if (!(obj instanceof model.Commoncode)) return false;
		else {
			model.Commoncode commoncode = (model.Commoncode) obj;
			if (null == this.getId() || null == commoncode.getId()) return false;
			else return (this.getId().equals(commoncode.getId()));
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