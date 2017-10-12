package deepin.leestatepattern.callstate.cmddata;

import org.json.JSONException;
import org.json.JSONObject;

import deepin.leestatepattern.callstate.util.LogUtil;

/**
 * Created by li on 2017/9/29.
 */

public class BaseCallCmdData implements ICallCmdData {
    /**
     * 命令ID
     * {@link EmCommand}
     */
    EmCommand mCmdId = EmCommand.CMD_EMPTY;

    /**
     * 基本内容，每个消息都有
     *      mStrSuppliser：供应商
     *      mStrCallerId：主叫ID
     *      mStrCalleeId：主叫ID
     */
    String mStrSuppliser = "";
    String mStrCallerId = "";
    String mStrCalleeId = "";
    String mStrMeetingId = "";

    public EmCommand getmCmdId() {
        return mCmdId;
    }

    protected void setmCmdId(EmCommand mCmdId) {
        this.mCmdId = mCmdId;
    }

    public String getmStrSuppliser() {
        return mStrSuppliser;
    }

    public void setmStrSuppliser(String mStrSuppliser) {
        this.mStrSuppliser = mStrSuppliser;
    }

    public String getmStrCallerId() {
        return mStrCallerId;
    }

    public void setmStrCallerId(String mStrCallerId) {
        this.mStrCallerId = mStrCallerId;
    }

    public String getmStrCalleeId() {
        return mStrCalleeId;
    }

    public void setmStrCalleeId(String mStrCalleeId) {
        this.mStrCalleeId = mStrCalleeId;
    }

    public String getmStrMeetingId() {
        return mStrMeetingId;
    }

    public void setmStrMeetingId(String mStrMeetingId) {
        this.mStrMeetingId = mStrMeetingId;
    }

    public String toString(){return null;}

    @Override
    public EmCommand getCommandId() {
        return mCmdId;
    }

    protected String getStrCmd(String ... contents) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(ICallCmdData.mStrTagCmdType,ICallCmdData.mStrVideoCmdType);
            jsonObject.put(ICallCmdData.mStrTagCmdId, mCmdId.getStrCmd());

            JSONObject jsonDataObject = new JSONObject();
            jsonDataObject.put(ICallCmdData.mStrSupplier, mStrSuppliser);
            jsonDataObject.put(ICallCmdData.mStrCaller, mStrCallerId);
            jsonDataObject.put(ICallCmdData.mStrCallee, mStrCalleeId);
            jsonDataObject.put(ICallCmdData.mStrMeetingId, mStrMeetingId);

            for (int i = 0; contents != null && i < contents.length; ++i){
                jsonDataObject.put(contents[i], contents[++i]);
            }

            jsonObject.put(ICallCmdData.mStrTagCmdData, jsonDataObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String strResult = jsonObject.toString();
//        LogUtil.log(strResult);
        return strResult;
    }

    //    {
    //        "cmd_type":"video_chat",
    //            "cmd_id":"invite",
    //            "cmd_data":
    //        {
    //            “supplier”:“SW”,          // 基本数据，每个信令都有。厂商 声网SW，菊风JF，泰岳TY
    //            “caller_id”:“id”,         // 基本数据，每个信令都有。主叫
    //            “callee_id”:“id”,         // 基本数据，每个信令都有。被叫
    //            “meeting_id”:“123456”,    // 基本数据，每个信令都有。会议Id
    //        }
    //    }
    public void setDataFromJson(JSONObject jsonObj) {
        try {
            JSONObject jsonDataObj = null;

            if (jsonObj.has(ICallCmdData.mStrTagCmdData)) {
                jsonDataObj= jsonObj.getJSONObject(ICallCmdData.mStrTagCmdData);
            }

            if(jsonDataObj == null){
                return;
            }

            if (jsonDataObj.has(ICallCmdData.mStrSupplier)) {
                String strContent = jsonDataObj.getString(ICallCmdData.mStrSupplier);
                setmStrSuppliser(strContent);
            }

            if (jsonDataObj.has(ICallCmdData.mStrCaller)) {
                String strContent = jsonDataObj.getString(ICallCmdData.mStrCaller);
                setmStrCallerId(strContent);
            }

            if (jsonDataObj.has(ICallCmdData.mStrCallee)) {
                String strContent = jsonDataObj.getString(ICallCmdData.mStrCallee);
                setmStrCalleeId(strContent);
            }

            if (jsonDataObj.has(ICallCmdData.mStrMeetingId)) {
                String strContent = jsonDataObj.getString(ICallCmdData.mStrMeetingId);
                setmStrMeetingId(strContent);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
