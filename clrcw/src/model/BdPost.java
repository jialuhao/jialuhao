package model;

import model.base.BaseBdPost;



public class BdPost extends BaseBdPost {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BdPost () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BdPost (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BdPost (
		java.lang.Integer id,
		model.BdPostRoot postIdRoot,
		java.lang.String postName) {

		super (
			id,
			postIdRoot,
			postName);
	}

/*[CONSTRUCTOR MARKER END]*/


}