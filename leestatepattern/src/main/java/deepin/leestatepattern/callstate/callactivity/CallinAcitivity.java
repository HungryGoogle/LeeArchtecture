package deepin.leestatepattern.callstate.callactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import deepin.leestatepattern.R;
import deepin.leestatepattern.callstate.api.Peer2PeerCallback;
import deepin.leestatepattern.callstate.api.Peer2PeerSDK;
import deepin.leestatepattern.callstate.cmddata.AcceptCmd;
import deepin.leestatepattern.callstate.cmddata.InviteCancelCmd;
import deepin.leestatepattern.callstate.cmddata.InviteCmd;
import deepin.leestatepattern.callstate.cmddata.RejectCmd;
import deepin.leestatepattern.callstate.util.LogUtil;

public class CallinAcitivity extends BasePeer2PeerAcitivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callin_acitivity);

        mCallBack = new CallBack();
        Peer2PeerSDK.getIns().addCallback(mCallBack);

        findViewById(R.id.id_accept_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtil.log("simulate peer accept");
                Peer2PeerSDK.getIns().accept();

                startActivity(new Intent(CallinAcitivity.this, ConnectedAcitivity.class));
                finish();
            }
        });

        findViewById(R.id.id_reject_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Peer2PeerSDK.getIns().reject();
                finish();
            }
        });

        findViewById(R.id.id_simulate_invite_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InviteCancelCmd acceptCancelCmd = new InviteCancelCmd();
                acceptCancelCmd.setmStrCallerId("caller id");
                acceptCancelCmd.setmStrCalleeId("callee id");
                acceptCancelCmd.setmStrMeetingId("meeting id");
                acceptCancelCmd.setmStrSuppliser("SW");
                Peer2PeerSDK.getIns().cmdComeIn(acceptCancelCmd.toString());
            }
        });
    }

    class CallBack extends Peer2PeerCallback {
        public void callerCancelInvite() {
            LogUtil.log("callerCancelInvite, finish");
            finish();
        }
    }
}
