package deepin.databinding.secondexample;

import android.util.Log;

/**
 * Created by li on 2017/9/19.
 */

public class User {
    public String firstName;
    public String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        Log.i("User", "getFirstName");
        return firstName;
    }

    public String firstName()
    {
        Log.i("User", "firstName");
        return "12132";
    }



}
