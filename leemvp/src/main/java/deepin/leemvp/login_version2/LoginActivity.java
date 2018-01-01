package deepin.leemvp.login_version2;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import deepin.leemvp.R;

public class LoginActivity extends Activity implements LoginActivityInterface.View {
    LoginActivityPreserter mLoginActivityPreserter = new LoginActivityPreserter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        showProcessBar(false);

        findViewById(R.id.id_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUserName = ((EditText) (findViewById(R.id.editTextName))).getText().toString();
                String strUserPwd = ((EditText) (findViewById(R.id.editTextPwd))).getText().toString();

                if (!TextUtils.isEmpty(strUserName) && !TextUtils.isEmpty(strUserPwd))
                    mLoginActivityPreserter.doLogin(strUserName, strUserPwd);
            }
        });
    }

    @Override
    public void onResultSucceed() {
        showProcessBar(false);
        ((TextView) findViewById(R.id.id_login_process)).setText("恭喜，登录成功！");
    }

    @Override
    public void onResultFailed() {
        showProcessBar(false);
        ((TextView) findViewById(R.id.id_login_process)).setText("失败，请重新登录");
    }

    @Override
    public void showProcessBar(boolean bShow) {
        if(bShow) {
            findViewById(R.id.id_login).setEnabled(false);
            findViewById(R.id.id_login_process).setVisibility(View.VISIBLE);
            ((TextView) findViewById(R.id.id_login_process)).setText("登录中，请稍后...");
        }else {
            findViewById(R.id.id_login).setEnabled(true);
        }
    }
}
