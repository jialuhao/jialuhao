package model;

import model.base.BaseUserRole;



public class UserRole extends BaseUserRole {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public UserRole () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public UserRole (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public UserRole (
		java.lang.Integer id,
		model.BdRole role,
		model.ManaUser user) {

		super (
			id,
			role,
			user);
	}

/*[CONSTRUCTOR MARKER END]*/


}