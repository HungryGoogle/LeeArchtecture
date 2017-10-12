package deepin.leestatepattern.callstate;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import deepin.leestatepattern.R;
import deepin.leestatepattern.callstate.cmddata.BaseCallCmdData;
import deepin.leestatepattern.callstate.cmddata.ICallCmdData;
import deepin.leestatepattern.callstate.dataprocess.JsonProcess;
import deepin.leestatepattern.callstate.state.StateContext;

public class CallStateSimpleTestActivity extends Activity {

    StateContext stateContext = new StateContext();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_call_state);

        findViewById(R.id.id_call_out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 呼出
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("cmd_id", "invite");
                    jsonObject.put("supplier", "SW");
                    jsonObject.put("caller", "caller_id");
                    jsonObject.put("callee", "callee_id");
                    jsonObject.put("meeting_id", "123456");
                    jsonObject.put("type", "1");
                    jsonObject.put("start_time", "2017-09-29 10,23,38");
                    jsonObject.put("invalidate_time", "30000");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                BaseCallCmdData cmdData = null;
                String strResult = jsonObject.toString();
                try {
                    cmdData = JsonProcess.parseJson(strResult);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                stateContext.handle(cmdData);
            }
        });


        findViewById(R.id.id_invite_cancel).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        JSONObject jsonObject = new JSONObject();
                        try {
                            jsonObject.put("cmd_id", "invite_cancel");
                            jsonObject.put("supplier", "SW");
                            jsonObject.put("caller", "id");
                            jsonObject.put("callee", "id");
                            jsonObject.put("meeting_id", "123456");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        BaseCallCmdData cmdData = null;
                        String strResult = jsonObject.toString();
                        try {
                            cmdData = JsonProcess.parseJson(strResult);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        stateContext.handle(cmdData);
                    }
                });

        // 接听
        findViewById(R.id.id_accept).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("cmd_id", "accept");
                    jsonObject.put("supplier", "SW");
                    jsonObject.put("caller", "id");
                    jsonObject.put("callee", "id");
                    jsonObject.put("meeting_id", "123456");
                    jsonObject.put("type", "1");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                BaseCallCmdData cmdData = null;
                String strResult = jsonObject.toString();
                try {
                    cmdData = JsonProcess.parseJson(strResult);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                stateContext.handle(cmdData);
            }
        });

        // 拒接
        findViewById(R.id.id_reject).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        JSONObject jsonObject = new JSONObject();
                        try {
                            jsonObject.put("cmd_id", ICallCmdData.mStrRejectCmd);
                            jsonObject.put("supplier", "SW");
                            jsonObject.put("caller", "id");
                            jsonObject.put("callee", "id");
                            jsonObject.put("meeting_id", "123456");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        BaseCallCmdData cmdData = null;
                        String strResult = jsonObject.toString();
                        try {
                            cmdData = JsonProcess.parseJson(strResult);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        stateContext.handle(cmdData);
                    }
                });

        // 挂断
        findViewById(R.id.id_hangup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("cmd_id", "hangup");
                    jsonObject.put("supplier", "SW");
                    jsonObject.put("caller", "id");
                    jsonObject.put("callee", "id");
                    jsonObject.put("meeting_id", "123456");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                BaseCallCmdData cmdData = null;
                String strResult = jsonObject.toString();
                try {
                    cmdData = JsonProcess.parseJson(strResult);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                stateContext.handle(cmdData);
            }
        });
    }
}
