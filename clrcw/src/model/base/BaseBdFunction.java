package model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bd_function table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bd_function"
 */

public abstract class BaseBdFunction  implements Serializable {

	public static String REF = "BdFunction";
	public static String PROP_NAME = "Name";
	public static String PROP_ID = "Id";


	// constructors
	public BaseBdFunction () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdFunction (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBdFunction (
		java.lang.Integer id,
		java.lang.String name) {

		this.setId(id);
		this.setName(name);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String name;

	// collections
	private java.util.Set<model.RoleFunction> roleFunctions;



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
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof model.BdFunction)) return false;
		else {
			model.BdFunction bdFunction = (model.BdFunction) obj;
			if (null == this.getId() || null == bdFunction.getId()) return false;
			else return (this.getId().equals(bdFunction.getId()));
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