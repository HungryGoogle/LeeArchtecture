package deepin.leestatepattern.callstate.cmddata;

/**
 * Created by Li on 2017/10/2.
 */

public interface ICallCmdData {
    String mStrEmptyCmd = "";
    String mStrInviteCmd = "invite";
    String mStrAcceptCmd = "accept";
    String mStrRejectCmd = "reject";
    String mStrHangupCmd = "hangup";
    String mStrCalleeJoinCmd = "callee_join";
    String mStrCallerJoinCmd = "caller_join";
    String mStrInviteCancelCmd = "invite_cancel";

    String mStrTagCmdType = "cmd_type";            // 必须是video_chat才处理
    String mStrVideoCmdType = "video_chat";     // 必须是video_chat才处理
    String mStrTagCmdId = "cmd_id";
    String mStrTagCmdData = "cmd_data";

    String mStrSupplier = "supplier";
    String mStrCaller = "caller_id";
    String mStrCallee = "callee_id";
    String mStrMeetingId = "meeting_id";

    String mStrCallType = "type";
    String mStrStartTime = "start_time";
    String mStrInvalidateTime = "invalidate_time";

    String mStrAcceptCallType = "type";
    String mStrRejectCallType = "type";

    EmCommand getCommandId();
//    String getStrCmd();


}

