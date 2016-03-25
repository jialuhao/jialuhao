package model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the user_role table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="user_role"
 */

public abstract class BaseUserRole  implements Serializable {

	public static String REF = "UserRole";
	public static String PROP_USER = "User";
	public static String PROP_ROLE = "Role";
	public static String PROP_ID = "Id";


	// constructors
	public BaseUserRole () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUserRole (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUserRole (
		java.lang.Integer id,
		model.BdRole role,
		model.ManaUser user) {

		this.setId(id);
		this.setRole(role);
		this.setUser(user);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private model.BdRole role;
	private model.ManaUser user;



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
	 * Return the value associated with the column: role_id
	 */
	public model.BdRole getRole () {
		return role;
	}

	/**
	 * Set the value related to the column: role_id
	 * @param role the role_id value
	 */
	public void setRole (model.BdRole role) {
		this.role = role;
	}



	/**
	 * Return the value associated with the column: user_id
	 */
	public model.ManaUser getUser () {
		return user;
	}

	/**
	 * Set the value related to the column: user_id
	 * @param user the user_id value
	 */
	public void setUser (model.ManaUser user) {
		this.user = user;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof model.UserRole)) return false;
		else {
			model.UserRole userRole = (model.UserRole) obj;
			if (null == this.getId() || null == userRole.getId()) return false;
			else return (this.getId().equals(userRole.getId()));
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