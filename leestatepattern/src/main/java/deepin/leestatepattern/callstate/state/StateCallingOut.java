package deepin.leestatepattern.callstate.state;

import deepin.leestatepattern.callstate.cmddata.BaseCallCmdData;
import deepin.leestatepattern.callstate.cmddata.ICallCmdData;
import deepin.leestatepattern.callstate.util.LogUtil;

/**
 * Created by li on 2017/9/28.
 */

public class StateCallingOut extends BaseState {

    StateCallingOut() {
        super(EmState.STATE_CALLING_OUT);
        LogUtil.log("new State CallingOut");
    }


    @Override
    public void handle(StateContext stateContext, BaseCallCmdData cmdData) {
        super.handle(stateContext, cmdData);

        if(mCmdData == null){
            return;
        }

        switch (mCmdData.getCommandId().getStrCmd()){
            case ICallCmdData.mStrAcceptCmd:{
                LogUtil.log("callout state, peer calleeAccept, show connect activity.");
                stateContext.setState(new StateConnected());

                stateContext.getCallback().calleeAccept();
                break;
            }
            case ICallCmdData.mStrInviteCancelCmd:{
                LogUtil.log("call out state, cancel, show idle");
                stateContext.setState(new StateIdle());
                break;
            }
            case ICallCmdData.mStrRejectCmd:{
                LogUtil.log("call out state, reject, show idle");
                stateContext.setState(new StateIdle());
                stateContext.getCallback().calleeReject();
                break;
            }
            default:
                LogUtil.log("not handle cmd : " + mCmdData.getCommandId().getStrCmd());
                break;
        }
    }


}
