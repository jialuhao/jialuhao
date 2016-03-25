package model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bd_role table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bd_role"
 */

public abstract class BaseBdRole  implements Serializable {

	public static String REF = "BdRole";
	public static String PROP_ROLE_NAME = "RoleName";
	public static String PROP_ID = "Id";


	// constructors
	public BaseBdRole () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdRole (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBdRole (
		java.lang.Integer id,
		java.lang.String roleName) {

		this.setId(id);
		this.setRoleName(roleName);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String roleName;

	// collections
	private java.util.Set<model.RoleFunction> roleFunctions;
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
	 * Return the value associated with the column: role_name
	 */
	public java.lang.String getRoleName () {
		return roleName;
	}

	/**
	 * Set the value related to the column: role_name
	 * @param roleName the role_name value
	 */
	public void setRoleName (java.lang.String roleName) {
		this.roleName = roleName;
	}



	/**
	 * Return the value associated with the column: RoleFunctions
	 */
	public java.util.Set<model.RoleFunction> getRoleFunctions () {
		return roleFunctions;
	}

	/**
	 * Set the value related to the column: RoleFunctions
	 * @param roleFunctions the RoleFunctions value
	 */
	public void setRoleFunctions (java.util.Set<model.RoleFunction> roleFunctions) {
		this.roleFunctions = roleFunctions;
	}

	public void addToRoleFunctions (model.RoleFunction roleFunction) {
		if (null == getRoleFunctions()) setRoleFunctions(new java.util.TreeSet<model.RoleFunction>());
		getRoleFunctions().add(roleFunction);
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
		if (!(obj instanceof model.BdRole)) return false;
		else {
			model.BdRole bdRole = (model.BdRole) obj;
			if (null == this.getId() || null == bdRole.getId()) return false;
			else return (this.getId().equals(bdRole.getId()));
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