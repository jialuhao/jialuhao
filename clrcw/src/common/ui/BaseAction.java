package common.ui;

import org.apache.struts.actions.DispatchAction;

import service.InviteManager;



public abstract class BaseAction extends DispatchAction {

	protected InviteManager inviteManager;
	//依赖注入,必须的设值注入
	public void setInviteManager(InviteManager inviteManager){
		this.inviteManager = inviteManager;
	}
	public InviteManager getInviteManager() {
        return inviteManager;
   }
}
