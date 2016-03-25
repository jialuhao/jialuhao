package model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the person_resume table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="person_resume"
 */

public abstract class BasePersonResume  implements Serializable {

	public static String REF = "PersonResume";
	public static String PROP_USER = "User";
	public static String PROP_PERSON_IMAGE = "PersonImage";
	public static String PROP_COMP_LEVEL = "CompLevel";
	public static String PROP_LANG = "Lang";
	public static String PROP_PHONE = "Phone";
	public static String PROP_LEVEL2 = "Level2";
	public static String PROP_SPECIALTY = "Specialty";
	public static String PROP_HOMEPLACE = "Homeplace";
	public static String PROP_LEVEL1 = "Level1";
	public static String PROP_LANG2 = "Lang2";
	public static String PROP_NAME = "Name";
	public static String PROP_BIRTHDAY = "Birthday";
	public static String PROP_DR = "Dr";
	public static String PROP_MAILCODE = "Mailcode";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_INTRO_SELF = "IntroSelf";
	public static String PROP_LIMIT_YEAR = "LimitYear";
	public static String PROP_ID = "Id";
	public static String PROP_EDUCATE = "Educate";
	public static String PROP_FK_PERSON_IMAGE = "FkPersonImage";
	public static String PROP_VERSION = "Version";
	public static String PROP_SCHOOL = "School";
	public static String PROP_SEX = "Sex";
	public static String PROP_QZDQ="qzdq";


	// constructors
	public BasePersonResume () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePersonResume (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePersonResume (
		java.lang.Integer id,
		model.UserInfo user,
		model.BdEducate educate,
		java.lang.String qzdq) {

		this.setId(id);
		this.setUser(user);
		this.setEducate(educate);
		this.setQzdq(qzdq);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String name;
	private byte[] personImage;
	private java.lang.String sex;
	private java.lang.String birthday;
	private java.lang.String homeplace;
	private java.lang.String address;
	private java.lang.String mailcode;
	private java.lang.String phone;
	private java.lang.String school;
	private java.lang.String specialty;
	private java.lang.String limitYear;
	private java.lang.String compLevel;
	private java.lang.String lang;
	private java.lang.String lang2;
	private java.lang.String level1;
	private java.lang.String level2;
	private java.lang.String lang3;
	private java.lang.String level3;
	private java.lang.String introSelf;
	private java.lang.Short version;
	private java.lang.String dr;
	private java.lang.String qzdq;
	private java.lang.String dkind;
	private java.lang.String dlevel;
	private java.lang.String marriage;
	private java.lang.String tool;
	private java.lang.String political;
	private java.lang.String skill;
	private java.lang.String workstate;
	private java.lang.String parts;
	private java.lang.String interests;
	private java.lang.Integer pv;
	private java.lang.String otherparts;
	private java.lang.String servicearea;
	private java.lang.String aglientcode;
	private java.lang.String cardnumber;
	private java.lang.String state;
	private java.lang.String opinion;
	public java.lang.String getOpinion() {
		return opinion;
	}

	public void setOpinion(java.lang.String opinion) {
		this.opinion = opinion;
	}

	public java.lang.String getState() {
		return state;
	}

	public void setState(java.lang.String state) {
		this.state = state;
	}

	public java.lang.String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(java.lang.String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public java.lang.String getAglientcode() {
		return aglientcode;
	}

	public void setAglientcode(java.lang.String aglientcode) {
		this.aglientcode = aglientcode;
	}

	public java.lang.String getQzdq() {
		return qzdq;
	}

	public void setQzdq(java.lang.String qzdq) {
		if(qzdq==null){
			qzdq="";
		}
		this.qzdq = qzdq;
	}



	// many to one
	private model.PersonImage fkPersonImage;
	private model.UserInfo user;
	private model.BdEducate educate;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="pk_resume"
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
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: person_image
	 */
	public byte[] getPersonImage () {
		return personImage;
	}

	/**
	 * Set the value related to the column: person_image
	 * @param personImage the person_image value
	 */
	public void setPersonImage (byte[] personImage) {
		this.personImage = personImage;
	}



	/**
	 * Return the value associated with the column: sex
	 */
	public java.lang.String getSex () {
		return sex;
	}

	/**
	 * Set the value related to the column: sex
	 * @param sex the sex value
	 */
	public void setSex (java.lang.String sex) {
		this.sex = sex;
	}



	/**
	 * Return the value associated with the column: birthday
	 */
	public java.lang.String getBirthday () {
		return birthday;
	}

	/**
	 * Set the value related to the column: birthday
	 * @param birthday the birthday value
	 */
	public void setBirthday (java.lang.String birthday) {
		this.birthday = birthday;
	}



	/**
	 * Return the value associated with the column: homeplace
	 */
	public java.lang.String getHomeplace () {
		return homeplace;
	}

	/**
	 * Set the value related to the column: homeplace
	 * @param homeplace the homeplace value
	 */
	public void setHomeplace (java.lang.String homeplace) {
		this.homeplace = homeplace;
	}



	/**
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * @param address the address value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: mailcode
	 */
	public java.lang.String getMailcode () {
		return mailcode;
	}

	/**
	 * Set the value related to the column: mailcode
	 * @param mailcode the mailcode value
	 */
	public void setMailcode (java.lang.String mailcode) {
		this.mailcode = mailcode;
	}



	/**
	 * Return the value associated with the column: phone
	 */
	public java.lang.String getPhone () {
		return phone;
	}

	/**
	 * Set the value related to the column: phone
	 * @param phone the phone value
	 */
	public void setPhone (java.lang.String phone) {
		this.phone = phone;
	}



	/**
	 * Return the value associated with the column: school
	 */
	public java.lang.String getSchool () {
		return school;
	}

	/**
	 * Set the value related to the column: school
	 * @param school the school value
	 */
	public void setSchool (java.lang.String school) {
		this.school = school;
	}



	/**
	 * Return the value associated with the column: specialty
	 */
	public java.lang.String getSpecialty () {
		return specialty;
	}

	/**
	 * Set the value related to the column: specialty
	 * @param specialty the specialty value
	 */
	public void setSpecialty (java.lang.String specialty) {
		this.specialty = specialty;
	}



	/**
	 * Return the value associated with the column: limit_year
	 */
	public java.lang.String getLimitYear () {
		return limitYear;
	}

	/**
	 * Set the value related to the column: limit_year
	 * @param limitYear the limit_year value
	 */
	public void setLimitYear (java.lang.String limitYear) {
		this.limitYear = limitYear;
	}



	/**
	 * Return the value associated with the column: comp_level
	 */
	public java.lang.String getCompLevel () {
		return compLevel;
	}

	/**
	 * Set the value related to the column: comp_level
	 * @param compLevel the comp_level value
	 */
	public void setCompLevel (java.lang.String compLevel) {
		this.compLevel = compLevel;
	}



	/**
	 * Return the value associated with the column: lang
	 */
	public java.lang.String getLang () {
		return lang;
	}

	/**
	 * Set the value related to the column: lang
	 * @param lang the lang value
	 */
	public void setLang (java.lang.String lang) {
		this.lang = lang;
	}



	/**
	 * Return the value associated with the column: lang2
	 */
	public java.lang.String getLang2 () {
		return lang2;
	}

	/**
	 * Set the value related to the column: lang2
	 * @param lang2 the lang2 value
	 */
	public void setLang2 (java.lang.String lang2) {
		this.lang2 = lang2;
	}



	/**
	 * Return the value associated with the column: level1
	 */
	public java.lang.String getLevel1 () {
		return level1;
	}

	/**
	 * Set the value related to the column: level1
	 * @param level1 the level1 value
	 */
	public void setLevel1 (java.lang.String level1) {
		this.level1 = level1;
	}



	/**
	 * Return the value associated with the column: level2
	 */
	public java.lang.String getLevel2 () {
		return level2;
	}

	/**
	 * Set the value related to the column: level2
	 * @param level2 the level2 value
	 */
	public void setLevel2 (java.lang.String level2) {
		this.level2 = level2;
	}



	/**
	 * Return the value associated with the column: intro_self
	 */
	public java.lang.String getIntroSelf () {
		return introSelf;
	}

	/**
	 * Set the value related to the column: intro_self
	 * @param introSelf the intro_self value
	 */
	public void setIntroSelf (java.lang.String introSelf) {
		this.introSelf = introSelf;
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



	public java.lang.Integer getPv() {
		return pv;
	}

	public void setPv(java.lang.Integer pv) {
		this.pv = pv;
	}

	public java.lang.String getOtherparts() {
		return otherparts;
	}

	public void setOtherparts(java.lang.String otherparts) {
		this.otherparts = otherparts;
	}

	/**
	 * Return the value associated with the column: fk_person_image
	 */
	public model.PersonImage getFkPersonImage () {
		return fkPersonImage;
	}

	/**
	 * Set the value related to the column: fk_person_image
	 * @param fkPersonImage the fk_person_image value
	 */
	public void setFkPersonImage (model.PersonImage fkPersonImage) {
		this.fkPersonImage = fkPersonImage;
	}



	/**
	 * Return the value associated with the column: user_id
	 */
	public model.UserInfo getUser () {
		return user;
	}

	/**
	 * Set the value related to the column: user_id
	 * @param user the user_id value
	 */
	public void setUser (model.UserInfo user) {
		this.user = user;
	}



	/**
	 * Return the value associated with the column: educate_id
	 */
	public model.BdEducate getEducate () {
		return educate;
	}

	/**
	 * Set the value related to the column: educate_id
	 * @param educate the educate_id value
	 */
	public void setEducate (model.BdEducate educate) {
		this.educate = educate;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof model.PersonResume)) return false;
		else {
			model.PersonResume personResume = (model.PersonResume) obj;
			if (null == this.getId() || null == personResume.getId()) return false;
			else return (this.getId().equals(personResume.getId()));
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

	public java.lang.String getDkind() {
		return dkind;
	}

	public void setDkind(java.lang.String dkind) {
		this.dkind = dkind;
	}

	public java.lang.String getDlevel() {
		return dlevel;
	}

	public void setDlevel(java.lang.String dlevel) {
		this.dlevel = dlevel;
	}

	public java.lang.String getMarriage() {
		return marriage;
	}

	public void setMarriage(java.lang.String marriage) {
		this.marriage = marriage;
	}

	public java.lang.String getTool() {
		return tool;
	}

	public void setTool(java.lang.String tool) {
		this.tool = tool;
	}

	public java.lang.String getPolitical() {
		return political;
	}

	public void setPolitical(java.lang.String political) {
		this.political = political;
	}

	public java.lang.String getSkill() {
		return skill;
	}

	public void setSkill(java.lang.String skill) {
		this.skill = skill;
	}

	public java.lang.String getWorkstate() {
		return workstate;
	}

	public void setWorkstate(java.lang.String workstate) {
		this.workstate = workstate;
	}

	public java.lang.String getParts() {
		return parts;
	}

	public void setParts(java.lang.String parts) {
		this.parts = parts;
	}

	public java.lang.String getLang3() {
		return lang3;
	}

	public void setLang3(java.lang.String lang3) {
		this.lang3 = lang3;
	}

	public java.lang.String getLevel3() {
		return level3;
	}

	public void setLevel3(java.lang.String level3) {
		this.level3 = level3;
	}

	public java.lang.String getInterests() {
		return interests;
	}

	public void setInterests(java.lang.String interests) {
		this.interests = interests;
	}

	public java.lang.String getServicearea() {
		return servicearea;
	}

	public void setServicearea(java.lang.String servicearea) {
		this.servicearea = servicearea;
	}


}