package deepin.databinding.secondexample;

import android.util.Log;
import android.widget.Toast;

/**
 * Created by Li on 2017/9/19.
 */

public class Presenter {
    public void click() {
        Log.i("LeeTest------>", "Presenter onClick");
    }

    public boolean longClick() {
        Log.i("LeeTest------>", "Presenter onLongClick");
        return true;
    }
}
