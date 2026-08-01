package com.example.a25th2532_androidprogramming;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Ánh xạ ListView từ file XML
        listView = findViewById(R.id.listView);

        // 2. Tạo danh sách các Tỉnh Thành ở VN y hệt ví dụ trong video của Thầy
        ArrayList<String> dsTinhThanh = new ArrayList<>();
        dsTinhThanh.add("Hà Nội");
        dsTinhThanh.add("Thành phố HCM");
        dsTinhThanh.add("Đồng Nai");
        dsTinhThanh.add("Bình Thuận");
        dsTinhThanh.add("Ninh Thuận");
        dsTinhThanh.add("Nha Trang");
        dsTinhThanh.add("Tiền Giang");
        dsTinhThanh.add("Cần Thơ");
        dsTinhThanh.add("Huế");

        // 3. Khởi tạo ArrayAdapter nạp dữ liệu danh sách
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            dsTinhThanh
        );

        // 4. Nạp Adapter vào ListView để hiển thị
        listView.setAdapter(adapter);

        // 5. Xử lý sự kiện OnItemClick khi chọn 1 Tỉnh Thành (Video Phần 2 - Xử lý sự kiện)
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tenTinh = dsTinhThanh.get(position);
                Toast.makeText(MainActivity.this, "Bạn vừa chọn: " + tenTinh, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
