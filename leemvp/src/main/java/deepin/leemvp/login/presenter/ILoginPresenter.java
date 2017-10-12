package deepin.leemvp.login.presenter;

/**
 * Created by li on 2017/8/23.
 */

public interface ILoginPresenter
{
    void clear();
    void doLogin(String name, String passwd);
    void setProgressBarVisiblity(int visiblity);
}
