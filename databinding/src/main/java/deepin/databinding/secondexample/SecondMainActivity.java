package deepin.databinding.secondexample;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import deepin.databinding.R;
import deepin.databinding.databinding.SecondActivityMainBinding;

public class SecondMainActivity extends Activity {

    private SecondActivityMainBinding mBinding;
    private User mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.second_activity_main);
        mUser = new User("Lee", "Deepin");

        mBinding.setUser(mUser);
        mBinding.setHandler(new MyHandlers());
        mBinding.setPresenter(new Presenter());

        findViewById(R.id.id_change_value).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUser.firstName = "after chage: Lee";
                mUser.lastName = "after chage: wen";

                mBinding.setUser(mUser);
            }
        });

//        mBinding.setHandler(new MyHandlers());
//        mBinding.setPresenter(new Presenter());


    }
}
