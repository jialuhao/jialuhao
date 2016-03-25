package model.base;

import java.io.Serializable;

import model.BdSalary;


/**
 * This is an object that contains data related to the areacode table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="areacode"
 */

public abstract class BaseSalary  implements Serializable {

	public static String REF = "Salarycode";
	public static String PROP_SalaryCODE = "Salarycode";
	public static String PROP_SalaryNAME = "Salaryname";
	public static String PROP_DR = "Dr";
	public static String PROP_ID = "Id";


	// constructors
	public BaseSalary () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSalary (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String salarycode;
	private java.lang.String salaryname;
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
	 * Return the value associated with the column: salarycode
	 */
	public java.lang.String getSalarycode () {
		return salarycode;
	}

	/**
	 * Set the value related to the column: salarycode
	 * @param salarycode the salarycode value
	 */
	public void setSalarycode (java.lang.String salarycode) {
		this.salarycode = salarycode;
	}



	/**
	 * Return the value associated with the column: salaryname
	 */
	public java.lang.String getSalaryname () {
		return salaryname;
	}

	/**
	 * Set the value related to the column: salaryname
	 * @param salaryname the salaryname value
	 */
	public void setSalaryname (java.lang.String salaryname) {
		this.salaryname = salaryname;
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
		if (!(obj instanceof BdSalary)) return false;
		else {
			BdSalary salarycode = (BdSalary) obj;
			if (null == this.getId() || null == salarycode.getId()) return false;
			else return (this.getId().equals(salarycode.getId()));
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