package deepin.leestatepattern.callstate.state;

import deepin.leestatepattern.callstate.cmddata.BaseCallCmdData;
import deepin.leestatepattern.callstate.cmddata.ICallCmdData;
import deepin.leestatepattern.callstate.util.LogUtil;

/**
 * Created by li on 2017/9/28.
 */

public class StateIdle extends BaseState {

    StateIdle() {
        super(EmState.STATE_IDLE);
        LogUtil.log("new State Idle");
    }

    @Override
    public void handle(StateContext stateContext, BaseCallCmdData cmdData) {
        super.handle(stateContext, cmdData);

        if(mCmdData == null){
            return;
        }

        switch (mCmdData.getCommandId().getStrCmd()){
            case ICallCmdData.mStrInviteCmd:{
                if(stateContext.amICaller()){
                    LogUtil.log("Idle state, show callout activity.");
                    stateContext.setState(new StateCallingOut());
                }else {
                    LogUtil.log("Idle state, show callin activity.");
                    stateContext.setState(new StateCallingIn());
                }

                break;
            }

            default:
                LogUtil.log("not handle cmd : " + mCmdData.getCommandId().getStrCmd());
                break;
        }
    }
}
