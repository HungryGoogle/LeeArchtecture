package deepin.leestatepattern.callstate.state;

import deepin.leestatepattern.callstate.cmddata.BaseCallCmdData;

/**
 * Created by li on 2017/9/28.
 */

public interface IState {

    enum EmState{
        STATE_EMPTY("empty"),
        STATE_IDLE("IDLE state"),
        STATE_CALLING_OUT("call out state"),
        STATE_CALLING_IN("call in state"),
        STATE_CONNECTED("connect state");

        String mCurState;
        EmState(String state) {
            mCurState = state;
        }

        String getStrState(){
            return mCurState;
        }
    }

    EmState getCurState();
    void handle(StateContext stateContext, BaseCallCmdData cmdData);
}
