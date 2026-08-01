package com.example.a25th2532_androidprogramming;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 1. Khai báo các biến truy cập RecyclerView
    ItemLandScapeAdapter adapter;
    ArrayList<LandScape> landScapeList;
    RecyclerView recyclerViewLand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. Chuẩn bị dữ liệu danh sách Cảnh đẹp LandScape
        landScapeList = getDataForRecycler();

        // 3. Tìm điều khiển RecyclerView
        recyclerViewLand = findViewById(R.id.recyclerViewLand);

        // 4. Tạo LayoutManager đặt bố cục cho RecyclerView (LinearLayoutManager)
        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this);
        recyclerViewLand.setLayoutManager(layoutLinear);

        // 5. Tạo adapter gắn với nguồn dữ liệu
        adapter = new ItemLandScapeAdapter(this, landScapeList);

        // 6. Gắn adapter với RecyclerView
        recyclerViewLand.setAdapter(adapter);
    }

    // Hàm khởi tạo danh sách địa danh Cảnh đẹp theo bài giảng
    private ArrayList<LandScape> getDataForRecycler() {
        ArrayList<LandScape> listData = new ArrayList<>();
        listData.add(new LandScape("Flag Tower of Ha Noi", "flag_tower_of_hanoi"));
        listData.add(new LandScape("Eiffel Tower", "eiffel"));
        listData.add(new LandScape("Buckingham Palace", "buckingham"));
        listData.add(new LandScape("Statue of Liberty", "statue_of_liberty"));
        listData.add(new LandScape("Fuji Mountain", "fuji"));
        return listData;
    }

    // --- LỚP MODEL CẤU TRÚC DỮ LIỆU LANDSCAPE (Slide 7) ---
    static class LandScape {
        private String landscapeName;
        private String landscapeImage;

        public LandScape(String landscapeName, String landscapeImage) {
            this.landscapeName = landscapeName;
            this.landscapeImage = landscapeImage;
        }

        public String getLandscapeName() { return landscapeName; }
        public String getLandscapeImage() { return landscapeImage; }
    }

    // --- LỚP ADAPTER VÀ VIEWHOLDER CHO RECYCLERVIEW (Slide 8 - 18) ---
    static class ItemLandScapeAdapter extends RecyclerView.Adapter<ItemLandScapeAdapter.ItemLandScapeViewHolder> {

        private Context context;
        private ArrayList<LandScape> datas;

        public ItemLandScapeAdapter(Context _context, ArrayList<LandScape> _datas) {
            this.context = _context;
            this.datas = _datas;
        }

        @NonNull
        @Override
        public ItemLandScapeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View viewItem = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            return new ItemLandScapeViewHolder(viewItem);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemLandScapeViewHolder holder, int position) {
            LandScape land = datas.get(position);
            holder.textViewLandName.setText(land.getLandscapeName());
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        // Lớp ViewHolder quản lý từng hàng và xử lý sự kiện OnClick (Slide 17-18)
        class ItemLandScapeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            TextView textViewLandName;

            public ItemLandScapeViewHolder(@NonNull View itemView) {
                super(itemView);
                textViewLandName = itemView.findViewById(android.R.id.text1);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                int clickedPosition = getAdapterPosition();
                LandScape land = datas.get(clickedPosition);
                Toast.makeText(v.getContext(), "Bạn vừa chọn: " + land.getLandscapeName(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
