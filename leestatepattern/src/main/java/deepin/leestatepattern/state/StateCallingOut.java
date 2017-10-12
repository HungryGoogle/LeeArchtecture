package deepin.leestatepattern.state;

/**
 * Created by li on 2017/9/28.
 */

public class StateCallingOut implements IState {


    @Override
    public EmState getCurState() {
        return EmState.STATE_CALLING_OUT;
    }

    @Override
    public void handle(StateContext stateContext, String strConent) {
        LogUtil.log("StateCallingOut");
        stateContext.setState(new StateConnected());
    }
}
