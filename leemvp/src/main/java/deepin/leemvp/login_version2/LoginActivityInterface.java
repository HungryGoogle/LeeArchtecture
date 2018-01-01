package deepin.leemvp.login_version2;

/**
 * Created by Li on 2017/12/29.
 */

public interface LoginActivityInterface {
    interface View {
        void onResultSucceed();
        void onResultFailed();
        void showProcessBar(boolean bShow);
    }

    interface Preserter {
        void doLogin(String strUserName, String strPwd);
    }
}
