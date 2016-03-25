package model;

import model.base.BaseBdTrade;



public class BdTrade extends BaseBdTrade {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BdTrade () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BdTrade (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BdTrade (
		java.lang.Integer id,
		java.lang.String tradeName) {

		super (
			id,
			tradeName);
	}

/*[CONSTRUCTOR MARKER END]*/


}