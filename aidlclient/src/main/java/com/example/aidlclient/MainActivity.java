package com.example.aidlclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btn_aidl;
    private Button btn_get;
    private TextView tv_show;
    private Intent mIpItent;
    private com.example.aidlserver.IPerson mIpIPerson=null;
    private ServiceConnection conn=new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mIpIPerson= com.example.aidlserver.IPerson.Stub.asInterface(service);
            btn_get.setEnabled(true);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        initEvent();
    }

    private void initData(){
        // mIpItent=new Intent("com.aidl.IPerson");  --》这里要修改
        mIpItent = new Intent();
        mIpItent.setAction("com.example.aidlserver.IPerson1");
        mIpItent.setPackage("com.example.aidlserver");
    }

    private void initView(){
        btn_aidl=(Button) this.findViewById(R.id.btn_aidl);
        btn_get=(Button) this.findViewById(R.id.btn_get);
        tv_show=(TextView) this.findViewById(R.id.tv_show);
        btn_get.setEnabled(false);
    }


    private void initEvent(){
        btn_aidl.setOnClickListener(this);
        btn_get.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_aidl://绑定AIDL服务
                bindService(mIpItent, conn, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btn_get://获取服务端数据
                try {
                    tv_show.setText("姓名:"+mIpIPerson.getName()+"\n年龄:"+mIpIPerson.getAge());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            default:
                break;
        }
    }
}
