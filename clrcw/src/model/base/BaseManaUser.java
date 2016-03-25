package model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mana_user table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mana_user"
 */

public abstract class BaseManaUser  implements Serializable {

	public static String REF = "ManaUser";
	public static String PROP_DR = "Dr";
	public static String PROP_PASSWORD = "Password";
	public static String PROP_ACCOUNT = "Account";
	public static String PROP_AREACODE = "areacode";
	public static String PROP_ID = "Id";
	public static String PROP_VERSION = "Version";


	// constructors
	public BaseManaUser () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseManaUser (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String account;
	private java.lang.String password;
	private java.lang.Short version;
	private java.lang.String areacode;
	private java.lang.String dr;

	// collections
	private java.util.Set<model.UserRole> userRoles;



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
	 * Return the value associated with the column: account
	 */
	public java.lang.String getAccount () {
		return account;
	}

	/**
	 * Set the value related to the column: account
	 * @param account the account value
	 */
	public void setAccount (java.lang.String account) {
		this.account = account;
	}



	/**
	 * Return the value associated with the column: password
	 */
	public java.lang.String getPassword () {
		return password;
	}

	/**
	 * Set the value related to the column: password
	 * @param password the password value
	 */
	public void setPassword (java.lang.String password) {
		this.password = password;
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



	public java.lang.String getAreacode() {
		return areacode;
	}

	public void setAreacode(java.lang.String areacode) {
		this.areacode = areacode;
	}

	/**
	 * Return the value associated with the column: UserRoles
	 */
	public java.util.Set<model.UserRole> getUserRoles () {
		return userRoles;
	}

	/**
	 * Set the value related to the column: UserRoles
	 * @param userRoles the UserRoles value
	 */
	public void setUserRoles (java.util.Set<model.UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public void addToUserRoles (model.UserRole userRole) {
		if (null == getUserRoles()) setUserRoles(new java.util.TreeSet<model.UserRole>());
		getUserRoles().add(userRole);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof model.ManaUser)) return false;
		else {
			model.ManaUser manaUser = (model.ManaUser) obj;
			if (null == this.getId() || null == manaUser.getId()) return false;
			else return (this.getId().equals(manaUser.getId()));
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