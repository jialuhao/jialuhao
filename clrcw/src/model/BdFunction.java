package model;

import model.base.BaseBdFunction;



public class BdFunction extends BaseBdFunction {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BdFunction () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BdFunction (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BdFunction (
		java.lang.Integer id,
		java.lang.String name) {

		super (
			id,
			name);
	}

/*[CONSTRUCTOR MARKER END]*/


}