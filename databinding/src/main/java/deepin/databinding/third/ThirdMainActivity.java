package deepin.databinding.third;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import deepin.databinding.R;
import deepin.databinding.databinding.ActivityThirdMainBinding;

public class ThirdMainActivity extends Activity {

    private ActivityThirdMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_third_main);
        mBinding.setStyle(BaseApplication.getStyle());

        // 切换到下一页
        findViewById(R.id.button_next_page).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ThirdMainActivity.this, ThirdMain2Activity.class));
            }
        });
    }
}
