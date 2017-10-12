package deepin.leestatepattern.callstate.state;

import deepin.leestatepattern.callstate.cmddata.BaseCallCmdData;
import deepin.leestatepattern.callstate.cmddata.ICallCmdData;
import deepin.leestatepattern.callstate.util.LogUtil;

/**
 * Created by li on 2017/9/28.
 */

public class StateConnected extends BaseState {

    StateConnected() {
        super(EmState.STATE_CONNECTED);
        LogUtil.log("new State Connected");
    }

    @Override
    public void handle(StateContext stateContext, BaseCallCmdData cmdData) {
        super.handle(stateContext, cmdData);

        if(mCmdData == null){
            return;
        }

        switch (mCmdData.getCommandId().getStrCmd()){
//            case ICallCmdData.mStrRejectCmd:{
//                LogUtil.log("connect state, calleeHangup, show StateIdle.");
//                stateContext.setState(new StateIdle());
//                stateContext.getCallback().calleeReject();
//                break;
//            }
            case ICallCmdData.mStrHangupCmd:{
                LogUtil.log("connect state, mStrHangupCmd, show StateIdle.");
                stateContext.setState(new StateIdle());
                stateContext.getCallback().calleeHangup();
                break;
            }
            default:
                LogUtil.log("not handle cmd : " + mCmdData.getCommandId().getStrCmd());
                break;
        }
    }

}
