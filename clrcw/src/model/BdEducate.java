package model;

import model.base.BaseBdEducate;



public class BdEducate extends BaseBdEducate {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BdEducate () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BdEducate (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BdEducate (
		java.lang.Integer id,
		java.lang.String educateName) {

		super (
			id,
			educateName);
	}

/*[CONSTRUCTOR MARKER END]*/


}