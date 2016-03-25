package model;

import model.base.BaseBdJob;



public class BdJob extends BaseBdJob {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BdJob () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BdJob (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BdJob (
		java.lang.Integer id,
		java.lang.String jobName,
		java.lang.Short version) {

		super (
			id,
			jobName,
			version);
	}
	/**
	 * Constructor for required fields
	 */
   public BdJob(java.lang.Integer id,java.lang.String jobName,java.lang.Short version,java.lang.String address){
	   
	   super (
				id,
				jobName,
				version);
	   
   }
	
/*[CONSTRUCTOR MARKER END]*/


}