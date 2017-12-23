package leeoberver;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import deepin.com.eventobserver.R;
import leeoberver.login.LoginUI;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.id_btnTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginUI loginUI = new LoginUI();
                loginUI.login();
            }
        });
    }

    // 通过java直接测试
    public static void main(String[] args){
        LoginUI loginUI = new LoginUI();
        loginUI.login();
    }
}
