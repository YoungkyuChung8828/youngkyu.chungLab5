package youngkyu.chung.Lab5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class ViewPager2Adapter extends FragmentStateAdapter {
    private ArrayList<Fragment> fragments; //variable holds the fragments the ViewPager2 allows us to swipe to.

    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {         //this is the constructor
        super(fragmentActivity);

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) { return fragments.get(position); }

    @Override
    public int getItemCount() { return fragments.size();  }

    public void setData(ArrayList<Fragment> fragments) { this.fragments = fragments; }

    public void replaceFragment(int position, Fragment fragment) {
        fragments.set(position, fragment);
    }



}

