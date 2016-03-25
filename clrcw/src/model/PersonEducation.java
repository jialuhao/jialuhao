package model;

import model.base.BasePersonEducation;
import model.base.BasePersonResumeB;
/**
 *<p>Title: 个人简历教育培训经历</p>
 *
 *<p>Description: </p>
 *
 *<p>Company: 太极</p>
 *
 * @author 苏成龙
 *
 * @version 1.0
 * 
 * table="person_Education"
 */


public class PersonEducation extends BasePersonEducation {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PersonEducation () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PersonEducation (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public PersonEducation (
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