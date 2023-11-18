package vn.poly.mob305.slide1;

import android.app.FragmentManager;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.poly.mob305.slide1.fragments.Demo2Fragment;
import vn.poly.mob305.slide1.fragments.DemoFragment;

public class DemoPagerAdapter extends FragmentStateAdapter {

    public DemoPagerAdapter(FragmentActivity fm){
        super(fm);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        DemoFragment demo1 = new DemoFragment();
        Demo2Fragment demo2 = new Demo2Fragment();
        switch (position) {
            case 0 : return demo1;
            case 1 : return demo2;
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
