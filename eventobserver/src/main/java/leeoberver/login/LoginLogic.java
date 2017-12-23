package leeoberver.login;


import leeoberver.EventManager.EventManager;
import leeoberver.EventManager.IWatching;
import leeoberver.EventManager.Watching;
import leeoberver.event.BaseEvent;
import leeoberver.event.LoginEvent;
import leeoberver.observation.pattern.BaseObservation;

/**
 * Created by Li on 2017/12/23.
 */

public class LoginLogic {

    public void login(){
        // 调用底层登录  。。。

        // 底层返回成功，上报UI成功
        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setLoginResult("loginSucceed");
        EventManager.getIns().publishEvent(loginEvent);
    }

    public BaseObservation newLoginObservation(){
        Watching watching = EventManager.getIns().newWatching(LoginEvent.class);
        LoginObserVation loginObservation = new LoginObserVation(watching);
        return loginObservation;
    }

    public static class LoginObserVation  extends BaseObservation {
        LoginObserVation(IWatching watching){
            mWatching = watching;
        }

        @Override
        public void onEvent(BaseEvent event) {
            if(event != null && event instanceof LoginEvent){
                publishNotify(((LoginEvent) event).getLoginResult());
            }
        }
    }
}
