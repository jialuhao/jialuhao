package util;

import java.util.List;




import common.exception.BaseException;
import common.ui.BaseAction;

import model.PersonResume;

public class Getmessage extends BaseAction{
	public  PersonResume  modifyserviceJob(String cardnumber)
			throws BaseException {
	
	
	List eee=super.getInviteManager().findResumeBycardnumber(cardnumber);
	Object[] vvv = (Object[]) eee.get(0);
	PersonResume personresume= (PersonResume) vvv[0];
	return personresume;
	}
}
