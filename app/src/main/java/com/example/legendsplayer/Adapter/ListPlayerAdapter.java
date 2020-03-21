package com.example.legendsplayer.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.legendsplayer.Model.PlayerModel;
import com.example.legendsplayer.R;

import java.util.ArrayList;

public class ListPlayerAdapter extends RecyclerView.Adapter<ListPlayerAdapter.ListViewHolder> {
    private ArrayList<PlayerModel> listPlayer;

    public ListPlayerAdapter(ArrayList<PlayerModel> list) {
        this.listPlayer = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_player, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        PlayerModel player = listPlayer.get(position);
        Glide.with(holder.itemView.getContext())
                .load(player.getPhoto())
                .apply(new RequestOptions().override(200, 200))
                .into(holder.imgPhoto);
        holder.tvName.setText(player.getName());
        holder.tvCountry.setText(player.getCountry());
        holder.tvDetail.setText(player.getDetail());
    }

    @Override
    public int getItemCount() {
        return listPlayer.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView  imgPhoto;
        TextView  tvName, tvDetail, tvCountry;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvCountry = itemView.findViewById(R.id.tv_country);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDetail = itemView.findViewById(R.id.tv_detail);
        }
    }
}
