package cn.aizhangzhang.aizhangzhang.Fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import cn.aizhangzhang.aizhangzhang.Adapter.TabFragmentPagerAdapter;
import cn.aizhangzhang.aizhangzhang.Base.BaseFragment;
import cn.aizhangzhang.aizhangzhang.HomePage.Fragment.HeadlineFragment;
import cn.aizhangzhang.aizhangzhang.HomePage.Fragment.RecreationFragment;
import cn.aizhangzhang.aizhangzhang.HomePage.Fragment.SportFragment;
import cn.aizhangzhang.aizhangzhang.HomePage.Fragment.TechnologyFragment;
import cn.aizhangzhang.aizhangzhang.R;

public class HomepageFragment extends BaseFragment {
    TabLayout mViewpagerTab;
    ViewPager mNewViewpager;

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_homepage;
    }

    @Override
    protected void initViews() {
        //找到控件
        mViewpagerTab=findViewById(R.id.home_viewpager_tab);
        mNewViewpager=findViewById(R.id.home_viewpager);
        //fragment列表
        List<Fragment> list_fragment =new ArrayList<>();
        //tab名的列表
        List<String> list_Title =new ArrayList<>();

        list_fragment.add(new HeadlineFragment());
        list_fragment.add(new RecreationFragment());
        list_fragment.add(new SportFragment());
        list_fragment.add(new TechnologyFragment());
        list_fragment.add(new HeadlineFragment());
        list_fragment.add(new RecreationFragment());
        list_fragment.add(new SportFragment());
        list_fragment.add(new TechnologyFragment());
        list_fragment.add(new HeadlineFragment());
        list_fragment.add(new RecreationFragment());
        list_fragment.add(new SportFragment());
        list_fragment.add(new TechnologyFragment());

        list_Title.add("头条");
        list_Title.add("娱乐");
        list_Title.add("体育");
        list_Title.add("科技");
        list_Title.add("头 条");
        list_Title.add("娱 乐");
        list_Title.add("体 育");
        list_Title.add("科 技");
        list_Title.add("头条");
        list_Title.add("娱乐");
        list_Title.add("体育");
        list_Title.add("科技");

        //设置名称
        for (int i=0;i < list_Title.size();i++){
            mViewpagerTab.addTab(mViewpagerTab.newTab().setText(list_Title.get(i)));
        }
        TabFragmentPagerAdapter adapter =new TabFragmentPagerAdapter(
                getActivity().getSupportFragmentManager(),list_fragment,list_Title
        );
        //viewpager 加载adapter
        mNewViewpager.setAdapter(adapter);
        //TableLayout 加载viewpager
        mViewpagerTab.setupWithViewPager(mNewViewpager);


    }
}

