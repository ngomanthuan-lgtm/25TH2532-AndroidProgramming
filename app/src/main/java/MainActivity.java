package com.example.a25th2532_androidprogramming;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Khai báo các biến lưu trữ điều khiển theo đúng sơ đồ bài giảng
    EditText edtA, edtB, edtKQ;
    Button btnCong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Tìm đúng điều khiển cần xử lý thông qua findViewById
        TimDieuKhien();
    }

    void TimDieuKhien() {
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        btnCong = findViewById(R.id.btnCong);
        edtKQ = findViewById(R.id.edtKQ);
    }

    // 2. Hàm thực hiện tính toán khi người dùng nhấn (click) vào nút TÍNH TỔNG
    public void XuLyTinhTong(View v) {
        // Lấy dữ liệu từ giao diện
        String strA = edtA.getText().toString().trim();
        String strB = edtB.getText().toString().trim();

        if (strA.isEmpty() || strB.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ 2 số a và b!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            // Chuyển dữ liệu chuỗi sang số để tính
            double a = Double.parseDouble(strA);
            double b = Double.parseDouble(strB);
            double tong = a + b;

            // Đưa dữ liệu ra ô giao diện kết quả
            if (tong == (long) tong) {
                edtKQ.setText(String.valueOf((long) tong));
            } else {
                edtKQ.setText(String.valueOf(tong));
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Dữ liệu nhập phải là số hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }
}
