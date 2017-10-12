package deepin.leemvp.login.presenter;

import android.os.Handler;
import android.os.Looper;

import deepin.leemvp.login.model.IUser;
import deepin.leemvp.login.model.UserModel;
import deepin.leemvp.login.view.ILoginView;

/**
 * Created by li on 2017/8/23.
 */

public class LoginPresenterImpl implements ILoginPresenter
{
    ILoginView iLoginView;
    IUser user;
    Handler handler;
    public LoginPresenterImpl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        initUser();
        handler = new Handler(Looper.getMainLooper());
    }
    
    @Override
    public void clear() {
        iLoginView.onClearText();
    }
    
    @Override
    public void doLogin(String name, String passwd) {
        Boolean isLoginSuccess = true;
        final int code = user.checkUserValidity(name,passwd);
        if (code!=0) isLoginSuccess = false;
        final Boolean result = isLoginSuccess;
    
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(result, code);
            }
        }, 3000);
    }
    
    @Override
    public void setProgressBarVisiblity(int visiblity){
        iLoginView.onSetProgressBarVisibility(visiblity);
    }
    private void initUser(){
        user = new UserModel("mvp","mvp");
    }
}
