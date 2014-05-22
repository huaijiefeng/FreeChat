package com.snail.freechat.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.snail.freechat.R;
import com.snail.freechat.ui.contact.ContactFragment;
import com.snail.freechat.ui.dialing.DialingFragment;
import com.snail.freechat.ui.message.MessageFragment;
import com.snail.freechat.ui.setting.SettingFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fenghb on 2014/5/15.
 */
public class HomeActivity extends FragmentActivity {
    private ViewPager mViewPager;

    private ContactFragment mContactFragment;
    private MessageFragment mMessageFragment;
    private DialingFragment mDialingFragment;
    private SettingFragment mSettingFragment;

    private List<Fragment> fragments;

    private FragmentManager mFragmentManager;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();

    }


    private void initViews() {
        fragments = new ArrayList<Fragment>();
        mContactFragment = new ContactFragment();
        mMessageFragment = new MessageFragment();
        mDialingFragment = new DialingFragment();
        mSettingFragment = new SettingFragment();
        fragments.add(mContactFragment);
        fragments.add(mMessageFragment);
        fragments.add(mDialingFragment);
        fragments.add(mSettingFragment);

        mFragmentManager = getSupportFragmentManager();

        mViewPager = (ViewPager) findViewById(R.id.viewpager_home);
        mViewPager.setAdapter(new FragmentViewPagerAdapter(mFragmentManager));
    }

    private class FragmentViewPagerAdapter extends FragmentPagerAdapter {

        public FragmentViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }
    }
}
