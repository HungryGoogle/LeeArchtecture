package deepin.leestatepattern.callstate.state;

import deepin.leestatepattern.callstate.cmddata.BaseCallCmdData;
import deepin.leestatepattern.callstate.cmddata.ICallCmdData;
import deepin.leestatepattern.callstate.util.LogUtil;

/**
 * Created by li on 2017/9/28.
 */

public class StateCallingIn extends BaseState {

    StateCallingIn() {
        super(EmState.STATE_CALLING_IN);
        LogUtil.log("new State CallingIn");
    }

    @Override
    public void handle(StateContext stateContext, BaseCallCmdData cmdData) {
        super.handle(stateContext, cmdData);

        if(mCmdData == null){
            return;
        }

        switch (mCmdData.getCommandId().getStrCmd()){
            case ICallCmdData.mStrAcceptCmd:{
                LogUtil.log("call in state, calleeAccept, show connected activity.");
                stateContext.setState(new StateConnected());
                break;
            }
            case ICallCmdData.mStrInviteCancelCmd:{
                LogUtil.log("call in state, cancel, show idle");
                stateContext.setState(new StateIdle());
                stateContext.getCallback().callerCancelInvite();
                break;
            }
            case ICallCmdData.mStrRejectCmd:{
                LogUtil.log("call in state, reject, show idle");
                stateContext.setState(new StateIdle());
                break;
            }

            default:
                LogUtil.log("not handle cmd : " + mCmdData.getCommandId().getStrCmd());
                break;
        }
    }


}
