package deepin.leestatepattern.callstate.dataprocess;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import deepin.leestatepattern.callstate.cmddata.BaseCallCmdData;
import deepin.leestatepattern.callstate.cmddata.AcceptCmd;
import deepin.leestatepattern.callstate.cmddata.CalleeJoinedCmd;
import deepin.leestatepattern.callstate.cmddata.CallerJoinedCmd;
import deepin.leestatepattern.callstate.cmddata.HangupCmd;
import deepin.leestatepattern.callstate.cmddata.ICallCmdData;
import deepin.leestatepattern.callstate.cmddata.InviteCancelCmd;
import deepin.leestatepattern.callstate.cmddata.InviteCmd;
import deepin.leestatepattern.callstate.cmddata.RejectCmd;
import deepin.leestatepattern.callstate.util.LogUtil;

/**
 * Created by li on 2017/9/29.
 */

public class JsonProcess {
    /**
     * 通过org.json解析json
     *
     * @param jsonStr json字符串
     * @throws JSONException 格式不对，转换异常
     */
    public static BaseCallCmdData parseJson(String jsonStr) throws JSONException {
        BaseCallCmdData parseResult = null;
        if (TextUtils.isEmpty(jsonStr)) {
            Log.i("leeTest------->", "jsonStr is null");
            return null;
        }

        // 使用该方法解析思路，遇到大括号用JsonObject，中括号用JsonArray
        // 第一个是大括号{}
        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject(jsonStr);
        } catch (JSONException e) {
            Log.i("leeTest------->", "JSONException, return ");
            return null;
        }

        Log.i("leeTest------->", "parseJsonByOrgJson begin ... ");
        if (jsonObj == null) {
            Log.i("leeTest------->", "jsonObj 1 is null");
            return null;
        }

        if (jsonObj.has(ICallCmdData.mStrTagCmdType)) {
            String cmd_type = jsonObj.getString(ICallCmdData.mStrTagCmdType);
            if(!ICallCmdData.mStrVideoCmdType.equals(cmd_type)){
                Log.i("leeTest------->", "not video data, not handle");
                return null;
            }

            parseResult = getDataFromJosn(jsonObj);
        }

        return parseResult;
    }

    private static BaseCallCmdData getDataFromJosn(JSONObject jsonObj) {
        BaseCallCmdData parseResult = null;
        try {
            if (jsonObj.has(ICallCmdData.mStrTagCmdId)) {

                String cmd_id = jsonObj.getString(ICallCmdData.mStrTagCmdId);
                LogUtil.log("-------------------------------------> command come in : " + cmd_id);
                switch (cmd_id) {
                    case ICallCmdData.mStrEmptyCmd: {
                        parseResult = null;
                        break;
                    }
                    case ICallCmdData.mStrInviteCmd: {
                        parseResult = new InviteCmd();
                        break;
                    }
                    case ICallCmdData.mStrAcceptCmd: {
                        parseResult = new AcceptCmd();
                        break;
                    }
                    case ICallCmdData.mStrRejectCmd: {
                        parseResult = new RejectCmd();
                        break;
                    }
                    case ICallCmdData.mStrHangupCmd: {
                        parseResult = new HangupCmd();
                        break;
                    }
                    case ICallCmdData.mStrCalleeJoinCmd: {
                        parseResult = new CalleeJoinedCmd();
                        break;
                    }
                    case ICallCmdData.mStrCallerJoinCmd: {
                        parseResult = new CallerJoinedCmd();
                        break;
                    }
                    case ICallCmdData.mStrInviteCancelCmd: {
                        parseResult = new InviteCancelCmd();
                        break;
                    }
                    default:{
                        LogUtil.log("no handle this commmand.");
                        break;
                    }
                }

                if(parseResult != null){
                    parseResult.setDataFromJson(jsonObj);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return parseResult;
    }

}