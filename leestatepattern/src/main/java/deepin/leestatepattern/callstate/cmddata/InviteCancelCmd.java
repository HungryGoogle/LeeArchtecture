package deepin.leestatepattern.callstate.cmddata;

/**
 * Created by Li on 2017/10/2.
 */

public class InviteCancelCmd extends BaseCallCmdData {
    public InviteCancelCmd(){
        mCmdId = EmCommand.CMD_INVITE_CANCEL;
    }

    @Override
    public String toString() {
        return super.getStrCmd();
    }

}
