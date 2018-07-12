package cn.aizhangzhang.aizhangzhang;
import cn.aizhangzhang.aizhangzhang.Base.BaseActivity;
import cn.aizhangzhang.aizhangzhang.Base.BaseFragment;
import cn.aizhangzhang.aizhangzhang.Fragment.HomepageFragment;
import cn.aizhangzhang.aizhangzhang.Fragment.LiveFragment;
import cn.aizhangzhang.aizhangzhang.Fragment.MessageFragment;
import cn.aizhangzhang.aizhangzhang.Fragment.MineFragment;
import cn.aizhangzhang.aizhangzhang.Fragment.NearbyFragment;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {

    private  RadioButton  rb_Homepage;
    private RadioButton  rb_Near;
    private RadioButton  rb_Message;
    private RadioButton  rb_Mine;
    private  RadioButton  rb_Live;

  //  private FragmentManager mFm;
  //  private Fragment mContent;
    //private FragmentTransaction ft = null;
 //   private List<BaseFragment> fragments = new ArrayList<BaseFragment>();


    RadioGroup mRgBottomMenu;
    //数组 存储Fragment
    Fragment[] mFragments;
    //当前Fragent的下标
    private int currentIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRgBottomMenu = (RadioGroup) findViewById(R.id.rg_main);
        rb_Homepage=(RadioButton)findViewById(R.id.rb_homepage);
        rb_Near=(RadioButton) findViewById(R.id.rb_near);
        rb_Mine=(RadioButton) findViewById(R.id.rb_mine);
        rb_Live=(RadioButton) findViewById(R.id.rb_live);
        initViews();
        Button forceOffline = (Button) findViewById(R.id.force_offline);
        forceOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.broadcastbestpractice.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });




    }
    protected void initViews() {
        //将Fragment加入数组
        mFragments = new Fragment[] {
                //首页、附近、消息、LIVE、个人
                new HomepageFragment(),
                new NearbyFragment(),
                new MessageFragment(),
                new LiveFragment(),
                new MineFragment()

        };
        //开启事务
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //设置为默认界面 MainHomeFragment
        ft.add(R.id.fg_container,mFragments[0]).commit();
        //RadioGroup选中事件监听 改变fragment
        mRgBottomMenu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_homepage:
                        setIndexSelected(0);
                        break;
                    case R.id.rb_near:
                        setIndexSelected(1);
                        break;
                    case R.id.rb_message:
                        setIndexSelected(2);
                        break;
                    case R.id.rb_live:
                        setIndexSelected(3);
                        break;
                    case R.id.rb_mine:
                        setIndexSelected(4);
                        break;
                }
            }
        });
    }
    //设置Fragment页面
    private void setIndexSelected(int index) {
        if (currentIndex == index) {
            return;
        }
        //开启事务
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //隐藏当前Fragment
        ft.hide(mFragments[currentIndex]);
        //判断Fragment是否已经添加
        if (!mFragments[index].isAdded()) {
            ft.add(R.id.fg_container,mFragments[index]).show(mFragments[index]);
        }else {
            //显示新的Fragment
            ft.show(mFragments[index]);
        }
        ft.commit();
        currentIndex = index;
    }





}

