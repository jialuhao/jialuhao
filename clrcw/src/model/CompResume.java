package model;

import model.base.BaseCompResume;



public class CompResume extends BaseCompResume {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CompResume () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CompResume (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CompResume (
		java.lang.Integer id,
		model.PersonResume pkResume,
		java.lang.String compLoginId) {

		super (
			id,
			pkResume,
			compLoginId);
	}

/*[CONSTRUCTOR MARKER END]*/


}