package com.example.a25th2532_androidprogramming;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        String[] values = new String[] {
            "Việt Nam",
            "Trung Quốc",
            "Triều Tiên",
            "Cuba",
            "Hoa Kỳ",
            "Nhật Bản",
            "Hàn Quốc",
            "Pháp",
            "Đức",
            "Anh"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            values
        );

        listView.setAdapter(adapter);
    }
}
