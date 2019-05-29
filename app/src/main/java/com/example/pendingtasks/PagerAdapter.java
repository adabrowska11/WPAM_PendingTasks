package com.example.pendingtasks;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumofTabs;
    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumofTabs = NumOfTabs;
    }

    @Override
    public int getCount() {
        return mNumofTabs;
    }

    public Fragment getItem(int position) {
        switch(position) {
            case 0: return new TabWykonane();
            case 1: return new TabDoZrobienia();
            case 2: return new TabZlecone();
            default: return null;
        }
    }
}
