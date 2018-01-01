package deepin.leemvp.login_version2;

import android.os.Handler;

/**
 * Created by Li on 2017/12/29.
 */

public class LoginActivityPreserter implements LoginActivityInterface.Preserter {
    LoginActivityInterface.View mView;
    LoginActivityPreserter(LoginActivityInterface.View view){
        mView = view;
    }

    @Override
    public void doLogin(final String strUserName, final String strPwd) {
        mView.showProcessBar(true);


        // 后台做登录操作
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if("lee".equals(strUserName) && "pwd".equals(strPwd)) {
                    loginResult(true);
                }else {
                    loginResult(false);
                }
            }
        }, 1000);
    }

    private void loginResult(boolean bSucceed){
        if(bSucceed) {
            mView.onResultSucceed();
        }else {
            mView.onResultFailed();
        }
    }
}
