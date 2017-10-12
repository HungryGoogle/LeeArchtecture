package deepin.leestatepattern.callstate.callactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import deepin.leestatepattern.R;
import deepin.leestatepattern.callstate.api.Peer2PeerCallback;
import deepin.leestatepattern.callstate.api.Peer2PeerSDK;
import deepin.leestatepattern.callstate.cmddata.AcceptCmd;
import deepin.leestatepattern.callstate.util.LogUtil;

public class CalloutAcitivity extends Activity {

    CallBack mCallBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callout_acitivity);

        mCallBack = new CallBack();
        Peer2PeerSDK.getIns().addCallback(mCallBack);

        findViewById(R.id.id_invite_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtil.log("cancel callout");
                Peer2PeerSDK.getIns().cancelCallout();

                finish();
            }
        });

        findViewById(R.id.id_peer_accept).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtil.log("simulate peer accept");

                AcceptCmd acceptCmd = new AcceptCmd();
                acceptCmd.setmStrType("1");
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
        LogUtil.log("callout Activity onDestroy");
        Peer2PeerSDK.getIns().removeCallback(mCallBack);
    }

    class CallBack extends Peer2PeerCallback {
        public void calleeAccept() {
            LogUtil.log("Activity receive accept");
            startActivity(new Intent(CalloutAcitivity.this, ConnectedAcitivity.class));
            finish();
        }

        public void calleeReject() {
            LogUtil.log("Activity receive Reject");
            finish();
        }
    }
}
