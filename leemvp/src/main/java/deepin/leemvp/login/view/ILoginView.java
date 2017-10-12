package deepin.leemvp.login.view;

/**
 * Created by li on 2017/8/23.
 */

public interface ILoginView
{
    public void onClearText();
    public void onLoginResult(Boolean result, int code);
    public void onSetProgressBarVisibility(int visibility);
}
