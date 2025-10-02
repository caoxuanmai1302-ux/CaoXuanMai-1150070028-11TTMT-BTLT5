package com.example.caoxuanmaibt5;
import android.os.Bundle;
import android.view.*;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.fragment.app.Fragment;

public class ScreenSlidePageFragment extends Fragment {
    private static final String KEY_INDEX = "index";
    public static ScreenSlidePageFragment newInstance(int idx) {
        Bundle b = new Bundle(); b.putInt(KEY_INDEX, idx);
        ScreenSlidePageFragment f = new ScreenSlidePageFragment(); f.setArguments(b);
        return f;
    }
    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_page, container, false);
        TextView tv = v.findViewById(R.id.tvPage);
        int idx = getArguments() != null ? getArguments().getInt(KEY_INDEX, 0) : 0;
        tv.setText(idx == 0 ? "ViewPager2 — Trang 1" : "ViewPager2 — Trang 2");
        return v;
    }
}