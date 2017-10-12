package deepin.leestatepattern.callstate.callactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import deepin.leestatepattern.R;
import deepin.leestatepattern.callstate.api.Peer2PeerCallback;
import deepin.leestatepattern.callstate.api.Peer2PeerSDK;
import deepin.leestatepattern.callstate.cmddata.HangupCmd;
import deepin.leestatepattern.callstate.util.LogUtil;

public class ConnectedAcitivity extends Activity {

    CallBack mCallBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_acitivity);

        mCallBack = new CallBack();
        Peer2PeerSDK.getIns().addCallback(mCallBack);

        LogUtil.log("ConnectAcitivity");
        findViewById(R.id.id_hangup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtil.log("hangup");
                Peer2PeerSDK.getIns().hangup();
                finish();
            }
        });

        findViewById(R.id.id_peer_hangup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtil.log("simulate peer hangup");

                HangupCmd acceptCmd = new HangupCmd();
                acceptCmd.setmStrCallerId("caller id");
                acceptCmd.setmStrCalleeId("callee id");
                acceptCmd.setmStrMeetingId("meeting id");
                acceptCmd.setmStrSuppliser("SW");

                Peer2PeerSDK.getIns().cmdComeIn(acceptCmd.toString());
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.log("Activity ConnectAcitivity onDestroy");
        Peer2PeerSDK.getIns().removeCallback(mCallBack);
    }

    class CallBack extends Peer2PeerCallback {
        public void calleeHangup() {
            LogUtil.log("Activity receive peer hangup");
            finish();
        }
    }
}
