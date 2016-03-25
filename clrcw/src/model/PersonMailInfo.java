package model;

import model.base.BasePersonMailInfo;



public class PersonMailInfo extends BasePersonMailInfo {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PersonMailInfo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PersonMailInfo (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public PersonMailInfo (
		java.lang.Integer id,
		model.PublishJobInfo compJob) {

		super (
			id,
			compJob);
	}

/*[CONSTRUCTOR MARKER END]*/


}