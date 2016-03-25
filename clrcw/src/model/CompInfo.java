package model;

import model.base.BaseCompInfo;



public class CompInfo extends BaseCompInfo {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CompInfo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CompInfo (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CompInfo (
		java.lang.Integer id,
		model.CompBespeak comp,
		model.BdCompkind type,
		model.BdTrade bd) {

		super (
			id,
			comp,
			type,
			bd);
	}

/*[CONSTRUCTOR MARKER END]*/


}