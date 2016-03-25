package model;

import model.base.BasePublishJobInfo;



public class PublishJobInfo extends BasePublishJobInfo {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PublishJobInfo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PublishJobInfo (java.lang.Integer id) {
		super(id);
	}

	//public static String PROP_JOB_INFO = "JobInfo";


	




	/**
	 * Constructor for required fields
	 */
	public String validtime;
	public java.lang.String getValidtime() {
		return validtime;
	}
	
	public void setValidtime(java.lang.String validtime) {
		this.validtime = validtime;
	}
	public  String zp_flag;
	public  String getZp_flag() {
		return zp_flag;
	}

	public  void setZp_flag(String zpFlag) {
		this.zp_flag = zpFlag;
	}

	public PublishJobInfo (
			
		java.lang.Integer id,
		model.BdEducate education,
		model.CompInfo pkComp,
		model.BdPost post,
		model.BdJob job,
		java.lang.String compLoginId,
		java.lang.String address) {

		super (
			id,
			education,
			pkComp,
			post,
			job,
			compLoginId,
			address);
	}
	

	

/*[CONSTRUCTOR MARKER END]*/


}