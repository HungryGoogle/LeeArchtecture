package deepin.leemvp.login.model;

/**
 * Created by li on 2017/8/23.
 */

public interface IUser
{
    String getName();
    
    String getPasswd();
    
    int checkUserValidity(String name, String passwd);
}
