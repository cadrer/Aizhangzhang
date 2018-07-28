package cn.aizhangzhang.aizhangzhang.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.aizhangzhang.aizhangzhang.R;

public class LiveFragment extends Fragment {

    @BindView(R.id.dkdjjilu)
    LinearLayout dkdjjilu;
    @BindView(R.id.dkdjhvkr)
    LinearLayout dkdjhvkr;
    @BindView(R.id.xbdkdj)
    LinearLayout xbdkdj;
    @BindView(R.id.hetsjilu)
    LinearLayout hetsjilu;
    @BindView(R.id.xbhets)
    LinearLayout xbhets;
    @BindView(R.id.hvkrjilu)
    LinearLayout hvkrjilu;
    @BindView(R.id.xbhvkr)
    LinearLayout xbhvkr;
    @BindView(R.id.jisrtiig)
    LinearLayout jisrtiig;
    @BindView(R.id.jpsrtiig)
    LinearLayout jpsrtiig;
    @BindView(R.id.ufpi)
    LinearLayout ufpi;
    @BindView(R.id.kehugrli)
    LinearLayout kehugrli;
    @BindView(R.id.xbzgkehu)
    LinearLayout xbzgkehu;
    @BindView(R.id.fwysufqk)
    LinearLayout fwysufqk;
    @BindView(R.id.fwysjilv)
    LinearLayout fwysjilv;
    Unbinder unbinder;

    private String TAG = "FunctionFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        //   View rootView = super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_live, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        System.out.println("response12 ");  //12
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: FunctionFragment");
    }

    @OnClick({R.id.dkdjjilu, R.id.dkdjhvkr, R.id.xbdkdj, R.id.hetsjilu, R.id.xbhets, R.id.hvkrjilu, R.id.xbhvkr, R.id.jisrtiig, R.id.jpsrtiig, R.id.ufpi, R.id.kehugrli, R.id.xbzgkehu, R.id.fwysufqk, R.id.fwysjilv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dkdjjilu:
             //   new History().startActivity(getContext());
                break;
            case R.id.dkdjhvkr:
                break;
            case R.id.xbdkdj:
                break;
            case R.id.hetsjilu:
                break;
            case R.id.xbhets:
                break;
            case R.id.hvkrjilu:
                break;
            case R.id.xbhvkr:
                break;
            case R.id.jisrtiig:
                break;
            case R.id.jpsrtiig:
                break;
            case R.id.ufpi:
                break;
            case R.id.kehugrli:
                break;
            case R.id.xbzgkehu:
                break;
            case R.id.fwysufqk:
                break;
            case R.id.fwysjilv:
                break;
        }
    }
}
