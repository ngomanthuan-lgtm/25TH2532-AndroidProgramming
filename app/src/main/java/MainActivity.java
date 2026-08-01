package com.example.a25th2532_androidprogramming;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtSo1, edtSo2, edtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ View từ XML
        edtSo1 = findViewById(R.id.edtSo1);
        edtSo2 = findViewById(R.id.edtSo2);
        edtKetQua = findViewById(R.id.edtKetQua);
    }

    // Hàm hỗ trợ lấy và kiểm tra dữ liệu 2 số nhập vào
    private boolean layDuLieu(double[] numbers) {
        String str1 = edtSo1.getText().toString().trim();
        String str2 = edtSo2.getText().toString().trim();

        if (str1.isEmpty() || str2.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ cả 2 số!", Toast.LENGTH_SHORT).show();
            return false;
        }

        try {
            numbers[0] = Double.parseDouble(str1);
            numbers[1] = Double.parseDouble(str2);
            return true;
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Dữ liệu nhập vào phải là số!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    // Xử lý Phép Cộng (+)
    public void XuLyCong(View v) {
        double[] num = new double[2];
        if (layDuLieu(num)) {
            hienKetQua(num[0] + num[1]);
        }
    }

    // Xử lý Phép Trừ (-)
    public void XuLyTru(View v) {
        double[] num = new double[2];
        if (layDuLieu(num)) {
            hienKetQua(num[0] - num[1]);
        }
    }

    // Xử lý Phép Nhân (*)
    public void XuLyNhan(View v) {
        double[] num = new double[2];
        if (layDuLieu(num)) {
            hienKetQua(num[0] * num[1]);
        }
    }

    // Xử lý Phép Chia (/)
    public void XuLyChia(View v) {
        double[] num = new double[2];
        if (layDuLieu(num)) {
            if (num[1] == 0) {
                Toast.makeText(this, "Không thể chia cho số 0!", Toast.LENGTH_SHORT).show();
                edtKetQua.setText("Lỗi chia cho 0");
            } else {
                hienKetQua(num[0] / num[1]);
            }
        }
    }

    // Hàm hiển thị kết quả lên ô EditText kết quả
    private void hienKetQua(double kq) {
        if (kq == (long) kq) {
            edtKetQua.setText(String.valueOf((long) kq));
        } else {
            edtKetQua.setText(String.valueOf(kq));
        }
    }
}
