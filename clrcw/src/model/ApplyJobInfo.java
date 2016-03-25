package model;

import model.base.BaseApplyJobInfo;



public class ApplyJobInfo extends BaseApplyJobInfo {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ApplyJobInfo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ApplyJobInfo (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ApplyJobInfo (
		java.lang.Integer id,
		model.PersonResume resumeCode,
		model.BdJob jobCode,
		model.BdTrade postCode,
		model.UserInfo personCode,
		java.lang.String createTime) {

		super (
			id,
			resumeCode,
			jobCode,
			postCode,
			personCode,
			createTime	
		);
	}

/*[CONSTRUCTOR MARKER END]*/


}