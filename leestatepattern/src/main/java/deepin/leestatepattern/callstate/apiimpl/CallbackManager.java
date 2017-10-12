package deepin.leestatepattern.callstate.apiimpl;

import android.util.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import deepin.leestatepattern.callstate.api.Peer2PeerCallback;

public class CallbackManager {

    private Set<Peer2PeerCallback> mEventHandlers;

    public CallbackManager() {
        mEventHandlers = new HashSet<>();
    }

    public void addEventHandler(Peer2PeerCallback eventHandler) {
        mEventHandlers.add(eventHandler);
    }

    public void removeEventHandler(Peer2PeerCallback eventHandler) {
        mEventHandlers.remove(eventHandler);
    }

    public Peer2PeerCallback callBack = new Peer2PeerCallback() {

        @Override
        public void callin() {
            Log.i("leeTest-------->", "callin");
            Iterator<Peer2PeerCallback> iterator = mEventHandlers.iterator();
            while (true) {
                if (!(iterator.hasNext())) break;
                Peer2PeerCallback eventHandler = iterator.next();
                eventHandler.callin();
            }
        }

        @Override
        public void callerCancelInvite(){
            Log.i("leeTest-------->", "callerCancelInvite");
            Iterator<Peer2PeerCallback> iterator = mEventHandlers.iterator();
            while (true) {
                if (!(iterator.hasNext())) break;
                Peer2PeerCallback eventHandler = iterator.next();
                eventHandler.callerCancelInvite();
            }
        }

        @Override
        public void calleeAccept() {
            Log.i("leeTest-------->", "calleeAccept");
            Iterator<Peer2PeerCallback> iterator = mEventHandlers.iterator();
            while (true) {
                if (!(iterator.hasNext())) break;
                Peer2PeerCallback eventHandler = iterator.next();
                eventHandler.calleeAccept();
            }
        }

        @Override
        public void calleeHangup() {
            Log.i("leeTest-------->", "calleeHangup");
            Iterator<Peer2PeerCallback> iterator = mEventHandlers.iterator();
            while (true) {
                if (!(iterator.hasNext())) break;
                Peer2PeerCallback eventHandler = iterator.next();
                eventHandler.calleeHangup();
            }
        }

        @Override
        public void calleeReject() {
            Log.i("leeTest-------->", "calleeReject");
            Iterator<Peer2PeerCallback> iterator = mEventHandlers.iterator();
            while (true) {
                if (!(iterator.hasNext())) break;
                Peer2PeerCallback eventHandler = iterator.next();
                eventHandler.calleeReject();
            }
        }

        @Override
        public void calleeJoined() {
            Log.i("leeTest-------->", "calleeJoined");
            Iterator<Peer2PeerCallback> iterator = mEventHandlers.iterator();
            while (true) {
                if (!(iterator.hasNext())) break;
                Peer2PeerCallback eventHandler = iterator.next();
                eventHandler.calleeJoined();
            }
        }
    };
}
