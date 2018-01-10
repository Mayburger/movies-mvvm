package com.nacoda.moviesmvvm.mvvm.detail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import kotlin.jvm.internal.Intrinsics;

/**
 * Created by Mayburger on 1/10/18.
 */
public class TabSliderAdapter extends FragmentPagerAdapter {

    private FragmentManager fragmentManager;
    ArrayList<Fragment> fragmentList = new ArrayList<>();
    ArrayList<String> nameList = new ArrayList<>();


    public TabSliderAdapter(FragmentManager fm) {
        super(fm);
        fragmentManager = fm;
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    void addFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        nameList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return nameList.get(position);
    }
}
