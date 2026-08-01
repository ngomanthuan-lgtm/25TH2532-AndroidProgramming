package com.example.a25th2532_androidprogramming;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtSoA, edtSoB;
    private Button btnTinhTong;
    private TextView tvKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSoA = findViewById(R.id.edtSoA);
        edtSoB = findViewById(R.id.edtSoB);
        btnTinhTong = findViewById(R.id.btnTinhTong);
        tvKetQua = findViewById(R.id.tvKetQua);

        btnTinhTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyTinhTong();
            }
        });
    }

    private void xuLyTinhTong() {
        String strA = edtSoA.getText().toString().trim();
        String strB = edtSoB.getText().toString().trim();

        if (strA.isEmpty() || strB.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ cả 2 số!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double a = Double.parseDouble(strA);
            double b = Double.parseDouble(strB);
            double tong = a + b;

            if (tong == (long) tong) {
                tvKetQua.setText("Kết quả: " + (long) tong);
            } else {
                tvKetQua.setText("Kết quả: " + tong);
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Dữ liệu nhập vào phải là số!", Toast.LENGTH_SHORT).show();
        }
    }
}
