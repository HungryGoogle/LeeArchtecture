package deepin.leestatepattern.callstate.api;

import deepin.leestatepattern.callstate.apiimpl.CallManagerImpl;

/**
 * Created by Li on 2017/10/3.
 */

public class Peer2PeerSDK {
    public void callout(String strCallee){};
    public void caller_joined(){};
    public void hangup(){};
    public void cancelCallout(){};
    public void accept(){};
    public void reject(){};

    public void cmdComeIn(String strCallee){};

    public void addCallback(Peer2PeerCallback callback){};
    public void removeCallback(Peer2PeerCallback callback){};


    public static final Peer2PeerSDK ins = new CallManagerImpl();
    public static Peer2PeerSDK getIns() {
        return ins;
    }
}
