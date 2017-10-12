package deepin.leestatepattern.callstate.cmddata;

/**
 * Created by Li on 2017/10/2.
 */

public class RejectCmd extends BaseCallCmdData {
    public RejectCmd(){
        mCmdId = EmCommand.CMD_REJECT;
    }

    @Override
    public String toString() {
        return super.getStrCmd(ICallCmdData.mStrRejectCallType, "1");
    }
}
