package vn.poly.mob305.slide1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TabLayout tabs = findViewById(R.id.tabs);
        ViewPager2 pager2 = findViewById(R.id.pagers);
        DemoPagerAdapter adapter = new DemoPagerAdapter(this);
        pager2.setAdapter(adapter);

        new TabLayoutMediator(tabs, pager2, (tab, position) -> {
            switch (position){
                case 0 : tab.setText("Tab 1"); break;
                case 1: tab.setText("Tab 2");
            }
        }).attach();
    }
}