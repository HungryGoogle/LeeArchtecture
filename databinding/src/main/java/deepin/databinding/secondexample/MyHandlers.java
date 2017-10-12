package deepin.databinding.secondexample;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by li on 2017/9/19.
 */

public class MyHandlers {
    public void click(View view) {
        Toast.makeText(view.getContext(), "MyHandlers click", Toast.LENGTH_LONG).show();
        Log.i("LeeTest------>", "MyHandlers onClick");
    }

    public boolean longClick(View view) {
        Toast.makeText(view.getContext(), "MyHandlers onLongClick", Toast.LENGTH_LONG).show();;
        Log.i("LeeTest------>", "MyHandlers onLongClick");
        return true;
    }

}
