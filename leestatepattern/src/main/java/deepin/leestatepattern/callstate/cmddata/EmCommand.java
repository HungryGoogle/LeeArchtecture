package deepin.leestatepattern.callstate.cmddata;

/**
 * Created by li on 2017/9/29.
 */

public enum EmCommand {
    CMD_EMPTY(ICallCmdData.mStrEmptyCmd),                     // 空指令
    CMD_INVITE(ICallCmdData.mStrInviteCmd),                   // 呼叫对方
    CMD_ACCEPT(ICallCmdData.mStrAcceptCmd),                   // 接受呼叫
    CMD_REJECT(ICallCmdData.mStrRejectCmd),                   // 拒接呼叫
    CMD_HANGUP(ICallCmdData.mStrHangupCmd),                   // 挂断电话
    CMD_CALLEE_JOINED(ICallCmdData.mStrCalleeJoinCmd),      // 被叫加入
    CMD_CALLER_JOINED(ICallCmdData.mStrCallerJoinCmd),      // 主叫加入
    CMD_INVITE_CANCEL(ICallCmdData.mStrInviteCancelCmd)     // 主叫取消呼叫
    ;

    String mStrCmd;
    EmCommand(String cmd) {
        mStrCmd = cmd;
    }

    public String getStrCmd(){
        return mStrCmd;
    }
}
