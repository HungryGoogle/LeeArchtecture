package deepin.leestatepattern.state;

/**
 * Created by li on 2017/9/28.
 */

public class StateIdle implements IState {

    @Override
    public EmState getCurState() {
        return EmState.STATE_IDLE;
    }

    @Override
    public void handle(StateContext stateContext, String strConent) {
        LogUtil.log("StateIdle");
        stateContext.setState(new StateCallingOut());
    }
}
