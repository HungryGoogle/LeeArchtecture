package deepin.leestatepattern.callstate.state;

import deepin.leestatepattern.callstate.api.Peer2PeerCallback;
import deepin.leestatepattern.callstate.cmddata.BaseCallCmdData;
import deepin.leestatepattern.callstate.util.LogUtil;

/**
 * Created by li on 2017/9/28.
 */

public class StateContext {
    IState mState;
    Peer2PeerCallback mCallback;
    private boolean mAmICaller;

    public StateContext(){
        mState = new StateIdle();
    }
    protected void setState(IState state){
        mState = state;
    }
    public void handle(BaseCallCmdData cmdData){
        LogUtil.log(cmdData.toString());
        mState.handle(this, cmdData);
    }

    public void setCallback(Peer2PeerCallback callback){
        mCallback = callback;
    };

    public Peer2PeerCallback getCallback(){
        if(mCallback != null){
            return mCallback;
        }
        else {
            return new Peer2PeerCallback();
        }
    }

    public void setAmICaller(boolean amICaller){mAmICaller = amICaller;}
    public boolean amICaller(){
        return mAmICaller;
    }
}
