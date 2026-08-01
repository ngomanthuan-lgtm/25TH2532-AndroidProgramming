package com.example.a25th2532_androidprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Hàm đáp ứng sự kiện nhấn nút "Sang màn hình khác" (Trang 2 PDF)
    public void ChuyenManHinh(View v) {
        // Tạo một đối tượng Intent
        // Tham số thứ 2 của hàm tạo này là tên Activity (màn hình) ta muốn chuyển sang
        Intent iManHinhKhac = new Intent(this, SubActivityOne.class);
        // Thực hiện chuyển
        startActivity(iManHinhKhac);
    }

    // Lớp Activity Màn hình thứ 2 (SubActivityOne)
    public static class SubActivityOne extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        // Hàm xử lý nút Quay về màn hình trang chủ
        public void QuayVe(View v) {
            Intent iManHinhCHINH = new Intent(this, MainActivity.class);
            startActivity(iManHinhCHINH);
        }
    }
}
