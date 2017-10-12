package deepin.leestatepattern.state;

/**
 * Created by li on 2017/9/28.
 */

public class StateContext {
    IState mState;

    public StateContext(){
        mState = new StateIdle();
    }

    public void setState(IState state){
        mState = state;
    }


    public void handle(String data){
        mState.handle(this, data);
    }
}
