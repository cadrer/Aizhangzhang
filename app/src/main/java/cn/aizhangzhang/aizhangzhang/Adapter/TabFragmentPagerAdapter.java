package cn.aizhangzhang.aizhangzhang.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class TabFragmentPagerAdapter extends FragmentPagerAdapter{

    //fragment 列表
    private List<Fragment> list_fragment;
    //tab名列表
    private List<String> list_Title;

    public TabFragmentPagerAdapter(FragmentManager fm, List<Fragment> list_fragment, List<String> list_Title) {
        super(fm);
        this.list_fragment = list_fragment;
        this.list_Title = list_Title;
    }

    @Override
    public Fragment getItem(int position) {
        return list_fragment.get(position);
    }

    @Override
    public int getCount() {
        return list_Title.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list_Title.get(position);
    }
}
