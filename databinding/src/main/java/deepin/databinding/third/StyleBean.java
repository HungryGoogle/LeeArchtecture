package deepin.databinding.third;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import deepin.databinding.BR;
import deepin.databinding.R;

/**
 * Created by li on 2017/9/20.
 */

public class StyleBean extends BaseObservable
{
    /**
     * 字体大小的级别 0-5
     */
    @Bindable
    private int textSizeLivel;
    /**
     * 主题风格 白天或者黑夜
     */
    @Bindable
    private boolean isNight;
    private static float[] dimens;
    private static int mColorDay;
    private static int mColorNight;
    private static int mBackgroundDay;
    private static int mBackgroundNight;

    public int getTextSizeLivel()
    {
        return textSizeLivel;
    }

    public void setTextSizeLivel(int textSizeLivel)
    {
        this.textSizeLivel = textSizeLivel;
        notifyPropertyChanged(BR.textSizeLivel);
    }

    public boolean isNight()
    {
        return isNight;
    }

    public void setNight(boolean night)
    {
        isNight = night;
        notifyPropertyChanged(BR._all);
    }

    public StyleBean(int textSizeLivel, boolean isNight)
    {
        this.textSizeLivel = textSizeLivel;
        this.isNight = isNight;

        initResource();
    }

    private void initResource()
    {
        dimens = new float[6];
        Resources resources = BaseApplication.getContext().getResources();
        dimens[0] = resources.getDimension(R.dimen.size_level_0);
        dimens[1] = resources.getDimension(R.dimen.size_level_1);
        dimens[2] = resources.getDimension(R.dimen.size_level_2);
        dimens[3] = resources.getDimension(R.dimen.size_level_3);
        dimens[4] = resources.getDimension(R.dimen.size_level_4);
        dimens[5] = resources.getDimension(R.dimen.size_level_5);

        mColorDay = resources.getColor(R.color.textColorDay);
        mColorNight = resources.getColor(R.color.textColorNight);

        mBackgroundDay = resources.getColor(R.color.backgroundDay);
        mBackgroundNight = resources.getColor(R.color.backgroundNight);
    }

    @BindingAdapter("android:textSize")
    public static void setTextSize(TextView textView, int level)
    {
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, StyleBean.dimens[level]);
    }


    @BindingAdapter("android:textColor")
    public static void setTextColor(TextView textView, boolean isNight)
    {
        textView.setTextColor(isNight ? StyleBean.mColorNight : StyleBean.mColorDay);
    }

    @BindingAdapter("android:background")
    public static void setBackground(View view, boolean isNight)
    {
        view.setBackgroundColor(isNight ? mBackgroundNight : mBackgroundDay);
    }

    public void changeTextSize(View view)
    {
        final String[] items = {"0", "1", "2", "3", "4", "5"};
        new AlertDialog.Builder(view.getContext()).setItems(items, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                BaseApplication.setTextSize(Integer.valueOf(items[i]));
            }
        }).create().show();
    }
    public void changeNight(View view)
    {
        final String[] items = {"夜间", "白天"};
        new AlertDialog.Builder(view.getContext()).setItems(items, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                BaseApplication.setNight(i == 0);
            }
        }).create().show();
    }
}