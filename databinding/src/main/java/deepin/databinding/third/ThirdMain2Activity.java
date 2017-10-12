package deepin.databinding.third;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import deepin.databinding.R;
import deepin.databinding.databinding.ActivityThirdMain2Binding;

public class ThirdMain2Activity extends Activity {

    private ActivityThirdMain2Binding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_third_main2);
        mBinding.setStyle(BaseApplication.getStyle());
    }
}
