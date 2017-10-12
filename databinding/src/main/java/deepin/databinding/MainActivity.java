package deepin.databinding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import deepin.databinding.databinding.FirstActivityMainBinding;
import deepin.databinding.firstexample.FirstMainActivity;
import deepin.databinding.firstexample.User;
import deepin.databinding.fourlist.ContributorsActivity;
import deepin.databinding.secondexample.SecondMainActivity;

public class MainActivity extends Activity {

    private FirstActivityMainBinding mBinding;
    private User mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 例子1
        findViewById(R.id.id_example1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FirstMainActivity.class));
            }
        });

        // 例子2
        findViewById(R.id.id_example2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondMainActivity.class));
            }
        });

        // 例子3
        findViewById(R.id.id_example3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, deepin.databinding.third.ThirdMainActivity.class));
            }
        });

        // 例子4
        findViewById(R.id.id_example4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ContributorsActivity.class));
            }
        });
    }
}
