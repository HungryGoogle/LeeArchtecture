package deepin.leestatepattern.callstate.apiimpl;

import org.json.JSONException;

import deepin.leestatepattern.callstate.api.Peer2PeerSDK;
import deepin.leestatepattern.callstate.api.Peer2PeerCallback;
import deepin.leestatepattern.callstate.cmddata.AcceptCmd;
import deepin.leestatepattern.callstate.cmddata.BaseCallCmdData;
import deepin.leestatepattern.callstate.cmddata.HangupCmd;
import deepin.leestatepattern.callstate.cmddata.InviteCancelCmd;
import deepin.leestatepattern.callstate.cmddata.InviteCmd;
import deepin.leestatepattern.callstate.cmddata.RejectCmd;
import deepin.leestatepattern.callstate.dataprocess.JsonProcess;
import deepin.leestatepattern.callstate.state.StateContext;

/**
 * Created by Li on 2017/10/3.
 */

public class CallManagerImpl extends Peer2PeerSDK {
    StateContext stateContext = new StateContext();
    CallbackManager eventHandler = new CallbackManager();
    public CallManagerImpl(){
        stateContext.setCallback(eventHandler.callBack);
    }

    public void addCallback(Peer2PeerCallback callback){
        eventHandler.addEventHandler(callback);
    }

    public void removeCallback(Peer2PeerCallback callback){
        eventHandler.removeEventHandler(callback);
    };


    public void cmdComeIn(String strCallee){
        BaseCallCmdData cmdData = null;
        try {
            cmdData = JsonProcess.parseJson(strCallee);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        stateContext.handle(cmdData);
    }

    /**
     * 呼出
     * @param strCallee 被叫号码
     */
    public void callout(String strCallee) {
        InviteCmd inviteCmd = new InviteCmd();
        inviteCmd.setmStrSuppliser("SW");
        inviteCmd.setmStrCallerId("caller A");
        inviteCmd.setmStrCalleeId(strCallee);
        inviteCmd.setmStrMeetingId("MeetingId 000000");

        inviteCmd.setmStrType("1");
        inviteCmd.setmStrStartTime("2017-09-29 10:23:38");
        inviteCmd.setmStrInvalidateTime("30000");

        // String strJson = inviteCmd.getStrCmd();
        stateContext.setAmICaller(true);
        stateContext.handle(inviteCmd);
    }

    public void caller_joined() {
    }

    public void hangup() {
        HangupCmd acceptCmd = new HangupCmd();
        acceptCmd.setmStrCallerId("caller id");
        acceptCmd.setmStrCalleeId("callee id");
        acceptCmd.setmStrMeetingId("meeting id");
        acceptCmd.setmStrSuppliser("SW");
        stateContext.handle(acceptCmd);
    }
    public void accept(){
        AcceptCmd acceptCmd = new AcceptCmd();
        acceptCmd.setmStrType("1");
        acceptCmd.setmStrCallerId("caller id");
        acceptCmd.setmStrCalleeId("callee id");
        acceptCmd.setmStrMeetingId("meeting id");
        acceptCmd.setmStrSuppliser("SW");
        stateContext.handle(acceptCmd);
    };
    public void reject(){
        RejectCmd rejectCmd = new RejectCmd();
        rejectCmd.setmStrCallerId("caller id");
        rejectCmd.setmStrCalleeId("callee id");
        rejectCmd.setmStrMeetingId("meeting id");
        rejectCmd.setmStrSuppliser("SW");
        stateContext.handle(rejectCmd);
    };
    public void cancelCallout() {
        InviteCancelCmd inviteCancelCmd = new InviteCancelCmd();
        inviteCancelCmd.setmStrSuppliser("SW");
        inviteCancelCmd.setmStrCallerId("caller A");
        inviteCancelCmd.setmStrCalleeId("callee B");
        inviteCancelCmd.setmStrMeetingId("MeetingId 000000");
        stateContext.handle(inviteCancelCmd);
    }
}
