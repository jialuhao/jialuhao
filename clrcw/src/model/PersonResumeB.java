package model;

import model.base.BasePersonResumeB;



public class PersonResumeB extends BasePersonResumeB {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PersonResumeB () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PersonResumeB (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public PersonResumeB (
		java.lang.Integer id,
		model.PersonResume resume,
		java.lang.String userLoginId) {

		super (
			id,
			resume,
			userLoginId);
	}

/*[CONSTRUCTOR MARKER END]*/


}