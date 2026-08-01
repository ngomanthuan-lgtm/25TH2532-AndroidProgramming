package com.example.a25th2532_androidprogramming;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        // Step 1: Chuẩn bị nguồn dữ liệu danh sách đối tượng Country (Slide 45)
        List<Country> listData = new ArrayList<>();
        listData.add(new Country("Vietnam", "vn", 98000000));
        listData.add(new Country("United States", "us", 330000000));
        listData.add(new Country("Russia", "ru", 142000000));
        listData.add(new Country("Japan", "jp", 125000000));
        listData.add(new Country("South Korea", "kr", 51000000));

        // Step 2: Khởi tạo CustomListAdapter và nạp vào ListView (Slide 47 - 49)
        CustomListAdapter adapter = new CustomListAdapter(this, listData);
        listView.setAdapter(adapter);

        // Step 3: Xử lý sự kiện click từng dòng trên Custom ListView (Slide 43)
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Country country = listData.get(position);
                Toast.makeText(MainActivity.this, "Bạn chọn: " + country.getCountryName() + " - Dân số: " + country.getPopulation(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Step 1: Lớp cấu trúc dữ liệu Country (Slide 46)
    static class Country {
        private String countryName;
        private String flagName;
        private int population;

        public Country(String countryName, String flagName, int population) {
            this.countryName = countryName;
            this.flagName = flagName;
            this.population = population;
        }

        public String getCountryName() { return countryName; }
        public String getFlagName() { return flagName; }
        public int getPopulation() { return population; }
    }

    // Step 2: Lớp CustomListAdapter kế thừa BaseAdapter (Slide 47-50)
    static class CustomListAdapter extends BaseAdapter {
        private List<Country> listData;
        private LayoutInflater layoutInflater;
        private Context context;

        public CustomListAdapter(Context aContext, List<Country> listData) {
            this.context = aContext;
            this.listData = listData;
            this.layoutInflater = LayoutInflater.from(aContext);
        }

        @Override
        public int getCount() { return listData.size(); }

        @Override
        public Object getItem(int position) { return listData.get(position); }

        @Override
        public long getItemId(int position) { return position; }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = layoutInflater.inflate(android.R.layout.simple_list_item_2, null);
                holder = new ViewHolder();
                holder.countryNameView = convertView.findViewById(android.R.id.text1);
                holder.populationView = convertView.findViewById(android.R.id.text2);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            Country country = this.listData.get(position);
            holder.countryNameView.setText(country.getCountryName());
            holder.populationView.setText("Dân số: " + country.getPopulation() + " người");
            return convertView;
        }

        // Lớp ViewHolder quản lý các View (Slide 50)
        static class ViewHolder {
            TextView countryNameView;
            TextView populationView;
        }
    }
}
