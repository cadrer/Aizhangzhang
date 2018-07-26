package cn.aizhangzhang.aizhangzhang.Fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.aizhangzhang.aizhangzhang.Base.BaseFragment;
import cn.aizhangzhang.aizhangzhang.R;
import cn.aizhangzhang.aizhangzhang.RecyclerViewWithEmptyView;
import cn.aizhangzhang.aizhangzhang.TestFirst.ItemData;
import cn.aizhangzhang.aizhangzhang.TestFirst.MyRecycleViewAdapter;

public class MessageFragment extends BaseFragment {
    private RecyclerViewWithEmptyView mRecyclerView;
    private MyRecycleViewAdapter mAdapter;
    private View mEmptyView;
    private List<ItemData> mList; //数据源

    private SwipeRefreshLayout swipeRefresh;

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_message;
    }

    @Override
    protected void initViews() {
        initData();

        //initView
        mRecyclerView = (RecyclerViewWithEmptyView) findViewById(R.id.emptyRecyclerView);
        mEmptyView = findViewById(R.id.empty_iv);
        findViewById(R.id.deleteAll_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //删除所有数据
                mList.clear();
                mAdapter.notifyDataSetChanged();
            }
        });
        findViewById(R.id.insert_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //添加10条数据
                for (int i = 0; i < 10; i++) {
                    ItemData itemData = new ItemData("列表" + i);
                    mList.add(itemData);
                }
                mAdapter.notifyDataSetChanged();
            }
        });

        initRv();


        srl_init();
    }

    //插入数据
    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ItemData itemData = new ItemData("列表" + i);
            mList.add(itemData);
        }
    }
    private void initRv() {
        mAdapter = new MyRecycleViewAdapter(getActivity(), mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setEmptyView(mEmptyView); //设置空布局
    }


    /**
     * SwipeRefreshLayout 初始化
     */
    private void srl_init() {
        swipeRefresh =(SwipeRefreshLayout) findViewById(R.id.sr_live_list);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }

        });
    }
}
