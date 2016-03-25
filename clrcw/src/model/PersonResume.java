package model;

import model.base.BasePersonResume;



public class PersonResume extends BasePersonResume {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PersonResume () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PersonResume (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public PersonResume (
		java.lang.Integer id,
		model.UserInfo user,
		model.BdEducate educate,
		java.lang.String qzdq) {

		super (
			id,
			user,
			educate,
			qzdq);
	}

/*[CONSTRUCTOR MARKER END]*/


}