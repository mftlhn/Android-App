package com.example.legendsplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.legendsplayer.Adapter.ListPlayerAdapter;
import com.example.legendsplayer.Model.PlayerData;
import com.example.legendsplayer.Model.PlayerModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPlayer;
    private ArrayList<PlayerModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPlayer = findViewById(R.id.rv_player);
        rvPlayer.setHasFixedSize(true);

        list.addAll(PlayerData.getListData());
        showRecyclerList();


    }

    private void showRecyclerList() {
        rvPlayer.setLayoutManager(new LinearLayoutManager(this));
        ListPlayerAdapter listPlayerAdapter = new ListPlayerAdapter(list);
        rvPlayer.setAdapter(listPlayerAdapter);
    }
}
