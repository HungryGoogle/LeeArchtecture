package deepin.databinding.firstexample;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import deepin.databinding.R;
import deepin.databinding.databinding.FirstActivityMainBinding;

public class FirstMainActivity extends Activity {

    private FirstActivityMainBinding mBinding;
    private User mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.first_activity_main);
        mUser = new User("Lee", "Deepin");
        mBinding.setUser(mUser);

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
