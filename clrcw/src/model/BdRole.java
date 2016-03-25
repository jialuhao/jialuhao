package model;

import model.base.BaseBdRole;



public class BdRole extends BaseBdRole {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BdRole () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BdRole (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BdRole (
		java.lang.Integer id,
		java.lang.String roleName) {

		super (
			id,
			roleName);
	}

/*[CONSTRUCTOR MARKER END]*/


}