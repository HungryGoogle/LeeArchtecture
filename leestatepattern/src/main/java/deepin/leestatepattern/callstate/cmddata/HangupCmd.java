package deepin.leestatepattern.callstate.cmddata;

/**
 * Created by Li on 2017/10/2.
 */

public class HangupCmd extends BaseCallCmdData {
    public HangupCmd(){
        mCmdId = EmCommand.CMD_HANGUP;
    }

    @Override
    public String toString() {
        return super.getStrCmd();
    }
}
