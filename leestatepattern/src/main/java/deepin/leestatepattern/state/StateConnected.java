package deepin.leestatepattern.state;

/**
 * Created by li on 2017/9/28.
 */

public class StateConnected implements IState {

    @Override
    public EmState getCurState() {
        return EmState.STATE_CONNECTED;
    }

    @Override
    public void handle(StateContext stateContext, String strConent) {
        LogUtil.log("StateConnected");
        stateContext.setState(new StateIdle());
    }
}
