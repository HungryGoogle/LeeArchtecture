package com.example.androidpriorityjobqueue;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.path.android.jobqueue.JobManager;

public class MainActivity extends AppCompatActivity {
    private JobManager jobManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jobManager = AppApplication.getInstance().getJobManager();
        Button btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jobManager.addJobInBackground(new MJob("1"));
                jobManager.addJobInBackground(new MJob("2"));
                jobManager.addJobInBackground(new MJob("3"));
                jobManager.addJobInBackground(new MJob("4"));
                jobManager.addJobInBackground(new MJob("5"));
                jobManager.addJobInBackground(new MJob("6"));
                jobManager.addJobInBackground(new MJob("7"));
                jobManager.addJobInBackground(new MJob("8"));
                jobManager.addJobInBackground(new MJob("9"));
                jobManager.addJobInBackground(new MJob("18"));
                jobManager.addJobInBackground(new MJob("28"));
                jobManager.addJobInBackground(new MJob("38"));
                jobManager.addJobInBackground(new MJob("48"));
                jobManager.addJobInBackground(new MJob("58"));
                jobManager.addJobInBackground(new MJob("68"));
                jobManager.addJobInBackground(new MJob("78"));
                jobManager.addJobInBackground(new MJob("88"));
//                jobManager.addJobInBackground(new MJob(""));
//                jobManager.addJobInBackground(new MJob(""));
//                jobManager.addJobInBackground(new MJob(""));
            }
        });
        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }
}
