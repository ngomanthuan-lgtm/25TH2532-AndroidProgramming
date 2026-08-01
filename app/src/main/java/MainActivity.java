package com.example.a25th2532_androidprogramming;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Khai báo các điều khiển cơ bản
    EditText editTextSo1, editTextSo2, editTextKQ;
    Button nutCong, nutTru, nutNhan, nutChia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các điều khiển
        TimDieuKhien();
    }

    // Hàm tìm và ánh xạ các điều khiển từ file XML
    void TimDieuKhien() {
        editTextSo1 = findViewById(R.id.edtSo1);
        editTextSo2 = findViewById(R.id.edtSo2);
        editTextKQ = findViewById(R.id.edtKetQua);
        nutCong = findViewById(R.id.btnCong);
        nutTru = findViewById(R.id.btnTru);
        nutNhan = findViewById(R.id.btnNhan);
        nutChia = findViewById(R.id.btnChia);
    }

    // b1. Xử lý sự kiện Phép Cộng (+)
    public void XuLyCong(View v) {
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        float Tong = soA + soB;
        editTextKQ.setText(String.valueOf(Tong));
    }

    // b2. Xử lý sự kiện Phép Trừ (-)
    public void XuLyTru(View v) {
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        float Hieu = soA - soB;
        editTextKQ.setText(String.valueOf(Hieu));
    }

    // b3. Xử lý sự kiện Phép Nhân (*)
    public void XuLyNhan(View v) {
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        float Tich = soA * soB;
        editTextKQ.setText(String.valueOf(Tich));
    }

    // b4. Xử lý sự kiện Phép Chia (/)
    public void XuLyChia(View v) {
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
