package model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the comp_info table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="comp_info"
 */

public abstract class BaseCompInfo  implements Serializable {

	public static String REF = "CompInfo";
	public static String PROP_BD = "Bd";
	public static String PROP_DR = "Dr";
	public static String PROP_COMPCOUNT = "compcount";
	public static String PROP_FAX = "fax";
	public static String PROP_WORK_SCROP = "WorkScrop";
	public static String PROP_TYPE = "Type";
	public static String PROP_NET_ADDRESS = "NetAddress";
	public static String PROP_ID = "Id";
	public static String PROP_COMP_INTRO = "CompIntro";
	public static String PROP_RESUME_STATUS = "ResumeStatus";
	public static String PROP_VERSION = "Version";
	public static String PROP_COMP = "Comp";


	// constructors
	public BaseCompInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCompInfo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCompInfo (
		java.lang.Integer id,
		model.CompBespeak comp,
		model.BdCompkind type,
		model.BdTrade bd) {

		this.setId(id);
		this.setComp(comp);
		this.setType(type);
		this.setBd(bd);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String workScrop;
	private java.lang.String netAddress;
	private java.lang.String compIntro;
	private java.lang.String resumeStatus;
	private java.lang.Short version;
	private java.lang.String dr;
	private java.lang.String fax;
	private java.lang.String compcount;

	// many to one
	private model.CompBespeak comp;
	private model.BdCompkind type;
	private model.BdTrade bd;

	// collections
	private java.util.Set<model.PublishJobInfo> publishJobInfos;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="pk_comp"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: work_scrop
	 */
	public java.lang.String getWorkScrop () {
		return workScrop;
	}

	/**
	 * Set the value related to the column: work_scrop
	 * @param workScrop the work_scrop value
	 */
	public void setWorkScrop (java.lang.String workScrop) {
		this.workScrop = workScrop;
	}



	/**
	 * Return the value associated with the column: net_address
	 */
	public java.lang.String getNetAddress () {
		return netAddress;
	}

	/**
	 * Set the value related to the column: net_address
	 * @param netAddress the net_address value
	 */
	public void setNetAddress (java.lang.String netAddress) {
		this.netAddress = netAddress;
	}



	/**
	 * Return the value associated with the column: comp_intro
	 */
	public java.lang.String getCompIntro () {
		return compIntro;
	}

	/**
	 * Set the value related to the column: comp_intro
	 * @param compIntro the comp_intro value
	 */
	public void setCompIntro (java.lang.String compIntro) {
		this.compIntro = compIntro;
	}



	/**
	 * Return the value associated with the column: resume_status
	 */
	public java.lang.String getResumeStatus () {
		return resumeStatus;
	}

	/**
	 * Set the value related to the column: resume_status
	 * @param resumeStatus the resume_status value
	 */
	public void setResumeStatus (java.lang.String resumeStatus) {
		this.resumeStatus = resumeStatus;
	}



	/**
	 * Return the value associated with the column: version
	 */
	public java.lang.Short getVersion () {
		return version;
	}

	/**
	 * Set the value related to the column: version
	 * @param version the version value
	 */
	public void setVersion (java.lang.Short version) {
		this.version = version;
	}



	/**
	 * Return the value associated with the column: dr
	 */
	public java.lang.String getDr () {
		return dr;
	}

	/**
	 * Set the value related to the column: dr
	 * @param dr the dr value
	 */
	public void setDr (java.lang.String dr) {
		this.dr = dr;
	}



	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	public java.lang.String getFax() {
		return fax;
	}

	public void setFax(java.lang.String fax) {
		this.fax = fax;
	}

	public java.lang.String getCompcount() {
		return compcount;
	}

	public void setCompcount(java.lang.String compcount) {
		this.compcount = compcount;
	}

	/**
	 * Return the value associated with the column: comp_id
	 */
	public model.CompBespeak getComp () {
		return comp;
	}

	/**
	 * Set the value related to the column: comp_id
	 * @param comp the comp_id value
	 */
	public void setComp (model.CompBespeak comp) {
		this.comp = comp;
	}



	/**
	 * Return the value associated with the column: type_id
	 */
	public model.BdCompkind getType () {
		return type;
	}

	/**
	 * Set the value related to the column: type_id
	 * @param type the type_id value
	 */
	public void setType (model.BdCompkind type) {
		this.type = type;
	}



	/**
	 * Return the value associated with the column: bd__id
	 */
	public model.BdTrade getBd () {
		return bd;
	}

	/**
	 * Set the value related to the column: bd__id
	 * @param bd the bd__id value
	 */
	public void setBd (model.BdTrade bd) {
		this.bd = bd;
	}



	/**
	 * Return the value associated with the column: PublishJobInfos
	 */
	public java.util.Set<model.PublishJobInfo> getPublishJobInfos () {
		return publishJobInfos;
	}

	/**
	 * Set the value related to the column: PublishJobInfos
	 * @param publishJobInfos the PublishJobInfos value
	 */
	public void setPublishJobInfos (java.util.Set<model.PublishJobInfo> publishJobInfos) {
		this.publishJobInfos = publishJobInfos;
	}

	public void addToPublishJobInfos (model.PublishJobInfo publishJobInfo) {
		if (null == getPublishJobInfos()) setPublishJobInfos(new java.util.TreeSet<model.PublishJobInfo>());
		getPublishJobInfos().add(publishJobInfo);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof model.CompInfo)) return false;
		else {
			model.CompInfo compInfo = (model.CompInfo) obj;
			if (null == this.getId() || null == compInfo.getId()) return false;
			else return (this.getId().equals(compInfo.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}