package model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the role_function table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="role_function"
 */

public abstract class BaseRoleFunction  implements Serializable {

	public static String REF = "RoleFunction";
	public static String PROP_FUNCTION = "Function";
	public static String PROP_ROLE = "Role";
	public static String PROP_ID = "Id";


	// constructors
	public BaseRoleFunction () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRoleFunction (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseRoleFunction (
		java.lang.Integer id,
		model.BdFunction function,
		model.BdRole role) {

		this.setId(id);
		this.setFunction(function);
		this.setRole(role);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private model.BdFunction function;
	private model.BdRole role;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="pk_role_function"
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
	 * Return the value associated with the column: function_id
	 */
	public model.BdFunction getFunction () {
		return function;
	}

	/**
	 * Set the value related to the column: function_id
	 * @param function the function_id value
	 */
	public void setFunction (model.BdFunction function) {
		this.function = function;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof model.RoleFunction)) return false;
		else {
			model.RoleFunction roleFunction = (model.RoleFunction) obj;
			if (null == this.getId() || null == roleFunction.getId()) return false;
			else return (this.getId().equals(roleFunction.getId()));
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