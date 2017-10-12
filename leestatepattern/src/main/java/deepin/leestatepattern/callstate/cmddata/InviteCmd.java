package deepin.leestatepattern.callstate.cmddata;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Li on 2017/10/2.
 */

public class InviteCmd extends BaseCallCmdData {
    public String mStrType;
    public String mStrStartTime;
    public String mStrInvalidateTime;

    public InviteCmd() {
        mCmdId = EmCommand.CMD_INVITE;
    }

    public String getmStrType() {
        return mStrType;
    }

    public void setmStrType(String mStrType) {
        this.mStrType = mStrType;
    }

    public String getmStrStartTime() {
        return mStrStartTime;
    }

    public void setmStrStartTime(String mStrStartTime) {
        this.mStrStartTime = mStrStartTime;
    }

    public String getmStrInvalidateTime() {
        return mStrInvalidateTime;
    }

    public void setmStrInvalidateTime(String mStrInvalidateTime) {
        this.mStrInvalidateTime = mStrInvalidateTime;
    }

    @Override
    public String toString() {
        return super.getStrCmd(ICallCmdData.mStrCallType, mStrType, ICallCmdData.mStrStartTime, mStrStartTime, ICallCmdData.mStrInvalidateTime, mStrInvalidateTime);
    }

    public void setDataFromJson(JSONObject jsonObj) {
        super.setDataFromJson(jsonObj);

        try {
            if (jsonObj.has(ICallCmdData.mStrCallType)) {
                String strContent = jsonObj.getString(ICallCmdData.mStrCallType);
                setmStrType(strContent);
            }

            if (jsonObj.has(ICallCmdData.mStrStartTime)) {
                String strContent = jsonObj.getString(ICallCmdData.mStrStartTime);
                setmStrStartTime(strContent);
            }

            if (jsonObj.has(ICallCmdData.mStrInvalidateTime)) {
                String strContent = jsonObj.getString(ICallCmdData.mStrInvalidateTime);
                setmStrInvalidateTime(strContent);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}