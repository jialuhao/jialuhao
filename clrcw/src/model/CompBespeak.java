package model;

import model.base.BaseCompBespeak;



public class CompBespeak extends BaseCompBespeak {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CompBespeak () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CompBespeak (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CompBespeak (
		java.lang.Integer id,
		java.lang.String userId,
		java.lang.String password,
		java.lang.String compName,
		java.lang.String compAddr,
		java.lang.String telephone,
		java.lang.String linkman,
		java.lang.String mail,
		java.lang.String compnum,
		java.lang.String comparea,
		java.lang.String cardnum) {

		super (
			id,
			userId,
			password,
			compName,
			compAddr,
			telephone,
			linkman,
			mail,
			compnum,
			comparea,
			cardnum);
	}
	private java.lang.String aglientcode;

	public java.lang.String getAglientcode() {
		return aglientcode;
	}

	public void setAglientcode(java.lang.String aglientcode) {
		this.aglientcode = aglientcode;
	}
/*[CONSTRUCTOR MARKER END]*/


}