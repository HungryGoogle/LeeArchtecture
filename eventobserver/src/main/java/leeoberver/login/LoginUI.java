package leeoberver.login;

import leeoberver.observation.pattern.BaseObservation;
import leeoberver.observation.pattern.IObserver;

/**
 * Created by Li on 2017/12/23.
 */

public class LoginUI {
    LoginLogic loginLogic = new LoginLogic();

    public LoginUI(){
        BaseObservation baseObservation = loginLogic.newLoginObservation();
        baseObservation.setObserver(new IObserver() {
            @Override
            public void handle(Object param) {
                if(null instanceof String){
                    System.out.print("result null");
                }

                if(param instanceof String){
                    String result = (String)param;
                    System.out.print("result : " + result );
                }
            }
        });
    }

    public void login(){
        loginLogic.login();
    }

}
