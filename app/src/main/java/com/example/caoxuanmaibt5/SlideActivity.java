package com.example.caoxuanmaibt5;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class SlideActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
        ViewPager2 pager = findViewById(R.id.pager);
        pager.setAdapter(new ScreenSlidePagerAdapter(this));
        pager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
    }
    private static class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        public ScreenSlidePagerAdapter(@NonNull FragmentActivity fa) { super(fa); }
        @NonNull @Override public Fragment createFragment(int position) {
            return ScreenSlidePageFragment.newInstance(position);
        }
        @Override public int getItemCount() { return 2; }
    }
}
