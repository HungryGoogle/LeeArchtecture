package deepin.leestatepattern.callstate.cmddata;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Li on 2017/10/2.
 */

public class AcceptCmd extends BaseCallCmdData {
    public String mStrType;

    public AcceptCmd(){
        mCmdId = EmCommand.CMD_ACCEPT;
    }

    public String getmStrType() {
        return mStrType;
    }

    public void setmStrType(String mStrType) {
        this.mStrType = mStrType;
    }

    @Override
    public String toString() {
        return super.getStrCmd(ICallCmdData.mStrCallType, mStrType);
    }


    public void setDataFromJson(JSONObject jsonObj) {
        super.setDataFromJson(jsonObj);

        try {
            if (jsonObj.has(ICallCmdData.mStrCallType)) {
                String strContent = jsonObj.getString(ICallCmdData.mStrCallType);
                setmStrType(strContent);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
