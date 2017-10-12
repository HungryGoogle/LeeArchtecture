package deepin.leestatepattern.state;

/**
 * Created by li on 2017/9/28.
 */

public interface IState {
    enum EmState{
        STATE_IDLE,
        STATE_CALLING_OUT,
        STATE_CONNECTED
    }

    EmState getCurState();
    void handle(StateContext stateContext, String strConent);
}
