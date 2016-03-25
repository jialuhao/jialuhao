package model;

import model.base.BaseRoleFunction;



public class RoleFunction extends BaseRoleFunction {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public RoleFunction () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public RoleFunction (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public RoleFunction (
		java.lang.Integer id,
		model.BdFunction function,
		model.BdRole role) {

		super (
			id,
			function,
			role);
	}

/*[CONSTRUCTOR MARKER END]*/


}