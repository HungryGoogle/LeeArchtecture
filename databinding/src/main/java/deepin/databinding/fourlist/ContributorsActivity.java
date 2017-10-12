package deepin.databinding.fourlist;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import deepin.databinding.R;



public class ContributorsActivity extends BaseActivity {


    public RecyclerView recyclerView;
    public TextView tvTip;
    public BaseAdapter<Contributor> adapter;
    List<Contributor> list = new ArrayList<>();

    private boolean loading;
    private RecyclerView.OnScrollListener scrollListener;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_contributors);

        initViews();
    }

    private void initViews() {

        tvTip = (TextView) findViewById(R.id.tv_tips);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new ContributorAdapter(this);
        RecyclerViewUtils.setLinearManagerAndAdapter(recyclerView, adapter);
        recyclerView.addItemDecoration(DividerItemDecoration.newVertical(this, R.dimen.list_divider_height, R.color.divider_color));

        tvTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 请求数据
                requestData();
            }
        });

        // 如果到了recycleview的底部
//        scrollListener = new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                //check for scroll down
//                if (adapter.getModelSize() == 0) {
//                    return;
//                }
//                if (dy > 0) {
//                    LinearLayoutManager mLayoutManager = (LinearLayoutManager)
//                            ContributorsActivity.this.recyclerView.getLayoutManager();
//                    int visibleItemCount = mLayoutManager.getChildCount();
//                    int totalItemCount = mLayoutManager.getItemCount();
//                    int pastVisibleItems = mLayoutManager.findFirstVisibleItemPosition();
//                    if (!loading) {
//                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
//                            loading = true;
//                            adapter.showFooter();
//                            requestData();
//                        }
//                    }
//                }
//            }
//        };

//        recyclerView.addOnScrollListener(scrollListener);
    }

    /**
     * 开启线程获取数据
     */
    private void requestData() {
        showLoadingDialog();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Contributor contributor = new Contributor();
                        contributor.setAvatar_url("1");
                        contributor.setContributions(1);
                        contributor.setLogin("贡献者1");

                        Contributor contributor2 = new Contributor();
                        contributor2.setAvatar_url("2");
                        contributor2.setContributions(2);
                        contributor2.setLogin("贡献者2");

                        Contributor contributor3 = new Contributor();
                        contributor3.setAvatar_url("3");
                        contributor3.setContributions(3);
                        contributor3.setLogin("贡献者3");

                        list.clear();
                        list.add(contributor);
                        list.add(contributor2);
                        list.add(contributor3);
                        adapter.appendItems(list);

                        hideLoadingDialog();
                    }
                });
            }
        }).start();



    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        recyclerView.removeOnScrollListener(scrollListener);
    }
}