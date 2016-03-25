package model;

import model.base.BaseBdPostRoot;



public class BdPostRoot extends BaseBdPostRoot {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BdPostRoot () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BdPostRoot (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BdPostRoot (
		java.lang.Integer id,
		java.lang.String postName) {

		super (
			id,
			postName);
	}

/*[CONSTRUCTOR MARKER END]*/


}