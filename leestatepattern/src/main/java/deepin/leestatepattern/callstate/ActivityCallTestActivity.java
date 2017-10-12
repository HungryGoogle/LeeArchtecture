package deepin.leestatepattern.callstate;

//         --------信令------------------------------------------------------------
//         发起呼叫 invite
//         接听呼叫 accept
//         拒接呼叫 reject
//         挂断     hangup
//         被叫入会    callee_id_join
//         主叫入会    caller_id_join
//         主叫在被叫未入会时取消呼叫    invite_cancel
//         --------信令------------------------------------------------------------

//         // 完整版invite信令
//         {
//         "cmd_type":"video_chat",
//         "cmd_id":"invite",
//         "cmd_data":
//         {
//         “supplier”:“SW”,          // 基本数据，每个信令都有。厂商 声网SW，菊风JF，泰岳TY
//         “caller_id”:“id”,         // 基本数据，每个信令都有。主叫
//         “callee_id”:“id”,         // 基本数据，每个信令都有。被叫
//         “meeting_id”:“123456”,    // 基本数据，每个信令都有。会议Id
//
//         “type”:“1”,                                // 本信令特有。呼叫类型，1 视频呼叫；2 音频呼叫；
//         “start_time”:“2017-09-29 10:23:38”,        // 本信令特有。发起呼叫时间
//         “invalidate_time”:“30000”,                 // 本信令特有。会议有效等待时间，默认30秒，单位毫秒
//         }
//         }
//
// --------信令数据罗列------------------------------------------------------------
//         invite
//         {
//         “supplier”:“SW”,          // 基本数据，每个信令都有。厂商 声网SW，菊风JF，泰岳TY
//         “caller_id”:“id”,         // 基本数据，每个信令都有。主叫
//         “callee_id”:“id”,         // 基本数据，每个信令都有。被叫
//         “meeting_id”:“123456”,    // 基本数据，每个信令都有。会议Id
//
//         “type”:“1”,                                // 本信令特有。呼叫类型，1 视频呼叫；2 音频呼叫；
//         “start_time”:“2017-09-29 10:23:38”,        // 本信令特有。发起呼叫时间
//         “invalidate_time”:“30000”,                 // 本信令特有。会议有效等待时间，默认30秒，单位毫秒
//         }
//
//         accept
//         {
//         “supplier”:“SW”,        // 厂商 声网SW，菊风JF，泰岳TY
//         “caller_id”:“id”,       // 主叫
//         “callee_id”:“id”,       // 被叫
//         “meeting_id”:“”,        // 会议Id
//
//         “type”:“”,              // 答复类型， 0 直接接受；1 音频接受； 2 视频接受；
//         }
//
//
//// 拒接
//         reject
//         {
//         “supplier”:“SW”,        // 厂商 声网SW，菊风JF，泰岳TY
//         “caller_id”:“id”,       // 主叫
//         “callee_id”:“id”,       // 被叫
//         “meeting_id”:“”,        // 会议Id
//
//         “type”:“”,	            // 答复类型， 0 默认拒接，默认操作；1 用户主动拒接，用于扩展，比如提示语“比较正在忙”； 2 对方正在通话中被动拒接；
//         }
//
//// 挂断
//         hangup
//         {
//         “supplier”:“SW”,        // 厂商 声网SW，菊风JF，泰岳TY
//         “caller_id”:“id”,       // 主叫
//         “callee_id”:“id”,       // 被叫
//         “meeting_id”:“”,        // 会议Id
//         }
//
//
//// 被叫入会
//         callee_id_join
//         {
//         “supplier”:“SW”,        // 厂商 声网SW，菊风JF，泰岳TY
//         “caller_id”:“id”,       // 主叫
//         “callee_id”:“id”,       // 被叫
//         “meeting_id”:“”,        // 会议Id
//         }
//
//// 主叫入会
//         caller_id_join
//         {
//         “supplier”:“SW”,        // 厂商 声网SW，菊风JF，泰岳TY
//         “caller_id”:“id”,       // 主叫
//         “callee_id”:“id”,       // 被叫
//         “meeting_id”:“”,        // 会议Id
//         }
//
//// 主叫在被叫未入会时取消呼叫
//         invite_cancel
//         {
//         “supplier”:“SW”,        // 厂商 声网SW，菊风JF，泰岳TY
//         “caller_id”:“id”,       // 主叫
//         “callee_id”:“id”,       // 被叫
//         “meeting_id”:“”,        // 会议Id
//         }

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import deepin.leestatepattern.R;
import deepin.leestatepattern.callstate.api.Peer2PeerSDK;
import deepin.leestatepattern.callstate.callactivity.CallinAcitivity;
import deepin.leestatepattern.callstate.callactivity.CalloutAcitivity;
import deepin.leestatepattern.callstate.cmddata.InviteCmd;
import deepin.leestatepattern.callstate.util.LogUtil;

public class ActivityCallTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_all_call);

        findViewById(R.id.id_call_out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtil.log("callout 158690472 begin ...");
                Peer2PeerSDK.getIns().callout("158690472");
                startActivity(new Intent(ActivityCallTestActivity.this, CalloutAcitivity.class));
            }
        });

        findViewById(R.id.id_simulate_call_in).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    LogUtil.log("simulate call in");

                    InviteCmd inviteCmd = new InviteCmd();
                    inviteCmd.setmStrType("1");
                    inviteCmd.setmStrCallerId("caller id");
                    inviteCmd.setmStrCalleeId("callee id");
                    inviteCmd.setmStrMeetingId("meeting id");
                    inviteCmd.setmStrSuppliser("SW");

                    Peer2PeerSDK.getIns().cmdComeIn(inviteCmd.toString());

                    startActivity(new Intent(ActivityCallTestActivity.this, CallinAcitivity.class));
                }
        });

    }
}
