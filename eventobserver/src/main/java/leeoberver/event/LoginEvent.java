package leeoberver.event;

/**
 * Created by Li on 2017/12/23.
 */

public class LoginEvent extends BaseEvent {
    String mLoginResult;

    public String getLoginResult() {
        return mLoginResult;
    }

    public void setLoginResult(String mLoginResult) {
        this.mLoginResult = mLoginResult;
    }

}
