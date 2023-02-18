package com.farzin.metro.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.farzin.metro.Activities.StationDetailsActivity;
import com.farzin.metro.R;
import com.farzin.metro.databinding.StationsRvLayoutBinding;
import com.farzin.metro.model.Stations;

import java.io.Serializable;
import java.util.List;

public class StationsRVAdapter extends RecyclerView.Adapter<StationsRVAdapter.MyViewHolder> {

    private List<Stations> stations;
    private Context context;

    public StationsRVAdapter(List<Stations> stations, Context context) {
        this.stations = stations;
        this.context = context;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        StationsRvLayoutBinding stationsRvLayoutBinding = StationsRvLayoutBinding.inflate(layoutInflater,parent,false);
        return new MyViewHolder(stationsRvLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.stationsRvLayoutBinding.enTitle.setText(stations.get(position).getTitleEnglish());
        holder.stationsRvLayoutBinding.persianTitle.setText(stations.get(position).getTitle());

        if (stations.get(position).getLineID() == 1){
            holder.stationsRvLayoutBinding.parentRel.setBackgroundColor(context.getResources().getColor(R.color.red));
        }
        else if (stations.get(position).getLineID() == 2){
            holder.stationsRvLayoutBinding.parentRel.setBackgroundColor(context.getResources().getColor(R.color.blue));
        }
        else if (stations.get(position).getLineID() == 3){
            holder.stationsRvLayoutBinding.parentRel.setBackgroundColor(context.getResources().getColor(R.color.lowBlue));
        }
        else if (stations.get(position).getLineID() == 4){
            holder.stationsRvLayoutBinding.parentRel.setBackgroundColor(context.getResources().getColor(R.color.yellow));
        }
        else if (stations.get(position).getLineID() == 5){
            holder.stationsRvLayoutBinding.parentRel.setBackgroundColor(context.getResources().getColor(R.color.green));
        }
        else if (stations.get(position).getLineID() == 7){
            holder.stationsRvLayoutBinding.parentRel.setBackgroundColor(context.getResources().getColor(R.color.purple));
        }

        if (stations.get(position).getCrossLineID() != 0){

            holder.stationsRvLayoutBinding.cross.setVisibility(View.VISIBLE);
            holder.stationsRvLayoutBinding.crossId.setText(stations.get(position).getCrossLineID() + "");
        }




        holder.stationsRvLayoutBinding.parentRel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, StationDetailsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("stationDetails", stations.get(holder.getAdapterPosition()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }








    class MyViewHolder extends RecyclerView.ViewHolder{

        StationsRvLayoutBinding stationsRvLayoutBinding;

        public MyViewHolder(@NonNull StationsRvLayoutBinding stationsRvLayoutBinding) {
            super(stationsRvLayoutBinding.getRoot());
            this.stationsRvLayoutBinding = stationsRvLayoutBinding;
        }
    }
}
