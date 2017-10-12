package deepin.leestatepattern.callstate.callactivity;

import android.app.Activity;
import android.os.Bundle;

import deepin.leestatepattern.R;
import deepin.leestatepattern.callstate.api.Peer2PeerCallback;
import deepin.leestatepattern.callstate.api.Peer2PeerSDK;
import deepin.leestatepattern.callstate.util.LogUtil;

public class BasePeer2PeerAcitivity extends Activity {

    Peer2PeerCallback mCallBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_peer2_peer_acitivity);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mCallBack != null) {
            Peer2PeerSDK.getIns().removeCallback(mCallBack);
        }
    }
}
