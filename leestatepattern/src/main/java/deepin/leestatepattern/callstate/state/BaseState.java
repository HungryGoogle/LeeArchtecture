package deepin.leestatepattern.callstate.state;

import deepin.leestatepattern.callstate.cmddata.BaseCallCmdData;
import deepin.leestatepattern.callstate.util.LogUtil;

/**
 * Created by Li on 2017/10/2.
 */

public class BaseState implements IState {
    protected BaseCallCmdData mCmdData;
    private StateContext mStateContext;
    protected EmState mCurState = EmState.STATE_EMPTY;

    BaseState(EmState state){
        mCurState = state;
    }

    @Override
    public EmState getCurState() {
        return mCurState;
    }

    @Override
    public void handle(StateContext stateContext, BaseCallCmdData cmdData) {
        mStateContext = stateContext;
        mCmdData = cmdData;

        LogUtil.log("cur state : " + mCurState.getStrState());
    }
}
