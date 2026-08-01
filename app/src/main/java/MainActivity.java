package com.example.a25th2532_androidprogramming;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Khai báo các điều khiển
    EditText editTextSo1, editTextSo2, editTextKQ;
    Button nutCong, nutTru, nutNhan, nutChia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Ánh xạ các điều khiển từ XML
        TimDieuKhien();

        // 2. Đăng ký Bộ lắng nghe sự kiện ẨN DANH (Inline Anonymous Listener) cho từng nút bấm
        nutCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XULY_CONG();
            }
        });

        nutTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XULY_TRU();
            }
        });

        nutNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XULY_NHAN();
            }
        });

        nutChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XULY_CHIA();
            }
        });
    }

    // Hàm ánh xạ điều khiển
    void TimDieuKhien() {
        editTextSo1 = findViewById(R.id.edtSo1);
        editTextSo2 = findViewById(R.id.edtSo2);
        editTextKQ = findViewById(R.id.edtKetQua);
        nutCong = findViewById(R.id.btnCong);
        nutTru = findViewById(R.id.btnTru);
        nutNhan = findViewById(R.id.btnNhan);
        nutChia = findViewById(R.id.btnChia);
    }

    // Hàm xử lý phép Cộng
    void XULY_CONG() {
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        float Tong = soA + soB;
        editTextKQ.setText(String.valueOf(Tong));
    }

    // Hàm xử lý phép Trừ
    void XULY_TRU() {
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        float Hieu = soA - soB;
        editTextKQ.setText(String.valueOf(Hieu));
    }

    // Hàm xử lý phép Nhân
    void XULY_NHAN() {
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        float Tich = soA * soB;
        editTextKQ.setText(String.valueOf(Tich));
    }

    // Hàm xử lý phép Chia
    void XULY_CHIA() {
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        if (soB != 0) {
            float Thuong = soA / soB;
            editTextKQ.setText(String.valueOf(Thuong));
        } else {
            editTextKQ.setText("Lỗi chia 0");
        }
    }
}
