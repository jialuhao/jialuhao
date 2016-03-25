package model;

import model.base.BaseBdCompkind;



public class BdCompkind extends BaseBdCompkind {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BdCompkind () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BdCompkind (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BdCompkind (
		java.lang.Integer id,
		java.lang.String compTypeName) {

		super (
			id,
			compTypeName);
	}

/*[CONSTRUCTOR MARKER END]*/


}