package youngkyu.chung.Lab5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class ChungActivity extends AppCompatActivity implements TabLayoutMediator.TabConfigurationStrategy {
    // implements is extend interface
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    ArrayList<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPager2);
        tabLayout = findViewById(R.id.tabLayout);

        setViewPagerAdapter();

        titles = new ArrayList<String>();
        titles.add("Home");
        titles.add("Settings");
        titles.add("Favorites");

        new TabLayoutMediator(tabLayout, viewPager2, this).attach();

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_settings);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_favorites);
    }
    public void setViewPagerAdapter() {
        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(this);

        ArrayList<Fragment> fragmentList = new ArrayList<>(); //creates an ArrayList of Fragments

        fragmentList.add(new HomeFragment());
        fragmentList.add(new SettingsFragment());
        fragmentList.add(new FavoritesFragment());

        viewPager2Adapter.setData(fragmentList);
        viewPager2.setAdapter(viewPager2Adapter);

    }

    @Override
    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
        tab.setText(titles.get(position)); // when tab each list change the page
    }
}