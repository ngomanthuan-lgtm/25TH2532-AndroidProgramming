package com.example.a25th2532_androidprogramming;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TH12: Khởi tạo và nạp Fragment Động bằng FragmentManager (Slide 10-11)
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            // Thêm FirstFragment vào màn hình
            fragmentTransaction.add(R.id.listView, new FirstFragment());
            fragmentTransaction.commit();
        }
    }

    // TH13: Hàm thay đổi chuyển đổi giữa các Fragment (Replacing Fragments Dynamically - Slide 12)
    public void thayDoiFragment(Fragment fragmentMoi) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.listView, fragmentMoi);
        fragmentTransaction.commit();
    }

    // --- BÀI TH11: LỚP FRAGMENT TĨNH & ĐỘNG THỨ NHẤT (First Fragment - Slide 1 & 8) ---
    public static class FirstFragment extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(android.R.layout.simple_list_item_1, container, false);
            TextView textView = view.findViewById(android.R.id.text1);
            textView.setText("FIRST FRAGMENT (Màn hình Fragment #1)");
            textView.setTextSize(20);
            textView.setPadding(20, 40, 20, 40);
            return view;
        }
    }

    // --- BÀI TH12 & TH13: LỚP FRAGMENT THỨ HAI (Second Fragment - Slide 1 & 12) ---
    public static class SecondFragment extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(android.R.layout.simple_list_item_1, container, false);
            TextView textView = view.findViewById(android.R.id.text1);
            textView.setText("SECOND FRAGMENT (Màn hình Fragment #2)");
            textView.setTextSize(20);
            textView.setPadding(20, 40, 20, 40);
            return view;
        }
    }
}