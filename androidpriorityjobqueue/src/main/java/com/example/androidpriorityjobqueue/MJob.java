package com.example.androidpriorityjobqueue;


import android.util.Log;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;
import com.path.android.jobqueue.RetryConstraint;

/**
 * Created by Li on 2017/9/5.
 */

public class MJob extends Job {
    private static final String TAG = "LeeTest------->";
    private String text;

    /**
     * 初始化任务，将text作为优先级，也作为任务号
     * @param text 必须为整形的字符串 需要作为job的优先级使用 比如 1
     *             {@code com.example.li.leeandroidpriorityjobqueue. MJob#onAdded}
     */
    public MJob(String text) {
        super(new Params(Integer.parseInt(text)).persist());
        this.text = text;
        Log.i(TAG, text + "  init");
    }

    @Override
    public void onAdded() {
        Log.i(TAG, text + "  Onadded to task list");
    }

    @Override
    public void onRun() throws Throwable {
        Log.i(TAG, text + "  onRun");
        Thread.sleep(1000);
    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(Throwable throwable, int runCount,int maxRunCount) {
        return RetryConstraint.createExponentialBackoff(runCount, 1000);
    }

    @Override
    protected void onCancel() {
        Log.i(TAG, text + "  onCancel");
    }
}
