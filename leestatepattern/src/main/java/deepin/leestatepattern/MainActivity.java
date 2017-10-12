package deepin.leestatepattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import deepin.leestatepattern.callstate.CallStateSimpleTestActivity;
import deepin.leestatepattern.callstate.ActivityCallTestActivity;
import deepin.leestatepattern.state.StateContext;
//import deepin.leestatepattern.videochat.TestAgoraActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.id_state).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StateContext stateContext = new StateContext();
                stateContext.handle("1");
                stateContext.handle("2");
                stateContext.handle("3");
                stateContext.handle("4");
            }
        });

        findViewById(R.id.id_call_state).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CallStateSimpleTestActivity.class));
            }
        });

        findViewById(R.id.id_call_activity_demo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActivityCallTestActivity.class));
            }
        });

        findViewById(R.id.id_agora_video_call_demo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, TestAgoraActivity.class));
            }
        });
    }
}
