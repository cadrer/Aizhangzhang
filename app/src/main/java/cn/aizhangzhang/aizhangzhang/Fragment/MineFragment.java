package cn.aizhangzhang.aizhangzhang.Fragment;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;

import cn.aizhangzhang.aizhangzhang.Base.BaseFragment;
import cn.aizhangzhang.aizhangzhang.R;

public class MineFragment extends BaseFragment {
    Handler mhandler = new Handler();

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initViews() {

    }


}
