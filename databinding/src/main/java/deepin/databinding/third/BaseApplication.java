package deepin.databinding.third;

import android.app.Application;
import android.content.Context;

/**
 * Created by li on 2017/9/20.
 */

public class BaseApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        sContext = this;
        style = new StyleBean(2, false);
    }

    private static StyleBean style;

    public static StyleBean getStyle()
    {
        return style;
    }

    public static Context sContext;

    public static Context getContext()
    {
        return sContext;
    }

    public static void setTextSize(int level)
    {
        style.setTextSizeLivel(level);
    }

    public static void setNight(boolean isNight)
    {
        style.setNight(isNight);
    }

    public static int getTextSize()
    {
        return style.getTextSizeLivel();
    }

    public static boolean getNight()
    {
        return style.isNight();
    }
}